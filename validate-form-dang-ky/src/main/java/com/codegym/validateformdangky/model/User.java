package com.codegym.validateformdangky.model;

import jakarta.validation.constraints.*;

public class User {
    @NotBlank
    @Size(min = 5, max = 45)
    private String firstName;

    @NotBlank
    @Size(min = 5, max = 45)
    private String lastName;

    @NotNull
    @Min(18)
    private Integer age;

    @NotBlank
    @Pattern(regexp = "^0\\d{9,10}$", message = "Số điện thoại không hợp lệ")
    private String phoneNumber;

    @NotBlank
    @Email
    private String email;

    public User(@NotBlank @Size(min = 2, max = 30) String firstName,
                @NotBlank @Size(min = 2, max = 30) String lastName,
                @Min(18) Integer age,
                @NotBlank
                @Pattern(regexp = "^0\\d{9,10}$", message = "Số điện thoại không hợp lệ") String phoneNumber,
                @NotBlank @Email String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public User() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
