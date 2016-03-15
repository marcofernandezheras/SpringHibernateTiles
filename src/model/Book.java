package model;

import javax.persistence.*;

/**
 * Created by Marco A. Fernández Heras on 9/03/16.
 */
@Entity
@Table(name = "book")
public class Book {
    private int id;
    private String title;
    private String author;
    private String topic;
    private int pages;
    private double price;
    private byte isNew;
    private byte formatOne;
    private byte formatTwo;
    private byte formatThree;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title", nullable = false, length = 150)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "author", nullable = false, length = 150)
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Basic
    @Column(name = "topic", nullable = false, length = 150)
    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    @Basic
    @Column(name = "pages", nullable = false)
    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    @Basic
    @Column(name = "price", nullable = false, precision = 0)
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Basic
    @Column(name = "isNew", nullable = false)
    public byte getIsNew() {
        return isNew;
    }

    public void setIsNew(byte isNew) {
        this.isNew = isNew;
    }

    @Basic
    @Column(name = "formatOne", nullable = false)
    public byte getFormatOne() {
        return formatOne;
    }

    public void setFormatOne(byte formatOne) {
        this.formatOne = formatOne;
    }

    @Basic
    @Column(name = "formatTwo", nullable = false)
    public byte getFormatTwo() {
        return formatTwo;
    }

    public void setFormatTwo(byte formatTwo) {
        this.formatTwo = formatTwo;
    }

    @Basic
    @Column(name = "formatThree", nullable = false)
    public byte getFormatThree() {
        return formatThree;
    }

    public void setFormatThree(byte formatThree) {
        this.formatThree = formatThree;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (id != book.id) return false;
        if (pages != book.pages) return false;
        if (Double.compare(book.price, price) != 0) return false;
        if (isNew != book.isNew) return false;
        if (formatOne != book.formatOne) return false;
        if (formatTwo != book.formatTwo) return false;
        if (formatThree != book.formatThree) return false;
        if (title != null ? !title.equals(book.title) : book.title != null) return false;
        if (author != null ? !author.equals(book.author) : book.author != null) return false;
        if (topic != null ? !topic.equals(book.topic) : book.topic != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (topic != null ? topic.hashCode() : 0);
        result = 31 * result + pages;
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (int) isNew;
        result = 31 * result + (int) formatOne;
        result = 31 * result + (int) formatTwo;
        result = 31 * result + (int) formatThree;
        return result;
    }
}
