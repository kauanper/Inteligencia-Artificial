package BuscaGulosaDeMelhorEscolha;

import AgenteDeProblema.Estado;

import java.util.ArrayList;

public class TabelaHeuristica {
    public ArrayList<Heuristica> linhaReta = new ArrayList<>();

    public void AddEstado(Heuristica h) {
        linhaReta.add(h);
    }
}
