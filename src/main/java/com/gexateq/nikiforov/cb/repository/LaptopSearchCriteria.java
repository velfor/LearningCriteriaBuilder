package com.gexateq.nikiforov.cb.repository;

import com.gexateq.nikiforov.cb.model.ProductType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LaptopSearchCriteria {
    private String name;
    private String brand;
    private String model;
    private String sku;
    private BigDecimal minPrice;
    private BigDecimal maxPrice;
    private String description;
    private Double minWeight;
    private Double maxWeight;

    private Double minLength;
    private Double maxLength;
    private Double minWidth;
    private Double maxWidth;
    private Double minHeight;
    private Double maxHeight;

    private String color;
    private String operatingSystem;
    private String processor;
    private Integer minRamSize;
    private Integer maxRamSize;
    private Integer minStorageCapacity;
    private Integer maxStorageCapacity;
    private String storageType;
    private Double minScreenSize;
    private Double maxScreenSize;
    private String screenResolution;
    private String batteryCapacity;


    private String graphicCard;
    private Boolean hasWebcam;
}

