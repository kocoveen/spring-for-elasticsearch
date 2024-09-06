package org.example.elasticsearch.book;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/book")
public class BookController {

    private final BookRepository bookRepository;

    @GetMapping
    public String getAll() {
        Iterable<Book> all = bookRepository.findAll();
        log.info("asdf {}", all);
        return "Hello World!";
    }

    @PostMapping
    public String store(@RequestBody Book book) {
        bookRepository.save(book);
        return "success!";
    }
}
