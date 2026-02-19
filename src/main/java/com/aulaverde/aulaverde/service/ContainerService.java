package com.aulaverde.aulaverde.service;

import java.util.List;
import java.util.Optional;

import com.aulaverde.aulaverde.entity.Container;

public interface ContainerService {

    public Container createContainer(Container container);

    public List<Container> getAllContainers();

    Optional<Container> getContainerById(Integer containerId);

    public void deleteContainer(Integer id);


}