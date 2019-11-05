package com.codegym.service;

import com.codegym.model.Status;

public interface IStatusService {
    Iterable<Status> findAll();

    Status findById(Long id);

    void remove(Long id);

    void save(Status status);
}
