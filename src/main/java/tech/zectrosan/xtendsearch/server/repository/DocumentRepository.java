package tech.zectrosan.xtendsearch.server.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import tech.zectrosan.xtendsearch.server.entity.Document;

public interface DocumentRepository extends  ElasticsearchRepository<Document, String> {
}
