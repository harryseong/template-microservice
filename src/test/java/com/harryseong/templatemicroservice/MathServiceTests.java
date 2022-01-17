package com.harryseong.templatemicroservice;

import com.harryseong.templatemicroservice.service.MathService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class MathServiceTests {

    @Autowired
    private MathService mathService;

    @Test
    void add_01() throws Exception {
        int[] numbers = new int[]{1, 3};
        assertThat(this.mathService.add(numbers)).isEqualTo(4);
    }

    @Test
    void add_02() throws Exception {
        int[] numbers = new int[]{1, 3, 2};
        assertThat(this.mathService.add(numbers)).isEqualTo(6);
    }

    @Test
    void add_03() throws Exception {
        int[] numbers = new int[]{};
        assertThat(this.mathService.add(numbers)).isEqualTo(0);
    }

    @Test
    void divide_01() throws Exception {
        assertThat(this.mathService.divide(6, 3)).isEqualTo(2);
    }

    @Test
    void divide_02() throws Exception {
        assertThat(this.mathService.divide(6, 4)).isEqualTo(1.5);
    }

    @Test
    void divide_03() {
        assertThat(this.mathService.divide(6, 0)).isInfinite();
    }
}
