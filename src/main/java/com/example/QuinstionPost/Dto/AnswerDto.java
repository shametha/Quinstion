package com.example.QuinstionPost.Dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Setter
@Getter
@ToString
public class AnswerDto {
    String questionId;
    String accountId;
    String AnswerDescription;
    int numberOfUpvotes;
    int numberOfDownvotes;
    String codeEmbed;
    String urlEmbed;
    boolean accepted;
}
