CREATE  TABLE users (
  username VARCHAR(45) NOT NULL ,
  password VARCHAR(45) NOT NULL ,
  enabled TINYINT NOT NULL DEFAULT 1 ,
  PRIMARY KEY (username));
CREATE TABLE user_roles (
  user_role_id int(11) NOT NULL AUTO_INCREMENT,
  username varchar(45) NOT NULL,
  role varchar(45) NOT NULL,
  PRIMARY KEY (user_role_id),
  UNIQUE KEY uni_username_role (role,username),
  KEY fk_username_idx (username),
  CONSTRAINT fk_username FOREIGN KEY (username) REFERENCES users (username));
  
INSERT INTO users(username,password,enabled)
VALUES ('theuns','theuns', true);
INSERT INTO users(username,password,enabled)
VALUES ('student','student', true);
INSERT INTO users(username,password,enabled)
VALUES ('teacher','teacher', true);
INSERT INTO users(username,password,enabled)
VALUES ('user','user', true);
INSERT INTO users(username,password,enabled)
VALUES ('admin','admin', true);

INSERT INTO user_roles (username, role)
VALUES ('user', 'ROLE_USER');
INSERT INTO user_roles (username, role)
VALUES ('admin', 'ROLE_ADMIN');
INSERT INTO user_roles (username, role)
VALUES ('theuns', 'ROLE_USER');
INSERT INTO user_roles (username, role)
VALUES ('theuns', 'ROLE_ADMIN');
INSERT INTO user_roles (username, role)
VALUES ('student', 'ROLE_STUDENT');
INSERT INTO user_roles (username, role)
VALUES ('teacher', 'ROLE_TEACHER');

commit;