SET FOREIGN_KEY_CHECKS=0;
-- Sebastian
update `authorities` set email = 'sebastian@hoefischebv.by' where email='sebastian.pfeifer@hoefischebv.de';
update benutzer set e_mailadresse = 'sebastian@hoefischebv.by' where e_mailadresse ='sebastian.pfeifer@hoefischebv.de';

-- Tobias
update `authorities` set email = 'tobias@hoefischebv.by' where email='tobias.gruener@hoefischebv.de';
update benutzer set e_mailadresse = 'tobias@hoefischebv.by' where e_mailadresse ='tobias.gruener@hoefischebv.de';

-- Georg
update `authorities` set email = 'georg@hoefischebv.by' where email='georg.wuttke@hoefischebv.de';
update benutzer set e_mailadresse = 'georg@hoefischebv.by' where e_mailadresse ='georg.wuttke@hoefischebv.de';
SET FOREIGN_KEY_CHECKS=1;
