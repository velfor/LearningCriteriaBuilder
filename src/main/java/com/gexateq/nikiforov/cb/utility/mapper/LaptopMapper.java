package com.gexateq.nikiforov.cb.utility.mapper;

import com.gexateq.nikiforov.cb.model.Laptop;
import com.gexateq.nikiforov.cb.model.dto.LaptopCompactView;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LaptopMapper {
    @Mapping(target = "fullName", expression = "java(entity.getFullName())")
    @Mapping(target = "screenParameters", expression = "java(entity.getScreenParameters())")
    @Mapping(target = "ramParameters", expression = "java(entity.getRamParameters())")
    @Mapping(target = "storageParameters", expression = "java(entity.getStorageParameters())")
    LaptopCompactView toDto(Laptop entity);
}
