package com.ll.sbb.controller;

import com.ll.sbb.domain.question.Question;
import com.ll.sbb.domain.question.QuestionRepository;
import com.ll.sbb.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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

    @GetMapping("/question/detail/{questionId}")
    public String detail(Model model,@PathVariable Integer questionId){
        Question question = questionService.getQuestion(questionId);
        model.addAttribute("question", question);
        return "question-detail";
    }
}
