package org.example.elasticsearch.log;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor

@RestController
@RequestMapping("/logs")
public class LogDocumentController {

    private final LogDocumentService logDocumentService;

    @GetMapping
    public Iterable<LogDocument> getAllLogs() {
        return logDocumentService.getAllLogs();
    }
}
