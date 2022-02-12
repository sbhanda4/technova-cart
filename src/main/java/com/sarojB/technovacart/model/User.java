package com.sarojB.technovacart.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="user_id")
@Data
public class User {


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @Column
    private String firstName;
    @Column
    private String lastName     ;
    @Column
    private String email;







}
