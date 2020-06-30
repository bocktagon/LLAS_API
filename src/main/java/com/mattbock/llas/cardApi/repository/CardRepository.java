package com.mattbock.llas.cardApi.repository;

import com.mattbock.llas.cardApi.model.card.Card;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface CardRepository extends CrudRepository<Card, Integer> {
    List<Card> findByIdolFirstNameIgnoreCase(String firstName);
    List<Card> findByIdolId(Integer id);

    @Query(value="SELECT card FROM Card card WHERE card.idol.id = :idolId AND card.rarity.abbreviation = :rarity")
    List<Card> findByIdolIdAndRarity(@Param("idolId") Integer id, @Param("rarity") String rarity);

    @Query(value="SELECT card FROM Card card WHERE card.rarity.abbreviation = :rarity OR card.rarity.name = :rarity")
    List<Card> findByRarity(@Param("rarity") String rarity);

    List<Card> findByAttributeNameIgnoreCase(String attribute);

    @Query(value="SELECT card FROM Card card WHERE card.cardType.name = :type OR card.cardType.abbreviation = :type")
    List<Card> findByCardType(String type);

    @Query(value = "SELECT card FROM Card card " +
            "WHERE (:idolId is null OR card.idol.id = :idolId) " +
            "AND (:rarityId is null OR card.rarity.id = :rarityId) " +
            "AND (:typeId is null OR card.cardType.id = :typeId) " +
            "AND (:attributeId is null OR card.attribute.id = :attributeId)" +
            "AND (:sourceId is null OR card.cardSource.id = :sourceId)" +
            "AND (card.title LIKE :titleText OR card.idolizedTitle LIKE :titleText)")
    List<Card> findByTextSearch(@Param("idolId") Integer idolId,
                                @Param("rarityId") Integer rarityId,
                                @Param("typeId") Integer typeId,
                                @Param("attributeId") Integer attributeId,
                                @Param("sourceId") Integer sourceId,
                                @Param("titleText") String titleText);
}
