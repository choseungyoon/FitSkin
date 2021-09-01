package com.fitksin.server.survey.repository;

import com.fitksin.server.survey.domain.OptionChoices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OptionChoiceRepository extends JpaRepository<OptionChoices, Integer> {

    List<OptionChoices> findByQuestionId(int questionId);
}
