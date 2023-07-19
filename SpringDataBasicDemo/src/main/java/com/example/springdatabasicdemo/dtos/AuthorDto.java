package com.example.springdatabasicdemo.dtos;

import com.example.springdatabasicdemo.models.Author;

public class AuthorDto {

    private int id;
    private String full_name;

    public AuthorDto (){}
    public AuthorDto(int id, String full_name){
        this.full_name = full_name;
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }
    @Override
    public String toString() {
        return "Author { id = " + id + ", full_name = " + full_name + " }";
    }

}
