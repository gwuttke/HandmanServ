CREATE TABLE authorities (
  email varchar(255) NOT NULL,
  berechtigung VARCHAR(50) NOT NULL
);

CREATE UNIQUE INDEX ix_auth_email on authorities (email,berechtigung);
CREATE UNIQUE INDEX ix_benutzer_email on benutzer (e_mailadresse);

alter table authorities add constraint FK_authorities foreign key (email) references benutzer (e_mailadresse);