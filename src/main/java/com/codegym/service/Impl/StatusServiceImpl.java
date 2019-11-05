package com.codegym.service.Impl;

import com.codegym.model.Status;
import com.codegym.repository.IStatusRepository;
import com.codegym.service.IStatusService;
import org.springframework.beans.factory.annotation.Autowired;

public class StatusServiceImpl implements IStatusService {
    @Autowired
    private IStatusRepository statusRepository;

    @Override
    public Iterable<Status> findAll() {
        return statusRepository.findAll();
    }

    @Override
    public Status findById(Long id) {
        return  statusRepository.findOne(id);
    }

    @Override
    public void remove(Long id) {
        statusRepository.delete(id);
    }

    @Override
    public void save(Status status) {
        statusRepository.save(status);
    }
}
