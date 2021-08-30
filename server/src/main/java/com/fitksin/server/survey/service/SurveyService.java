package com.fitksin.server.survey.service;

import com.fitksin.server.survey.domain.SurveyHeaders;

public interface SurveyService {

    SurveyHeaders createSurvey(SurveyHeaders surveyHeaders);

    SurveyHeaders getSurvey(int surveyId);

}
