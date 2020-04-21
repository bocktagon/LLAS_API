package com.mattbock.llas.cardApi.model.card;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="techniques")
public class Technique extends CardStat {
}
