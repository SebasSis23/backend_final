package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "login")
@Data
public class LoginEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codlog") 
    private int codlog;

    @Column(name = "usuar", nullable = false, unique = true, length = 50)
    private String usuar;

    @Column(name = "psw", nullable = false, length = 100)
    private String psw;

    @Column(name = "rol", length = 30)
    private String rol;

    @Column(name = "api_estado")
    private int apiEstado;
}