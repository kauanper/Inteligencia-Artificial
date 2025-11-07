package BuscaGulosaDeMelhorEscolha;

import AgenteDeProblema.Estado;

public class Heuristica {
    // Heurística: distância em linha reta até Bucareste
    public Estado estado;
    public int valor;

    public Heuristica(Estado estado, int valor) {
        this.estado = estado;
        this.valor = valor;
    }
}
