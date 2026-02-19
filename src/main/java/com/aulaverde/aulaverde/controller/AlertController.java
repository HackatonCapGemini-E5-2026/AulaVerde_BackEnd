package com.aulaverde.aulaverde.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aulaverde.aulaverde.entity.Alert;
import com.aulaverde.aulaverde.service.AlertService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("aulaverde/v1/alerts")
public class AlertController {

    private final AlertService alertService;

    public AlertController(AlertService alertService){
        this.alertService = alertService;
    }

        @PostMapping()
        public ResponseEntity<Alert> createAlert(@RequestBody Alert alert) {
        Alert newAlert = alertService.createAlert(alert);
        return new ResponseEntity<>(newAlert, HttpStatus.CREATED) ;
        }

        @GetMapping
        public ResponseEntity<List<Alert>> getAllAlert() {
        List<Alert> alert = alertService.getAllAlerts();
        return new ResponseEntity<>(alert, HttpStatus.OK);
        }

        @GetMapping("/{id}")
        public ResponseEntity<Alert> getAlertById(@PathVariable int id) {
        Alert alert = alertService.getAlertById(id).get();
        return new ResponseEntity<>(alert, HttpStatus.OK);
        }  
        
        @DeleteMapping("/{id}")
        public ResponseEntity<HttpStatus> deleteAlert(@PathVariable int id){
        alertService.deleteAlert(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

        

}
