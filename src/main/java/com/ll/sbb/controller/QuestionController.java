package com.ll.sbb.controller;

import com.ll.sbb.domain.question.Question;
import com.ll.sbb.dto.AnswerForm;
import com.ll.sbb.dto.QuestionForm;
import com.ll.sbb.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/question")
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping("/list")
    public String list(Model model) {
        List<Question> questionList = questionService.getList();
        model.addAttribute("questionList", questionList);
        return "question-list";
    }

    @GetMapping("/create")
    public String questionCreate(QuestionForm questionForm) {
        return "question-form";
    }

    @PostMapping("/create")
    public String questionCreate(@Validated QuestionForm questionForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "question-form";
        }
        questionService.create(questionForm.getSubject(), questionForm.getContent());
        return "redirect:/question/list";
    }

    @GetMapping("/detail/{questionId}")
    public String detail(Model model, @PathVariable Integer questionId, AnswerForm answerForm) {
        Question question = questionService.getQuestion(questionId);
        model.addAttribute("question", question);
        return "question-detail";
    }


}
