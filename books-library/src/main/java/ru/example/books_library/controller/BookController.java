package ru.example.books_library.controller;

import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.example.books_library.domain.Book;
import ru.example.books_library.domain.BookDTO;
import ru.example.books_library.service.BookService;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/book")
public class BookController {

    private final BookService bookService;

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok().body(bookService.getAllBooks());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) throws NotFoundException {
        return ResponseEntity.ok().body(bookService.getBook(id));
    }

    @PostMapping
    public ResponseEntity<Book> addBook(@Validated @RequestBody BookDTO bookDTO) throws URISyntaxException {
        return ResponseEntity.created(new URI(""))
                .body(bookService.addBook(bookDTO));
    }

    @DeleteMapping(path = "/{id}")
    public void deleteBook( @PathVariable Long id) {
        bookService.deleteBook(id);
    }
}
