package com.example.spring_boot_na_pratica.controllers;

import com.example.spring_boot_na_pratica.models.BookModel;
import com.example.spring_boot_na_pratica.services.BookService;
import com.example.spring_boot_na_pratica.dtos.BookRecordDto;
import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<BookModel> create(@Valid @RequestBody BookRecordDto dto) {
        BookModel model = bookService.save(dto);
        return ResponseEntity.status(201).body(model);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookModel> update(@PathVariable UUID id, @Valid @RequestBody BookRecordDto dto) {
        Optional<BookModel> optional = bookService.findById(id);
        if (optional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        BookModel model = bookService.update(id, dto);
        return ResponseEntity.ok(model);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        Optional<BookModel> optional = bookService.findById(id);
        if (optional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        bookService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<BookModel>> getAll() {
        List<BookModel> list = bookService.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookModel> getById(@PathVariable UUID id) {
        return bookService.findById(id)
                .map(model -> ResponseEntity.ok(model))
                .orElse(ResponseEntity.notFound().build());
    }
}