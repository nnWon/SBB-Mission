package com.ll.sbb.controller;

import com.ll.sbb.domain.question.Question;
import com.ll.sbb.domain.question.QuestionRepository;
import com.ll.sbb.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping("/")
    public String root(){
        return "redirect:/question/list";
    }

    @GetMapping("/question/list")
    public String list(Model model) {
        List<Question> questionList = questionService.getList();
        model.addAttribute("questionList", questionList);
        return "question-list";
    }
}
