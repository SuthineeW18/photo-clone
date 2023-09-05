package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import jakarta.validation.constraints.NotEmpty;

@Table("PHOTO")
public class Photo {
    @Id
    private Integer id;
    @NotEmpty
    private String fileName;
    private String contentType;

    @JsonIgnore
    private byte[] data;
    public  Photo() {
    }

    public byte[] getData() {
        return  this.data;
    }
    public void setData(byte[] data) {
        this.data = data;
    }
    public String getContentType() {
        return contentType;
    }
    public void setContentType(String contentType) {
        this.contentType = contentType;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public  String getFileName() {
        return fileName;
    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
