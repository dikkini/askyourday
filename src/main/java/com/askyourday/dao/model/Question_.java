package com.askyourday.dao.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Question.class)
public class Question_ {
    public static volatile ListAttribute<Question, QuestionTranslation> questionTranslation;
    public static volatile SingularAttribute<Question, String> month;
    public static volatile SingularAttribute<Question, String> year;
    public static volatile SingularAttribute<Question, Long> id;
    public static volatile SingularAttribute<Question, String> day;
}
