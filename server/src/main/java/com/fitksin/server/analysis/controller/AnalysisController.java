package com.fitksin.server.analysis.controller;

import com.fitksin.server.analysis.service.AnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class AnalysisController {

    private final AnalysisService analysisService;

    @Autowired
    public AnalysisController(AnalysisService analysisService){
        this.analysisService = analysisService;
    }

    public void getIndex(@RequestParam UUID id){

    }

    public void recommendProduct(){

    }

}
