package com.fitksin.server.survey.repository;

import com.fitksin.server.survey.domain.SurveySections;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SurveySectionRepository extends JpaRepository<SurveySections,Integer> {

    List<SurveySections> findByName(String name);

    List<SurveySections> findBySurveyHeaderId(int surveyHeaderId);

}
