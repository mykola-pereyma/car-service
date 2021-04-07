package com.company.carservice;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface ListingRepository extends JpaRepository<Listing, ListingKey>, JpaSpecificationExecutor<Listing> {

    default Specification<Listing> getListingQuery(Optional<String> make,
                                                   Optional<String> model,
                                                   Optional<Integer> year,
                                                   Optional<String> color) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            make.ifPresent(s -> predicates.add(criteriaBuilder.equal(root.get("make"), s)));
            model.ifPresent(s -> predicates.add(criteriaBuilder.equal(root.get("model"), s)));
            year.ifPresent(integer -> predicates.add(criteriaBuilder.equal(root.get("year"), integer)));
            color.ifPresent(s -> predicates.add(criteriaBuilder.equal(root.get("color"), s)));

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
