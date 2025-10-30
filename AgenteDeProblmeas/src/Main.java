public class Main {
    public static void main(String[] args) {
        Estado arad = new Estado("Arad");
        Estado zerind = new Estado("Zerind");
        Estado oradea = new Estado("Oradea");
        Estado sibiu = new Estado("Sibiu");
        Estado timisoara = new Estado("Timisoara");
        Estado lugoj = new Estado("Lugoj");
        Estado mehadia = new Estado("Mehadia");
        Estado drobeta = new Estado("Drobeta");
        Estado craiova = new Estado("Craiova");
        Estado rimnicuVilcea = new Estado("Rimnicu Vilcea");
        Estado fagaras = new Estado("Fagaras");
        Estado pitesti = new Estado("Pitesti");
        Estado bucharest = new Estado("Bucharest");
        Estado giurgiu = new Estado("Giurgiu");
        Estado urziceni = new Estado("Urziceni");
        Estado hirsova = new Estado("Hirsova");
        Estado eforie = new Estado("Eforie");
        Estado vaslui = new Estado("Vaslui");
        Estado iasi = new Estado("Iasi");
        Estado neamt = new Estado("Neamt");

        // Arad
        arad.transicoes.add(new Transicao(zerind, 75));
        arad.transicoes.add(new Transicao(sibiu, 140));
        arad.transicoes.add(new Transicao(timisoara, 118));
        // Zerind
        zerind.transicoes.add(new Transicao(arad, 75));
        zerind.transicoes.add(new Transicao(oradea, 71));
        // Oradea
        oradea.transicoes.add(new Transicao(zerind, 71));
        oradea.transicoes.add(new Transicao(sibiu, 151));
        // Sibiu
        sibiu.transicoes.add(new Transicao(oradea, 151));
        sibiu.transicoes.add(new Transicao(arad, 140));
        sibiu.transicoes.add(new Transicao(fagaras, 99));
        sibiu.transicoes.add(new Transicao(rimnicuVilcea, 80));
        // Timisoara
        timisoara.transicoes.add(new Transicao(arad, 118));
        timisoara.transicoes.add(new Transicao(lugoj, 111));
        // Lugoj
        lugoj.transicoes.add(new Transicao(timisoara, 111));
        lugoj.transicoes.add(new Transicao(mehadia, 70));
        // Mehadia
        mehadia.transicoes.add(new Transicao(lugoj, 70));
        mehadia.transicoes.add(new Transicao(drobeta, 75));
        // Drobeta
        drobeta.transicoes.add(new Transicao(mehadia, 75));
        drobeta.transicoes.add(new Transicao(craiova, 120));
        // Craiova
        craiova.transicoes.add(new Transicao(drobeta, 120));
        craiova.transicoes.add(new Transicao(rimnicuVilcea, 146));
        craiova.transicoes.add(new Transicao(pitesti, 138));
        // Rimnicu Vilcea
        rimnicuVilcea.transicoes.add(new Transicao(sibiu, 80));
        rimnicuVilcea.transicoes.add(new Transicao(craiova, 146));
        rimnicuVilcea.transicoes.add(new Transicao(pitesti, 97));
        // Fagaras
        fagaras.transicoes.add(new Transicao(sibiu, 99));
        fagaras.transicoes.add(new Transicao(bucharest, 211));
        // Pitesti
        pitesti.transicoes.add(new Transicao(rimnicuVilcea, 97));
        pitesti.transicoes.add(new Transicao(craiova, 138));
        pitesti.transicoes.add(new Transicao(bucharest, 101));
        // Bucharest
        bucharest.transicoes.add(new Transicao(fagaras, 211));
        bucharest.transicoes.add(new Transicao(pitesti, 101));
        bucharest.transicoes.add(new Transicao(giurgiu, 90));
        bucharest.transicoes.add(new Transicao(urziceni, 85));
        // Giurgiu
        giurgiu.transicoes.add(new Transicao(bucharest, 90));
        // Urziceni
        urziceni.transicoes.add(new Transicao(bucharest, 85));
        urziceni.transicoes.add(new Transicao(hirsova, 98));
        urziceni.transicoes.add(new Transicao(vaslui, 142));
        // Hirsova
        hirsova.transicoes.add(new Transicao(urziceni, 98));
        hirsova.transicoes.add(new Transicao(eforie, 86));
        // Eforie
        eforie.transicoes.add(new Transicao(hirsova, 86));
        // Vaslui
        vaslui.transicoes.add(new Transicao(urziceni, 142));
        vaslui.transicoes.add(new Transicao(iasi, 92));
        // Iasi
        iasi.transicoes.add(new Transicao(vaslui, 92));
        iasi.transicoes.add(new Transicao(neamt, 87));
        // Neamt
        neamt.transicoes.add(new Transicao(iasi, 87));

        // cria o mapa
        Mapa mapa = new Mapa();

        // adiciona todos os estados ao mapa
        mapa.estados.add(arad);
        mapa.estados.add(zerind);
        mapa.estados.add(oradea);
        mapa.estados.add(sibiu);
        mapa.estados.add(timisoara);
        mapa.estados.add(lugoj);
        mapa.estados.add(mehadia);
        mapa.estados.add(drobeta);
        mapa.estados.add(craiova);
        mapa.estados.add(rimnicuVilcea);
        mapa.estados.add(fagaras);
        mapa.estados.add(pitesti);
        mapa.estados.add(bucharest);
        mapa.estados.add(giurgiu);
        mapa.estados.add(urziceni);
        mapa.estados.add(hirsova);
        mapa.estados.add(eforie);
        mapa.estados.add(vaslui);
        mapa.estados.add(iasi);
        mapa.estados.add(neamt);

        // imprime conexões
        System.out.println("Cidades vizinhas de Arad:");
        for (Estado e : mapa.estados) {
            for (Transicao t : e.transicoes) {
                System.out.println(e.nome + " -> " + t.estado.nome + " (" + t.custo + ")");
            }
            System.out.println();
        }

        No resultado = BuscaCustoUniforme.buscar(arad, bucharest);

        if (resultado != null) {
            BuscaCustoUniforme.mostrarCaminho(resultado);
        } else {
            System.out.println("Nenhum caminho encontrado!");
        }

    }
}
