package com.example.jpademo;

import lombok.*;

import javax.validation.constraints.*;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserCreateRequest {

    @Min(value=1)
    @Max(value=100)
    private int age;

    @NotBlank
    @Size(max = 10)
    private String name;

    @Email
    private String email;

    private Boolean isSeniorCitizen;

    private boolean checkIfSeniorCitizen(){
        return this.age >=60;
    }

    public User toUser(){
        return User.builder()
                .name(name)
                .email(email)
                .age(age)
                .isSeniorCitizen(isSeniorCitizen == null ? checkIfSeniorCitizen():isSeniorCitizen)
                .build();
    }


}
