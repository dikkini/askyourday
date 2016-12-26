package com.fyc.dao.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "question", catalog = "fycapp", schema = "public")
public class Question implements Serializable {

    private static final long serialVersionUID = 2874365798237423123L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "question_seq_gen")
    @SequenceGenerator(name = "question_seq_gen", sequenceName = "question_id_seq")
    private Long id;

    @Column(name = "question")
    private String question;

    @Column(name = "day")
    private String day;

    @Column(name = "month")
    private String month;

    @Column(name = "year")
    private String year;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Question)) return false;

        Question question1 = (Question) o;

        if (!id.equals(question1.id)) return false;
        if (!question.equals(question1.question)) return false;
        if (!day.equals(question1.day)) return false;
        if (!month.equals(question1.month)) return false;
        return year.equals(question1.year);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + question.hashCode();
        result = 31 * result + day.hashCode();
        result = 31 * result + month.hashCode();
        result = 31 * result + year.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", day='" + day + '\'' +
                ", month='" + month + '\'' +
                ", year='" + year + '\'' +
                '}';
    }
}
