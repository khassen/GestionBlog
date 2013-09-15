- creation de la table commentaires:

 create table commentaires(com_id int not null auto_increment, com_nom varchar(250), com_email varchar(250), com_text text, com_date timestamp, com_validation char(1), primary key(com_id));
Query OK, 0 rows affected (0.03 sec)

2- creation de la table categories:

create table categories(cat_id int not null auto_increment, cat_name varchar(250), cat_url varchar(250), primary key (cat_id));
Query OK, 0 rows affected (0.01 sec)

3- creation de la table auteurs:

 create table auteurs (aut_id int not null auto_increment, aut_nom varchar(250), aut_prenom varchar(250), aut_url varchar(250), aut_email varchar(250), primary key(aut_id));

 4- creation de la table articles:
 
 create table articles(art_id int not null auto_increment, art_titre varchar(250), art_chapeau text, art_contenu text , art_date timestamp, art_en_ligne boolean, primary key (art_id));
Query OK, 0 rows affected (0.03 sec)

5- creation des clés etrangeres:

+
mysql> alter table commentaires add column art_id int;
Query OK, 0 rows affected (0.05 sec)
Records: 0  Duplicates: 0  Warnings: 0

mysql> alter table commentaires add constraint art_id foreign key(art_id) references articles(art_id);
Query OK, 0 rows affected (0.04 sec)
Records: 0  Duplicates: 0  Warnings: 0

+
mysql> alter table articles add column cat_id int;
Query OK, 0 rows affected (0.60 sec)
Records: 0  Duplicates: 0  Warnings: 0

mysql> alter table articles add column aut_id int;
Query OK, 0 rows affected (0.16 sec)
Records: 0  Duplicates: 0  Warnings: 0

mysql> alter table articles add constraint cat_id foreign key(cat_id) references categories(cat_id);
Query OK, 0 rows affected (0.03 sec)
Records: 0  Duplicates: 0  Warnings: 0

mysql> alter table articles add constraint aut_id foreign key(aut_id) references auteurs(aut_id);
Query OK, 0 rows affected (0.05 sec)
Records: 0  Duplicates: 0  Warnings: 0



