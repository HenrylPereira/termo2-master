package game;

import word.Word;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Termo {
    Random random = new Random();
    String palavraChave;
    int numeroDeTentativa = 1;

    Word word = new Word();
    List<String> words = word.formater();
    List<String> palavrasRestantes;

    public void getPalavraChave() {
        String palavraChave = words.get(random.nextInt(words.size()));
        System.out.println("palavra CHAVE = " + palavraChave);
        this.palavraChave = palavraChave;
    }

    public void iniciarTermo() {
        String chute = words.get(random.nextInt(words.size()));
        this.comparaChute(this.palavraChave, chute);
    }

    public void comparaChute(String palavraChave, String chute) {
        palavrasRestantes = new ArrayList<>(words);

        while (!chute.equals(palavraChave) && this.numeroDeTentativa <= 6) {
            final String finalChute = chute;
            System.out.println("Quantidade de palavras na lista: " + palavrasRestantes.size());
            palavrasRestantes.removeIf(palavra -> comparaLetrasPosicao(palavra, finalChute) != comparaLetrasPosicao(palavraChave, finalChute));

            chute = palavrasRestantes.get(random.nextInt(palavrasRestantes.size()));

            System.out.println("Chutando: " + chute + " Tentativa: " + this.numeroDeTentativa);
            this.numeroDeTentativa = this.numeroDeTentativa + 1;
        }
        if (Objects.equals(this.palavraChave, chute)) {
            System.out.println("ACERTOU: " + palavraChave);
        } else {
            System.out.println("ERROU: " + palavraChave);
        }

        ;
    }

    private int comparaLetrasPosicao(String palavra1, String palavra2) {
        int count = 0;
        for (int i = 0; i < palavra1.length(); i++) {
            if (palavra1.charAt(i) == palavra2.charAt(i)) {
                count++;
            }
        }
        return count;
    }
}
