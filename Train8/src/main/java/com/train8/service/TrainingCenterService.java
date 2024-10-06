package com.train8.service;

import com.train8.model.TrainingCenter;
import com.train8.repository.TrainingCenterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainingCenterService {

    private final TrainingCenterRepository repository;

    public TrainingCenterService(TrainingCenterRepository repository) {
        this.repository = repository;
    }

    public TrainingCenter saveTrainingCenter(TrainingCenter trainingCenter) {
        return repository.save(trainingCenter);
    }

    public List<TrainingCenter> getAllTrainingCenters() {
        return repository.findAll();
    }
}
