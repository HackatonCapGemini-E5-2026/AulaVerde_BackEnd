package com.aulaverde.aulaverde.service;

import java.util.List;
import java.util.Optional;
import com.aulaverde.aulaverde.repository.AlertRepository;
import org.springframework.stereotype.Service;

import com.aulaverde.aulaverde.entity.Alert;

@Service
public class AlertServiceImpl implements AlertService{

    private final AlertRepository alertRepository;

    AlertServiceImpl(AlertRepository alertRepository) {
        this.alertRepository = alertRepository;
    }

    @Override
    public Alert createAlert(Alert alert) {
        return alertRepository.save(alert);
    }

    @Override
    public List<Alert> getAllAlerts() {
        return alertRepository.findAll();
    }

    @Override
    public Optional<Alert> getAlertById(int id) {
        Optional<Alert> optionalAlert = alertRepository.findById(id);
        if(optionalAlert.isEmpty()) throw new RuntimeException("No existe alert con este id");
        return optionalAlert;
    }

    @Override
    public void deleteAlert(int id) {
        Optional<Alert> optionalAlert = alertRepository.findById(id);
        if(optionalAlert.isEmpty()) throw new RuntimeException("No existe un alert con este id");
        alertRepository.delete(optionalAlert.get());
        }
    }

