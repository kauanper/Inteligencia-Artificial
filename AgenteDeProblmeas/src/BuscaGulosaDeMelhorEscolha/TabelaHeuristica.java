package BuscaGulosaDeMelhorEscolha;

import AgenteDeProblema.Estado;

import java.util.ArrayList;

public class TabelaHeuristica {
    public ArrayList<Heuristica> linhaReta = new ArrayList<>();

    public void AddEstado(Heuristica h) {
        linhaReta.add(h);
    }

    public int getHeuristica(Estado e) {
        for (Heuristica h : linhaReta) {
            if (h.estado.equals(e)) {
                return h.valor;
            }
        }
        throw new RuntimeException("Heurística não encontrada para o estado: " + e.nome);
    }

}
