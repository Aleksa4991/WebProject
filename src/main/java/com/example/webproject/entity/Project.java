package com.example.webproject.entity;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PROJECTS")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "typeWork")
    private String typeWork;

    @Column(name = "startWork")
    private int startWork;

    @Column(name = "endWork")
    private int endWork;

    @Column(name = "costWork")
    private int costWork;

    @Column(name = "price")
    private int price;

}

