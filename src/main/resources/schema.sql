DROP TABLE IF EXISTS ANIMETWEET;

CREATE TABLE ANIMETWEET(
      id INT AUTO_INCREMENT  PRIMARY KEY,
      title VARCHAR(250) NOT NULL,
      link VARCHAR(250) NOT NULL,
      guid VARCHAR(250) NOT NULL,
      description VARCHAR(4000) NOT NULL,
      pubDate TIMESTAMP NOT NULL,
      createdDate TIMESTAMP NOT NULL DEFAULT  CURRENT_TIMESTAMP,
      category varchar(30)
);