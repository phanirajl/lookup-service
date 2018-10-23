CREATE KEYSPACE lookup_ref WITH replication = {'class':'SimpleStrategy', 'replication_factor' : 3};

DESCRIBE KEYSPACES;

USE lookup_ref;

CREATE TABLE country(
   country_id int PRIMARY KEY,
   country_code text,
   country_name_ar text,
   country_name_en text
);

DROP TABLE country;

SELECT * FROM COUNTRY;

INSERT INTO COUNTRY (country_id, country_code, country_name_ar, country_name_en) VALUES(1,'UAE', 'United Arab Emirates','United Arab Emirates');
INSERT INTO COUNTRY (country_id, country_code, country_name_ar, country_name_en) VALUES(2,'SAU', 'Saudi Arabia','Saudi Arabia');
INSERT INTO COUNTRY (country_id, country_code, country_name_ar, country_name_en) VALUES(3,'KWT', 'Kuwait','Kuwait');
INSERT INTO COUNTRY (country_id, country_code, country_name_ar, country_name_en) VALUES(4,'BHR', 'Bahrain','Bahrain');
INSERT INTO COUNTRY (country_id, country_code, country_name_ar, country_name_en) VALUES(5,'QAT', 'Qatar','Qatar');
INSERT INTO COUNTRY (country_id, country_code, country_name_ar, country_name_en) VALUES(6,'OMN', 'Oman','Oman');
INSERT INTO COUNTRY (country_id, country_code, country_name_ar, country_name_en) VALUES(7,'IRQ', 'Iraq','Iraq');
INSERT INTO COUNTRY (country_id, country_code, country_name_ar, country_name_en) VALUES(8,'YEM', 'Yemen','Yemen');
INSERT INTO COUNTRY (country_id, country_code, country_name_ar, country_name_en) VALUES(9,'LBN', 'Lebanon','Lebanon');
INSERT INTO COUNTRY (country_id, country_code, country_name_ar, country_name_en) VALUES(10,'SYR', 'Syria','Syria');
