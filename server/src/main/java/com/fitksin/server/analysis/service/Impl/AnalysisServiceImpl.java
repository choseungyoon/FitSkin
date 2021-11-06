package com.fitksin.server.analysis.service.Impl;

import com.fitksin.server.analysis.model.TypeScore;
import com.fitksin.server.analysis.repository.TypeScoreRepository;
import com.fitksin.server.analysis.service.AnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnalysisServiceImpl implements AnalysisService {

    private final TypeScoreRepository typeScoreRepository;

    @Autowired
    public AnalysisServiceImpl(TypeScoreRepository typeScoreRepository){
        this.typeScoreRepository = typeScoreRepository;
    }

    @Override
    public TypeScore getTypeScore(String type){
        return this.typeScoreRepository.findById(type).get();
    }

}
