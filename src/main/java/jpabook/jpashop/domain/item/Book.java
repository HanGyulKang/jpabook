package jpabook.jpashop.domain.item;

import jpabook.jpashop.controller.Form.BookForm;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("B")
@Getter
@Setter
public class Book extends Item {

    private String author;
    private String isbn;

    public Book createBook(BookForm book) {
        this.setName(book.getName());
        this.setPrice(book.getPrice());
        this.setStockQuantity(book.getStockQuantity());
        this.setAuthor(book.getAuthor());
        this.setIsbn(book.getIsbn());

        return this;
    }
}
