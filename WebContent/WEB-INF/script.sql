drop table if exists brukere, messages, bruker, melding;

create table meldinger (
  id integer,
  primary key (id)
);

create table melding (
  navn VARCHAR(20),
  melding VARCHAR(200),
  date VARCHAR(20),
  id integer,
  messages integer,
  primary key (id),
  foreign key (messages) references meldinger(id)
);

create table brukere (
  id integer,
  primary key (id)
);

create table bruker (
  mobil VARCHAR(8),
  fornavn VARCHAR(20),
  etternavn VARCHAR(20),
  passord VARCHAR(50),
  brukere integer,
  primary key (mobil),
  foreign key (brukere) references brukere(id)
);

insert into meldinger(id) values (1);
insert into brukere(id) values (1);

