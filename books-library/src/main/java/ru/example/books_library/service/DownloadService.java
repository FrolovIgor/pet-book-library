package ru.example.books_library.service;

import ru.example.books_library.domain.Book;

public interface DownloadService {
    void downloadBook(Book book) throws InterruptedException;
}
