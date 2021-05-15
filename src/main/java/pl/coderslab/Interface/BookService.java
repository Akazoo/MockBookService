package pl.coderslab.Interface;

import pl.coderslab.Model.Book;
import java.util.List;

public interface BookService {

    List<Book> getBooks();
    Book editBook(Book book);
    Book deleteBook(Long id);
    Book getBookById(Long id);
    Book addBook(Book book);
}