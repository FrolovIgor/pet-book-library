package ru.example.books_library.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.example.books_library.domain.Book;

@Repository
public interface BookRepository extends CrudRepository<Book,Long> {
}
