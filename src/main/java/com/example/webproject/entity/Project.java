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

    @Column(name = "name1")
    private String name1;

    @Column(name = "address")
    private String address;

    @Column(name = "typeWork")
    private String typeWork;

    @Column(name = "startWork")
    private String startWork;

    @Column(name = "endWork")
    private String endWork;

    @Column(name = "priceWork")
    private String priceWork;

    @Column(name = "chiefEngineer")
    private String chiefEngineer;


}

