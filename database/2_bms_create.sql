-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2023-11-30 12:54:37.0

-- tables
-- Table: bridge
CREATE TABLE bridge (
    id serial  NOT NULL,
    number int  NOT NULL,
    name varchar(255)  NOT NULL,
    length decimal(5,1)  NOT NULL,
    width decimal(4,1)  NOT NULL,
    type_id int  NOT NULL,
    condition_index decimal(4,1)  NOT NULL,
    location_id int  NOT NULL,
    material_id int  NOT NULL,
    CONSTRAINT bridge_pk PRIMARY KEY (id)
);

-- Table: county
CREATE TABLE county (
    id serial  NOT NULL,
    name varchar(30)  NOT NULL,
    CONSTRAINT county_pk PRIMARY KEY (id)
);

-- Table: image
CREATE TABLE image (
    id serial  NOT NULL,
    bridge_id int  NOT NULL,
    data bytea  NOT NULL,
    type char(1)  NOT NULL,
    CONSTRAINT image_pk PRIMARY KEY (id)
);

-- Table: interesting_fact
CREATE TABLE interesting_fact (
    id serial  NOT NULL,
    description text  NULL,
    bridge_id int  NOT NULL,
    CONSTRAINT interesting_fact_pk PRIMARY KEY (id)
);

-- Table: location
CREATE TABLE location (
    id serial  NOT NULL,
    county_id int  NOT NULL,
    latitude decimal(8,6)  NOT NULL,
    longitude decimal(8,6)  NOT NULL,
    CONSTRAINT location_pk PRIMARY KEY (id)
);

-- Table: material
CREATE TABLE material (
    id serial  NOT NULL,
    name varchar(30)  NOT NULL,
    CONSTRAINT material_pk PRIMARY KEY (id)
);

-- Table: role
CREATE TABLE role (
    id serial  NOT NULL,
    name varchar(40)  NOT NULL,
    CONSTRAINT role_pk PRIMARY KEY (id)
);

-- Table: type
CREATE TABLE type (
    id serial  NOT NULL,
    name varchar(255)  NOT NULL,
    CONSTRAINT type_pk PRIMARY KEY (id)
);

-- Table: user
CREATE TABLE "user" (
    id serial  NOT NULL,
    role_id int  NOT NULL,
    username varchar(255)  NOT NULL,
    password varchar(255)  NOT NULL,
    status char(1)  NOT NULL,
    CONSTRAINT user_pk PRIMARY KEY (id)
);

-- foreign keys
-- Reference: bridge_info_location (table: bridge)
ALTER TABLE bridge ADD CONSTRAINT bridge_info_location
    FOREIGN KEY (location_id)
    REFERENCES location (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: bridge_material (table: bridge)
ALTER TABLE bridge ADD CONSTRAINT bridge_material
    FOREIGN KEY (material_id)
    REFERENCES material (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: bridge_type (table: bridge)
ALTER TABLE bridge ADD CONSTRAINT bridge_type
    FOREIGN KEY (type_id)
    REFERENCES type (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: image_bridge (table: image)
ALTER TABLE image ADD CONSTRAINT image_bridge
    FOREIGN KEY (bridge_id)
    REFERENCES bridge (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: interesting_fact_bridge (table: interesting_fact)
ALTER TABLE interesting_fact ADD CONSTRAINT interesting_fact_bridge
    FOREIGN KEY (bridge_id)
    REFERENCES bridge (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: location_county (table: location)
ALTER TABLE location ADD CONSTRAINT location_county
    FOREIGN KEY (county_id)
    REFERENCES county (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: user_role (table: user)
ALTER TABLE "user" ADD CONSTRAINT user_role
    FOREIGN KEY (role_id)
    REFERENCES role (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- End of file.

