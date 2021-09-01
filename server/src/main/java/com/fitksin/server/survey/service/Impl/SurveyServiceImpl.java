package com.fitksin.server.survey.service.Impl;

import com.fitksin.server.survey.domain.OptionChoices;
import com.fitksin.server.survey.domain.Questions;
import com.fitksin.server.survey.domain.SurveyHeaders;
import com.fitksin.server.survey.domain.SurveySections;
import com.fitksin.server.survey.repository.OptionChoiceRepository;
import com.fitksin.server.survey.repository.QuestionRepository;
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
    private final QuestionRepository questionRepository;
    private final OptionChoiceRepository optionChoiceRepository;

    @Autowired
    public SurveyServiceImpl(SurveyHeaderRepository surveyHeaderRepository ,
                             SurveySectionRepository surveySectionRepository ,
                             QuestionRepository questionRepository ,
                             OptionChoiceRepository optionChoiceRepository){
        this.surveyHeaderRepository = surveyHeaderRepository;
        this.surveySectionRepository = surveySectionRepository;
        this.questionRepository = questionRepository;
        this.optionChoiceRepository = optionChoiceRepository;
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

    @Override
    public Questions createQuestion(Questions questions){
        Questions createdQuestion = this.questionRepository.save(questions);
        return createdQuestion;
    }

    @Override
    public List<Questions> getQuestions(int sectionId){
        List<Questions> questionsList = this.questionRepository.findBySurveySectionId(sectionId);
        return questionsList;
    }

    @Override
    public OptionChoices createOptionChoices(OptionChoices optionChoices){
        OptionChoices createdOptionChoice = this.optionChoiceRepository.save(optionChoices);
        return createdOptionChoice;
    }

    @Override
    public List<OptionChoices> getOptionChoice(int questionId){
        List<OptionChoices> optionChoices = this.optionChoiceRepository.findByQuestionId(questionId);
        return optionChoices;
    }

}
