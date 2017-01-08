package com.askyourday.dao.model;

import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(PasswordResetToken.class)
public abstract class PasswordResetToken_ {

	public static volatile SingularAttribute<PasswordResetToken, Date> expireDate;
	public static volatile SingularAttribute<PasswordResetToken, Long> id;
	public static volatile SingularAttribute<PasswordResetToken, User> user;
	public static volatile SingularAttribute<PasswordResetToken, String> token;

}

