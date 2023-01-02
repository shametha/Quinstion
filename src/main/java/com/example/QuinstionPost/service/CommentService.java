package com.example.QuinstionPost.service;

import com.example.QuinstionPost.Dto.CommentDto;
import com.example.QuinstionPost.Dto.QuestionDto;

public interface CommentService {
    CommentDto addComment (CommentDto commentDto, String accountId);
}
