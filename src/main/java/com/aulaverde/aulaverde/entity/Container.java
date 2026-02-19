package com.aulaverde.aulaverde.entity;

import java.sql.Timestamp;
import java.util.List;
import java.util.Locale.Category;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "container")
@Data
@NoArgsConstructor
public class Container {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Integer percent_full;

    @Column(nullable = false)
    private Timestamp last_empty;

    @Column(nullable = false)
    private Boolean need_empty;

    @Column(nullable = false)
    private String color;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Category category;

    @JsonIgnore
    @OneToMany(mappedBy = "waste_id", cascade = CascadeType.ALL)
    private List<Waste> wastes;

    @JsonIgnore
    @OneToMany(mappedBy = "alert_id", cascade = CascadeType.ALL)
    private List<Alert> alerts;

}