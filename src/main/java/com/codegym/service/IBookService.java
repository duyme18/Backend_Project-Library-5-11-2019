package com.codegym.service;

import com.codegym.model.Book;

public interface IBookService {
    Iterable<Book> findAll();

    Book findById(Long id);

    void remove(Long id);

    Book save(Book book);
}
