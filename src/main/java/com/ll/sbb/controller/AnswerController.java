package com.ll.sbb.controller;

import com.ll.sbb.domain.question.Question;
import com.ll.sbb.service.AnswerService;
import com.ll.sbb.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@RequestMapping("/answer")
@Controller
public class AnswerController {

    private final QuestionService questionService;
    private final AnswerService answerService;

    @PostMapping("/create/{questionId}")
    public String createAnswer(@PathVariable Integer questionId, @RequestParam String content) {
        Question question = questionService.getQuestion(questionId);
        answerService.create(content, question);
        return "redirect:/question/detail/{questionId}";
    }
}


