import java.util.*;

public class BuscaCustoUniforme {

    public static No buscar(Estado inicial, Estado objetivo) {

        //estado inicial do problema
        No noInicial = new No(inicial, null, null, 0);

        //criar fila de prioridade e adicionar nossa origem
        PriorityQueue<No> borda = new PriorityQueue<>();
        borda.add(noInicial);

        //armazenar estados já visitados
        HashSet<Estado> explorados = new HashSet<>();

        //enquanto fila estiver vazia faça
        while (!borda.isEmpty()) {

            No atual = borda.poll();

            if (atual.estado.equals(objetivo)) {
                return atual;
            }

            explorados.add(atual.estado);

            //é como se fosse a lista de adj d cada nó
            for (Transicao transicao : atual.estado.transicoes) {
                Estado vizinho = transicao.estado;
                int novoCusto = atual.custoCaminho + transicao.custo;

                if (!explorados.contains(vizinho)) {
                    No filho = new No(vizinho, atual, transicao, novoCusto);
                    borda.add(filho);
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
