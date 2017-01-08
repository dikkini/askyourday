package com.askyourday.dao;

import com.askyourday.dao.model.Role;
import com.askyourday.handler.RoleEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class RoleDAOImpl extends GenericDAOImpl<Role, Long> implements RoleDAO {

    @Autowired
    private GenericDAO<Role, Long> genericRoleDAO;

    @Override
    public Role findUserRole() {
        return genericRoleDAO.findOne(Role.class, RoleEnum.USER.getId());
    }
}
