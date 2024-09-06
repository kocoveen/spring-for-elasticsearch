package org.example.elasticsearch.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchConfiguration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.elasticsearch.support.HttpHeaders;

@EnableElasticsearchRepositories
@Configuration
public class ElasticConfig extends ElasticsearchConfiguration {

    @Override
    public ClientConfiguration clientConfiguration() {
        return ClientConfiguration.builder()
            .connectedTo("localhost:9200")
            .usingSsl("D2791E54E6EEE30857382FA861DCD2E3253F8CCF66EF1AF88414559AAB84A21A")
            .withHeaders(() -> {
                HttpHeaders headers = new HttpHeaders();
                headers.add("Authorization", "ApiKey " + "SFJoanFKRUJSR3pYWGNlT0VsdjI6eE0xN1E0MFJUSzIySmxydUc5RXlrUQ==");
                return headers;
            })
            .build();
    }
}