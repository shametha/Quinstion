package com.example.QuinstionPost.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;

@Setter
@Getter
@ToString
@Document
public class Question {
    @Id
    String id;
    private String description;
    private String codeEmbed;
    private String urlEmbed;
    private String accountId;
    private int numberOfUpvotes;
    private int numberOfDownvotes;
    private Date dateCreated;
    private boolean alive;
    private String category;
}
