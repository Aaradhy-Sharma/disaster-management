package com.example.controllers;

import com.example.models.*;
import com.example.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/disaster")
public class DisasterManagementController {

    @Autowired
    private DataIngestionService dataIngestionService;

    @Autowired
    private MachineLearningService mlService;

    @Autowired
    private NotificationService notificationService;

    @PostMapping("/ingest")
    public ResponseEntity<String> ingestData(@RequestBody DataIngestionRequest request) {
        dataIngestionService.ingestWeatherData(request.getWeatherData());
        dataIngestionService.ingestSatelliteImagery(request.getSatelliteImagery());
        dataIngestionService.ingestSocialMediaFeeds(request.getSocialMediaFeeds());
        return ResponseEntity.ok("Data ingestion successful");
    }
    
    @PostMapping("/predict")
    public ResponseEntity<DisasterPrediction> predictDisaster() {
        mlService.trainModel();
        DisasterPrediction prediction = mlService.predictDisaster();
        return ResponseEntity.ok(prediction);
    }

    
    @PostMapping("/notify")
    public ResponseEntity<String> notifyUsers(@RequestBody NotificationRequest request) {
        notificationService.generateAlerts(request.getAffectedAreas(), request.getDisasterType());
        return ResponseEntity.ok("Notifications sent successfully");
    }
}