insert into artist (
	id,
	name,
	genre,
	popularity,
	image_url
) values (
	'bc270ee4-aba0-11ea-bb37-0242ac130002',
	'Michael Jackson',
	'{"Pop","Rock"}',
	100,
	'https://i.ytimg.com/vi/oRdxUFDoQe0/maxresdefault.jpg'
), (
	'38054a52-aba7-11ea-bb37-0242ac130002',
	'Rick Astley',
	'{"Pop"}',
	100,
	'https://i.ytimg.com/vi/dQw4w9WgXcQ/maxresdefault.jpg'
);

insert into album (
	id,
	name,
	genre,
	artist_id,
	popularity,
	release_date,
	image_url
) values (
	'c6cefe32-aba1-11ea-bb37-0242ac130002',
	'Thriller',
	'{"Pop"}',
	'bc270ee4-aba0-11ea-bb37-0242ac130002',
	100,
	'1999-01-31T00:00:00-0300',
	'https://i.ytimg.com/vi/oRdxUFDoQe0/maxresdefault.jpg'
), (
	'3f55609e-ac5b-11ea-bb37-0242ac130002',
	'XSCAPE',
	'{"Rock"}',
	'bc270ee4-aba0-11ea-bb37-0242ac130002',
	80,
	'1967-01-02T00:00:00-0300',
	'https://i.ytimg.com/vi/oRdxUFDoQe0/maxresdefault.jpg'
);

insert into track (
	id,
	name,
	artist_id,
	album_id,
	popularity,
	release_date
) values (
	'06f842de-ac4c-11ea-bb37-0242ac130002',
	'Thriller',
	'bc270ee4-aba0-11ea-bb37-0242ac130002',
	'c6cefe32-aba1-11ea-bb37-0242ac130002',
	100,
	'1999-01-31T00:00:00-0300'
), (
	'06f844d2-ac4c-11ea-bb37-0242ac130002',
	'Human Nature',
	'bc270ee4-aba0-11ea-bb37-0242ac130002',
	'c6cefe32-aba1-11ea-bb37-0242ac130002',
	60,
	'1998-01-31T00:00:00-0300'
), (
	'06f846a8-ac4c-11ea-bb37-0242ac130002',
	'Billie Jean',
	'bc270ee4-aba0-11ea-bb37-0242ac130002',
	'c6cefe32-aba1-11ea-bb37-0242ac130002',
	80,
	'1997-01-31T00:00:00-0300'
), (
	'4496fd46-ac5c-11ea-bb37-0242ac130002',
	'Love Never Felt So Good',
	'bc270ee4-aba0-11ea-bb37-0242ac130002',
	'3f55609e-ac5b-11ea-bb37-0242ac130002',
	100,
	'2000-01-31T00:00:00-0300'
), (
	'4496ff76-ac5c-11ea-bb37-0242ac130002',
	'A Place With No Name',
	'bc270ee4-aba0-11ea-bb37-0242ac130002',
	'3f55609e-ac5b-11ea-bb37-0242ac130002',
	60,
	'2000-01-31T00:00:00-0300'
), (
	'44970066-ac5c-11ea-bb37-0242ac130002',
	'Blue Gangsta',
	'bc270ee4-aba0-11ea-bb37-0242ac130002',
	'3f55609e-ac5b-11ea-bb37-0242ac130002',
	80,
	'2000-01-31T00:00:00-0300'
);

insert into account(id, name, email) values ('b79389c3-23fc-4611-b1f2-024aac3dd11e', 'Fulaninho', 'fulaninho@example.test');

insert into playlist(id, owner_id, name, image_url) values (
    '7b42d1ec-9e59-4976-9657-f5777bb3be34',
    'b79389c3-23fc-4611-b1f2-024aac3dd11e',
    'My Top Hits',
    'https://pbs.twimg.com/media/EUHdBGGWsAAmh4O.jpg'
);

insert into playlist_entry(id, playlist_id, track_id) values (
    '7abace73-7fc0-4cce-b6b8-6aa31aa284b0',
    '7b42d1ec-9e59-4976-9657-f5777bb3be34',
    '06f842de-ac4c-11ea-bb37-0242ac130002'
), (
    'e96f8141-238a-43fe-bb78-63dc3f15872d',
    '7b42d1ec-9e59-4976-9657-f5777bb3be34',
    '06f846a8-ac4c-11ea-bb37-0242ac130002'
), (
    '75a3699e-0518-48c2-a861-60b48e4886f7',
    '7b42d1ec-9e59-4976-9657-f5777bb3be34',
    '06f846a8-ac4c-11ea-bb37-0242ac130002'
);

