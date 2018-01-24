package com.domeastudio.mappingo.servers.microservice.surveying.domain.mongodb.pojo;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.Date;
import java.util.List;

//地籍测绘
@Document(collection = "archives_info")
public class CadastralProjectEntity {
    @Id
    private String id;
    private List<FileEntity> fileEntity;
    private List<FileEntity> receiptFile;
    private List<FileEntity> otherFile;
    private String name;
    private String props;
    private Date createTime;
    private Date uploadTime;
}
