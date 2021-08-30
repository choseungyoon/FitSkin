package com.fitksin.server.survey.repository;

import com.fitksin.server.survey.domain.SurveyHeaders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyHeaderRepository extends JpaRepository<SurveyHeaders, Integer> {

}
