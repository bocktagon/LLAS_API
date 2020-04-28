package com.mattbock.llas.cardApi.model.card;

import com.mattbock.llas.cardApi.model.ability.PassiveAbility;
import com.mattbock.llas.cardApi.model.idol.Idol;

import javax.persistence.*;

@Entity
@Table(name = "cards")
public class Card {

    @Id
    private Integer id;

    private String title;
    private String idolizedTitle;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idol_id")
    private Idol idol;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rarity_id")
    private Rarity rarity;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "card_type_id")
    private CardType cardType;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "attribute_id")
    private Attribute attribute;

    @OneToOne
    @JoinColumn(name = "appeal_id")
    private Appeal appeal;

    @OneToOne
    @JoinColumn(name = "stamina_id")
    private Stamina stamina;

    @OneToOne
    @JoinColumn(name = "technique_id")
    private Technique technique;

    @OneToOne
    @JoinColumn(name = "passive_ability_id")
    private PassiveAbility passiveAbility;

    private String primaryActiveAbilityText;
    private String secondaryActiveAbilityText;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Idol getIdol() {
        return idol;
    }

    public void setIdol(Idol idol) {
        this.idol = idol;
    }

    public Rarity getRarity() {
        return rarity;
    }

    public void setRarity(Rarity rarity) {
        this.rarity = rarity;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIdolizedTitle() {
        return idolizedTitle;
    }

    public void setIdolizedTitle(String idolizedTitle) {
        this.idolizedTitle = idolizedTitle;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public Attribute getAttribute() {
        return attribute;
    }

    public void setAttribute(Attribute attribute) {
        this.attribute = attribute;
    }

    public Appeal getAppeal() {
        return appeal;
    }

    public void setAppeal(Appeal appeal) {
        this.appeal = appeal;
    }

    public Stamina getStamina() {
        return stamina;
    }

    public void setStamina(Stamina stamina) {
        this.stamina = stamina;
    }

    public Technique getTechnique() {
        return technique;
    }

    public void setTechnique(Technique technique) {
        this.technique = technique;
    }

    public PassiveAbility getPassiveAbility() {
        return passiveAbility;
    }

    public void setPassiveAbility(PassiveAbility passiveAbility) {
        this.passiveAbility = passiveAbility;
    }

    public String getPrimaryActiveAbilityText() {
        return primaryActiveAbilityText;
    }

    public void setPrimaryActiveAbilityText(String primaryActiveAbilityText) {
        this.primaryActiveAbilityText = primaryActiveAbilityText;
    }
}
