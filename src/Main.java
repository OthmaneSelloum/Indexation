package src;

import java.io.IOException;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String corpusPath = "TEXT";
        String stopwordsFilePath = "Stopwords_fr.txt";
        String outputPath = "index.txt";

        try {

            System.out.println("Lecture du corpus...");
            Map<String, String> documents = Corpus_Reader.readCorpus(corpusPath);


            System.out.println("Prétraitement des documents...");
            Pre_process preProcessor = new Pre_process(stopwordsFilePath);
            for (Map.Entry<String, String> entry : documents.entrySet()) {
                String processedText = preProcessor.processText(entry.getValue());
                documents.put(entry.getKey(), processedText);
            }

            System.out.println("Indexation TF-IDF...");
            Map<String, Map<String, Double>> index = Indexer.computeTFIDF(documents);

            System.out.println("Affichage de l'index TF-IDF :");
            for (Map.Entry<String, Map<String, Double>> docEntry : index.entrySet()) {
                System.out.println("Document : " + docEntry.getKey());
                for (Map.Entry<String, Double> termEntry : docEntry.getValue().entrySet()) {
                    System.out.printf("  Terme : %-20s TF-IDF : %.6f%n", termEntry.getKey(), termEntry.getValue());
                }
                System.out.println();
            }

            // Étape 5 : Enregistrer l'index dans un fichier
            System.out.println("Enregistrement de l'index...");
            Indexer.saveIndex(index, outputPath);

            System.out.println("Indexation terminée et enregistrée dans " + outputPath);

        } catch (IOException e) {
            System.err.println("Erreur lors de l'exécution : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
