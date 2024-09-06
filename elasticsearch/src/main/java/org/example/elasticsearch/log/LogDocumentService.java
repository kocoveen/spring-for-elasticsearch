package org.example.elasticsearch.log;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class LogDocumentService {

    private final LogDocumentRepository logDocumentRepository;

    public Iterable<LogDocument> getAllLogs() {
        log.info("why");
        Iterable<LogDocument> all = logDocumentRepository.findAll();
        log.info("{}", all);
        return logDocumentRepository.findAll();
    }
}