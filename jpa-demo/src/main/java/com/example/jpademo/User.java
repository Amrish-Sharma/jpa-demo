package com.example.jpademo;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class User implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private int age;

    @Column(name="senior_citizen")
    private boolean isSeniorCitizen;

    @Column(unique=true,nullable = false,length=30)
    private String email;

}
