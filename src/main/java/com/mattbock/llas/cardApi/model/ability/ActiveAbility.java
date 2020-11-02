package com.mattbock.llas.cardApi.model.ability;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="active_abilities")
public class ActiveAbility extends CardAbility {
}