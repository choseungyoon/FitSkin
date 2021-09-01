package com.fitksin.server.survey.repository;

import com.fitksin.server.survey.domain.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Questions,Integer> {

    List<Questions> findBySurveySectionId(int surveySectionId);
}
