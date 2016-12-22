package com.fyc.dao;

import com.fyc.dao.model.Role;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class RoleDAOImpl extends GenericDAOImpl<Role, Long> implements RoleDAO {
}
