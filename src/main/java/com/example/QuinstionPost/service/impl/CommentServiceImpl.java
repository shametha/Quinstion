package com.example.QuinstionPost.service.impl;

import com.example.QuinstionPost.Dto.CommentDto;
import com.example.QuinstionPost.entity.Answer;
import com.example.QuinstionPost.entity.Comment;
import com.example.QuinstionPost.repository.CommentRepository;
import com.example.QuinstionPost.service.CommentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentRepository commentRepository;

    @Override
    public CommentDto addComment(CommentDto commentDto, String accountId) {
        Comment commentToBePosted = new Comment();
        BeanUtils.copyProperties(commentDto,commentToBePosted);
        commentToBePosted.setAccountId(accountId);
        commentRepository.save(commentToBePosted);
        //send notification to common infra
        return commentDto;
    }
}
