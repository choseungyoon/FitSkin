package com.fitksin.server.survey.service.Impl;

import com.fitksin.server.survey.domain.SurveyHeaders;
import com.fitksin.server.survey.repository.SurveyHeaderRepository;
import com.fitksin.server.survey.service.SurveyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class SurveyServiceImpl implements SurveyService {

    private final SurveyHeaderRepository surveyHeaderRepository;

    @Autowired
    public SurveyServiceImpl(SurveyHeaderRepository surveyHeaderRepository){
        this.surveyHeaderRepository = surveyHeaderRepository;
    }

    @Override
    public SurveyHeaders createSurvey(SurveyHeaders surveyHeaders){
        SurveyHeaders createdSurvey = this.surveyHeaderRepository.save(surveyHeaders);
        return createdSurvey;
    }

    @Override
    public SurveyHeaders getSurvey(int surveyId){
        Optional<SurveyHeaders> getSurvey = this.surveyHeaderRepository.findById(surveyId);
        if(getSurvey.isPresent()){
            return getSurvey.get();
        }

        return null;
    }

}
