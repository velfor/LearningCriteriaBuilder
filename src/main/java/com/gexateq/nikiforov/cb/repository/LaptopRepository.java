package com.gexateq.nikiforov.cb.repository;

import com.gexateq.nikiforov.cb.model.Laptop;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Order;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
@Repository
public class LaptopRepository implements LaptopCustomRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Laptop> searchLaptops(LaptopSearchCriteria criteria) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Laptop> cq = cb.createQuery(Laptop.class);
        Root<Laptop> root = cq.from(Laptop.class);

        List<Predicate> predicates = createPredicates(criteria, cb, root);
        cq.where(predicates.toArray(new Predicate[0]));

        //Apply sorting
        /*if (pageable.getSort().isSorted()) {
            List<Order> orders = pageable.getSort().stream()
                    .map(order -> order.isAscending() ?
                            cb.asc(root.get(order.getProperty())) :
                            cb.desc(root.get(order.getProperty())))
                    .toList();
            cq.orderBy(orders);
        }*/

        //Execute query
        List<Laptop> laptops = entityManager.createQuery(cq)
                //.setFirstResult((int) pageable.getOffset())
                //.setMaxResults(pageable.getPageSize())
                .getResultList();

        //Count for pagination
        /*CriteriaQuery<Long> countQuery = cb.createQuery(Long.class);
        Root<Laptop> countRoot = countQuery.from(Laptop.class);
        countQuery.select(cb.count(countRoot)).where(predicates.toArray(new Predicate[0]));
        Long total = entityManager.createQuery(countQuery).getSingleResult();

        return new PageImpl<>(laptops, pageable, total);*/
        return laptops;
    }

    private List<Predicate> createPredicates(LaptopSearchCriteria criteria, CriteriaBuilder cb, Root<Laptop> root) {
        List<Predicate> predicates = new ArrayList<>();

        if (criteria.getName() != null) {
            predicates.add(cb.like(root.get("name"), "%" + criteria.getName() + "%"));
        }
        if (criteria.getBrand() != null) {
            predicates.add(cb.equal(root.get("brand"), criteria.getBrand()));
        }
        if (criteria.getModel() != null) {
            predicates.add(cb.equal(root.get("model"), criteria.getModel()));
        }
        if (criteria.getMinPrice() != null) {
            predicates.add(cb.greaterThanOrEqualTo(root.get("price"), criteria.getMinPrice()));
        }
        if (criteria.getMaxPrice() != null) {
            predicates.add(cb.lessThanOrEqualTo(root.get("price"), criteria.getMaxPrice()));
        }
        if (criteria.getColor() != null) {
            predicates.add(cb.equal(root.get("color"), criteria.getColor()));
        }
        if (criteria.getOperatingSystem() != null) {
            predicates.add(cb.equal(root.get("operatingSystem"), criteria.getOperatingSystem()));
        }
        if (criteria.getProcessor() != null) {
            predicates.add(cb.equal(root.get("processor"), criteria.getProcessor()));
        }
        if (criteria.getMinRamSize() != null) {
            predicates.add(cb.greaterThanOrEqualTo(root.get("ramSize"), criteria.getMinRamSize()));
        }
        if (criteria.getMaxRamSize() != null) {
            predicates.add(cb.lessThanOrEqualTo(root.get("ramSize"), criteria.getMaxRamSize()));
        }
        if (criteria.getMinStorageCapacity() != null) {
            predicates.add(cb.greaterThanOrEqualTo(root.get("storageCapacity"), criteria.getMinStorageCapacity()));
        }
        if (criteria.getMaxStorageCapacity() != null) {
            predicates.add(cb.lessThanOrEqualTo(root.get("storageCapacity"), criteria.getMaxStorageCapacity()));
        }
        if (criteria.getStorageType() != null) {
            predicates.add(cb.equal(root.get("storageType"), criteria.getStorageType()));
        }
        if (criteria.getMinScreenSize() != null) {
            predicates.add(cb.greaterThanOrEqualTo(root.get("screenSize"), criteria.getMinScreenSize()));
        }
        if (criteria.getMaxScreenSize() != null) {
            predicates.add(cb.lessThanOrEqualTo(root.get("screenSize"), criteria.getMaxScreenSize()));
        }
        if (criteria.getGraphicCard() != null) {
            predicates.add(cb.equal(root.get("graphicCard"), criteria.getGraphicCard()));
        }
        if (criteria.getHasWebcam() != null) {
            predicates.add(cb.equal(root.get("hasWebcam"), criteria.getHasWebcam()));
        }

        return predicates;
    }
}
