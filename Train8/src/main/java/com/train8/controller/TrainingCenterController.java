package com.train8.controller;

import com.train8.model.TrainingCenter;
import com.train8.service.TrainingCenterService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/training-centers")
public class TrainingCenterController {

    private final TrainingCenterService service;

    public TrainingCenterController(TrainingCenterService service) {
        this.service = service;
    }

    // POST API to create a new Training Center
    @PostMapping
    public ResponseEntity<TrainingCenter> createTrainingCenter(@Valid @RequestBody TrainingCenter trainingCenter) {
        TrainingCenter savedCenter = service.saveTrainingCenter(trainingCenter);
        return new ResponseEntity<>(savedCenter, HttpStatus.CREATED);
    }

    // GET API to get all Training Centers
    @GetMapping
    public ResponseEntity<List<TrainingCenter>> getAllTrainingCenters() {
        List<TrainingCenter> centers = service.getAllTrainingCenters();
        return new ResponseEntity<>(centers, HttpStatus.OK);
    }
}
