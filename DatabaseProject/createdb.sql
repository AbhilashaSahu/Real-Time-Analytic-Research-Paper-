
CREATE TABLE Buildings(Building_ID Varchar2(30),
Building_name Varchar2(200),
No_Of_vertices Number,
building_Shape sdo_Geometry,
constraint Buildings_pk Primary key(building_id) );


 INSERT INTO USER_SDO_GEOM_METADATA (TABLE_NAME, COLUMN_NAME, DIMINFO, SRID) VALUES ('BUILDINGS', 'BUILDING_SHAPE',
 MDSYS.SDO_DIM_ARRAY(MDSYS.SDO_DIM_ELEMENT('xpoint', -100,1000, 0.005), MDSYS.SDO_DIM_ELEMENT('Ypoint',  -100,1000, 0.005) ),NULL); 
 

CREATE INDEX buildings_spat_index on Buildings(building_Shape) 
 INDEXTYPE IS MDSYS.SPATIAL_INDEX;
 

 CREATE TABLE PHOTOGRAPHERI(photographer_id varchar2(5),photographerlocation sdo_geometry ,
 CONSTRAINT PHOTOGRAPHERI_pk Primary Key(photographer_id));
 

 INSERT INTO USER_SDO_GEOM_METADATA (TABLE_NAME, COLUMN_NAME, DIMINFO, SRID) VALUES ('PHOTOGRAPHERI', 'photographerlocation',
 MDSYS.SDO_DIM_ARRAY(MDSYS.SDO_DIM_ELEMENT('x_point',0,830, 0.005), MDSYS.SDO_DIM_ELEMENT('y_point', 0,590, 0.005) ),NULL); 


CREATE INDEX photographer_loc_index on PHOTOGRAPHERI(photographerlocation) INDEXTYPE IS MDSYS.SPATIAL_INDEX;


CREATE TABLE PHOTOI(photo_id varchar2(20),photographer_id varchar2(5),photo_location sdo_geometry,
CONSTRAINT PHOTOI_pk Primary Key(photo_id),CONSTRAINT photo_fk Foreign Key(photographer_id) REFERENCES PHOTOGRAPHER(photographer_id) ON DELETE CASCADE);


INSERT INTO USER_SDO_GEOM_METADATA (TABLE_NAME, COLUMN_NAME, DIMINFO, SRID) VALUES ('PHOTOI', 'photo_location',
MDSYS.SDO_DIM_ARRAY(MDSYS.SDO_DIM_ELEMENT('x_point',0,830, 0.005), MDSYS.SDO_DIM_ELEMENT('y_point', 0,590, 0.005) ),NULL); 

CREATE INDEX photo_loc_index on PHOTOI(photo_location) INDEXTYPE IS MDSYS.SPATIAL_INDEX;
