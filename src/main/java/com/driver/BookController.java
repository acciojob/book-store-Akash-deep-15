package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("books")
public class BookController {
    @Autowired
    BookService bookService;

    // One example controller, make the rest by yourself
    @PostMapping("/create-book")
    public ResponseEntity createBook(@RequestBody Book book){
        Book newbook = bookService.createBook(book);
        return new ResponseEntity<>(newbook, HttpStatus.CREATED);
    }

    @GetMapping("/get-book-by-id/{id}")
    public ResponseEntity<Book> findBookById(@PathVariable String id) {
        Book B = bookService.findBookById(id);
        return new ResponseEntity(B, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete-book-by-id/{id}")
    public ResponseEntity deleteBookById(@PathVariable("id") String id) {
        bookService.deleteBookById(id);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
    @GetMapping("/get-all-books")
    public ResponseEntity<List<Book>> findAllBooks() {
        List<Book> ans = bookService.findAllBooks();
        return new ResponseEntity(ans, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete-all-books")
    public ResponseEntity deleteAllBooks() {
        bookService.deleteAllBooks();
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    @GetMapping("/get-books-by-author")
    public ResponseEntity<List<Book>> findBooksByAuthor(@RequestParam String author) {
        List<Book> ans = bookService.findBooksByAuthor(author);
        return new ResponseEntity(ans, HttpStatus.ACCEPTED);
    }

    @GetMapping("/get-books-by-genre")
    public ResponseEntity<List<Book>> findBooksByGenre(@RequestParam String genre) {
        List<Book> ans = bookService.findBooksByGenre(genre);
        return new ResponseEntity(ans, HttpStatus.ACCEPTED);
    }

}
