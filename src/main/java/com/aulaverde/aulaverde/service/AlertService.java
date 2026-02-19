package com.aulaverde.aulaverde.service;

import java.util.List;
import java.util.Optional;

import com.aulaverde.aulaverde.entity.Alert;

public interface AlertService {

    public Alert createAlert(Alert alert);

    public List<Alert> getAllAlerts();

    public Optional<Alert> getAlertById(int id);

    public void deleteAlert(int id);

}
