package com.harryseong.templatemicroservice.domain;

import java.util.Objects;

public class MemoryDto {
    private Long freeMemory;
    private Long totalMemory;
    private Long maxMemory;

    public MemoryDto(Long freeMemory, Long totalMemory, Long maxMemory) {
        this.freeMemory = freeMemory;
        this.totalMemory = totalMemory;
        this.maxMemory = maxMemory;
    }

    public Long getFreeMemory() {
        return freeMemory;
    }

    public void setFreeMemory(Long freeMemory) {
        this.freeMemory = freeMemory;
    }

    public Long getTotalMemory() {
        return totalMemory;
    }

    public void setTotalMemory(Long totalMemory) {
        this.totalMemory = totalMemory;
    }

    public Long getMaxMemory() {
        return maxMemory;
    }

    public void setMaxMemory(Long maxMemory) {
        this.maxMemory = maxMemory;
    }

    @Override
    public int hashCode() {
        return Objects.hash(freeMemory, totalMemory, maxMemory);
    }

    @Override
    public String toString() {
        return "MemoryDto{" +
                "freeMemory=" + freeMemory +
                ", totalMemory=" + totalMemory +
                ", maxMemory=" + maxMemory +
                '}';
    }
}
