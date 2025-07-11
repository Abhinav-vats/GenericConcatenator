package com.centime.concatenator.service.Impl;

import com.centime.concatenator.service.GeneralConcatenatorService;
import com.centime.concatenator.vo.DetailVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class GeneralConcatenatorServiceHardcodedImpl implements GeneralConcatenatorService {


    @Override
    public String getCompleteMessageComponents(DetailVo detailVo) {
        log.info("Entered: getCompleteMessageComponents|"+getClass().getName());
        log.info("Exited: getCompleteMessageComponents|"+getClass().getName());
        return getHello()+" "+getConcatenatedName(detailVo);
    }

    private String getHello(){
        log.info("Entered: getHello|"+getClass().getName());
        log.info("Exited: getHello|"+getClass().getName());
        return "Hello";
    }

    private String getConcatenatedName(DetailVo detailVo){
        log.info("Entered: getConcatenatedName|"+getClass().getName());
        log.info("Exited: getConcatenatedName|"+getClass().getName());
        return detailVo.getName()+" "+ detailVo.getSurname();
    }
}
