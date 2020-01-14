use adlister_db;
DROP TABLE if exists users;
DROP TABLE if exists ads;
show tables;

insert into users (username, email, password) values
('roger', 'roger@email', 'password');

TRUNCATE users;
TRUNCATE ads;
SELECT * FROM users;
SELECT * FROM ads;

# insert into ads (title, description, user_id) values
# ('title1', 'One', 'one-id'),
# ('title2', 'Two', 'two-id'),
# ('title3', 'Three', 'three-id'),
# ('title4', 'Four', 'four-id');


