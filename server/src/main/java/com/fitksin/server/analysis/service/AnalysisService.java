package com.fitksin.server.analysis.service;

import com.fitksin.server.analysis.model.SkinIndex;
import com.fitksin.server.analysis.model.TypeScore;

import java.util.UUID;

public interface AnalysisService {

    TypeScore getTypeScore(String type);

    String getType(boolean sex, boolean makeup);

    SkinIndex getBestIndex(UUID id);

    SkinIndex getWorstIndex(UUID id);

    boolean insertSkinIndex(SkinIndex skinIndex);

}
