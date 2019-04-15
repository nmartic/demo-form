package com.example.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private String description;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "question_type", referencedColumnName = "id")
    @MapsId
    private QuestionType question_type;

    @OneToMany(mappedBy = "given_answers")
    private Set<GivenAnswer> givenAnswers;

    @OneToMany(mappedBy = "possible_answers")
    private Set<PossibleAnswer> possibleAnswers;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public QuestionType getQuestion_type() {
        return question_type;
    }

    public void setQuestion_type(QuestionType question_type) {
        this.question_type = question_type;
    }
}
