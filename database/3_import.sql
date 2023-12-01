INSERT INTO project.role (id, name) VALUES (DEFAULT, 'admin');
INSERT INTO project.role (id, name) VALUES (DEFAULT, 'customer');

INSERT INTO project."user" (id, role_id, username, password, status) VALUES (DEFAULT, 1, 'admin', '123', 'A');
INSERT INTO project."user" (id, role_id, username, password, status) VALUES (DEFAULT, 2, 'rain', '123', 'A');
INSERT INTO project."user" (id, role_id, username, password, status) VALUES (DEFAULT, 2, 'mitteaktiivne', '123', 'D');
