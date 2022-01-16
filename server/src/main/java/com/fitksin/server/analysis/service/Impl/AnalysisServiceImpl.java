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

    @Override
    public  List<Map<String,String>> recommendHabits(String skinIndex){
        List<Map<String,String>> ans = new ArrayList<>();
        Map<String,String> item1 = new HashMap<>();
        Map<String,String> item2 = new HashMap<>();
        Map<String,String> item3 = new HashMap<>();
        Map<String,String> item4 = new HashMap<>();

        switch (skinIndex){
            case "피부보습" :
                item1.put("title","물 많이 마시기 (수분 섭취 많이하기)");
                item1.put("value","하루에 2L 정도의 물을 마시는 습관을 가지는게 좋아요");
                ans.add(item1);

                item2.put("title","가습기를 틀어서 실내습도 유지하기");
                item2.put("value","실내 습도 40~70%로 유지해주는 것이 중요해요");
                ans.add(item2);

                item3.put("title","마스크팩 후 크림 꼼꼼히 바르기");
                item3.put("value","주 2~3회 수면 전 마스크팩과 수분크림을 꾸준히 하는게 좋아요");
                ans.add(item3);

                item4.put("title","너무 뜨거운 물로 세안하지 않기");
                item4.put("value","뜨거운 물은 수분을 빼앗아 갈 수 있어요. 미온수로 천천히 세안해주는게 좋아요");
                ans.add(item4);
                break;
            case "피지분비" :
                item1.put("title","물 많이 마시기 (수분 섭취 많이하기)");
                item1.put("value","하루에 2L 정도의 물을 마시는 습관을 가지는게 좋아요");
                ans.add(item1);

                item2.put("title","기름기 많은 정크푸드 줄이기");
                item2.put("value","실내 습도 40~70%로 유지해주는 것이 중요해요");
                ans.add(item2);

                item3.put("title","저자극 클렌저 사용하기");
                item3.put("value","주 2~3회 수면 전 마스크팩과 수분크림을 꾸준히 하는게 좋아요");
                ans.add(item3);

                item4.put("title","충분한 휴식으로 스트레스 줄이기");
                item4.put("value","뜨거운 물은 수분을 빼앗아 갈 수 있어요. 미온수로 천천히 세안해주는게 좋아요");
                ans.add(item4);
                break;
            case "피부민감성" :
                item1.put("title","피부가 민감하게 반응하는 요소 찾기");
                item1.put("value","햇빛, 메이크업, 냉난방을 주의해주세요");
                ans.add(item1);

                item2.put("title","자외선에 민감하다면 실내에서도 SPF 함유된 제품 사용하기");
                item2.put("value","실내 습도 40~70%로 유지해주는 것이 중요해요");
                ans.add(item2);

                item3.put("title","보습제품 사용하여 유수분 밸런스 맞춰주기");
                item3.put("value","주 2~3회 수면 전 마스크팩과 수분크림을 꾸준히 하는게 좋아요");
                ans.add(item3);

                item4.put("title","충분한 휴식으로 스트레스 줄이기");
                item4.put("value","뜨거운 물은 수분을 빼앗아 갈 수 있어요. 미온수로 천천히 세안해주는게 좋아요");
                ans.add(item4);
                break;
            case "피부탄력" :
                item1.put("title","야외활동시 자외선 차단제 바르기");
                item1.put("value","햇빛, 메이크업, 냉난방을 주의해주세요");
                ans.add(item1);

                item2.put("title","가습기를 틀어서 실내습도 유지하기");
                item2.put("value","실내 습도 40~70%로 유지해주는 것이 중요해요");
                ans.add(item2);

                item3.put("title","물 많이 마시기 (수분 섭취 많이하기)");
                item3.put("value","하루에 2L 정도의 물을 마시는 습관을 가지는게 좋아요");
                ans.add(item3);

                item4.put("title","탄력관리 제품 & 이너뷰티 사용하기");
                item4.put("value","뜨거운 물은 수분을 빼앗아 갈 수 있어요. 미온수로 천천히 세안해주는게 좋아요");
                ans.add(item4);

                break;
            case "색소침착" :
                item1.put("title","평상시 자외선 차단제 꼼꼼히 발라주기");
                item1.put("value","햇빛, 메이크업, 냉난방을 주의해주세요");
                ans.add(item1);

                item2.put("title","충분한 휴식으로 스트레스 줄이기");
                item2.put("value","실내 습도 40~70%로 유지해주는 것이 중요해요");
                ans.add(item2);

                item3.put("title","음주와 흡연 자제하기");
                item3.put("value","하루에 2L 정도의 물을 마시는 습관을 가지는게 좋아요");
                ans.add(item3);

                item4.put("title","비타민이 풍부한 제철과일 섭취하기");
                item4.put("value","뜨거운 물은 수분을 빼앗아 갈 수 있어요. 미온수로 천천히 세안해주는게 좋아요");
                ans.add(item4);

                break;
            case "트러블" :
                item1.put("title","트러블 유발하는 원인 알아두기");
                item1.put("value","기름진 음식, 자외선, 마스크사용 등은 트러블을 유발하기 좋아요");
                ans.add(item1);

                item2.put("title","잘못된 클렌징 습관 고치기");
                item2.put("value","실내 습도 40~70%로 유지해주는 것이 중요해요");
                ans.add(item2);

                item3.put("title","기름진 음식 피하기");
                item3.put("value","하루에 2L 정도의 물을 마시는 습관을 가지는게 좋아요");
                ans.add(item3);

                item4.put("title","얼굴 만지는 행동 삼가기");
                item4.put("value","뜨거운 물은 수분을 빼앗아 갈 수 있어요. 미온수로 천천히 세안해주는게 좋아요");
                ans.add(item4);
                break;
            default:
                return null;
        }
        return ans;
    }

}
