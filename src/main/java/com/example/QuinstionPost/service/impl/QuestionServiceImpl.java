package com.example.QuinstionPost.service.impl;

import com.example.QuinstionPost.Dto.QuestionDto;
import com.example.QuinstionPost.entity.Question;
import com.example.QuinstionPost.repository.QuestionRepository;
import com.example.QuinstionPost.service.QuestionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionServiceImpl implements QuestionService {


    @Autowired
    QuestionRepository questionRepository;

    @Override
    public QuestionDto addQuestion(QuestionDto questionDto, String accountId) {
        Question questionToBePosted = new Question();
        BeanUtils.copyProperties(questionDto,questionToBePosted);
        questionToBePosted.setAccountId(accountId);
        LocalDateTime localDate = LocalDateTime.now();
        questionToBePosted.setDateCreated(Date.from(localDate.atZone(ZoneId.systemDefault()).toInstant()));
        questionRepository.save(questionToBePosted);
        //send notification to common infra

        //
        return questionDto;
    }

    @Override
    public List<QuestionDto> viewAllQuestions() {
        List<Question> allQuestion = questionRepository.findAll();
        System.out.println(allQuestion);
        List<QuestionDto> allQuestionDto= new ArrayList<>();
        for(Question question: allQuestion){
            QuestionDto questionDto = new QuestionDto();
            BeanUtils.copyProperties(question,questionDto);
            allQuestionDto.add(questionDto);
        }
        return allQuestionDto;
    }

    @Override
    public List<QuestionDto> viewQuestionsByCategory(String category) {
        List<Question> allQuestion = questionRepository.findByCategory(category);
        List<QuestionDto> allQuestionDto= new ArrayList<>();
        for(Question question: allQuestion){
            QuestionDto questionDto = new QuestionDto();
            BeanUtils.copyProperties(question,questionDto);
            allQuestionDto.add(questionDto);
        }
        return allQuestionDto;
    }

    @Override
    public List<QuestionDto> viewQuestionsByAccount(String accountId) {
        List<Question> allQuestion = questionRepository.findByAccountId(accountId);
        List<QuestionDto> allQuestionDto= new ArrayList<>();
        for(Question question: allQuestion){
            QuestionDto questionDto = new QuestionDto();
            BeanUtils.copyProperties(question,questionDto);
            allQuestionDto.add(questionDto);
        }
        return allQuestionDto;
    }

    @Override
    public QuestionDto viewQuestionsById(String questionId) {
        Optional<Question> question = questionRepository.findById(questionId);
        QuestionDto questionDto= new QuestionDto();
         BeanUtils.copyProperties(question,questionDto);
        return questionDto;
    }

    @Override
    public void upVote(String questionId) {
        Optional<Question> question = questionRepository.findById(questionId);
        question.get().setNumberOfUpvotes(question.get().getNumberOfUpvotes()+1);
        questionRepository.save(question.get());
    }

    @Override
    public void downVote(String questionId) {
        Optional<Question> question = questionRepository.findById(questionId);
        question.get().setNumberOfDownvotes(question.get().getNumberOfDownvotes()+1);
        questionRepository.save(question.get());
    }
}
