INSERT INTO llas_cards.schools (school_id, name) VALUES
    (1, "Otonokizaka"),
    (2, "Uranohoshi"),
    (3, "Nijigasaki");

INSERT INTO llas_cards.subunits (subunit_id, name) VALUES
    (1, "lily White"),
    (2, "Printemps"),
    (3, "BiBi"),
    (4, "AZALEA"),
    (5, "CYaRon!"),
    (6, "Guilty Kiss"),
    (7, "DiverDiva"),
    (8, "A ZU NA"),
    (9, "QU4RTZ");

INSERT INTO llas_cards.idol_groups (idol_group_id, name) VALUES
    (1, "Mu's"),
    (2, "Aqours"),
    (3, "Nijigasaki High School Idol Club");

INSERT INTO llas_cards.idols (idol_id, first_name, last_name, color, school_id, year, idol_group_id, subunit_id) VALUES
    (1, "Honoka", "Kosaka", "#E2732D", 1, 2, 1, 2),
    (2, "Eli", "Ayase", "#36B3DD", 1, 3, 1, 3),
    (3, "Kotori", "Minami", "#8C9395", 1, 2, 1, 2),
    (4, "Umi", "Sonoda", "#1160A5", 1, 2, 1, 1),
    (5, "Rin", "Hoshizora", "#F1C51F", 1, 1, 1, 1),
    (6, "Maki", "Nishikino", "#CC3554", 1, 1, 1, 3),
    (7, "Nozomi", "Tojo", "#744791", 1, 3, 1, 1),
    (8, "Hanayo", "Koizumi", "#54AB48", 1, 1, 1, 2),
    (9, "Nico", "Yazawa", "#D54E8D", 1, 3, 1, 3),
    (10, "Chika", "Takami", "#F0A20B", 2, 2, 2, 5),
    (11, "Riko", "Sakurachi", "#E9A9E8", 2, 2, 2, 6),
    (12, "Kanan", "Matsuura", "#13E8AE", 2, 3, 2, 4),
    (13, "Dia", "Kurosawa", "#F23B4C", 2, 3, 2, 4),
    (14, "You", "Watanabe", "#49B9F9", 2, 2, 2, 5),
    (15, "Yoshiko", "Tsushima", "#898989", 2, 1, 2, 6),
    (16, "Hanamaru", "Kunikida", "#E6D617", 2, 1, 2, 4),
    (17, "Mari", "Ohara", "#AE58EB", 2, 3, 2, 6),
    (18, "Ruby", "Kurosawa", "#FB75E4", 2, 1, 2, 5),
    (19, "Ayumu", "Uehara", "#e792a9", 3, 2, 3, 8),
    (20, "Kasumi", "Nakasu", "#f2eb90", 3, 1, 3, 9),
    (21, "Shizuku", "Osaka", "#aedcf4", 3, 1, 3, 8),
    (22, "Karin", "Asaka", "#96b1e8", 3, 3, 3, 7),
    (23, "Ai", "Miyashita", "#fda566", 3, 2, 3, 7),
    (24, "Kanata", "Konoe", "#d299de", 3, 3, 3, 9),
    (25, "Setsuna", "Yuki", "#fd767a", 3, 2, 3, 8),
    (26, "Emma", "Verde", "#a6e37b", 3, 3, 3, 9),
    (27, "Rina", "Tennoji", "#aeabae", 3, 1, 3, 9);

INSERT INTO llas_cards.rarities (rarity_id, abbreviation, name) VALUES
    (1, "R", "Rare"),
    (2, "SR", "Super Rare"),
    (3, "UR", "Ultra Rare");

INSERT INTO llas_cards.card_types (card_type_id, name, abbreviation) VALUES
    (1, "Voltage", "Vo"),
    (2, "Guard", "Gd"),
    (3, "Skill", "Sk"),
    (4, "Special", "Sp");

INSERT INTO llas_cards.attributes (attribute_id, name) VALUES
    (1, "Active"),
    (2, "Cool"),
    (3, "Elegant"),
    (4, "Natural"),
    (5, "Pure"),
    (6, "Smile");

INSERT INTO llas_cards.appeals (appeal_id, lb0, lb1, lb2, lb3, lb4, lb5) VALUES
    (1, 0, 1, 2, 3, 4, 5),
    (2, 0, 1, 2, 3, 4, 5);

INSERT INTO llas_cards.staminas (stamina_id, lb0, lb1, lb2, lb3, lb4, lb5) VALUES
    (1, 2713, 3063, 3413, 3763, 4288, 4474),
    (2, 0, 1, 2, 3, 4, 5);

INSERT INTO llas_cards.techniques (technique_id, lb0, lb1, lb2, lb3, lb4, lb5) VALUES
    (1, 0, 1, 2, 3, 4, 5),
    (2, 0, 1, 2, 3, 4, 5);

INSERT INTO llas_cards.Cards (card_id, idol_id, rarity_id, card_type_id, attribute_id, title, idolized_title, appeal_id, stamina_id, technique_id) VALUES
    (1, 23, 2, 4, 1, "A Special Outing", "Exciting Animal", 1, 1, 1),
    (2, 23, 3, 2, 3, "UMA Will Definitely Eat it, Too!", "Princess of Ryuuguujou", 2, 2, 2);