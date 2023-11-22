package com.ll.sbb.service;

import com.ll.sbb.domain.answer.Answer;
import com.ll.sbb.domain.answer.AnswerRepository;
import com.ll.sbb.domain.question.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AnswerService {
    private final AnswerRepository answerRepository;

    public void create(String content, Question question) {
        Answer answer = new Answer(content, question);
        answerRepository.save(answer);
    }
}
