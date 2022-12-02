package com.driver;
import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
@Component
public class BookRepository {

    private int id;
    private List<Book> bookList;

    public BookRepository(){
        bookList = new ArrayList<>();
        this.id = 1;
    }


    public Book save( Book book){

        book.setId(id);
        id++;
        bookList.add(book);

        return book;
    }

    public Book findBookById(int id){

       List<Book> temp = bookList;

       if(!temp.isEmpty()) {
           for (Book B : temp) {
               if (B.getId() == id)
                   return B;
           }
       }
       return null;
    }

    public List<Book> findAll(){
//        if(!bookList.isEmpty())
             return bookList;
//        else
//        return null;
    }

    public void deleteBookById(int id){
        if(!bookList.isEmpty()) {
            for (Book B : bookList) {
                if (B.getId() == id)
                    bookList.remove(B);
            }
        }
    }

    public void deleteAll(){

        bookList = new ArrayList<>();
        return;
    }

    public List<Book> findBooksByAuthor(String author){

        List<Book> temp = bookList;
        List<Book> ans = new ArrayList<>();

        if(!temp.isEmpty()) {
            for (Book B : temp) {
                if (B.getAuthor() == author)
                    ans.add(B);
            }
        }
        return ans;
    }

    public List<Book> findBooksByGenre(String genre){
        List<Book> temp = bookList;
        List<Book> ans = new ArrayList<>();

        if(!temp.isEmpty()) {
            for (Book B : temp) {
                if (B.getGenre() == genre)
                    ans.add(B);

            }
        }
        return ans;
    }
}
