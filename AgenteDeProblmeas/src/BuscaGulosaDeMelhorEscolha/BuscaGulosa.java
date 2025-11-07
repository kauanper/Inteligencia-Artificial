package BuscaGulosaDeMelhorEscolha;

import AgenteDeProblema.Estado;
import AgenteDeProblema.Transicao;
import BuscaDeCusto.No;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

public class BuscaGulosa {

    public static No buscar(Estado inicial, Estado objetivo, TabelaHeuristica hTable) {

        // nó raiz com custo igual à heurística (custo guloso)
        int hInicial = hTable.getHeuristica(inicial);
        No raiz = new No(inicial, null, null, hInicial);

        // caso trivial
        if (inicial.equals(objetivo)) {
            return raiz;
        }

        // borda ordenada pela heurística h(n)
        PriorityQueue<No> borda = new PriorityQueue<>(Comparator.comparingInt(no -> no.custoCaminho));

        borda.add(raiz);

        HashSet<Estado> explorados = new HashSet<>();

        while (!borda.isEmpty()) {

            No atual = borda.poll();
            explorados.add(atual.estado);

            // verifica se chegou ao objetivo
            if (atual.estado.equals(objetivo)) {
                return atual;
            }

            // expande vizinhos
            for (Transicao transicao : atual.estado.transicoes) {

                Estado filhoEstado = transicao.estado;

                int hFilho = hTable.getHeuristica(filhoEstado);

                // nó guloso -> custo = heurística
                No filho = new No(filhoEstado, atual, transicao, hFilho);

                boolean naBorda = borda.stream().anyMatch(no -> no.estado.equals(filho.estado));

                if (!explorados.contains(filho.estado) && !naBorda) {
                    borda.add(filho);
                }

                // substitui se a heurística for menor
                else if (naBorda) {

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
