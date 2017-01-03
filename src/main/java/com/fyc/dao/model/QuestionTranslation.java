package com.fyc.dao.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "question_translation", catalog = "fycapp", schema = "public")
public class QuestionTranslation implements Serializable {

    private static final long serialVersionUID = 5871364898637199621L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "question_translation_seq_gen")
    @SequenceGenerator(name = "question_translation_seq_gen", sequenceName = "question_translation_id_seq")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;

    @Column(name = "question_text")
    private String questionText;

    @Column(name = "language")
    private String language;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof QuestionTranslation)) return false;

        QuestionTranslation that = (QuestionTranslation) o;

        if (!id.equals(that.id)) return false;
        if (!question.equals(that.question)) return false;
        if (!questionText.equals(that.questionText)) return false;
        return language.equals(that.language);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + question.hashCode();
        result = 31 * result + questionText.hashCode();
        result = 31 * result + language.hashCode();
        return result;
    }
}
