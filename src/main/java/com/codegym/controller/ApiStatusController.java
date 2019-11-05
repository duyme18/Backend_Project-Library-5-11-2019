package com.codegym.controller;

import com.codegym.model.Status;
import com.codegym.service.IStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
public class ApiStatusController {
    @Autowired
    private IStatusService statusService;

    @GetMapping("/api/status")
    public ResponseEntity<List<Status>> getStatusList(){
        List<Status> statuses = (List<Status>) statusService.findAll();

        if(statuses.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(statuses,HttpStatus.OK);
    }

    @GetMapping("/api/status/{id}")
    public ResponseEntity<Status> getStatus(@PathVariable Long id){
        Status status = statusService.findById(id);

        if(status == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(status,HttpStatus.OK);
    }

    @PostMapping("/api/status")
    public ResponseEntity<Void> createStatus(@RequestBody Status status) {
        statusService.save(status);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/api/status/{id}")
    public ResponseEntity<Status> editStatus(@RequestBody Status status, @PathVariable Long id){
        Status status1 = statusService.findById(id);
        if(status1 == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        status1.setStatus(status.getStatus());
        statusService.save(status1);

        return new ResponseEntity<>(status1,HttpStatus.OK);
    }

    @DeleteMapping("/api/status/{id}")
    public ResponseEntity<Void> deleteStatus(@PathVariable Long id){
        Status status = statusService.findById(id);

        if(status == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        statusService.remove(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
