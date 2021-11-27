package com.fitksin.server.survey.domain;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="survey_result")
public class SurveyResult {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    private String email;

    @NotBlank
    private boolean sex;

    @NotBlank
    private int age;

    @NotBlank
    private int total;

    @NotBlank
    private int moisturizing;

    @NotBlank
    private int sebum;

    @NotBlank
    private int sensitivity;

    @NotBlank
    private int elasticity;

    @NotBlank
    private int pigmentation;

    @NotBlank
    private int trouble;

    @NotBlank
    private LocalDateTime createdAt;

    @Builder
    public SurveyResult(String email, @NotBlank boolean sex, @NotBlank int age,@NotBlank int total ,@NotBlank int moisturizing, @NotBlank int sebum, @NotBlank int sensitivity, @NotBlank int elasticity, @NotBlank int pigmentation, @NotBlank int trouble) {
        this.email = email;
        this.sex = sex;
        this.age = age;
        this.total = total;
        this.moisturizing = moisturizing;
        this.sebum = sebum;
        this.sensitivity = sensitivity;
        this.elasticity = elasticity;
        this.pigmentation = pigmentation;
        this.trouble = trouble;
        this.createdAt = LocalDateTime.now();
    }

}
