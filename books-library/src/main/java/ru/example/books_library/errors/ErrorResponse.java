package ru.example.books_library.errors;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class ErrorResponse {
    private long timestamp;
    private int code;
    private String message;
    private List<Map<String, String>> variables;
}
