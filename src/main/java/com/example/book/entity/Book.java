package com.example.book.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

//image추가 필요
@Entity
@Table(name = "book")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;
    @CreationTimestamp
    private Date creationDate;
    private String name;
    private String writer;
    private String registrant;
    //registant userId랑 연결해야함
    //userDTO만들고 Feign사용할 것

    public Book(String name, String writer, String registant) {
        this.name = name;
        this.writer = writer;
        this.registrant = registant;
    }
}
