package com.ll.sbb.service;

import com.ll.sbb.domain.question.Question;
import com.ll.sbb.domain.question.QuestionRepository;
import com.ll.sbb.exception.DataNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionRepository questionRepository;

    public List<Question> getList() {
        return questionRepository.findAll();
    }

    public Question getQuestion(Integer questionId){
        Optional<Question> byId = questionRepository.findById(questionId);
        return byId.orElseThrow(() ->  new DataNotFoundException("question not found"));
    }

    public void create(String subject, String content) {
        Question question = new Question(subject,content);
        questionRepository.save(question);
    }

    public Page<Question> getList(Pageable pageable) {
        return questionRepository.findAll(pageable);
    }
}
