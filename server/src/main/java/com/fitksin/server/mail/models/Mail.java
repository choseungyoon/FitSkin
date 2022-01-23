package com.fitksin.server.mail.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Mail {
    private String address;
    private String title;
    private String message;
    private MultipartFile file;

}
