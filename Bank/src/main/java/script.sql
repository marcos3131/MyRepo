create table app.client (
Id Integer primary key GENERATED BY DEFAULT AS IDENTITY,
firstName varchar (50),
lastName varchar (50),
pesel varchar (11) unique,
email varchar (50)
);

create table app.account (
Id Integer primary key GENERATED BY DEFAULT AS IDENTITY,
notes varchar (255),
balance double,
Id_client Integer constraint fk_client references app.client
);