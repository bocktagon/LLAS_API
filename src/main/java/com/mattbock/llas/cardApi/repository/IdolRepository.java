package com.mattbock.llas.cardApi.repository;

import com.mattbock.llas.cardApi.model.idol.Idol;
import org.springframework.data.repository.CrudRepository;

public interface IdolRepository extends CrudRepository<Idol, Integer> {
}
