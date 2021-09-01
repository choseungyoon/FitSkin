package com.fitksin.server.survey.service;

import com.fitksin.server.survey.domain.SurveyHeaders;
import com.fitksin.server.survey.domain.SurveySections;

import java.util.List;

public interface SurveyService {

    SurveyHeaders createSurvey(SurveyHeaders surveyHeaders);

    SurveyHeaders getSurvey(int surveyId);

    SurveySections createSection(SurveySections surveySections);

    SurveySections getSectionById(int sectionId);

    List<SurveySections> getSectionBySectionName(String surveyName);

    List<SurveySections> getSectionByHeaderId(int surveyHeaderId);
}
