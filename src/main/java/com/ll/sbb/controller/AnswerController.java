package com.ll.sbb.controller;

import com.ll.sbb.domain.question.Question;
import com.ll.sbb.dto.AnswerForm;
import com.ll.sbb.service.AnswerService;
import com.ll.sbb.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@RequestMapping("/answer")
@Controller
public class AnswerController {

    private final QuestionService questionService;
    private final AnswerService answerService;

    @PostMapping("/create/{questionId}")
    public String createAnswer(@PathVariable Integer questionId, @Validated AnswerForm answerForm, BindingResult bindingResult, Model model) {
        Question question = questionService.getQuestion(questionId);

        if (bindingResult.hasErrors()) {
            model.addAttribute("question", question);
            return "question-detail";
        }
        answerService.create(answerForm.getContent(), question);
        return "redirect:/question/detail/{questionId}";
    }
}


