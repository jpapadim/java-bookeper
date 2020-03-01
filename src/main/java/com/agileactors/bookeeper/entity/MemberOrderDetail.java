package com.agileactors.bookeeper.entity;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "member_order_detail")
public class MemberOrderDetail {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(hidden = true)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_order_id", nullable = false)
    @NotBlank(message = "member order {error.not.blank}")
    private MemberOrder memberOrder;

    @OneToOne
    @JoinColumn(name = "book_id", nullable = false)
    @NotBlank(message = "book {error.not.blank}")
    private Book book;

    @Column (nullable = false)
    @NotBlank(message = "quantity {error.not.blank}")
    private Integer quantity;

    public Long getId() {
        return id;
    }


    public MemberOrder getMemberOrder() {
        return memberOrder;
    }

    public void setMemberOrder(MemberOrder memberOrder) {
        this.memberOrder = memberOrder;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
