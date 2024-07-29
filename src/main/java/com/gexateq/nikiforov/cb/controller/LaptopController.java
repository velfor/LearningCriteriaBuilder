package com.gexateq.nikiforov.cb.controller;

import com.gexateq.nikiforov.cb.model.dto.LaptopCompactView;
import com.gexateq.nikiforov.cb.repository.LaptopSearchCriteria;
import com.gexateq.nikiforov.cb.service.LaptopService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.gexateq.nikiforov.cb.utility.mapper.LaptopMapper;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products/laptops")
public class LaptopController {
    private final LaptopService laptopService;
    private final LaptopMapper laptopMapper;

    @Tag(name = "Laptops")
    @Operation(summary = "Get all laptops matching the search criteria")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/search")
    public ResponseEntity<List<LaptopCompactView>> searchLaptops(
            @ParameterObject LaptopSearchCriteria criteria,
            @PageableDefault(size = 25)
            @SortDefault(sort = "fullName")
            @ParameterObject Pageable pageable) {

        return ResponseEntity.ok(laptopService.searchLaptops(criteria).stream().map(laptopMapper::toDto).toList());
    }
}
