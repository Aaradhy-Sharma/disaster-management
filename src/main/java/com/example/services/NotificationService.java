package com.example.services;

import com.example.models.DisasterPrediction;
import com.example.utils.OpenAIClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    @Autowired
    private OpenAIClient openAIClient;

    public void generateAlerts(String[] affectedAreas, String disasterType) {
        DisasterPrediction prediction = new DisasterPrediction();
        // Fetch disaster prediction details

        String prompt = "Generate a personalized alert and instructions for residents in the following areas: " + String.join(", ", affectedAreas) + " regarding a potential " + disasterType + " disaster based on the following details: " + prediction.getDetails();

        String alert = openAIClient.generateText(prompt);

        // Send the alert to residents using notification services
    }
}