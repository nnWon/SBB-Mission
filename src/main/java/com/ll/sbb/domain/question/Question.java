package com.ll.sbb.domain.question;

import com.ll.sbb.domain.BaseEntity;
import com.ll.sbb.domain.answer.Answer;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Getter
@Entity
public class Question extends BaseEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    @Column(length = 200)
    private String subject;

    @Column(columnDefinition = "TEXT")
    private String content;

    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
    private List<Answer> answerList;
}
