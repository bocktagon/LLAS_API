package com.mattbock.llas.cardApi.repository;

import org.springframework.data.repository.CrudRepository;

import com.mattbock.llas.cardApi.model.card.Card;


public interface CardRepository extends CrudRepository<Card, Integer> {

}
