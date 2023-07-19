package com.example.springdatabasicdemo.services;

import com.example.springdatabasicdemo.dtos.EstimationDto;
import com.example.springdatabasicdemo.models.Estimation;
import org.springframework.stereotype.Service;

import java.util.Optional;


public interface EstimationService<ID> {

    EstimationDto registerEstimation(EstimationDto estimation);
    void expelEstimation(ID id);

    void expelEstimation(EstimationDto estimation);

    Optional<EstimationDto> findEstimation(ID id);

}