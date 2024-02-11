# centrale-java

## launch the cli app : 

./gradlew :cli:run

## Mon rendu

Les patterns sont appliqués à de petits programmes testables dans le cli en modifiant la méthode
appelée par la fonction main.

### Composite pattern
Ce pattern est mis en oeuvre dans le package org.centrale.domain.filesystem. Il permet de récupérer la 
taille de chaque dossier/fichier. J'ai simulé un petit explorateur de fichiers pour l'exercice. Les tests de
l'explorateur de fichier sont dans la section test du domain.

### Visitor pattern
Ce pattern est mis en oeuvre dans le package org.centrale.domain.shifumi. Pour tester le shifumi en lançant.
