package word;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Word {
    public List<String> formater() {
        List<String> palavrasComCincoLetras = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(Word.class.getResourceAsStream("/word/words.txt"), StandardCharsets.UTF_8))) {

            String linha;

            while ((linha = br.readLine()) != null) {
                String[] palavras = linha.split("\\s+");

                for (String palavra : palavras) {
                    if (palavra.length() == 5) {
                        palavrasComCincoLetras.add(palavra);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return palavrasComCincoLetras;
    }
}
