package com.fyc.service;

import com.fyc.controller.model.FileDTO;
import com.fyc.dao.model.File;

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
