package com.codegym.controller;

import com.codegym.model.Book;
import com.codegym.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/book")
public class ApiBookController {
    @Autowired
    //test
    private IBookService bookService;

    @GetMapping
    public ResponseEntity<List<Book>> getBookList(){
        List<Book> books = (List<Book>) bookService.findAll();

        if(books.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(books,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody Book book){
        Book insertedBook = bookService.save(book);
        return new ResponseEntity<>(insertedBook,HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBook(@PathVariable Long id){
        Book book = bookService.findById(id);

        if(book == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(book,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id){
        Book book = bookService.findById(id);

        if(book == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        bookService.remove(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
