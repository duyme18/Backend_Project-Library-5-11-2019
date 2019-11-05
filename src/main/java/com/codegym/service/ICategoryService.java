package com.codegym.service;

import com.codegym.model.Category;

public interface ICategoryService {
    Iterable<Category> findAll();

    Category findById(Long id);

    void remove(Long id);

    void save(Category category);
}
