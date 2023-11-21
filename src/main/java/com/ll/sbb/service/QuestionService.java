package com.ll.sbb.service;

import com.ll.sbb.domain.question.Question;
import com.ll.sbb.domain.question.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionRepository questionRepository;

    public List<Question> getList() {
        return questionRepository.findAll();
    }
}
