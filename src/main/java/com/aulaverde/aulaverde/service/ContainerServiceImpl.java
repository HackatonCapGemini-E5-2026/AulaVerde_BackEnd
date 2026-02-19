package com.aulaverde.aulaverde.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.aulaverde.aulaverde.entity.Alert;
import com.aulaverde.aulaverde.entity.Container;
import com.aulaverde.aulaverde.repository.AlertRepository;
import com.aulaverde.aulaverde.repository.ContainerRepository;

@Service
public class ContainerServiceImpl implements ContainerService {

    private final ContainerRepository containerRepository;
    private final AlertRepository alertRepository;

    public ContainerServiceImpl(ContainerRepository containerRepository, AlertRepository alertRepository) {
        this.containerRepository = containerRepository;
        this.alertRepository = alertRepository;
    }

    @Override
    public Container createContainer(Container container) {
        return containerRepository.save(container);
    }

    @Override
    public void updateContainerWeight(Integer containerId, Double newWasteWeight) {
        Container container = containerRepository.findById(containerId).get();
        container.setCurrentWeightKg(container.getCurrentWeightKg() + newWasteWeight);
        int newPercentFull = (int) ((container.getCurrentWeightKg() / container.getMaxWeightKg()) * 100);
        container.setPercentFull(newPercentFull);
        containerRepository.save(container);
        this.checkAndCreateAlerts(container);
    }

    @Override
    public List<Container> getAllContainers() {
        return containerRepository.findAll();
    }

    @Override
    public Optional<Container> getContainerById(Integer containerId) {
        return containerRepository.findById(containerId);
    }

    @Override
    public void deleteContainer(Integer id) {
        containerRepository.deleteById(id);
    }

    @Override
    public void emptyContainer(Integer containerId) {
        Container container = containerRepository.findById(containerId).get();
        container.setCurrentWeightKg(0.0);
        container.setPercentFull(0);
        container.setNeedEmpty(false);
        container.setLastEmpty(java.time.LocalDateTime.now());
        containerRepository.save(container);
    }

    private void checkAndCreateAlerts(Container container) {
        int percent = container.getPercentFull();
        if (percent >= 75) {
            if (percent >= 90) {
                container.setNeedEmpty(true);
                containerRepository.save(container);
            }
            Alert alert = new Alert();
            alert.setPercentAlert(percent);
            alert.setCleared(false);
            alert.setContainer(container);
            alert.setDate(LocalDate.now());
            if (percent >= 90) {
                alert.setMessage("CRÍTICO: Contenedor " + container.getCategory() + " requiere vaciado urgente ("
                        + percent + "%)");
            } else {
                alert.setMessage("WARNING: Contenedor " + container.getCategory() + " ha superado el límite del 75% ("
                        + percent + "%)");
            }
            alertRepository.save(alert);
        }
    }

}
