package com.mattbock.llas.cardApi.service;

import com.mattbock.llas.cardApi.model.card.Attribute;
import com.mattbock.llas.cardApi.model.card.CardType;
import com.mattbock.llas.cardApi.model.card.Rarity;
import com.mattbock.llas.cardApi.model.idol.Idol;
import com.mattbock.llas.cardApi.repository.AttributeRepository;
import com.mattbock.llas.cardApi.repository.CardTypeRepository;
import com.mattbock.llas.cardApi.repository.IdolRepository;
import com.mattbock.llas.cardApi.repository.RarityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RefService {

    @Autowired
    private IdolRepository idolRepository;

    @Autowired
    private RarityRepository rarityRepository;

    @Autowired
    private CardTypeRepository cardTypeRepository;

    @Autowired
    private AttributeRepository attributeRepository;

    private Map<String, Integer> idolNamesIds;
    private Map<String, Integer> rarityAbbreviationsIds;
    private Map<String, Integer> typeNamesIds;
    private Map<String, Integer> typeAbbreviationsIds;
    private Map<String, Integer> attributeNamesIds;

    public Map<String, Integer> getIdolNamesIds() {
        verifyIdolNamesMap();
        return idolNamesIds;
    }

    public Map<String, Integer> getRarityAbbreviationsIds() {
        verifyRarityAbbreviationssMap();
        return rarityAbbreviationsIds;
    }

    public Map<String, Integer> getTypeNamesIds() {
        verifyTypeNamesMap();
        return typeNamesIds;
    }

    public  Map<String, Integer> getTypeAbbreviationsIds() {
        verifyTypeAbbreviationsMap();
        return typeAbbreviationsIds;
    }

    public Map<String, Integer> getAttributeNamesIds() {
        veryfyAttributeNamesMap();
        return attributeNamesIds;
    }

    private void verifyIdolNamesMap() {
        if (idolNamesIds == null) {
            idolNamesIds = new HashMap<String, Integer>() {
                {
                    for(Idol idol : idolRepository.findAll()) {
                        put(idol.getFirstName().toLowerCase(), idol.getId());
                    }
                }
            };
        }
    }

    private void verifyRarityAbbreviationssMap() {
        if(rarityAbbreviationsIds == null) {
            rarityAbbreviationsIds = new HashMap<String, Integer>(){
                {
                    for(Rarity rarity : rarityRepository.findAll()) {
                        put(rarity.getAbbreviation().toLowerCase(), rarity.getId());
                    }
                }
            };
        }
    }

    private void verifyTypeNamesMap() {
        if(typeNamesIds == null) {
            typeNamesIds = new HashMap<String, Integer>(){
                {
                    for(CardType cardType : cardTypeRepository.findAll()) {
                        put(cardType.getName().toLowerCase(), cardType.getId());
                    }
                }
            };
        }
    }

    private void verifyTypeAbbreviationsMap() {
        if(typeAbbreviationsIds == null) {
            typeAbbreviationsIds = new HashMap<String, Integer>(){
                {
                    for(CardType cardType : cardTypeRepository.findAll()) {
                        put(cardType.getAbbreviation().toLowerCase(), cardType.getId());
                    }
                }
            };
        }
    }

    private void veryfyAttributeNamesMap() {
        if(attributeNamesIds == null) {
            attributeNamesIds = new HashMap<String, Integer>(){
                {
                    for(Attribute attribute : attributeRepository.findAll()) {
                        put(attribute.getName().toLowerCase(), attribute.getId());
                    }
                }
            };
        }
    }


}
