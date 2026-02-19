package com.aulaverde.aulaverde.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.aulaverde.aulaverde.entity.Waste;
import com.aulaverde.aulaverde.repository.WasteRepository;

@Service
public class WasteServiceImpl implements WasteService{

    private final WasteRepository wasteRepository;

    public WasteServiceImpl(WasteRepository wasteRepository){
        this.wasteRepository=wasteRepository;
    }

    @Override
    public Waste createWaste(Waste waste) {
        return wasteRepository.save(waste);
    }

    @Override
    public List<Waste> getAllWaste() {
        return wasteRepository.findAll();
    }

    @Override
    public Optional<Waste> getWasteById(int id) {
        Optional<Waste> optionalWaste = wasteRepository.findById(id);
        if(optionalWaste.isEmpty()) throw new RuntimeException("No existe articulo con este id");
        return optionalWaste;
    }

    @Override
    public void deleteWaste(int id) {
        Optional<Waste> optionalWaste = wasteRepository.findById(id);
        if(optionalWaste.isEmpty()) throw new RuntimeException("No existe articulo con este id");
        wasteRepository.delete(optionalWaste.get());
        }

}
