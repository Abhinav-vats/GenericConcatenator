package com.centime.concatenator.controller;


import com.centime.concatenator.service.GeneralConcatenatorService;
import com.centime.concatenator.vo.DetailVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/concatenator")
@Slf4j
public class GeneralConcatenatorController {

    private final GeneralConcatenatorService generalConcatenatorService;

    public GeneralConcatenatorController(@Qualifier("generalConcatenationServiceImpl") GeneralConcatenatorService generalConcatenatorService) {

        this.generalConcatenatorService = generalConcatenatorService;
    }

    @GetMapping("/check")
    public String healthCheck(){
        log.info("Entered: healthCheck|"+getClass().getName());
        log.info("Exited: healthCheck|"+getClass().getName());
        return "UP";
    }

    @PostMapping(value = "/all", consumes = "application/json")
    public ResponseEntity<Map<String, String>> concatenateAll(@RequestBody DetailVo detailVo){

        log.info("Entered: concatenateAll|"+getClass().getName());
        final String concatenatedString = generalConcatenatorService.getCompleteMessageComponents(detailVo);
        Map<String, String> response = new LinkedHashMap<>();
        response.put("status", HttpStatus.OK.getReasonPhrase());
        response.put("message", concatenatedString);
        log.info("Exited: concatenateAll|"+getClass().getName());
        return ResponseEntity.ok(response);
    }
}
