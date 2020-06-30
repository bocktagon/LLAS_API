DROP TABLE IF EXISTS cards;
DROP TABLE IF EXISTS rarities;
DROP TABLE IF EXISTS card_types;
DROP TABLE IF EXISTS attributes;
DROP TABLE IF EXISTS card_sources;
DROP TABLE IF EXISTS appeals;
DROP TABLE IF EXISTS staminas;
DROP TABLE IF EXISTS techniques;

DROP TABLE IF EXISTS idols;
DROP TABLE IF EXISTS schools;
DROP TABLE IF EXISTS subunits;
DROP TABLE IF EXISTS idol_groups;

DROP TABLE IF EXISTS passive_abilities;
DROP TABLE IF EXISTS buff_types;
DROP TABLE IF EXISTS buff_targets;


CREATE TABLE schools (
    id smallint NOT NULL,
    name varchar(11) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE subunits (
    id smallint NOT NULL,
    name varchar(11) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE idol_groups (
    id smallint NOT NULL,
    name varchar(32) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE idols (
    id smallint NOT NULL,
    first_name varchar(10) NOT NULL,
    last_name varchar(10) NOT NULL,
    color varchar(7) NOT NULL,
    school_id smallint NOT NULL,
    year smallint NOT NULL,
    idol_group_id smallint NOT NULL,
    subunit_id smallint NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (school_id) REFERENCES schools(id),
    FOREIGN KEY (idol_group_id) REFERENCES idol_groups(id),
    FOREIGN KEY (subunit_id) REFERENCES subunits(id)
);

CREATE TABLE buff_types (
    id int NOT NULL,
    type varchar(20) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE buff_targets (
    id int NOT NULL,
    target varchar(20) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE passive_abilities (
    id int NOT NULL,
    ability_text varchar(150) NOT NULL,
    buff_type_id int NOT NULL,
    buff_target_id int NOT NULL,
    buff_lvl0 double NOT NULL,
    buff_lvl1 double NOT NULL,
    buff_lvl2 double NOT NULL,
    buff_lvl3 double NOT NULL,
    buff_lvl4 double NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (buff_type_id) REFERENCES buff_types(id),
    FOREIGN KEY (buff_target_id) REFERENCES buff_targets(id)
);

CREATE TABLE rarities (
    id smallint NOT NULL,
    abbreviation varchar(2) NOT NULL,
    name varchar(10) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE card_types (
    id smallint NOT NULL,
    name varchar(7) NOT NULL,
    abbreviation varchar(2) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE attributes (
    id smallint NOT NULL,
    name varchar(7) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE card_sources (
    id smallint NOT NULL,
    name varchar(7) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE appeals (
    id int NOT NULL,
    lb0 int NOT NULL,
    lb1 int NOT NULL,
    lb2 int NOT NULL,
    lb3 int NOT NULL,
    lb4 int NOT NULL,
    lb5 int NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE staminas (
    id int NOT NULL,
    lb0 int NOT NULL,
    lb1 int NOT NULL,
    lb2 int NOT NULL,
    lb3 int NOT NULL,
    lb4 int NOT NULL,
    lb5 int NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE techniques (
    id int NOT NULL,
    lb0 int NOT NULL,
    lb1 int NOT NULL,
    lb2 int NOT NULL,
    lb3 int NOT NULL,
    lb4 int NOT NULL,
    lb5 int NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE cards (
    id int NOT NULL,
    idol_id smallint NOT NULL,
    rarity_id smallint NOT NULL,
    card_type_id smallint NOT NULL,
    attribute_id smallint NOT NULL,
    card_source_id smallint NOT NULL,
    title varchar(100) NOT NULL,
    idolized_title varchar(100) NOT NULL,
    appeal_id int NOT NULL,
    stamina_id int NOT NULL,
    technique_id int NOT NULL,
    passive_ability_id int NOT NULL,
    primary_active_ability_text varchar(200) NOT NULL,
    secondary_active_ability_text varchar(200),
    PRIMARY KEY (id),
    FOREIGN KEY (idol_id) REFERENCES idols(id),
    FOREIGN KEY (rarity_id) REFERENCES rarities(id),
    FOREIGN KEY (card_type_id) REFERENCES card_types(id),
    FOREIGN KEY (card_source_id) REFERENCES card_sources(id),
    FOREIGN KEY (attribute_id) REFERENCES attributes(id),
    FOREIGN KEY (appeal_id) REFERENCES appeals(id),
    FOREIGN KEY (stamina_id) REFERENCES staminas(id),
    FOREIGN KEY (technique_id) REFERENCES techniques(id),
    FOREIGN KEY (passive_ability_id) REFERENCES passive_abilities(id)
);
