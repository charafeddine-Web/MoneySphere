# MoneySphere => Application de Gestion de Comptes Bancaires (Java 8 - Console)
📌 Description du projet

Une banque souhaite automatiser la gestion de ses comptes via une application console en Java 8.
Ce projet permet de gérer différents types de comptes (courant, épargne), d’effectuer des opérations bancaires (versements, retraits, virements), et de consulter l’historique de chaque compte.

L’objectif est de mettre en place une architecture claire en couches et de respecter les bonnes pratiques de développement Java.

🛠️ Technologies utilisées

Java SE 8 (obligatoire)

Collections Java (ArrayList, HashMap)

Java Time API pour la gestion des dates

UUID pour l’identifiant unique des opérations

Git pour le contrôle de version

JIRA pour la gestion des tâches

(Bonus possible : JDBC + MySQL, Stream API, Lambdas, Optional)

🏗️ Structure du projet

L’application est développée en suivant une architecture en couches :

src/
├── controller/         → Contient la logique de gestion des comptes (CompteController)
├── model/              → Contient les entités (Compte, CompteCourant, CompteEpargne, Operation, Versement, Retrait…)
├── util/               → Contient les énumérations et utilitaires (Source, Destination…)
├── ui/                 → Interface console (menus, saisies utilisateur)
└── Main.java           → Point d’entrée de l’application

📂 Contenu des classes principales

Classe abstraite Compte

Attributs : code, solde, listeOperations

Méthodes abstraites : retirer(), calculerInteret(), afficherDetails()

Format du code : CPT-XXXXX (ex: CPT-00001)

CompteCourant (hérite de Compte)

Attribut : decouvert

Règle de retrait : solde ≥ -découvert

calculerInteret() retourne 0

CompteEpargne (hérite de Compte)

Attribut : tauxInteret

Règle de retrait : solde ≥ montant demandé

calculerInteret() calcule les intérêts

Classe abstraite Operation

Attributs : numero (UUID), date, montant

Versement (hérite de Operation)

Attribut : source (ex: "Virement externe", "Salaire")

Retrait (hérite de Operation)

Attribut : destination (ex: "Distributeur ATM")

🚀 Fonctionnalités principales

Créer un compte (courant ou épargne)

Effectuer un versement sur un compte

Effectuer un retrait d’un compte

Effectuer un virement entre deux comptes

Consulter le solde d’un compte

Consulter la liste des opérations d’un compte

Afficher la liste de tous les comptes

📋 Prérequis

Installer JDK 8

Vérifier l’installation avec :

java -version
javac -version


Avoir Git installé

Cloner le projet depuis GitHub :

git clone https://github.com/charafeddine-Web/MoneySphere.git

cd MoneySphere

▶️ Exécution

Compiler le projet :

javac -d bin src/**/*.java


Lancer l’application :

java -cp bin Main


Un menu interactif s’affichera dans la console.

   =========================

Exemple de virement
Virement de 1000 DH effectué avec succès !

📦 Livrables

Code source complet sur GitHub

Fichier JAR exécutable

Diagramme de classes

README.md complet avec description, structure, prérequis et captures

✅ Critères de performance

Respect strict de Java 8

Application fonctionnelle

Architecture en couches respectée

Code propre, clair et bien commenté

Progression Git avec commits réguliers et descriptifs

README clair et complet