package com.fyc.dao.model;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user_answer", catalog = "fycapp", schema = "public")
public class UserAnswer implements Serializable {

    private static final long serialVersionUID = 2874365798237423123L;

    @Id
    @GeneratedValue(generator = "system-uuid", strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @Column(name = "uuid", unique = true)
    private String uuid;

    @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "user_uuid", referencedColumnName = "uuid")
    private User user;

    @OneToOne(targetEntity = Question.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "question_id", referencedColumnName = "id")
    private Question question;

    @Column(name = "answer")
    private String answer;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserAnswer)) return false;

        UserAnswer that = (UserAnswer) o;

        if (!uuid.equals(that.uuid)) return false;
        if (!user.equals(that.user)) return false;
        if (!question.equals(that.question)) return false;
        return answer.equals(that.answer);

    }

    @Override
    public int hashCode() {
        int result = uuid.hashCode();
        result = 31 * result + user.hashCode();
        result = 31 * result + question.hashCode();
        result = 31 * result + answer.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "UserAnswer{" +
                "uuid='" + uuid + '\'' +
                ", user=" + user +
                ", question=" + question +
                ", answer='" + answer + '\'' +
                '}';
    }
}
