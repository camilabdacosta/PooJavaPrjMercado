package br.edu.fatecmm.projeto_prjfinal1;
import br.edu.fatecmm.projeto_prjfinal1.GerenciarProdutos;
import br.edu.fatecmm.projeto_prjfinal1.Produto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cesta  {
private List<Produto>cesta = new ArrayList<>();

    public List<Produto> getCesta() {
        return cesta;
    }


    public void exibirLista(Produto cesta){
        GerenciarProdutos.cesta.exibirLista(cesta);
    }

    public void adicionarItem(Produto produto) {
        cesta.add(produto);
    }

    @Override
    public String toString() {
        return "Cesta{" +
                "cesta=" + cesta +
                '}';
    }

    public void calcularTotal(Produto produtoTotal) {



    }
}
