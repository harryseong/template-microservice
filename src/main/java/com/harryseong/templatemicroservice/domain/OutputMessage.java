package com.harryseong.templatemicroservice.domain;

import lombok.*;

@NoArgsConstructor @AllArgsConstructor
@Getter @Setter @ToString
public class OutputMessage {
    private String from;
    private String text;
    private String time;
}
