package com.codegym.controller;

import com.codegym.model.Category;
import com.codegym.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
public class ApiCategoryController {
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/api/category")
    public ResponseEntity<List<Category>> getCategoryList(){
        List<Category> categories = (List<Category>) categoryService.findAll();

        if(categories.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(categories,HttpStatus.OK);
    }

    @GetMapping("/api/category/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable Long id){
        Category category = categoryService.findById(id);

        if(category == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(category,HttpStatus.OK);
    }

    @PostMapping("/api/category")
    public ResponseEntity<Void> createCategory(@RequestBody Category category) {
        categoryService.save(category);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/api/category/{id}")
    public ResponseEntity<Category> editCategory(@RequestBody Category category, @PathVariable Long id){
        Category category1 = categoryService.findById(id);
        if(category1 == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        category1.setCategory(category.getCategory());
        categoryService.save(category1);

        return new ResponseEntity<>(category1,HttpStatus.OK);
    }

    @DeleteMapping("/api/category/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id){
        Category category = categoryService.findById(id);

        if(category == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        categoryService.remove(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
