delete from users;
delete from role;
delete from drag_queen;
delete from ratings;
INSERT INTO users (id, firstName, lastName, username, password, email) VALUES (1, 'Joe','Coyne','jcoyne', 'supersecret1', 'jcoyne@gmail.com'), (2, 'Fred','Hensen','fhensen', 'supersecret2', 'fhensen@gmail.com'), (3, 'Barney','Curry','bcurry', 'supersecret3','bcurry@gmail.com'), (4, 'Karen','Mack','kmack', 'supersecret4','kmack@gmail.com'), (5, 'Dianne','Klein','dklein', 'supersecret5','dklein@gmail.com'), (6, 'Dawn','Tillman','dtillman', 'supersecret6','dtillman@gmail.com');
INSERT INTO role (id, role, user_id, username) VALUES (1 , 'user', 1, 'jcoyne'), (2 , 'user', 2, 'fhensen'), (3 , 'user', 3,'bcurry'), (4 , 'user', 4,'kmack'), (5 , 'admin', 5,'dklein'), (6 , 'admin', 6,'dtillman');
INSERT INTO drag_queen (dragQueenId, name, dobScore) VALUES (1, 'Trixie Matelle', 4.5), (2, 'Crystal Method', 3.2);
INSERT INTO ratings (reviewId, userId, dragQueenId, humour, makeup, hair, fashion, personality, dancing, acting, lipsync, impersonation, lyrics, brand) VALUES (1, 1, 1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11);