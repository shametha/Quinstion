package com.example.QuinstionPost.controller;


import com.example.QuinstionPost.Dto.AnswerDto;
import com.example.QuinstionPost.Dto.CommentDto;
import com.example.QuinstionPost.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    CommentService commentService;

    @PostMapping(value = "/addComment/{accountId}")
    CommentDto addComment (@RequestBody CommentDto comment, @PathVariable("accountId") String accountId){
        return commentService.addComment(comment, accountId);
    }
}
