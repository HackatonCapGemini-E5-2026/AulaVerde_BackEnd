package com.aulaverde.aulaverde.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aulaverde.aulaverde.entity.Alert;

public interface AlertRepository extends JpaRepository<Alert, Integer>{

}
