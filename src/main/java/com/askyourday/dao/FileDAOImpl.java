package com.askyourday.dao;

import com.askyourday.dao.model.File;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class FileDAOImpl extends GenericDAOImpl<File, Long> implements FileDAO {
}
