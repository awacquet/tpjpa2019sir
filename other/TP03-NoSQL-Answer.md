# Compte rendu tpmongodb

### Quelles sont les limites d’une base données orientées document ?

Voici les principales limitations:

* La taille maximal d'un document est de 16 Mb
* La profondeur maximal d'imbrication possible est de 100 documents
* La taille maximal de la base de donnée est de 32 TB

une liste plus complète peut être consulté sur (https://docs.mongodb.com/manual/reference/limits/)

### Quelles sont les types de données stockés dans Redis, que peut on faire comme types de requêtes ?

Les stockés via Redis sont sous forme de Map (assocations de clé-valeur). Redis accepte de multiples donnés tel que:

* Les Strings
* Les Lists
* Les Sets
* Les Hashes
* Les Sorted sets
* Les Bitmaps et HyperLogLogs
