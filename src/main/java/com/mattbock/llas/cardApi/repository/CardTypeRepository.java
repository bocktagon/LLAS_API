package com.mattbock.llas.cardApi.repository;

import com.mattbock.llas.cardApi.model.card.CardType;
import org.springframework.data.repository.CrudRepository;

public interface CardTypeRepository extends CrudRepository<CardType, Integer> {
}
