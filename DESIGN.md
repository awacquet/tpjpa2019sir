# Architecture du projet

Le projet se décompose en plusieurs dossier et fichier voici la liste de ceux-ci et ce qu'ils contiennent:

## Other

Ici nous allons trouver tous les fichiers relatifs au projet mais qui ne sont pas du code ou qui n'ont pas de lien direct avec le code. Nous trouvons donc ici les rapports par exemple.

## SRC/MAIN/JAVA

### Entity

Ici nous trouvons la liste des entités qui composent notre projet. 

### Rest

Contient les classes relative à l'application REST. Avec nottament les chemins et les actions relatives à ceux-ci.

### Jpa

Nous trouvons ici la classe principal (main) ainsi que la classe Helper qui permet de réaliser des transactions avec la base de données.

### Servlet

Contient toutes les classes relatives aux Servlets.

## Resources

Contient les configurations nottament celles de la connection à la base de donnée.

## Webapp

Contient les templates pour la partie Servlet de l'application.

## Racine du projet

A la racine du projet nous trouvons le fichier maven pom.xml ainsi que le README.md qui explique comment installer le projet, le faire marcher et comment il marche.