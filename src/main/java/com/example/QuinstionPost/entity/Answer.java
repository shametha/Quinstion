package com.example.QuinstionPost.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@ToString
@Document
public class Answer {
    @Id
    String id;
    String questionId;
    String accountId;
    String AnswerDescription;
    int numberOfUpvotes;
    int numberOfDownvotes;
    Date dateModified;

    String codeEmbed;
    String urlEmbed;
    boolean accepted;
}
