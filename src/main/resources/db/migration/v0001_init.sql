create table account (
    id uuid primary key not null,
    name character varying not null,
    email character varying not null
);

create table artist (
    id uuid primary key not null,
    name character varying not null,
    genre character varying[] not null,
    popularity integer not null default 0,
    image_url character varying not null
);

create table album (
    id uuid primary key not null,
    artist_id uuid not null references artist(id) on delete cascade,
    name character varying not null,
    genre character varying[] not null,
    popularity integer not null default 0,
    image_url character varying not null,
    release_date timestamp with time zone
);

create table track (
    id uuid primary key not null,
    artist_id uuid not null references artist(id) on delete cascade,
    album_id uuid not null references album(id) on delete cascade,
    name character varying not null,
    popularity integer not null default 0
);

create table playlist (
    id uuid primary key not null,
    owner_id uuid not null references account(id) on delete cascade,
    name character varying not null,
    image_url character varying not null
);

create table playlist_entry (
    id uuid primary key not null,
    playlist_id uuid not null references playlist(id) on delete cascade,
    track_id uuid not null references track(id) on delete cascade
);

create index track_artist_id_index on track using btree (artist_id);
create index track_album_id_index on track using btree (album_id);
create index album_artist_id_index on album using btree (artist_id);
create index playlist_owner_id_index on playlist using btree (owner_id);
