package BuscaEmLargura;

import AgenteDeProblema.Estado;
import AgenteDeProblema.Transicao;
import BuscaDeCusto.No;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class BuscaEmLargura {

    public static No buscar(Estado inicial, Estado objetivo){

        No raiz = new No(inicial, null, null, 0);

        if(raiz.estado.equals(objetivo)){
            return raiz; //solução
        }

        Queue<No> borda = new LinkedList<>();
        borda.add(raiz);

        HashSet<Estado> explorados = new HashSet<>();

        while(!borda.isEmpty()){
            No atual = borda.poll();
            explorados.add(atual.estado);
            for(Transicao acao : atual.estado.transicoes){
                No filho = new No(acao.estado, atual, acao, acao.custo);
                if(!explorados.contains(filho.estado)){
                    filho.custoCaminho = atual.custoCaminho + acao.custo;
                    borda.add(filho);
                    explorados.add(filho.estado);
                    if(filho.estado.equals(objetivo)){
                        return filho;
                    }
                }
            }
        }
        return null;
    }
}
