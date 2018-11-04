package tech.zectrosan.xtendsearch.server.entity;

import lombok.*;

import java.time.ZonedDateTime;

import javax.persistence.Id;


@org.springframework.data.elasticsearch.annotations.Document(indexName = "documents", type = "document")
public class Document {
 
    @Id
    @Getter @Setter private String id;
     
    @Getter @Setter private String title;
	@Getter @Setter private String uri;
	@Getter @Setter private String content;
	
	@Getter @Setter ZonedDateTime createdAt;
	@Getter @Setter ZonedDateTime updatedAt;
     
     
}