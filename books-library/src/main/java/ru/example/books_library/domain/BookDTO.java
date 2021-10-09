package ru.example.books_library.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import static ru.example.books_library.service.constants.Constants.EMPTY_FIELD_EXCEPTION;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Valid
public class BookDTO {

    @NotNull(message = EMPTY_FIELD_EXCEPTION)
    @NotBlank(message = EMPTY_FIELD_EXCEPTION)
    @Size(min = 4)
    String title;

    @NotNull(message = EMPTY_FIELD_EXCEPTION)
    @NotBlank(message = EMPTY_FIELD_EXCEPTION)
    String author;

    String description;
}