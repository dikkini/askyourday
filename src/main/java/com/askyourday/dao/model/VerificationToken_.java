package com.askyourday.dao.model;

import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(VerificationToken.class)
public abstract class VerificationToken_ {

	public static volatile SingularAttribute<VerificationToken, Date> expireDate;
	public static volatile SingularAttribute<VerificationToken, Long> id;
	public static volatile SingularAttribute<VerificationToken, User> user;
	public static volatile SingularAttribute<VerificationToken, String> token;

}

