package com.example.springdatabasicdemo.models;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    protected int id;

    public BaseEntity(Integer id) {
    }

    protected BaseEntity() {
    }

    public int getId() {
        return id;
    }

    protected void setId(int id) {
        this.id = id;
    }
}
