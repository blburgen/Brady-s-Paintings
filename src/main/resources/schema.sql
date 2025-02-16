DROP TABLE IF EXISTS painting_medium;
DROP TABLE IF EXISTS medium;
DROP TABLE IF EXISTS painting;
DROP TABLE IF EXISTS completion;

CREATE TABLE completion (
	completion_id int NOT NULL AUTO_INCREMENT,
	completion_year int NOT NULL,
	status varchar(256) NOT NULL,
	PRIMARY KEY (completion_id)
);

CREATE TABLE painting (
	painting_id int NOT NULL AUTO_INCREMENT,
	completion_id int NOT NULL,
	painting_name varchar(256) NOT NULL,
	estimated_hours int,
	notes varchar(256),
	PRIMARY KEY (painting_id),
	FOREIGN KEY (completion_id) REFERENCES completion (completion_id) ON DELETE CASCADE
);

CREATE TABLE medium (
	media_id int NOT NULL AUTO_INCREMENT,
	media_name varchar(256) NOT NULL,
	media_quality varchar(256),
	PRIMARY KEY (media_id)
);

CREATE TABLE painting_medium (
	painting_id int NOT NULL,
	media_id int NOT NULL,
	FOREIGN KEY (painting_id) REFERENCES painting (painting_id) ON DELETE CASCADE,
	FOREIGN KEY (media_id) REFERENCES medium (media_id) ON DELETE CASCADE
);