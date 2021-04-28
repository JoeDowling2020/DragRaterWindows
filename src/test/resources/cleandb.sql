delete from users;
delete from role;
delete from drag_queen;
delete from ratings;
INSERT INTO users (id, firstName, lastName, username, password) VALUES (1, 'Joe','Coyne','jcoyne', 'supersecret1'), (2, 'Fred','Hensen','fhensen', 'supersecret2'), (3, 'Barney','Curry','bcurry', 'supersecret3'), (4, 'Karen','Mack','kmack', 'supersecret4'), (5, 'Dianne','Klein','dklein', 'supersecret5'), (6, 'Dawn','Tillman','dtillman', 'supersecret6');
INSERT INTO role (id, role, user_id) VALUES (1 , 'user', 1), (2 , 'user', 2), (3 , 'user', 3), (4 , 'user', 4), (5 , 'admin', 5), (6 , 'admin', 6);
INSERT INTO drag_queen (dragQueenId, name, dobScore) VALUES (1, 'Trixie Matelle', 4.5), (2, 'Crystal Method', 3.2);
INSERT INTO ratings (reviewId, userId, dragQueenId, humour, makeup, hair, fashion, personality, dancing, acting, lipsync, impersonation, lyrics, brand) VALUES (1, 1, 1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11);

Drop user 'tomcat'@'localhost';

CREATE USER 'tomcat'@'localhost' IDENTIFIED BY 'tomcat';
GRANT SELECT ON dragrater.* TO 'tomcat'@'localhost';