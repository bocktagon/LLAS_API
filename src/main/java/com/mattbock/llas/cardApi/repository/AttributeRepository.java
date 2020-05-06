package com.mattbock.llas.cardApi.repository;

import com.mattbock.llas.cardApi.model.card.Attribute;
import org.springframework.data.repository.CrudRepository;

public interface AttributeRepository extends CrudRepository<Attribute, Integer> {
}
