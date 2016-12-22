package com.fyc.controller;

import com.fyc.config.ApplicationProperties;
import com.fyc.controller.model.FileDTO;
import com.fyc.dao.model.File;
import com.fyc.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

@Controller
@RequestMapping("/file")
public class FileController {

    @Autowired
    private FileService fileService;

    @Resource
    private ApplicationProperties properties;

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public ResponseEntity upload(Authentication authentication, MultipartHttpServletRequest request,
                                 HttpServletResponse response) {

        Iterator<String> itr = request.getFileNames();
        Collection<File> fileCollection = new ArrayList<>();

        while (itr.hasNext()) {

            MultipartFile mpf = request.getFile(itr.next());

            try {
                String originalFileName = mpf.getOriginalFilename();
                String contentType = mpf.getContentType();
                Long fileSize = mpf.getSize() / 1024;
                String filesPath = properties.getFilesPath();

                FileDTO fileDTO = new FileDTO(originalFileName, contentType, fileSize);

                File file = fileService.uploadFile(fileDTO);

                FileCopyUtils.copy(mpf.getBytes(), new FileOutputStream(filesPath + file.getId()));

                fileCollection.add(file);
            } catch (IOException e) {
                e.printStackTrace();

            }
        }
        return ResponseEntity.ok(fileCollection);
    }

    @RequestMapping(value = "/get/{fileId}", method = RequestMethod.GET)
    public void getFileById(HttpServletResponse response, @PathVariable Long fileId) {
        File file = fileService.getFile(fileId);
        java.io.File ioFile = new java.io.File(properties.getFilesPath() + file.getId());

        try {
            FileInputStream fis = new FileInputStream(ioFile);
            response.setContentType(file.getContentType());
            response.setHeader("Content-disposition", "attachment; filename=\"" + file.getName() + "\"");
            ServletOutputStream outputStream = response.getOutputStream();
            byte[] buf = new byte[(int) ioFile.length()];

            int c;
            while ((c = fis.read(buf, 0, buf.length)) > 0) {
                outputStream.write(buf, 0, c);
                outputStream.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @PostMapping(value = "/delete", params = "fileId", headers = "Accept=application/json")
    public void deleteFileById(@RequestParam(value = "fileId") Long fileId) {
        fileService.deleteFile(fileId);
    }
}