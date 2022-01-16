package com.harryseong.templatemicroservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class MathService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MathService.class);

    private static int sumCounter = 0;

    public int add(int[] numbers) {
        sumCounter++;
        LOGGER.info(String.format("Sum counter is: %d", sumCounter));
        int sum = 0;
        for (int i : numbers) sum += i;
        return sum;
    }

    public double divide(double dividend, double divisor) throws ArithmeticException {
        return dividend / divisor;
    }
}
