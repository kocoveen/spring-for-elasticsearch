package org.example.elasticsearch.log;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogDocumentRepository extends ElasticsearchRepository<LogDocument, String> {

}
