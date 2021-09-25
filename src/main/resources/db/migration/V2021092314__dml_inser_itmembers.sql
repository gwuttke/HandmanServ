-- Sebastian
INSERT INTO `benutzer`(`anrede`, `e_mailadresse`, `enabled`, `letzte_anmeldung`, `nachname`, `passwort`, `telefonnummer`, `vorname`) VALUES 
		      ('Herr','sebastian.pfeifer@hoefischebv.de',1,null,'Pfeifer','$2a$10$oc4auLofic8mpnZVVbL8Nu9RFb8GVJigbE6dhk1npC8jBMHCLQAnS','089456241789','Sebastian');

INSERT INTO `itmitarbeiter`(`benutzer_id`) VALUES (LAST_INSERT_ID());

INSERT INTO `authorities` (`email`, `berechtigung`) VALUES ('sebastian.pfeifer@hoefischebv.de','ROLE_ITMitarbeiter');
-- Tobias
INSERT INTO `benutzer`(`anrede`, `e_mailadresse`, `enabled`, `letzte_anmeldung`, `nachname`, `passwort`, `telefonnummer`, `vorname`) VALUES 
		      ('Herr','tobias.gruener@hoefischebv.de',1,null,'Grüner','$2a$10$oc4auLofic8mpnZVVbL8Nu9RFb8GVJigbE6dhk1npC8jBMHCLQAnS','089456241790','Tobias');

INSERT INTO `itmitarbeiter`(`benutzer_id`) VALUES (LAST_INSERT_ID());

INSERT INTO `authorities` (`email`, `berechtigung`) VALUES ('tobias.gruener@hoefischebv.de','ROLE_ITMitarbeiter');
-- Georg
INSERT INTO `benutzer`(`anrede`, `e_mailadresse`, `enabled`, `letzte_anmeldung`, `nachname`, `passwort`, `telefonnummer`, `vorname`) VALUES 
		      ('Herr','georg.wuttke@hoefischebv.de',1,null,'Wuttke','$2a$10$oc4auLofic8mpnZVVbL8Nu9RFb8GVJigbE6dhk1npC8jBMHCLQAnS','089456241790','Georg');

INSERT INTO `itmitarbeiter`(`benutzer_id`) VALUES (LAST_INSERT_ID());

INSERT INTO `authorities` (`email`, `berechtigung`) VALUES ('georg.wuttke@hoefischebv.de','ROLE_ITMitarbeiter');

