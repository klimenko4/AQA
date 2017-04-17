CREATE TABLE movies (
    mID INT ,
    title VARCHAR(64),
    year INT,
    director VARCHAR(64),
    PRIMARY KEY (mID)
);

insert into movies values(101, 'Gone with the Wind', 1939, 'Victor Fleming');
insert into movies values(102, 'Star Wars', 1977, 'George Lucas');
insert into movies values(103, 'The Sound of Music', 1965, 'Robert Wise');
insert into movies values(104, 'E.T.', 1982, 'Steven Spielberg');
insert into movies values(105, 'Titanic', 1997, 'James Cameron');
insert into movies values(106, 'Snow White', 1937, null);
insert into movies values(107, 'Avatar', 2009, 'James Cameron');
insert into movies values(108, 'Raiders of the Lost Ark', 1981, 'Steven Spielberg');