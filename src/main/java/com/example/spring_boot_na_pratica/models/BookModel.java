package com.example.spring_boot_na_pratica.models;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "tb_books")
public class BookModel {

    @SuppressWarnings("removal")
    @Id
    @Column(name = "id", columnDefinition = "uuid")
    @org.hibernate.annotations.GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(generator = "uuid2")
    private UUID id;

    @Column(nullable = false, length = 150)
    private String title;

    @Column(nullable = false, length = 100)
    private String author;

    @Column(nullable = false, length = 100)
    private String publisher;

    @Column(nullable = false)
    private int publicationYear;

    @Column(columnDefinition = "TEXT")
    private String review;
}