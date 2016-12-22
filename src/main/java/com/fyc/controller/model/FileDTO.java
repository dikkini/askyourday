package com.fyc.controller.model;

import javax.validation.constraints.NotNull;

public class FileDTO {

    @NotNull
    private String name;

    @NotNull
    private String contentType;

    @NotNull
    private Long size;

    public FileDTO() {
    }

    public FileDTO(String name, String contentType, Long size) {
        this.name = name;
        this.contentType = contentType;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }
}
