package com.askyourday.dao.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Role.class)
public abstract class Role_ {

	public static volatile CollectionAttribute<Role, Privilege> privileges;
	public static volatile SingularAttribute<Role, String> name;
	public static volatile SingularAttribute<Role, Long> id;

}

