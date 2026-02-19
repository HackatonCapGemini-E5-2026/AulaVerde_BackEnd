package com.aulaverde.aulaverde.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aulaverde.aulaverde.entity.Waste;

public interface WasteRepository extends JpaRepository<Waste, Integer>{
    
}
