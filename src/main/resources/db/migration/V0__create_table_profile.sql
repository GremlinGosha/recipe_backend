CREATE TABLE profile (
  id bigserial primary key not null,
  name varchar(50) not null,
  surname varchar(50) not null,
  email varchar(250) not null,
  phone varchar(20) not null
)