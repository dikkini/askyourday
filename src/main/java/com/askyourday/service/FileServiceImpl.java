package com.askyourday.service;

import com.askyourday.controller.model.FileDTO;
import com.askyourday.dao.FileDAO;
import com.askyourday.dao.GenericDAO;
import com.askyourday.dao.model.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FileServiceImpl implements FileService {

    @Autowired
    @Qualifier(value = "genericDAOImpl")
    private GenericDAO<File, Long> genericDAO;

    @Autowired
    private FileDAO fileDAO;

    @Override
    public File uploadFile(FileDTO fileDTO) {
        File file = new File(fileDTO);
        genericDAO.create(file);
        return file;
    }

    @Override
    public File getFile(Long fileId) {
        return genericDAO.findOne(File.class, fileId);
    }

    @Override
    public void deleteFile(Long fileId) {
        File file = genericDAO.findOne(File.class, fileId);
        genericDAO.delete(file);
    }
}
