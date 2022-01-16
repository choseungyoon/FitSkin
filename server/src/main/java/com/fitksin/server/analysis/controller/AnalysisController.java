package com.fitksin.server.analysis.controller;

import com.fitksin.server.analysis.model.SkinIndex;
import com.fitksin.server.analysis.service.AnalysisService;
import com.fitksin.server.common.domain.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/api/analysis")
public class AnalysisController {

    private final AnalysisService analysisService;

    @Autowired
    public AnalysisController(AnalysisService analysisService){
        this.analysisService = analysisService;
    }

    @GetMapping("/index/best")
    public Result getBestIndex(@RequestParam UUID id) throws Exception{
        Result returnResult = Result.successInstance();
        returnResult.setData(this.analysisService.getBestIndex(id));
        return returnResult;
    }

    @GetMapping("/index/worst")
    public Result getWorstIndex(@RequestParam UUID id) throws Exception{
        Result returnResult = Result.successInstance();
        returnResult.setData(this.analysisService.getWorstIndex(id));
        return returnResult;
    }

    @PostMapping("/index")
    public Result insertSkinIndex(@RequestBody SkinIndex skinIndex){
        Result returnResult = Result.successInstance();
        returnResult.setData(this.analysisService.insertSkinIndex(skinIndex));
        return returnResult;
    }

    @GetMapping("/habits")
    public Result recommendHabits(@RequestParam String index){
        Result returnResult = Result.successInstance();
        returnResult.setData(this.analysisService.recommendHabits(index));
        return returnResult;
    }

}
