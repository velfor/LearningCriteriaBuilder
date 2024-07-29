package com.gexateq.nikiforov.cb.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class LaptopCompactView {
    private String fullName;
    private String screenParameters;
    private String processor;
    private String ramParameters;
    private String storageParameters;
    private String graphicCard;
    private String operatingSystem;
    private String color;
    private String batteryCapacity;
}
