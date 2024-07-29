package com.gexateq.nikiforov.cb.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = false, of = {"id"})
@ToString
@Builder
@Entity
@Table(name = "laptops")
public class Laptop extends ElectronicProduct {
    private String graphicCard;
    @Enumerated(EnumType.STRING)
    ProductType type = ProductType.LAPTOP;
    private boolean hasWebcam;
    @Override
    public String getProductType() {
        return type.toString();
    }
    public String getScreenParameters() {
        return getScreenSize() + "'' " + getScreenResolution() + ", " + getScreenType() + ", " + getScreenRefreshRate() + " Hz";
    }
    public String getRamParameters(){
        return getRamSize() + " " + getRamType();
    }
    public String getStorageParameters(){
        return "";
    }
}
