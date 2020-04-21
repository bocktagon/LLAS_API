package com.mattbock.llas.cardApi.repository;

import com.mattbock.llas.cardApi.model.card.Rarity;
import org.springframework.data.repository.CrudRepository;

public interface RarityRepository extends CrudRepository<Rarity, Integer> {
}
