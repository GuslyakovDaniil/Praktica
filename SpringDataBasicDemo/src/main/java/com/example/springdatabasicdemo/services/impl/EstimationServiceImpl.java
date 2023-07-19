package com.example.springdatabasicdemo.services.impl;

import com.example.springdatabasicdemo.dtos.AuthorDto;
import com.example.springdatabasicdemo.dtos.EstimationDto;
import com.example.springdatabasicdemo.models.Author;
import com.example.springdatabasicdemo.models.Estimation;
import com.example.springdatabasicdemo.repositories.EstimationRepository;
import com.example.springdatabasicdemo.services.EstimationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EstimationServiceImpl implements EstimationService<Integer> {
    @Autowired
    private EstimationRepository estimationRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public EstimationDto registerEstimation(EstimationDto estimation) {
        Estimation s = modelMapper.map(estimation, Estimation.class);
        return modelMapper.map(estimationRepository.save(s), EstimationDto.class);
    }

    @Override
    public void expelEstimation(Integer id) {
        estimationRepository.deleteById(id);
    }

    @Override
    public void expelEstimation(EstimationDto estimation) {
        estimationRepository.deleteById(estimation.getId());
    }

    @Override
    public Optional<EstimationDto> findEstimation(Integer id) {
        return estimationRepository.findById(id)
                .map(estimation -> modelMapper.map(estimation, EstimationDto.class));
    }
}