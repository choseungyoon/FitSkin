package com.fitksin.server.survey.service.Impl;

import com.fitksin.server.survey.domain.SurveyHeaders;
import com.fitksin.server.survey.domain.SurveySections;
import com.fitksin.server.survey.repository.SurveyHeaderRepository;
import com.fitksin.server.survey.repository.SurveySectionRepository;
import com.fitksin.server.survey.service.SurveyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class SurveyServiceImpl implements SurveyService {

    private final SurveyHeaderRepository surveyHeaderRepository;
    private final SurveySectionRepository surveySectionRepository;

    @Autowired
    public SurveyServiceImpl(SurveyHeaderRepository surveyHeaderRepository , SurveySectionRepository surveySectionRepository ){
        this.surveyHeaderRepository = surveyHeaderRepository;
        this.surveySectionRepository = surveySectionRepository;
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

    @Override
    public SurveySections createSection(SurveySections surveySections){
        SurveySections createdSection = this.surveySectionRepository.save(surveySections);
        return createdSection;
    }

    @Override
    public SurveySections getSectionById(int sectionId){
        Optional<SurveySections> sections = this.surveySectionRepository.findById(sectionId);
        if(sections.isPresent()){
            return sections.get();
        }
        return null;
    }

    @Override
    public List<SurveySections> getSectionBySectionName(String sectionName){
        List<SurveySections> sectionsList = this.surveySectionRepository.findByName(sectionName);
        return sectionsList;
    }

    @Override
    public List<SurveySections> getSectionByHeaderId(int surveyHeaderId){
        List<SurveySections> sectionsList = this.surveySectionRepository.findBySurveyHeaderId(surveyHeaderId);
        return sectionsList;
    }

}
