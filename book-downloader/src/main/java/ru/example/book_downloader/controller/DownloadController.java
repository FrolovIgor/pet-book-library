package ru.example.book_downloader.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.example.book_downloader.service.DownloadService;

import javax.websocket.server.PathParam;

@Controller
@RequiredArgsConstructor
public class DownloadController {

    private final DownloadService downloadService;

    @RequestMapping(path = "/download/{id}")
    public void download(@PathVariable Long id) {
        downloadService.download(id);
    }
}
