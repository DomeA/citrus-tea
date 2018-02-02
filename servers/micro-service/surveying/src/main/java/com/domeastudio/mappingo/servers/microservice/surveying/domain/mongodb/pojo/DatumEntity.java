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
}
