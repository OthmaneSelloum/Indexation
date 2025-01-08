# 📚 TF-IDF Indexing Project

Bienvenue dans ce projet d'indexation de documents basé sur le calcul **TF-IDF** (Term Frequency - Inverse Document Frequency). Ce projet traite un corpus de fichiers textes, applique un prétraitement avancé et génère un fichier contenant l'index TF-IDF des documents.

---

## 🛠️ **Structure du projet**

### 1️⃣ **Corpus_Reader**
📁 *Fichier : `Corpus_Reader.java`*

Cette classe est responsable de la lecture du corpus de documents.

- **Fonction principale :**
    - `readCorpus(String corpusPath)` : Parcourt un dossier contenant les fichiers texte, lit leur contenu et les stocke sous forme de clé-valeur (*nom du fichier* -> *contenu*).

💡 **Rôle** : Préparer les documents pour les étapes suivantes.

---

### 2️⃣ **Pre_process**
📁 *Fichier : `Pre_process.java`*

Cette classe effectue les étapes de prétraitement des documents :

- **Constructeur :**
    - `Pre_process(String stopwordsFilePath)` : Charge une liste de mots vides (*stopwords*) depuis un fichier.

- **Méthodes principales :**
    - `removeStopwords(String content)` : Supprime les mots vides du texte.
    - `applyStemming(String content)` : Réduit les mots à leur racine à l'aide de l'algorithme de *Porter Stemming*.
    - `processText(String content)` : Applique les deux étapes ci-dessus sur un texte donné.

💡 **Rôle** : Nettoyer les documents pour améliorer la qualité de l'indexation.

---

### 3️⃣ **Indexer**
📁 *Fichier : `Indexer.java`*

Cette classe calcule les valeurs TF-IDF pour chaque terme dans chaque document et génère un index.

- **Méthodes principales :**
    - `calculateTF(String[] terms)` : Calcule la fréquence des termes (*TF*) pour un document donné.
    - `calculateIDF(Map<String, String> documents)` : Calcule l'inverse de la fréquence des documents (*IDF*) pour tous les termes.
    - `computeTFIDF(Map<String, String> documents)` : Combine les valeurs TF et IDF pour produire les scores TF-IDF.
    - `saveIndex(Map<String, Map<String, Double>> index, String outputPath)` : Enregistre l'index TF-IDF dans un fichier texte.

💡 **Rôle** : Effectuer l'indexation principale et persister les résultats.

---

### 4️⃣ **Main**
📁 *Fichier : `Main.java`*

Cette classe exécute le programme principal, intégrant toutes les étapes précédentes :

1. **Lecture du corpus** avec `Corpus_Reader`.
2. **Prétraitement** des documents avec `Pre_process`.
3. **Calcul des scores TF-IDF** avec `Indexer`.
4. **Affichage et sauvegarde** des résultats dans un fichier `index.txt`.

💡 **Rôle** : Fournir un point d'entrée au programme et orchestrer les étapes.

---

## 🚀 **Étapes pour exécuter le projet**

1. Placez votre corpus de fichiers texte dans un dossier nommé `TEXT`.
2. Créez un fichier `Stopwords_fr.txt` contenant les mots vides à exclure.
3. Exécutez la classe `Main` pour générer l'index TF-IDF.
4. Consultez le fichier `index.txt` pour voir les résultats.

---

## 📝 **Résultat attendu**

Le fichier d'index final contient pour chaque document les termes et leurs scores TF-IDF, par exemple :

```
Document: doc1.txt
mot1: 0.123
mot2: 0.456
...

Document: doc2.txt
mot1: 0.789
mot3: 0.234
...
```

---

## 📂 **Organisation des fichiers**

```
project_root/
│
├── src/
│   ├── Corpus_Reader.java
│   ├── Pre_process.java
│   ├── Indexer.java
│   ├── Main.java
│
├── TEXT/           # Dossier contenant les fichiers texte à indexer
├── Stopwords_fr.txt
├── index.txt       # Fichier de sortie avec l'index TF-IDF
```

---

## ⚙️ **Technologies utilisées**

- **Langage :** Java
- **Bibliothèque de stemming :** *PorterStemmer*

---

## 🌟 **À propos**

Ce projet est conçu pour automatiser l'indexation de documents textuels avec le TF-IDF, permettant une recherche d'information plus efficace et pertinente. 💡
