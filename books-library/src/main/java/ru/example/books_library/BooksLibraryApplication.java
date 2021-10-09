package ru.example.books_library;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
@Slf4j
public class BooksLibraryApplication implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(BooksLibraryApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) {
        log.info("Application started with command-line arguments: {}", Arrays.toString(args.getSourceArgs()));
        for (String name : args.getOptionNames()) {
            log.info("arg-" + name + "=" + args.getOptionValues(name));
        }
    }
}
