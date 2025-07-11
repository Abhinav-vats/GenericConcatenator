package com.centime.concatenator.controller;


import com.centime.concatenator.service.GeneralConcatenatorService;
import com.centime.concatenator.vo.DetailVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/concatenator")
@Slf4j
public class GeneralConcatenatorController {

    private final GeneralConcatenatorService generalConcatenatorService;

    public GeneralConcatenatorController(@Qualifier("generalConcatenationServiceHardcodedImpl") GeneralConcatenatorService generalConcatenatorService) {

        this.generalConcatenatorService = generalConcatenatorService;
    }

    @GetMapping("/check")
    public String healthCheck(){
        log.info("Entered: healthCheck|"+getClass().getName());
        log.info("Exited: healthCheck|"+getClass().getName());
        return "UP";
    }

    @PostMapping(value = "/all", consumes = "application/json")
    public String concatenateAll(@RequestBody DetailVo detailVo){

        log.info("Entered: healthCheck|"+getClass().getName());
        final String concatenatedString = generalConcatenatorService.getCompleteMessageComponents(detailVo);
        log.info("Exited: healthCheck|"+getClass().getName());
        return concatenatedString;
    }
}
