package com.fitksin.server.auth.controllers;

import com.fitksin.server.auth.models.ERole;
import com.fitksin.server.auth.models.Role;
import com.fitksin.server.auth.models.User;
import com.fitksin.server.auth.payload.request.LoginRequest;
import com.fitksin.server.auth.payload.request.SignupRequest;
import com.fitksin.server.auth.payload.response.JwtResponse;
import com.fitksin.server.auth.payload.response.MessageResponse;
import com.fitksin.server.auth.repository.RoleRepository;
import com.fitksin.server.auth.repository.UserRepository;
import com.fitksin.server.auth.security.jwt.JwtUtils;
import com.fitksin.server.auth.security.services.UserDetailsImpl;
import com.fitksin.server.auth.services.KakaoLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    private final KakaoLoginService kakaoLoginService;
    public AuthController(KakaoLoginService kakaoLogin){
        this.kakaoLoginService = kakaoLogin;
    }

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        System.out.println("Login request");
        System.out.println(loginRequest.getEmail());
        System.out.println(loginRequest.getPassword());

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        System.out.println("userDetails");
        System.out.println(userDetails.getPassword());
        System.out.println(userDetails.getEmail());
        System.out.println(userDetails.getUsername());
        System.out.println(userDetails.getId());
        System.out.println(roles);

        ResponseEntity<?> ans = ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                roles));

        System.out.println("return  : " + ans);

        return ans;
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {

        System.out.println("Sign UP");

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }

        // Create new user's account
        User user = new User(signUpRequest.getUsername(),
                signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword()));
        System.out.println("Email : " + user.getEmail());
        System.out.println("UserName: " + user.getUsername());

        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);

                        break;
                    case "mod":
                        Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(modRole);

                        break;
                    default:
                        Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);
                }
            });
        }

        user.setRoles(roles);
        userRepository.save(user);

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }

    @GetMapping("/klogin")
    public ResponseEntity<?> kakaoLogin(@RequestParam String authorize_code){
        System.out.println("Execute kakao Login");
        String access_token = kakaoLoginService.getAccessToken(authorize_code);

        HashMap<String,String> userInfoFromKakao = kakaoLoginService.getUserInfo(access_token);
        System.out.println("Check existed user from kakao info");
        if (!userRepository.existsByEmail(userInfoFromKakao.get("email"))) {
            System.out.println("Execute Sign up");
            SignupRequest signupRequest = new SignupRequest();
            signupRequest.setEmail(userInfoFromKakao.get("email"));
            signupRequest.setUsername(userInfoFromKakao.get("username"));
            signupRequest.setPassword(userInfoFromKakao.get("id"));
            registerUser(signupRequest);
        }

        System.out.println("Execute Sign in");

        return this.authenticateUser(
                new LoginRequest(userInfoFromKakao.get("email"),userInfoFromKakao.get("id")));

    }

    @PutMapping("/update/account")
    public ResponseEntity<?> updateAccount(@Valid @RequestBody User user){
        User updatedUser = this.userRepository.findById(user.getId()).get();
        updatedUser.setUsername(user.getUsername());
        return ResponseEntity.ok(new MessageResponse("User info is updated successfully!"));

    }
}
