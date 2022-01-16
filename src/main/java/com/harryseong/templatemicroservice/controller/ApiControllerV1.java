package com.harryseong.templatemicroservice.controller;

import com.harryseong.templatemicroservice.TemplateMicroserviceApplication;
import com.harryseong.templatemicroservice.domain.MemoryStat;
import com.harryseong.templatemicroservice.service.MathService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1")
public class ApiControllerV1 {

    private static final Logger LOGGER = LoggerFactory.getLogger(TemplateMicroserviceApplication.class);

    @Autowired
    private MathService mathService;

    @GetMapping("memory")
    public ResponseEntity<MemoryStat> GetMemoryDetails() {
        try {
            MemoryStat memoryStat = new MemoryStat(
                    Runtime.getRuntime().freeMemory(),
                    Runtime.getRuntime().totalMemory(),
                    Runtime.getRuntime().maxMemory()
            );
            LOGGER.info(String.format("Memory details: %s", memoryStat));
            return ResponseEntity.ok().body(memoryStat);
        } catch (Exception ex) {
            LOGGER.error("There was a server error", ex);
            return ResponseEntity.internalServerError().body(null);
        }
    }

    @GetMapping("math/add")
    public ResponseEntity<Integer> GetSum(@RequestParam int[] numbers) {
        try {
            int sum = mathService.add(numbers);
            HttpHeaders responseHeaders = new HttpHeaders();
            responseHeaders.add("api-key", "testValue");
            return ResponseEntity.ok()
                    .headers(responseHeaders)
                    .body(sum);
        } catch (Exception ex) {
            LOGGER.error("There was a server error", ex);
            return ResponseEntity.internalServerError().body(null);
        }
    }

    @GetMapping("math/divide")
    public ResponseEntity<Double> GetQuotient(@RequestParam double dividend, @RequestParam double divisor) {
        try {
            double quotient = mathService.divide(dividend, divisor);
            HttpHeaders responseHeaders = new HttpHeaders();
            responseHeaders.add("api-key", "testValue");
            return ResponseEntity.ok()
                    .headers(responseHeaders)
                    .body(quotient);
        } catch (ArithmeticException ex) {
            LOGGER.error("There was an arithmetic error.", ex);
            return ResponseEntity.badRequest().body(null);
        } catch (Exception ex) {
            LOGGER.error("There was a server error.", ex);
            return ResponseEntity.internalServerError().body(null);
        }
    }
}
