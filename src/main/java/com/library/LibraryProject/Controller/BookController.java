package com.library.LibraryProject.Controller;

import com.library.LibraryProject.Model.Author;
import com.library.LibraryProject.Model.Book;
import com.library.LibraryProject.Repository.AuthorRepository;
import com.library.LibraryProject.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    AuthorRepository arepo;

    @Autowired
    private BookService service;
    @RequestMapping("/")
    public String getRoot(){
        return "Hello World";
    }

    @GetMapping("/allbooks")
    public List<Book> getAllBooks(){
        return service.getAllBooks();
    }

    @GetMapping("allauthors")
    public List<Author> getAllAuthors(){return service.getAllAuthors();}

saveBook    public List<Book> search(@PathVariable String text){
        return service.search(text);
    }

    @GetMapping("/books/{text}/{num}")
    public List<Book> searchByTextAndNum(@PathVariable String text , @PathVariable long num){
        return service.searchByTextAndNum(text , num);
    }

    @PostMapping("/save-Books")
    public void saveBook(@RequestBody Book book){
        service.saveBook(book);
    }

    @PostMapping("/save-Authors")
    public void saveAuthor(@RequestBody Author auth)    {
        service.saveAuthor(auth);
    }

    @GetMapping("/findBooks/{AuthName}?")
    public List<Book> findBooksBasedOnAuth(@PathVariable String authName){
        return service.findbooksbasedonauth(authName);
    }

    @GetMapping("/findAuth/{likeAuth}?")
    public List<Author> findAuthorsRegex(@PathVariable String likeAuth){
        return service.findauthorsregex(likeAuth);
    }

}
