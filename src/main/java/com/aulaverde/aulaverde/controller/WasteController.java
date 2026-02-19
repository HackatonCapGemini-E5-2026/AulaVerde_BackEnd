package com.aulaverde.aulaverde.controller;

import org.springframework.web.bind.annotation.RestController;

import com.aulaverde.aulaverde.entity.Container;
import com.aulaverde.aulaverde.entity.Waste;
import com.aulaverde.aulaverde.service.WasteService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


//http://localhost:8080/aulaverde/v1/wastes/

@RestController
@RequestMapping("/aulaverde/v1/wastes")
public class WasteController {

        private final WasteService wasteService;

        public WasteController(WasteService wasteService){
            this.wasteService = wasteService;
        }

    @PostMapping
    public ResponseEntity<Waste> createWaste (@RequestBody Waste waste, @PathVariable int containerId ){
        Waste newWaste =  wasteService.createWaste(waste, containerId);
        return new ResponseEntity<>(newWaste, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Waste>> getAllWaste() {
        List<Waste> waste = wasteService.getAllWaste();
        return new ResponseEntity<>(waste, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Waste> getWasteById(@PathVariable int id) {
        Waste waste = wasteService.getWasteById(id).get();
        return new ResponseEntity<>(waste, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteWaste(@PathVariable int id){
        wasteService.deleteWaste(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
}
} 


