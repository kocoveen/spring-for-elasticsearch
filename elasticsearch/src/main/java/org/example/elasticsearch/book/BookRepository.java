package org.example.elasticsearch.book;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface BookRepository extends ElasticsearchRepository<Book, Long> {

    @Query ("{\"match\": {\"name\": {\"query\": \"?0\"}}}")
    Page<Book> findByName(String name, Pageable pageable);
}
