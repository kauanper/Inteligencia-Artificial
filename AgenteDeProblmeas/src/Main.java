import AgenteDeProblema.Estado;
import AgenteDeProblema.Mapa;
import AgenteDeProblema.Transicao;
import BuscaDeCusto.BuscaCustoUniforme;
import BuscaDeCusto.No;
import BuscaEmLargura.BuscaEmLargura;
import BuscaEmProfundidade.BuscaEmProfundidade;
import BuscaGulosaDeMelhorEscolha.BuscaGulosa;
import BuscaGulosaDeMelhorEscolha.Heuristica;
import BuscaGulosaDeMelhorEscolha.TabelaHeuristica;

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

        /* imprime conexões
        System.out.println("Cidades vizinhas de Arad:");
        for (Estado e : mapa.estados) {
            for (Transicao t : e.transicoes) {
                System.out.println(e.nome + " -> " + t.estado.nome + " (" + t.custo + ")");
            }
            System.out.println();
        }
         */

        /*
        No resultado = BuscaEmLargura.buscar(oradea, vaslui);
        System.out.println("Busca Em Largura");
        if (resultado != null) {
            BuscaCustoUniforme.mostrarCaminho(resultado);
        } else {
            System.out.println("Nenhum caminho encontrado!");
        }

        No resultado2 = BuscaCustoUniforme.buscar(oradea, vaslui);
        System.out.println("\nBusca Uniforme");
        if (resultado2 != null) {
            BuscaCustoUniforme.mostrarCaminho(resultado2);
        } else {
            System.out.println("Nenhum caminho encontrado!");
        }

        No resultado3 = BuscaEmProfundidade.buscar(oradea, vaslui);
        System.out.println("\nBusca Em Profundidade");
        if (resultado3 != null) {
            BuscaCustoUniforme.mostrarCaminho(resultado3);
        } else {
            System.out.println("Nenhum caminho encontrado!");
        }
        */


        TabelaHeuristica h = new TabelaHeuristica();

        Heuristica arad_h = new Heuristica(arad, 366);
        h.AddEstado(arad_h);

        Heuristica bucharest_h = new Heuristica(bucharest, 0);
        h.AddEstado(bucharest_h);

        Heuristica craiova_h = new Heuristica(craiova, 160);
        h.AddEstado(craiova_h);

        Heuristica drobeta_h = new Heuristica(drobeta, 242);
        h.AddEstado(drobeta_h);

        Heuristica eforie_h = new Heuristica(eforie, 161);
        h.AddEstado(eforie_h);

        Heuristica fagaras_h = new Heuristica(fagaras, 176);
        h.AddEstado(fagaras_h);

        Heuristica giurgiu_h = new Heuristica(giurgiu, 77);
        h.AddEstado(giurgiu_h);

        Heuristica hirsova_h = new Heuristica(hirsova, 151);
        h.AddEstado(hirsova_h);

        Heuristica iasi_h = new Heuristica(iasi, 226);
        h.AddEstado(iasi_h);

        Heuristica lugoj_h = new Heuristica(lugoj, 244);
        h.AddEstado(lugoj_h);

        Heuristica mehadia_h = new Heuristica(mehadia, 241);
        h.AddEstado(mehadia_h);

        Heuristica neamt_h = new Heuristica(neamt, 234);
        h.AddEstado(neamt_h);

        Heuristica oradea_h = new Heuristica(oradea, 380);
        h.AddEstado(oradea_h);

        Heuristica pitesti_h = new Heuristica(pitesti, 100);
        h.AddEstado(pitesti_h);

        Heuristica rimnicuVilcea_h = new Heuristica(rimnicuVilcea, 193);
        h.AddEstado(rimnicuVilcea_h);

        Heuristica sibiu_h = new Heuristica(sibiu, 253);
        h.AddEstado(sibiu_h);

        Heuristica timisoara_h = new Heuristica(timisoara, 329);
        h.AddEstado(timisoara_h);

        Heuristica urziceni_h = new Heuristica(urziceni, 80);
        h.AddEstado(urziceni_h);

        Heuristica vaslui_h = new Heuristica(vaslui, 199);
        h.AddEstado(vaslui_h);

        Heuristica zerind_h = new Heuristica(zerind, 374);
        h.AddEstado(zerind_h);

        No resultado4 = BuscaGulosa.buscar(bucharest, eforie, h);
        System.out.println("\nBusca Gulosa");
        if (resultado4 != null) {
            BuscaGulosa.mostrarCaminho(resultado4);
        } else {
            System.out.println("Nenhum caminho encontrado!");
        }

    }
}
