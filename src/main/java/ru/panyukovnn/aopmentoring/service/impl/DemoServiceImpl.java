package ru.panyukovnn.aopmentoring.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.panyukovnn.aopmentoring.annotation.Log;
import ru.panyukovnn.aopmentoring.service.DemoService;

@Slf4j
@Service
public class DemoServiceImpl implements DemoService {

    @Log
    @Override
    public void doSmthInService() {
        log.info("Выполняю логику в @Service");
    }
}
