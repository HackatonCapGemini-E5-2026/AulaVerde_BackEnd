package com.aulaverde.aulaverde.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.aulaverde.aulaverde.entity.Container;
import com.aulaverde.aulaverde.repository.ContainerRepository;

@Service
public class ContainerServiceImpl implements ContainerService {

    private final ContainerRepository containerRepository;

    public ContainerServiceImpl(ContainerRepository containerRepository){
        this.containerRepository = containerRepository;
    }

    @Override
    public Container createContainer(Container container){
        return containerRepository.save(container);
    }

    @Override
    public List<Container> getAllContainers(){
        return containerRepository.findAll();
    }

    @Override
    public Optional<Container> getContainerById(Integer containerId){
        return containerRepository.findById(containerId);
    }

    @Override
    public void deleteContainer(Integer id){
        containerRepository.deleteById(id);
    }
}