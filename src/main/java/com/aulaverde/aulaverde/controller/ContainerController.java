package com.aulaverde.aulaverde.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aulaverde.aulaverde.entity.Container;
import com.aulaverde.aulaverde.service.ContainerService;

@RestController
@RequestMapping("/aulaverde/v1/containers")
public class ContainerController {

    private final ContainerService containerService;

    public ContainerController(ContainerService containerService) {
        this.containerService = containerService;
    }

    @PostMapping
    public ResponseEntity<Container> createContainer(@RequestBody Container container) {
        Container newContainer = containerService.createContainer(container);
        return new ResponseEntity<>(newContainer, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Container>> getAllContainers() {
        List<Container> containers = containerService.getAllContainers();
        return new ResponseEntity<>(containers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Container> getContainerByid(@PathVariable int id){
        Container container = containerService.getContainerById(id);
        return new ResponseEntity<>(container, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteContainer(@PathVariable int id) {
        containerService.deleteContainer(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}/empty")
    public ResponseEntity<Void> emptyContainer(@PathVariable Integer id) {
        containerService.emptyContainer(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}