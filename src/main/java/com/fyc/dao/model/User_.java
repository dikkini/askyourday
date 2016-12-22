package com.fyc.dao.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(User.class)
public abstract class User_ {

	public static volatile SingularAttribute<User, String> firstName;
	public static volatile SingularAttribute<User, String> lastName;
	public static volatile SingularAttribute<User, String> password;
	public static volatile SingularAttribute<User, Boolean> credentialsNonExpired;
	public static volatile CollectionAttribute<User, Role> roles;
	public static volatile CollectionAttribute<User, File> files;
	public static volatile SingularAttribute<User, Boolean> accountNonExpired;
	public static volatile SingularAttribute<User, String> uuid;
	public static volatile SingularAttribute<User, String> email;
	public static volatile SingularAttribute<User, Boolean> enabled;
	public static volatile SingularAttribute<User, String> username;
	public static volatile SingularAttribute<User, Boolean> accountNonLocked;

}

