package ru.example.books_library.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;
import ru.example.books_library.domain.Book;
import ru.example.books_library.service.DownloadService;

import javax.xml.ws.Action;

@Service
@Slf4j
@EnableAsync
public class DownloadServiceImpl implements DownloadService {

    @Override
    @Async
    public void downloadBook(Book book) throws InterruptedException {
        log.info("Start downloading book, id={}", book.getId());
        //doSomething
        Thread.sleep(5 * 1000);
        log.info("Book download complete, id={}", book.getId());
    }
}
