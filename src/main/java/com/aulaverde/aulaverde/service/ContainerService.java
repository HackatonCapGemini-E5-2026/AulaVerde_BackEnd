package com.aulaverde.aulaverde.service;

import java.util.List;
import java.util.Optional;

import com.aulaverde.aulaverde.entity.Container;

public interface ContainerService {

    public Container createContainer(Container container);

    void updateContainerWeight(Integer containerId, Double newWasteWeight);

    public List<Container> getAllContainers();

    Container getContainerById(int containerId);

    public void deleteContainer(Integer id);

    void emptyContainer(Integer containerId);

}
