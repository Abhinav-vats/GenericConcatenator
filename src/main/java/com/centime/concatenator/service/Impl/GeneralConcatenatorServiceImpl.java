package com.centime.concatenator.service.Impl;

import com.centime.concatenator.service.GeneralConcatenatorService;
import com.centime.concatenator.vo.DetailVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


@Service
@Slf4j
public class GeneralConcatenatorServiceImpl implements GeneralConcatenatorService {

    @Value("${url.hello}")
    private String helloUrl;
    @Value("${url.concatenated.name}")
    private String nameUrl;

    @Autowired
    private WebClient webClient;

    @Override
    public String getCompleteMessageComponents(DetailVo detailVo) {
        log.info("Entered: getCompleteMessageComponents|"+getClass().getName());
        final String helloMessage = getGreetingMessage();
        final String nameConcatenated = getNameConcatenated(detailVo);
        log.info("Exited: getCompleteMessageComponents|"+getClass().getName());
        return helloMessage.concat(" ").concat(nameConcatenated);
    }

    private String getNameConcatenated(DetailVo detailVo) {
        log.info("Entered: getNameConcatenated|"+getClass().getName());
        log.info("Exited: getNameConcatenated|"+getClass().getName());
        return webClient.post()
                .uri(nameUrl)
                //.uri("http://localhost:8082/v1/centime/name/concatenator")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(detailVo)
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

    private String getGreetingMessage() {
        log.info("Entered: getGreetingMessage|"+getClass().getName());
        log.info("Exited: getGreetingMessage|"+getClass().getName());
        return webClient.get()
                .uri(helloUrl)
                //.uri("http://localhost:8081/v1/centime/hello/message")
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}
