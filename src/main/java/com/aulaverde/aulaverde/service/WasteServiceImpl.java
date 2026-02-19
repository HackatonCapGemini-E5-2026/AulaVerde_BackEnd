package com.aulaverde.aulaverde.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.aulaverde.aulaverde.entity.Container;
import com.aulaverde.aulaverde.entity.Waste;
import com.aulaverde.aulaverde.repository.WasteRepository;

@Service
public class WasteServiceImpl implements WasteService{

    private final WasteRepository wasteRepository;
    private final ContainerService containerService;

    public WasteServiceImpl(WasteRepository wasteRepository,ContainerService containerService ){
        this.wasteRepository = wasteRepository;
        this.containerService = containerService;
    }

    @Override
    public Waste createWaste(Waste waste, int containerId) {
        Container container = containerService.getContainerById(containerId).get();
        waste.setContainer(container);
        Waste savedWaste = wasteRepository.save(waste);
        containerService.updateContainerWeight(containerId, savedWaste.getWeight());
        return savedWaste;
    }

    @Override
    public List<Waste> getAllWaste() {
        return wasteRepository.findAll();
    }

    @Override
    public Optional<Waste> getWasteById(int id) {
        Optional<Waste> optionalWaste = wasteRepository.findById(id);
        if(optionalWaste.isEmpty()) throw new RuntimeException("No existe residuo con este id");
        return optionalWaste;
    }

    @Override
    public void deleteWaste(int id) {
        Optional<Waste> optionalWaste = wasteRepository.findById(id);
        if(optionalWaste.isEmpty()) throw new RuntimeException("No existe residuo con este id");
        wasteRepository.delete(optionalWaste.get());
        }

}
