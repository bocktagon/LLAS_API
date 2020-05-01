package com.mattbock.llas.cardApi.repository;

import com.mattbock.llas.cardApi.model.card.Card;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface CardRepository extends CrudRepository<Card, Integer> {
    List<Card> findByIdolFirstNameIgnoreCase(String firstName);
    List<Card> findByIdolId(int id);
}
