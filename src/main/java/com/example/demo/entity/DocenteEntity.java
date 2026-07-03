package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "docente")
@Data 
public class DocenteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "coddoc")
    private int coddoc; 

    @Column(name = "nomdoc", nullable = false, length = 100)
    private String nomdoc;

    @Column(name = "itemdoc", length = 20)
    private String itemdoc;

    @Column(name = "especialidad", length = 50)
    private String honesty; 

    @Column(name = "api_estado")
    private int apiEstado; 
}