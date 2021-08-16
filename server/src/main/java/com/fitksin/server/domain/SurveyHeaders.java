package com.fitksin.server.domain;

import com.sun.istack.Nullable;
import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "servey_headers")
public class SurveyHeaders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "survey_name") @Nullable
    private String surveyName;

    @Column @Nullable
    private String instructions;

    @Column(name = "other_header_info") @Nullable
    private String otherHeaderInfo;

    public SurveyHeaders(String surveyName , String instructions , String otherHeaderInfo){
        this.surveyName = surveyName;
        this.instructions = instructions;
        this.otherHeaderInfo = otherHeaderInfo;
    }
}
