package com.agileactors.bookeeper.entity;

import com.agileactors.bookeeper.entity.enums.BookStatus;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name="book")
public class Book {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(hidden = true)
    private Long id;


    @JoinColumn(name = "publisher_id", nullable = false)
    private Long publisher;

    private int code;

    @Column(nullable = false)
    @NotBlank(message = "title {error.not.blank}")
    //TODO rename to title?/
    private String title;

    @Column(nullable = false)
    @NotBlank(message = "author {error.not.blank}")
    private String author;

    private Integer year;

    private Double price;

    private Double discount;

    @Column(nullable = false)
    @NotBlank(message = "stock {error.not.blank}")
    private int stock;

    @Column(nullable = false)
    @NotBlank(message = "status {error.not.blank}")
    @Enumerated(EnumType.STRING)
    private BookStatus status;

    public Long getId() {
        return id;
    }



    public Long getPublisher() {
        return publisher;
    }

    public void setPublisher(Long publisher) {
        this.publisher = publisher;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public BookStatus getStatus() {
        return status;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }
}
