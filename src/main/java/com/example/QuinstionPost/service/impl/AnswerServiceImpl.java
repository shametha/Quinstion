package com.example.QuinstionPost.service.impl;

import com.example.QuinstionPost.Dto.AnswerDto;
import com.example.QuinstionPost.Dto.QuestionDto;
import com.example.QuinstionPost.entity.Answer;
import com.example.QuinstionPost.entity.Question;
import com.example.QuinstionPost.repository.AnswerRepository;
import com.example.QuinstionPost.service.AnswerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    AnswerRepository answerRepository;

    public AnswerDto addAnswer(AnswerDto answerDto, String accountId) {
        Answer answerToBePosted = new Answer();
        BeanUtils.copyProperties(answerDto,answerToBePosted);
        answerToBePosted.setAccountId(accountId);
        LocalDateTime localDate = LocalDateTime.now();
        answerToBePosted.setDateModified(Date.from(localDate.atZone(ZoneId.systemDefault()).toInstant()));
        answerRepository.save(answerToBePosted);
        //send notification to common infra
        return answerDto;
    }

    @Override
    public List<AnswerDto> findByQuestionId(String questionId) {
        List<Answer> allAnswers = answerRepository.findByQuestionId(questionId);
        List<AnswerDto> allAnswerDto= new ArrayList<>();
        for(Answer answer: allAnswers){
            AnswerDto answerDto = new AnswerDto();
            BeanUtils.copyProperties(answer,answerDto);
        }
        return allAnswerDto;
    }
    @Override
    public void upVote(String answerId) {
        Optional<Answer> answer = answerRepository.findById(answerId);
        answer.get().setNumberOfUpvotes(answer.get().getNumberOfUpvotes()+1);
        answerRepository.save(answer.get());
    }

    @Override
    public void downVote(String questionId) {
        Optional<Answer> answer = answerRepository.findById(questionId);
        answer.get().setNumberOfDownvotes(answer.get().getNumberOfDownvotes()+1);
        answerRepository.save(answer.get());
    }
}
