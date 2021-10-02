package com.fitksin.server.survey.repository;

import com.fitksin.server.survey.domain.SurveyResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ResultRepository extends JpaRepository<SurveyResult, UUID> {

    List<SurveyResult> findByEmail(String email);
}
