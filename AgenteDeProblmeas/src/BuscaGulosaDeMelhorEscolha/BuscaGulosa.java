package BuscaGulosaDeMelhorEscolha;

import AgenteDeProblema.Estado;
import AgenteDeProblema.Transicao;
import BuscaDeCusto.No;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

public class BuscaGulosa {

    public static No buscar(Estado inicial, Estado objetivo) {

        No raiz = new No(inicial, null, null, 0);

        if (raiz.estado.equals(objetivo)) {
            return raiz;
        }

        PriorityQueue<No> borda = new PriorityQueue<>(Comparator.comparingInt(no -> no.custoCaminho));
        borda.add(raiz);

        HashSet<Estado> explorados = new HashSet<>();

        while (!borda.isEmpty()) {
            No atual = borda.poll();
            explorados.add(atual.estado);

            if (atual.estado.equals(objetivo)) {
                return atual;
            }

            for (Transicao transicao : atual.estado.transicoes) {
                No filho = new No(transicao.estado, atual, transicao, atual.custoCaminho + transicao.custo);
                boolean naBorda = borda.stream().anyMatch(no -> no.estado.equals(filho.estado));
                if (!explorados.contains(filho.estado) && !naBorda) {
                    borda.add(filho);
                } else if (naBorda) {
                    No existente = borda.stream()
                            .filter(no -> no.estado.equals(filho.estado))
                            .findFirst()
                            .orElse(null);
                    if (existente != null && existente.custoCaminho > filho.custoCaminho) {
                        borda.remove(existente);
                        borda.add(filho);
                    }
                }
            }
        }
        return null;
    }
}
