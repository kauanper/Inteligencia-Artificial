import java.util.ArrayList;

public class Estado {
    public String nome;
    public ArrayList<Transicao> transicoes;

    public Estado(String name) {
        this.nome = name;
        this.transicoes = new ArrayList<>();
    }

}
