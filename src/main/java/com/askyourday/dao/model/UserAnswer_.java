package com.askyourday.dao.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(UserAnswer.class)
public class UserAnswer_ {
    public static volatile SingularAttribute<UserAnswer, Question> question;
    public static volatile SingularAttribute<UserAnswer, String> answer;
    public static volatile SingularAttribute<UserAnswer, String> uuid;
    public static volatile SingularAttribute<UserAnswer, User> user;
}
