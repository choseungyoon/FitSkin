package com.fitksin.server.survey.domain;


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
@Table(name="questions")
public class Questions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "survey_section_id") @NotNull
    private int surveySectionId;

    @Column(name = "question_type") @NotNull
    private String type;

    @Column(name = "question_name") @NotNull
    private String name;

    @Column(name = "question_subtext") @NotNull
    private String subtext;

    @Column(name = "is_required") @NotNull
    private boolean isRequired;

    @Column(name = "seq") @NotNull
    private int seq;

    @Transient
    private List<String> choices;

}
