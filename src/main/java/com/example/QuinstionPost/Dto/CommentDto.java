package com.example.QuinstionPost.Dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class CommentDto {
    String accountId;
    String parentId;
    int level;
    String commentText;
    String codeEmbed;
    String urlEmbed;
}

