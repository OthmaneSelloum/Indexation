package src;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

public class Corpus_Reader {
    public static Map<String, String> readCorpus(String corpusPath) throws IOException {
        Map<String, String> documents = new HashMap<>();
        File folder = new File(corpusPath);

        if (!folder.exists() || !folder.isDirectory()) {
            throw new IllegalArgumentException("Invalid corpus path");
        }

        for (File subFolder : folder.listFiles()) {
            if (subFolder.isDirectory()) {
                for (File file : subFolder.listFiles()) {
                    String content = Files.readString(file.toPath());
                    documents.put(file.getName(), content);
                }
            }
        }
        return documents;
    }
}
