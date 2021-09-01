package com.fitksin.server.survey.domain;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="option_choices")
public class OptionChoices {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "question_id") @NotNull
    private int questionId;

    @Column(name = "option_choice_name") @NotNull
    private String optionChoiceName;

}
