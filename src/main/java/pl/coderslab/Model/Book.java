package pl.coderslab.Model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Book {

    private Long id;
    private String isbn;
    private String title;
    private String author;
    private String publisher;
    private String type;
}