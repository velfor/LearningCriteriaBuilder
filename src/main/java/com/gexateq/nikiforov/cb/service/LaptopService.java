package com.gexateq.nikiforov.cb.service;

import com.gexateq.nikiforov.cb.model.Laptop;
import com.gexateq.nikiforov.cb.repository.LaptopSearchCriteria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface LaptopService {
    List<Laptop> searchLaptops(LaptopSearchCriteria criteria);
}
