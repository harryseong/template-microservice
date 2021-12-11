package com.harryseong.templatemicroservice.controller;

import com.harryseong.templatemicroservice.TemplateMicroserviceApplication;
import com.harryseong.templatemicroservice.domain.MemoryDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RequestMapping(value = "/api/v1")
@RestController
public class ApiControllerV1 {

    private static final Logger LOGGER = LoggerFactory.getLogger(TemplateMicroserviceApplication.class);

    private final AtomicLong counter = new AtomicLong();

    @GetMapping("memory")
    public MemoryDto GetMemoryDetails() {
        MemoryDto memoryDto = new MemoryDto(
                Runtime.getRuntime().freeMemory(),
                Runtime.getRuntime().totalMemory(),
                Runtime.getRuntime().maxMemory()
        );
        LOGGER.info(String.format("Memory details: %s", memoryDto));
        return memoryDto;
    }

    @GetMapping("math/sum")
    public int GetSum(@RequestParam int num1, @RequestParam int num2) {
        int sum = num1 + num2;
        LOGGER.info(String.format("It adds up! %d + %d = %d", num1, num2, sum));
        return sum;
    }
}
