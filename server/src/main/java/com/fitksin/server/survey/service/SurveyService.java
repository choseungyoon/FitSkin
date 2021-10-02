package com.fitksin.server.survey.service;

import com.fitksin.server.survey.domain.*;
import org.json.simple.JSONArray;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public interface SurveyService {
    boolean insertSurvey(SurveyForm surveyForm);
    UUID insertResult(HashMap<String,Object> result, String email);
    JSONArray selectResult(UUID id);
}
