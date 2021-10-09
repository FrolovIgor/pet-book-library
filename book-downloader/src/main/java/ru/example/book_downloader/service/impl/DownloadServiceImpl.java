package ru.example.book_downloader.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.example.book_downloader.service.DownloadService;

@Service
@Slf4j
@RequiredArgsConstructor
public class DownloadServiceImpl implements DownloadService {

    private final KafkaTemplate<String, Long> kafkaTemplate;

    @Override
    public void download(Long id) {
        log.debug("Started download book with id={}", id);
        kafkaTemplate.send("book_downloads", id);
    }
}