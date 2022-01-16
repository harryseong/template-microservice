package com.harryseong.templatemicroservice.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Objects;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class MemoryStat {
    private Long freeMemory;
    private Long totalMemory;
    private Long maxMemory;

    @Override
    public int hashCode() {
        return Objects.hash(freeMemory, totalMemory, maxMemory);
    }

    @Override
    public String toString() {
        return "MemoryDto{" +
                "freeMemory=" + NumberFormat.getNumberInstance(Locale.US).format(freeMemory)+
                ", totalMemory=" + NumberFormat.getNumberInstance(Locale.US).format(totalMemory) +
                ", maxMemory=" + NumberFormat.getNumberInstance(Locale.US).format(maxMemory) +
                '}';
    }
}
