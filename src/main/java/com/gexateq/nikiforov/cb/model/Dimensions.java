package com.gexateq.nikiforov.cb.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Embeddable
public class Dimensions {
    private Integer length;
    private Integer width;
    private Integer height;
}
