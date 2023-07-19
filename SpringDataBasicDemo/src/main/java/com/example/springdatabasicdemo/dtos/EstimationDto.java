package com.example.springdatabasicdemo.dtos;

import com.example.springdatabasicdemo.models.Estimation;

public class EstimationDto {


    private int id;
    private int mark;

    public EstimationDto (){}
    public EstimationDto(int id, int mark){
        this.id = id;
        this.mark = mark;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }
}
