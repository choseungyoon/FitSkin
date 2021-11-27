package com.fitksin.server.analysis.service.Impl;

import com.fitksin.server.analysis.model.SkinIndex;
import com.fitksin.server.analysis.model.TypeScore;
import com.fitksin.server.analysis.repository.IndexRepository;
import com.fitksin.server.analysis.repository.TypeScoreRepository;
import com.fitksin.server.analysis.service.AnalysisService;
import com.fitksin.server.survey.domain.SurveyResult;
import com.fitksin.server.survey.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AnalysisServiceImpl implements AnalysisService {

    private final TypeScoreRepository typeScoreRepository;
    private final ResultRepository resultRepository;
    private final IndexRepository indexRepository;

    @Autowired
    public AnalysisServiceImpl(TypeScoreRepository typeScoreRepository,
                               ResultRepository resultRepository,
                               IndexRepository indexRepository){
        this.typeScoreRepository = typeScoreRepository;
        this.resultRepository = resultRepository;
        this.indexRepository = indexRepository;
    }

    @Override
    public TypeScore getTypeScore(String type){
        return this.typeScoreRepository.findById(type).get();
    }

    @Override
    public String getType(boolean sex, boolean makeup){
        /*if(sex && makeup) return "A";
        else if(sex && !makeup) return "B";
        else if(!sex && makeup) return "C";
        else return "D";*/
        return "A";
    }

    @Override
    public SkinIndex getBestIndex(UUID id){

        SurveyResult result = this.resultRepository.findById(id).get();

        List<SkinIndex> objList = new ArrayList<SkinIndex>();
        objList.add(new SkinIndex("moisturizing",result.getMoisturizing()));
        objList.add(new SkinIndex("sebum",result.getSebum()));
        objList.add(new SkinIndex("sensitivity",result.getSensitivity()));
        objList.add(new SkinIndex("elasticity",result.getElasticity()));
        objList.add(new SkinIndex("pigmentation",result.getPigmentation()));
        objList.add(new SkinIndex("trouble",result.getTrouble()));

        SkinIndex maxObject = Collections.max(objList, new Comparator<SkinIndex>() {
            @Override
            public int compare(SkinIndex o1, SkinIndex o2) {
                if (o1.getScore() == o2.getScore()) {
                    return 0;
                } else if (o1.getScore() < o2.getScore()) {
                    return -1;
                } else if (o1.getScore() > o2.getScore()) {
                    return 1;
                }
                return 0;
            }
        });
        maxObject.setImage(this.indexRepository.findById(maxObject.getSkinIndex()).get().getImage());
        maxObject.setSkinIndex(setIndexName(maxObject.getSkinIndex()));

        return maxObject;
    }

    @Override
    public SkinIndex getWorstIndex(UUID id){

        SurveyResult result = this.resultRepository.findById(id).get();

        List<SkinIndex> objList = new ArrayList<SkinIndex>();
        objList.add(new SkinIndex("moisturizing",result.getMoisturizing()));
        objList.add(new SkinIndex("sebum",result.getSebum()));
        objList.add(new SkinIndex("sensitivity",result.getSensitivity()));
        objList.add(new SkinIndex("elasticity",result.getElasticity()));
        objList.add(new SkinIndex("pigmentation",result.getPigmentation()));
        objList.add(new SkinIndex("trouble",result.getTrouble()));

        SkinIndex minObject = Collections.max(objList, new Comparator<SkinIndex>() {
            @Override
            public int compare(SkinIndex o1, SkinIndex o2) {
                if (o1.getScore() == o2.getScore()) {
                    return 0;
                } else if (o1.getScore() > o2.getScore()) {
                    return -1;
                } else if (o1.getScore() < o2.getScore()) {
                    return 1;
                }
                return 0;
            }
        });

        minObject.setImage(this.indexRepository.findById(minObject.getSkinIndex()).get().getImage());
        minObject.setSkinIndex(setIndexName(minObject.getSkinIndex()));
        return minObject;
    }

    @Override
    public boolean insertSkinIndex(SkinIndex skinIndex){
        try{
            this.indexRepository.save(skinIndex);
        }
        catch (Exception ex){
            return false;
        }
        return true;
    }

    private String setIndexName(String skinIndex){
        switch (skinIndex){
            case "moisturizing" :
                return "피부보습";
            case "sebum" :
                return "피지분비";
            case "sensitivity" :
                return "피부민감성";
            case "elasticity" :
                return "피부탄력";
            case "pigmentation" :
                return "피부 색소침착";
            case "trouble" :
                return "피부 트러블빈도";
            default:
                return null;
        }
    }
}
