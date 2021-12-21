package com.fitksin.server.survey.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class IndexDto {

    private int moisturizing;

    private int sebum;

    private int sensitivity;

    private int elasticity;

    private int pigmentation;

    private int trouble;
}
