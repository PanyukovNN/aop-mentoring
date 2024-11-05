package ru.panyukovnn.aopmentoring.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.panyukovnn.aopmentoring.annotation.Log;
import ru.panyukovnn.aopmentoring.service.DemoComponent;

@Slf4j
@Component
public class DemoComponentImpl implements DemoComponent {

    @Log
    @Override
    public String doSmthInComponent() {
        log.info("Выполняю логику в @Component");

        return "demo return";
    }
}
