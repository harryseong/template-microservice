package com.harryseong.templatemicroservice.domain;

import lombok.*;

@NoArgsConstructor @AllArgsConstructor
@Getter @Setter @ToString
public class Message {
    private String from;
    private String text;
}
