package BuscaDeCusto;

import AgenteDeProblema.Estado;
import AgenteDeProblema.Transicao;

import java.util.*;

public class BuscaCustoUniforme {

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

    //apenas mostrar o caminho msm
    public static void mostrarCaminho(No objetivo) {
        ArrayList<No> caminho = new ArrayList<>();
        No atual = objetivo;

        while (atual != null) {
            caminho.add(atual);
            atual = atual.pai;
        }

        Collections.reverse(caminho);

        System.out.println("Caminho encontrado:");
        for (int i = 0; i < caminho.size(); i++) {
            System.out.print(caminho.get(i).estado.nome);
            if (i < caminho.size() - 1) {
                System.out.print(" -> ");
            }
        }

        System.out.println("\nCusto total: " + objetivo.custoCaminho);
    }
}
