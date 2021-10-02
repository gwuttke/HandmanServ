create table passwort_token (id bigint not null auto_increment, ablaufdatum datetime(6), 
token varchar(255), email varchar(255), primary key (id)) engine=InnoDB;

alter table passwort_token add constraint UK13n9f6jej33sqjcnaou2bj97b unique (token);
alter table passwort_token add constraint UK_5618yaqybi80ng6v7bdr8lb8r unique (email);

alter table passwort_token add constraint email_benutzerEmail 
foreign key (email) references benutzer (e_mailadresse);