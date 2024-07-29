package com.gexateq.nikiforov.cb.repository;

import com.gexateq.nikiforov.cb.model.Laptop;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface LaptopCustomRepository {
    List<Laptop> searchLaptops(LaptopSearchCriteria criteria);
}

