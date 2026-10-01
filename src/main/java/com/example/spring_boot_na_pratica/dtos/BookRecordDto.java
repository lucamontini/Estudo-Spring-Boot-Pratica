package com.example.spring_boot_na_pratica.dtos;

import jakarta.validation.constraints.*;

public record BookRecordDto(
    @NotNull @Size(max = 150) String title,
    @NotNull @Size(max = 100) String author,
    @NotNull @Size(max = 100) String publisher,
    @Min(1500) @Max(2100) Integer publicationYear
) {
}