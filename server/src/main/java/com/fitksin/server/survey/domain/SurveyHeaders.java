package com.fitksin.server.survey.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import com.sun.istack.Nullable;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="survey_headers")
public class SurveyHeaders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title") @Nullable
    private String title;

    @Column(name = "description") @NotNull
    private String description;

    @Column(name = "other_header_info") @Nullable
    private String otherInfo;

    @Transient
    private List<SurveySections> pages;

    @JsonCreator
    public SurveyHeaders(@JsonProperty("title") String title,
                         @JsonProperty("description")  String description,
                         @JsonProperty("otherInfo")  String otherInfo) {
        this.title = title;
        this.description = description;
        this.otherInfo = otherInfo;
    }

}
