DROP TABLE IF EXISTS cards;
DROP TABLE IF EXISTS rarities;
DROP TABLE IF EXISTS card_types;
DROP TABLE IF EXISTS attributes;
DROP TABLE IF EXISTS appeals;
DROP TABLE IF EXISTS staminas;
DROP TABLE IF EXISTS techniques;

DROP TABLE IF EXISTS idols;
DROP TABLE IF EXISTS schools;
DROP TABLE IF EXISTS subunits;
DROP TABLE IF EXISTS idol_groups;


CREATE TABLE schools (
    school_id smallint NOT NULL,
    name varchar(11) NOT NULL,
    PRIMARY KEY (school_id)
);

CREATE TABLE subunits (
    subunit_id smallint NOT NULL,
    name varchar(11) NOT NULL,
    PRIMARY KEY (subunit_id)
);

CREATE TABLE idol_groups (
    idol_group_id smallint NOT NULL,
    name varchar(32) NOT NULL,
    PRIMARY KEY (idol_group_id)
);

CREATE TABLE idols (
    idol_id smallint NOT NULL,
    first_name varchar(10) NOT NULL,
    last_name varchar(10) NOT NULL,
    color varchar(7) NOT NULL,
    school_id smallint NOT NULL,
    year smallint NOT NULL,
    idol_group_id smallint NOT NULL,
    subunit_id smallint NOT NULL,
    PRIMARY KEY (idol_id),
    FOREIGN KEY (school_id) REFERENCES schools(school_id),
    FOREIGN KEY (idol_group_id) REFERENCES idol_groups(idol_group_id),
    FOREIGN KEY (subunit_id) REFERENCES subunits(subunit_id)
);

CREATE TABLE rarities (
    rarity_id smallint NOT NULL,
    abbreviation varchar(2) NOT NULL,
    name varchar(10) NOT NULL,
    PRIMARY KEY (rarity_id)
);

CREATE TABLE card_types (
    card_type_id smallint NOT NULL,
    name varchar(7) NOT NULL,
    abbreviation varchar(2) NOT NULL,
    PRIMARY KEY (card_type_id)
);

CREATE TABLE attributes (
    attribute_id smallint NOT NULL,
    name varchar(7) NOT NULL,
    PRIMARY KEY (attribute_id)
);

CREATE TABLE appeals (
    appeal_id int NOT NULL,
    lb0 int NOT NULL,
    lb1 int NOT NULL,
    lb2 int NOT NULL,
    lb3 int NOT NULL,
    lb4 int NOT NULL,
    lb5 int NOT NULL,
    PRIMARY KEY (appeal_id)
);

CREATE TABLE staminas (
    stamina_id int NOT NULL,
    lb0 int NOT NULL,
    lb1 int NOT NULL,
    lb2 int NOT NULL,
    lb3 int NOT NULL,
    lb4 int NOT NULL,
    lb5 int NOT NULL,
    PRIMARY KEY (stamina_id)
);

CREATE TABLE techniques (
    technique_id int NOT NULL,
    lb0 int NOT NULL,
    lb1 int NOT NULL,
    lb2 int NOT NULL,
    lb3 int NOT NULL,
    lb4 int NOT NULL,
    lb5 int NOT NULL,
    PRIMARY KEY (technique_id)
);

CREATE TABLE cards (
    card_id smallint NOT NULL,
    idol_id smallint NOT NULL,
    rarity_id smallint NOT NULL,
    card_type_id smallint NOT NULL,
    attribute_id smallint NOT NULL,
    title varchar(50) NOT NULL,
    idolized_title varchar(50) NOT NULL,
    appeal_id int NOT NULL,
    stamina_id int NOT NULL,
    technique_id int NOT NULL,
    PRIMARY KEY (card_id),
    FOREIGN KEY (idol_id) REFERENCES idols(idol_id),
    FOREIGN KEY (rarity_id) REFERENCES rarities(rarity_id),
    FOREIGN KEY (card_type_id) REFERENCES card_types(card_type_id),
    FOREIGN KEY (attribute_id) REFERENCES attributes(attribute_id),
    FOREIGN KEY (appeal_id) REFERENCES appeals(appeal_id),
    FOREIGN KEY (stamina_id) REFERENCES staminas(stamina_id),
    FOREIGN KEY (technique_id) REFERENCES techniques(technique_id)
);