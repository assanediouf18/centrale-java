# Java

## Petit historique 

- Java est un langage de programmation “généraliste” avec une syntaxe proche de celle du C (1973) et du C++ (1983)
- Java officiellement sorti en 1995 (28 ans).
- Créé par James Gosling et Patrick Naughton, employés de Sun Microsystems (société aujd rachetée par Oracle)
- Java : argot américain pour le café, boisson favorite des développeurs (pas tous).
- A inspiré en 2002 : .NET et C#, Groovy

## Caractéristiques 

- **Langage  compilé en langage machine puis interprété par la JVM** : le code java est un code qui est compilé en bytecode. Le bytecode est interprété lors de l’exécution par un programme particulier : la JVM (Java Virtual Machine). Il existe plusieurs versions de la JVM (de différents auteurs, pour plusieurs OS) ce qui assure la portabilité du langage java
  (Note : langages compilés - C, C++ ; langages interprétés : Java, Python, PHP, JS)
- **Java est portable** (le langage machine produit)  :  il peut être exécuté sur plusieurs OS sans avoir à recompiler le code en bytecode. (fonctionne dès qu’une machine virtuelle est installée). C et C++ nécessitent de recompiler le code pour chaque ordinateur.
- **Java est orienté objet** : suit le paradigme orienté objet (conception particulière du code). Java définit quelques types primitifs qui ne sont pas des objets.
- **Fortement typé** : toutes les variables ont un type et il n’est pas possible de changer le type.
- **Garbage collector** : la gestion de la mémoire est aisée (automatique) : la JVM propose un système de ramasse-miettes (Garbage collector) permettant de libérer la mémoire RAM. En C et C++, le développeur doit gérer la gestion de la mémoire, ce qui est fastidieux.
- **Java permet le multithreading** (c'est-à-dire le multitache).
- **De nombreuses librairies fournies** dans la version standard (IO, réseaux, web)
- **Une très grande communauté de développeurs.**

## Processus de code : 

- Ecrire dans les fichiers `.java`
- Compilation (javac)
- Exécution (java)

- Des outils de build permettent de créer des projets complexes et d'exécuter plusieurs tâches de manière automatique. (compilation, exécution, exécution des tests...) Gradle en est un.

## Projet Intellij 

- L'intéret d'IntelliJ est de fournir un environnement de travail unique permettant de centraliser tous les différents outils de developpement (java, gradle, bases de données, terminal, git)
- L'inconvénient est que l'on perd la maitrise de chacun des outils (beaucoup de choses semblent automatiques et magiques).

En créant un projet Java "Empty", on crée un projet qui contient déjà plusieurs outils : Java + gradle + git
- Java : utilisation du JDK, un compilateur est inclus. Aide à l'écriture du code.
- Gradle (un moteur de production) permet (entre autres) de standardiser un projet java en suivant des conventions. (Par exemple : le découpage du projet en plusieurs dossiers).
- Git : permet de gérer ses sources. Un projet contient un repository local.

## Rappels conception orientée objets :

tuto conseillé : https://www.baeldung.com/get-started-with-java-series
