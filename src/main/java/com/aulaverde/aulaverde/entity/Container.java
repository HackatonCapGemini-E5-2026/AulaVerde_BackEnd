package com.aulaverde.aulaverde.entity;

import java.time.LocalDateTime;
import java.util.List;
import com.aulaverde.aulaverde.entity.enums.Category;
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
@Table(name = "containers")
@Data
@NoArgsConstructor
public class Container {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Integer percentFull;

    @Column(nullable = false)
    private LocalDateTime lastEmpty;

    @Column(nullable = false)
    private Boolean needEmpty;

    @Column(nullable = false)
    private String color;

    @Column(nullable = false)
    private Double maxWeightKg = 500.00;

    @Column(nullable = false)
    private Double currentWeightKg = 0.0;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Category category;

    @JsonIgnore
    @OneToMany(mappedBy = "container", cascade = CascadeType.ALL)
    private List<Waste> wastes;

    @JsonIgnore
    @OneToMany(mappedBy = "container", cascade = CascadeType.ALL)
    private List<Alert> alerts;

}