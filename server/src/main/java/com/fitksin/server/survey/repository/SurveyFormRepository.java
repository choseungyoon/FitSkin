package com.fitksin.server.survey.repository;

import com.fitksin.server.survey.domain.SurveyForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyFormRepository extends JpaRepository<SurveyForm,Integer> {
}
