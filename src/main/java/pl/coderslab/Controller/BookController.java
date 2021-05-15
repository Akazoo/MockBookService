package pl.coderslab.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.Interface.BookService;
import pl.coderslab.Model.Book;
import pl.coderslab.Service.MemoryBookService;

import java.util.List;

@Controller
@RestController
@RequestMapping("/books")

public class BookController {

    @Autowired
    private BookService memoryBookService;

    @GetMapping
    public List<Book> getBooks() {

        return memoryBookService.getBooks();
    } //done

    @PostMapping
    public Book addBook(@RequestBody Book book) {

        return memoryBookService.addBook(book);
    } //done

    @GetMapping("/{id:\\d+}")
    public Book getBookById(@PathVariable Long id) {

        return memoryBookService.getBookById(id);
    } //done

    @PutMapping
    public Book editBook(@RequestBody Book book) {

        return memoryBookService.editBook(book);
    } //done

    @DeleteMapping("/{id:\\d+}")
    public Book deleteBook(@PathVariable Long id) {

        return memoryBookService.deleteBook(id);
    } //done

}