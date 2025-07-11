package com.centime.concatenator.configuration;


import com.centime.concatenator.service.GeneralConcatenatorService;
import com.centime.concatenator.service.Impl.GeneralConcatenatorServiceHardcodedImpl;
import com.centime.concatenator.service.Impl.GeneralConcatenatorServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GeneralConcatenatorConfiguration {

    @Bean
    public GeneralConcatenatorService generalConcatenationServiceImpl(){
        return new GeneralConcatenatorServiceImpl();
    }

    @Bean
    public GeneralConcatenatorService generalConcatenationServiceHardcodedImpl(){
        return new GeneralConcatenatorServiceHardcodedImpl();
    }
}
