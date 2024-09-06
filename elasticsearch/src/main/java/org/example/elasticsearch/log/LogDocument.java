package org.example.elasticsearch.log;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Document(indexName = "logstash-*")  // Logstash 인덱스 패턴
public class LogDocument {

    @Id
    private String id;

    @Field(type = FieldType.Text, fielddata = true)
    private String message;

    @Field(type = FieldType.Text) // Store as text but will use a custom format for parsing
    private String timestamp;

    @Field(type = FieldType.Object)
    private Event event;

    @Field(type = FieldType.Object)
    private Host host;

    @Field(type = FieldType.Text, fielddata = true)
    private String version;

    @Field(type = FieldType.Object)
    private Log log;

    // Getters and Setters

    public void setTimestamp(LocalDateTime timestamp) {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        this.timestamp = timestamp.format(formatter);
    }

    public LocalDateTime getParsedTimestamp() {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        return LocalDateTime.parse(this.timestamp, formatter);
    }

    @Data
    public static class Event {
        @Field(type = FieldType.Text, fielddata = true)
        private String original;
    }

    @Data
    public static class Host {
        @Field(type = FieldType.Text, fielddata = true)
        private String name;
    }

    @Data
    public static class Log {
        @Field(type = FieldType.Object)
        private File file;

        @Data
        public static class File {
            @Field(type = FieldType.Text, fielddata = true)
            private String path;
        }
    }
}