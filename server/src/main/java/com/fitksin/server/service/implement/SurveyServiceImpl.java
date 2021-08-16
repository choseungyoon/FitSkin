package com.fitksin.server.service.implement;

import com.fitksin.server.repository.SurveyHeadersRepository;
import com.fitksin.server.service.SurveyService;
import org.springframework.stereotype.Service;

@Service
public class SurveyServiceImpl implements SurveyService {

    private final SurveyHeadersRepository surveyHeadersRepository;

    public SurveyServiceImpl(SurveyHeadersRepository surveyHeadersRepository){
        this.surveyHeadersRepository = surveyHeadersRepository;
    }



}
