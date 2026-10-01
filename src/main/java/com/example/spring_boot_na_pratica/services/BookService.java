package com.example.spring_boot_na_pratica.services;

import com.example.spring_boot_na_pratica.models.BookModel;
import com.example.spring_boot_na_pratica.repositories.BookRepository;
import com.example.spring_boot_na_pratica.dtos.BookRecordDto;
import com.example.spring_boot_na_pratica.services.ReviewService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final ReviewService reviewService;

    public BookService(BookRepository bookRepository, ReviewService reviewService) {
        this.bookRepository = bookRepository;
        this.reviewService = reviewService;
    }

    public List<BookModel> findAll() {
        return bookRepository.findAll().stream()
                .collect(Collectors.toList());
    }

    public Optional<BookModel> findById(UUID id) {
        return bookRepository.findById(id);
    }

    public BookModel save(BookRecordDto dto) {
        BookModel model = new BookModel();
        BeanUtils.copyProperties(dto, model);
        String review = reviewService.generateReview(dto.title());
        model.setReview(review);
        return bookRepository.save(model);
    }

    public BookModel update(UUID id, BookRecordDto dto) {
        BookModel model = bookRepository.findById(id)
                .orElseThrow();
        BeanUtils.copyProperties(dto, model);
        return bookRepository.save(model);
    }

    public void deleteById(UUID id) {
        bookRepository.deleteById(id);
    }
}