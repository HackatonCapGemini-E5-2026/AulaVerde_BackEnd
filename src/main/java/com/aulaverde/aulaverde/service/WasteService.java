package com.aulaverde.aulaverde.service;

import java.util.List;
import java.util.Optional;

import com.aulaverde.aulaverde.entity.Waste;

public interface WasteService {

    public Waste createWaste(Waste waste, int containerId);

    public List<Waste> getAllWaste();

    public Optional<Waste> getWasteById(int id);

    public void deleteWaste(int id);

    

}
