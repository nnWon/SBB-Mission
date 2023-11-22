package com.ll.sbb.domain.answer;

import com.ll.sbb.domain.BaseEntity;
import com.ll.sbb.domain.question.Question;
import jakarta.persistence.*;
import lombok.Getter;

import static jakarta.persistence.GenerationType.*;

@Getter
@Entity
public class Answer extends BaseEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    @Column(columnDefinition = "TEXT")
    private String content;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    protected Answer() {}

    public Answer(String content, Question question) {
        this.content = content;
        this.question = question;
    }
}

