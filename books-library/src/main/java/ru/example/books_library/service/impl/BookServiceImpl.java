package ru.example.books_library.service.impl;

import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.example.books_library.domain.Book;
import ru.example.books_library.domain.BookDTO;
import ru.example.books_library.repository.BookRepository;
import ru.example.books_library.service.BookService;
import ru.example.books_library.service.DownloadService;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final DownloadService downloadService;


    @Override
    public List<Book> getAllBooks() {
        return (List<Book>) bookRepository.findAll();
    }

    @Override
    public Book getBook(Long id) throws NotFoundException {
        return bookRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(
                        String.format("Book with id=%s not found!", id)
                ));
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Book addBook(BookDTO bookDTO) {
        Book book = Book.builder()
                .title(bookDTO.getTitle())
                .author(bookDTO.getAuthor())
                .description(bookDTO.getDescription())
                .downloadsCount(0L)
                .build();
        return bookRepository.save(book);
    }

    @Override
    @KafkaListener(topics = "book_downloads", groupId = "group_id")
    public void downloadsIncrement(Long id) throws NotFoundException, InterruptedException {
        downloadService.downloadBook(getBook(id));
    }
}
