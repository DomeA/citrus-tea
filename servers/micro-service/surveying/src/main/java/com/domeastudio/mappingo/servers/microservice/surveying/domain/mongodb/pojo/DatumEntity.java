package com.domeastudio.mappingo.servers.microservice.surveying.domain.mongodb.pojo;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.List;

@Document(collection = "archives_info")
public class DatumEntity {
    @Id
    private String id;
    private String name;
    private List<FileEntity> fileEntityList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<FileEntity> getFileEntityList() {
        return fileEntityList;
    }

    public void setFileEntityList(List<FileEntity> fileEntityList) {
        this.fileEntityList = fileEntityList;
    }
}
