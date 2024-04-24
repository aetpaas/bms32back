INSERT INTO role (id, name) VALUES (DEFAULT, 'admin');
INSERT INTO role (id, name) VALUES (DEFAULT, 'customer');

INSERT INTO "user" (id, role_id, username, password, status) VALUES (DEFAULT, 1, 'admin', '123', 'A');
INSERT INTO "user" (id, role_id, username, password, status) VALUES (DEFAULT, 2, 'rain', '123', 'A');
INSERT INTO "user" (id, role_id, username, password, status) VALUES (DEFAULT, 2, 'mitteaktiivne', '123', 'D');

INSERT INTO county (id, name) VALUES (DEFAULT, 'Harju maakond');
INSERT INTO county (id, name) VALUES (DEFAULT, 'Hiiu maakond');
INSERT INTO county (id, name) VALUES (DEFAULT, 'Ida-Viru maakond');
INSERT INTO county (id, name) VALUES (DEFAULT, 'Jõgeva maakond');
INSERT INTO county (id, name) VALUES (DEFAULT, 'Järva maakond');
INSERT INTO county (id, name) VALUES (DEFAULT, 'Lääne maakond');
INSERT INTO county (id, name) VALUES (DEFAULT, 'Lääne-Viru maakond');
INSERT INTO county (id, name) VALUES (DEFAULT, 'Põlva maakond');
INSERT INTO county (id, name) VALUES (DEFAULT, 'Pärnu maakond');
INSERT INTO county (id, name) VALUES (DEFAULT, 'Rapla maakond');
INSERT INTO county (id, name) VALUES (DEFAULT, 'Saare maakond');
INSERT INTO county (id, name) VALUES (DEFAULT, 'Tartu maakond');
INSERT INTO county (id, name) VALUES (DEFAULT, 'Valga maakond');
INSERT INTO county (id, name) VALUES (DEFAULT, 'Viljandi maakond');
INSERT INTO county (id, name) VALUES (DEFAULT, 'Võru maakond');

INSERT INTO material(id, name) VALUES (DEFAULT,'Puit');
INSERT INTO material(id, name) VALUES (DEFAULT,'Metall');
INSERT INTO material(id, name) VALUES (DEFAULT,'Raudbetoon');
INSERT INTO material(id, name) VALUES (DEFAULT,'Muu');

INSERT INTO type(id, name) VALUES (DEFAULT, 'Viadukt');
INSERT INTO type(id, name) VALUES (DEFAULT, 'Sild');
INSERT INTO type(id, name) VALUES (DEFAULT, 'Tunnel');
INSERT INTO type(id, name) VALUES (DEFAULT, 'Ökodukt');

INSERT INTO location(id, county_id, latitude, longitude) VALUES (DEFAULT, 15, 57.729548, 26.917039);
INSERT INTO location(id, county_id, latitude, longitude) VALUES (DEFAULT, 15, 58.731887, 23.992332);
INSERT INTO location(id, county_id, latitude, longitude) VALUES (DEFAULT, 1, 59.175789, 24.502101);
INSERT INTO location(id, county_id, latitude, longitude) VALUES (DEFAULT, 15, 59.280388, 24.978404);
INSERT INTO location (id, county_id, latitude, longitude) VALUES (DEFAULT, 11, 58.228452, 22.382314);


INSERT INTO bridge (id, number, name, length, width, type_id, condition_index, location_id, material_id) VALUES (DEFAULT, 937, 'ALA-RÕUGE', 11.8, 11,2,98,1,1);
INSERT INTO bridge (id, number, name, length, width, type_id, condition_index, location_id, material_id) VALUES (DEFAULT,350,'KASARI (Vana)',307.80,7.00,2,83,2,3);
INSERT INTO bridge (id, number, name, length, width, type_id, condition_index, location_id, material_id) VALUES (DEFAULT,1310,'KERNU Ökodukt',11.00,20.00,4,83,3,2);
INSERT INTO bridge (id, number, name, length, width, type_id, condition_index, location_id, material_id) VALUES (DEFAULT,150,'VAIDA Jalakäijate sild',132.00,4.00,2,100,4,2);
INSERT INTO bridge (id, number, name, length, width, type_id, condition_index, location_id, material_id) VALUES (DEFAULT,1043,'NASVA SILD',18.20,14.00,2,89.8,5,2);
