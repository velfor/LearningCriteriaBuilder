package com.gexateq.nikiforov.cb.service;

import com.gexateq.nikiforov.cb.model.Laptop;
import com.gexateq.nikiforov.cb.repository.LaptopRepository;
import com.gexateq.nikiforov.cb.repository.LaptopSearchCriteria;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LaptopServiceImpl implements LaptopService{

    private final LaptopRepository laptopRepository;

    @Override
    public List<Laptop> searchLaptops(LaptopSearchCriteria criteria) {
        return laptopRepository.searchLaptops(criteria);
    }
}
