package com.askyourday.service;

import com.askyourday.controller.model.FileDTO;
import com.askyourday.dao.model.File;

public interface FileService {

    /**
     *
     * @param fileDTO
     * @return
     */
    File uploadFile(FileDTO fileDTO);

    /**
     *
     * @param fileId
     * @return
     */
    File getFile(Long fileId);

    /**
     *
     * @param fileId
     */
    void deleteFile(Long fileId);
}
