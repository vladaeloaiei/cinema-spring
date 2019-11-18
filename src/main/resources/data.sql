--#script
--#sali
INSERT INTO rooms VALUES(1, 'mare', 160,10, 16);
INSERT INTO rooms VALUES(2, 'mare', 160,10, 16);
INSERT INTO rooms VALUES(3, 'mica', 100,10, 10);
INSERT INTO rooms VALUES(4, 'mica', 100,10, 10);

--#filme
INSERT INTO movies VALUES(1, 'Rampage', 107, 22.00);
INSERT INTO movies VALUES(2, 'Deadpool 2', 120, 21.00);
INSERT INTO movies VALUES(3, 'Avengers', 151, 23.00);
INSERT INTO movies VALUES(4, 'Peter iepurasul', 95, 20.00);
INSERT INTO movies VALUES(5, 'Amnezie cu surprize', 112, 20.00);

--#detalii_filme
INSERT INTO detalii_filme VALUES(1, TO_DATE('13/04/2018', 'DD/MM/YYYY'), 'Acțiune, Ficțiune, Aventură', 'O gorilă, un crocodil şi un lup cad victime unor malefice experimente genetice.', 1);

INSERT INTO detalii_filme VALUES(2, TO_DATE('18/05/2018', 'DD/MM/YYYY'), 'Acțiune, Aventură, Comedie', 'Guralivul mercenar de la Marvel se întoarce.', 2);

INSERT INTO detalii_filme VALUES(3, TO_DATE('27/04/2018', 'DD/MM/YYYY'), 'Fantastic, Acțiune, Aventură', 'L-am întrezarit la finalul lui The Avengers, furios ca Chitauri nu au reușit sa înfrânga Pamântul și, mai ales, sa obțina Tesseractul: este Thanos', 3);

INSERT INTO detalii_filme VALUES(4, TO_DATE('30/03/2018', 'DD/MM/YYYY'), 'Romantic, Comedie', 'Peter Rabbit este adaptarea pentru marele ecran a clasicei povesti semnate de Beatrix Potter.', 4);

INSERT INTO detalii_filme VALUES(5, TO_DATE('11/05/2018', 'DD/MM/YYYY'), 'Acțiune, Ficțiune, Aventură', 'Un bogatas rasfatat si obraznic devine amnezic în urma unui accident.', 5);

--#program
INSERT INTO programe values(1,TO_DATE('29/05/2018 12:00', 'DD/MM/YYYY HH24:MI'), 1, 1);
INSERT INTO programe values(2,TO_DATE('29/05/2018 12:00', 'DD/MM/YYYY HH24:MI'), 2, 2);
INSERT INTO programe values(3,TO_DATE('29/05/2018 12:00', 'DD/MM/YYYY HH24:MI'), 3, 3);
INSERT INTO programe values(4,TO_DATE('29/05/2018 14:30', 'DD/MM/YYYY HH24:MI'), 4, 4);
INSERT INTO programe values(5,TO_DATE('29/05/2018 14:30', 'DD/MM/YYYY HH24:MI'), 1, 5);

--rezervari
INSERT INTO rezervari values(1,'email1@gmail.com',10,'12,13,14', 1);
INSERT INTO rezervari values(2,'email2@yahoo.com',8,'9,10', 2);
INSERT INTO rezervari values(3,'email3@gmail.com',5,'1,2', 3);
INSERT INTO rezervari values(4,'email4@gmail.com',6,'3,4,5,6', 4);
INSERT INTO rezervari values(5,'email5@yahoo.com',7,'6,7,8,9,10', 5);


--useri
INSERT INTO useri VALUES(1,'admin', 'admin', 1);
INSERT INTO useri VALUES(2,'casier', 'casier', 2);
