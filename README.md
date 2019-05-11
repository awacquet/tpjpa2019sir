# Application Doodle

Application de sondage pour la création de réunions.

Note: voir le fichier DESIGN.md pour connaitre l'arborescence du projet et trouver les réponses au TP03.

## Fonctionnalités implémentées

#### Servlet:

* Création d'un utilisateur
* Affichage de tous les utilisateurs
* Création d'un sondage
* Affichage des sondages
* Voir résultats du sondage

#### REST:

* Récupération de la liste des réunions
* Récupération d'une réunion
* Récupération de la liste des sondages
* Récupération d'un sondage
* Récupération de la liste des utilisateurs
* Récupération d'un utilisateur
* Ajout d'un utilisateur

#### Angular:
* Mise en place d'un proxy entre le front et le back pour accéder à l'API REST
    * http://localhost:4200/api/ → url de base à compléter par l'api visée
        * User : liste des utilisateurs
        * meeting : liste des réunions
        * survey : liste des sondages
    * Chacune de ces APIs peut recevoir un ID en paramètre (ajouter "/id")
    * Si le port de votre API REST n'est pas 8080, il vous faudra modifier le fichier `proxy.conf.json`
* Affichage des réunions (utilisation d'un service)
* Affichage des utilisateurs (utilisation d'un service)

## Fonctionnalités à venir

#### Servlet:
* Participation à un sondage
* Ajout des préférences alimentaires

#### REST:
* Récupération des sondages créés par un utilisateur

#### Angular:
* Utiliser du CSS
* Préférer utiliser nginx à la place du proxy actuel
* Mettre en place des services pour afficher plus d'éléments (récupération d'une réunion pour la modifier par exemple)
* Mettre en place des formulaires (création d'utilisateur, de réunion, etc)

#### Autre:
* Tests Unitaires
* Creation de la partie DAO
* Révision du diagramme UML en cas de fonctionnalités pas implémentables dans le futur
* Correction des bugs trouvés

## Prise en main

Ces instructions vous permettront d'installer et tester le projet sur votre machine.

### Pré-requis

Pour pouvoir tester le projet vous avez besoin d'un IDE tel qu'IntelliJ. ainsi qu'un JDK tel que Java 11.

### Installation

#### Partie 1

Tout d'abord vous devez installer les librairies manquantes via le fichier POM.xml. Pour se faire sous IntelliJ cliquez droit dessus puis sélectez: 

```
Add as Maven Project
```

Ou

```
Maven → Reimport
```

Ou toute autre manipulation relative a votre IDE favoris.

#### Partie 2

Pour pouvoir utiliser JPA correctement il est nécessaire de configurer le fichier persistence.xml et modifier le bloc qui se nomme:

```
 <persistence-unit name="mysql">
 ...
 </persistence-unit>
```

En fonction de la configuration de la base de donnée que vous utilisez. Vous pouvez trouver de l'aide pour la configuration grâce à [cet article](https://thoughts-on-java.org/jpa-persistence-xml/).

**enfin n'ouliez pas de laisser le name du bloc à "mysql" et ce même si vous n'utilisez pas mysql comme moteur de BDD pour des raison de fonctionnement du code de l'application !**

#### Partie 3

Afin de lancer le nécessaire pour le fonctionnement du projet, il faut d'abord lancer votre base de données.  
Ensuite il faudra lancer tomcat dont le répertoire de travail sera la racine du projet.  
Enfin il faudra exécuter la commande `ng serve` dans le dossier `front`.
La partie front-end sera ensuite accessible depuis http://localhost:4200/ (le port peut varier selon votre configuration).

## Crédits

### Développé grâce à

* [IntelliJ](https://www.jetbrains.com/idea/) - IDE utilisé
* [Maven](https://maven.apache.org/) - Gestionnaire de dépendances
* [MySQL](https://www.mysql.com/fr/) - Moteur de base de données utilisé

### Auteurs

* **Barais Olivier** - *Créateur du squelette*
* **Wacquet Adrien** - *Contributeur principal*
* **Kupratsevitch Vadim** - *Contributeur principal*

### License

Ce projet est sous licence MIT - voir le fichier [LICENSE.md](LICENSE.md) pour plus de détails
