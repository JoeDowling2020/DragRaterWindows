delete from users;
delete from role;
INSERT INTO users (id, firstName, lastName, username, password) VALUES (1, 'Joe','Coyne','jcoyne', 'supersecret1'), (2, 'Fred','Hensen','fhensen', 'supersecret2'), (3, 'Barney','Curry','bcurry', 'supersecret3'), (4, 'Karen','Mack','kmack', 'supersecret4'), (5, 'Dianne','Klein','dklein', 'supersecret5'), (6, 'Dawn','Tillman','dtillman', 'supersecret6');
INSERT INTO role (id, role, user_id) VALUES (1 , 'user', 1), (2 , 'user', 2), (3 , 'user', 3), (4 , 'user', 4), (5 , 'admin', 5), (6 , 'admin', 6);