package com.example.spring_boot_na_pratica.repositories;

import com.example.spring_boot_na_pratica.models.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface BookRepository extends JpaRepository<BookModel, UUID> {
}