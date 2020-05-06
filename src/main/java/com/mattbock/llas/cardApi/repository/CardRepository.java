package com.mattbock.llas.cardApi.repository;

import com.mattbock.llas.cardApi.model.card.Card;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface CardRepository extends CrudRepository<Card, Integer> {
    List<Card> findByIdolFirstNameIgnoreCase(String firstName);
    List<Card> findByIdolId(int id);

    @Query(value = "SELECT card FROM Card card " +
            "WHERE (:idolId is null OR card.idol.id = :idolId) " +
            "AND (:rarityId is null OR card.rarity.id = :rarityId) " +
            "AND (:typeId is null OR card.cardType.id = :typeId) " +
            "AND (:attributeId is null OR card.attribute.id = :attributeId)" +
            "AND (card.title LIKE :titleText OR card.idolizedTitle LIKE :titleText)")
    List<Card> findByTextSearch(@Param("idolId") Integer idolId,
                                @Param("rarityId") Integer rarityId,
                                @Param("typeId") Integer typeId,
                                @Param("attributeId") Integer attributeId,
                                @Param("titleText") String titleText);
}
