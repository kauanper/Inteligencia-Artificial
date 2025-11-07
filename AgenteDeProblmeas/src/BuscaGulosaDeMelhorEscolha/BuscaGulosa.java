package BuscaGulosaDeMelhorEscolha;

import AgenteDeProblema.Estado;
import AgenteDeProblema.Transicao;
import BuscaDeCusto.No;

import java.util.*;

public class BuscaGulosa {

    public static No buscar(Estado inicial, Estado objetivo, TabelaHeuristica hTable) {

        int hInicial = hTable.getHeuristica(inicial);
        No raiz = new No(inicial, null, null, hInicial);

        if (inicial.equals(objetivo)) {
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

                Estado filhoEstado = transicao.estado;

                int hFilho = hTable.getHeuristica(filhoEstado);

                No filho = new No(filhoEstado, atual, transicao, hFilho);

                boolean naBorda = borda.stream().anyMatch(no -> no.estado.equals(filho.estado));

                if (!explorados.contains(filho.estado) && !naBorda) {
                    borda.add(filho);
                }
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

    public static void mostrarCaminho(No objetivo) {

        ArrayList<No> caminho = new ArrayList<>();
        No atual = objetivo;

        // reconstrói o caminho pelo pai
        while (atual != null) {
            caminho.add(atual);
            atual = atual.pai;
        }

        Collections.reverse(caminho);

        System.out.println("Caminho encontrado (Busca Gulosa):");
        for (int i = 0; i < caminho.size(); i++) {
            System.out.print(caminho.get(i).estado.nome);
            if (i < caminho.size() - 1) {
                System.out.print(" -> ");
            }
        }

        // aqui custoCaminho contém apenas h(n), não custo real
        System.out.println("\nHeurística do objetivo (h): " + objetivo.custoCaminho);
    }

}
