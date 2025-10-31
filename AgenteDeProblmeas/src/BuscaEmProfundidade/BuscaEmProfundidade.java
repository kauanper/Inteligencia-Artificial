package BuscaEmProfundidade;

import AgenteDeProblema.Estado;
import AgenteDeProblema.Transicao;
import BuscaDeCusto.No;
import java.util.Stack;
import java.util.HashSet;

public class BuscaEmProfundidade {

    public static No buscar(Estado inicial, Estado objetivo) {

        No raiz = new No(inicial, null, null, 0);

        if (raiz.estado.equals(objetivo)) {
            return raiz;
        }

        Stack<No> borda = new Stack<>();
        borda.push(raiz);

        HashSet<Estado> explorados = new HashSet<>();

        while (!borda.isEmpty()) {
            No atual = borda.pop();
            explorados.add(atual.estado);

            for (Transicao acao : atual.estado.transicoes) {
                No filho = new No(acao.estado, atual, acao, acao.custo);
                filho.custoCaminho = atual.custoCaminho + acao.custo;
                if (!explorados.contains(filho.estado)) {
                    if (filho.estado.equals(objetivo)) {
                        return filho;
                    }
                    borda.push(filho);
                }
            }
        }
        return null;
    }
}
