create table account (
    id uuid primary key not null,
    name character varying not null
);

create table artist (
    id uuid primary key not null,
    name character varying not null
);

create table album (
    id uuid primary key not null,
    artist_id uuid not null references artist(id) on delete cascade,
    name character varying not null
);

create table track (
    id uuid primary key not null,
    artist_id uuid not null references artist(id) on delete cascade,
    album_id uuid references album(id) on delete no action,
    name character varying not null
);

create table playlist (
    id uuid primary key not null,
    owner_id uuid not null references account(id) on delete cascade,
    name character varying not null
);

create index track_artist_id_index on track using btree (artist_id);
create index track_album_id_index on track using btree (album_id);
create index album_artist_id_index on album using btree (artist_id);
create index playlist_owner_id_index on playlist using btree (owner_id);