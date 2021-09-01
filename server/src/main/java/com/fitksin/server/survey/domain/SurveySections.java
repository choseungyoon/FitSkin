package com.fitksin.server.survey.domain;
import com.sun.istack.NotNull;
import com.sun.istack.Nullable;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="survey_sections")
public class SurveySections {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "survey_header_id") @Nullable
    private int surveyHeaderId;

    @Column(name = "section_name") @Nullable
    private String name;

    @Column(name = "seq") @NotNull
    private int seq;

}
