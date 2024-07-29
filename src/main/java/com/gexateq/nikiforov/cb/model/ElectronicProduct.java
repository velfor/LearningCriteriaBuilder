package com.gexateq.nikiforov.cb.model;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@MappedSuperclass
@Getter
@Setter
public abstract class ElectronicProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;
    private String name;
    private String brand;
    private String model;
    private String sku;
    private BigDecimal price;
    private String description;
    private Double weight;
    @Embedded
    private Dimensions dimensions;
    private String color;

    private String operatingSystem;
    private String processor;
    private Integer ramSize;
    private String ramType;
    private Integer storageCapacity;
    private String storageType;
    private Double screenSize;
    private String screenResolution;
    private String screenType;
    private Integer screenRefreshRate;
    private String batteryCapacity;

    public abstract String getProductType();

    public String getFullName() {
        return this.brand + " " + this.model;
    }
}
