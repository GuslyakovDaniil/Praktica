package com.example.springdatabasicdemo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "estimation")
public class Estimation extends BaseEntity {

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id")
    private Book book;

    @Column(name = "mark")
    private Integer mark;

    public Integer getEstimation() {
        return mark;
    }

    public void setEstimation(Integer estimation) {
        this.mark = estimation;
    }

    public Estimation() {
    }

    protected Estimation(Integer mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "Estimation { id=" + id + ", estimation=" + mark + " }";
    }
}
