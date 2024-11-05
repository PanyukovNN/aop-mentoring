package ru.panyukovnn.aopmentoring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.panyukovnn.aopmentoring.service.DemoComponent;
import ru.panyukovnn.aopmentoring.service.impl.DemoServiceImpl;

@SpringBootApplication
public class AopMentoringApp implements CommandLineRunner {

    @Autowired
    private DemoComponent demoComponent;
    @Autowired
    private DemoServiceImpl aopServiceImpl;

    public static void main(String[] args) {
        SpringApplication.run(AopMentoringApp.class, args);
    }

    @Override
    public void run(String... args) {
        aopServiceImpl.doSmthInService();
        demoComponent.doSmthInComponent();
    }
}
