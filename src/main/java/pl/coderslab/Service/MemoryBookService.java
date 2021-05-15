package pl.coderslab.Service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import pl.coderslab.Interface.BookService;
import pl.coderslab.Model.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Primary
public class MemoryBookService implements BookService {

    List<Book> bookList;
    private static Long nextId = 4L;

    public MemoryBookService() {
        bookList = new ArrayList<>();
        bookList.add(new Book(1L, "9788324631766", "Thinking in Java", "Bruce Eckel", "Helion", "programming"));
        bookList.add(new Book(2L, "9788324627738", "Rusz glowa Java.", "Sierra Kathy, Bates Bert", "Helion", "programming"));
        bookList.add(new Book(3L, "9780130819338", "Java 2. Podstawy", "Cay Horstmann, Gary Cornell", "Helion", "programming"));
    }

    public List<Book> getBooks() {

        return List.copyOf(bookList);
    } //done

    public Book editBook(Book book) {

        Optional<Book> book1 = find(book.getId());

        if (book1.isPresent()) {
            Book book2 = book1.get();
            int index = bookList.indexOf(book2);

            if (book.getIsbn() != null) {book2.setIsbn(book.getIsbn());}
            if (book.getAuthor() != null) {book2.setAuthor(book.getAuthor());}
            if (book.getPublisher() != null) {book2.setPublisher(book.getPublisher());}
            if (book.getTitle() != null) {book2.setTitle(book.getTitle());}
            if (book.getType() != null) {book2.setType(book.getType());}

            bookList.set(index, book2);
            return book2;
        } else {
            return new Book();
        }
    } //done

    public Book deleteBook(Long id) {

        Optional<Book> book = find(id);

        if (book.isPresent()) {
            bookList.remove(book.get());
            return book.get();
        } else {
            return new Book();
        }
    } //done

    public Book getBookById(Long id) {

        Optional<Book> book = find(id);
        return book.orElseGet(Book::new);

    } //done

    public Book addBook(Book book) {

        book.setId(nextId);
        bookList.add(book);
        nextId++;

        return book;
    } //done

    public Optional<Book> find(Long id) {

        return bookList.stream()
                .filter(x -> x.getId().equals(id))
                .findFirst();
    } //done
}