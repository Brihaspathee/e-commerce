create table if not exists category(
    id bigint not null primary key,
    description varchar(255),
    name varchar(255)
);

create table if not exists product(
                                      id bigint not null primary key,
                                      description varchar(255),
                                      name varchar(255),
    available_quantity double precision not null,
    price numeric(38,2),
    category_id bigint
              constraint category_fk references category
);

CREATE SEQUENCE IF NOT EXISTS category_seq increment by 50;
create sequence if not exists product_seq increment by 50;