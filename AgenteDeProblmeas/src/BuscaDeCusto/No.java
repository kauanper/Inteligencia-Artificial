package BuscaDeCusto;

import AgenteDeProblema.Estado;
import AgenteDeProblema.Transicao;

public class No implements Comparable<No> {
    public Estado estado;
    public No pai;
    public Transicao acao;
    public int custoCaminho;

    public No(Estado estado, No pai, Transicao acao, int custoCaminho) {
        this.estado = estado;
        this.pai = pai;
        this.acao = acao;
        this.custoCaminho = custoCaminho;
    }

    @Override
    public int compareTo(No outro) {
        return Integer.compare(this.custoCaminho, outro.custoCaminho);
    }
}
