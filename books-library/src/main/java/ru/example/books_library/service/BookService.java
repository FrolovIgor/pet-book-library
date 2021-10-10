package ru.example.books_library.service;

import javassist.NotFoundException;
import org.springframework.stereotype.Service;
import ru.example.books_library.domain.Book;
import ru.example.books_library.domain.BookDTO;

import java.util.List;

public interface BookService {

    List<Book> getAllBooks();

    Book getBook(Long id) throws NotFoundException;

    void deleteBook(Long id);

    Book addBook(BookDTO book);

    void downloadsIncrement(Long id) throws NotFoundException, InterruptedException;

}
