package com.askyourday.dao.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(QuestionTranslation.class)
public class QuestionTranslation_ {
    public static volatile SingularAttribute<QuestionTranslation, String> language;
    public static volatile SingularAttribute<QuestionTranslation, String> questionText;
    public static volatile SingularAttribute<QuestionTranslation, Question> question;
    public static volatile SingularAttribute<QuestionTranslation, Long> id;
}
