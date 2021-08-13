package br.edu.fatecmm.projeto_prjfinal1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.getInteger;
import static java.lang.Integer.parseInt;

public  class  GerenciarProdutos {
    Scanner sc = new Scanner(System.in);

    public  static  Cesta cesta;
    List<Produto> listamercado = new ArrayList<>();

    public GerenciarProdutos(){
        Fornecedor Marcio = new Fornecedor();
        Contato CMarcio= new Contato();
        CMarcio.setNome("Marcio");
        CMarcio.setEmail("marcio@gmail.com");
        CMarcio.setTelefone("984567574");

        Produto banana = new Produto();
        banana.setCodigo(1);
        banana.setDescricao("Banana Prata");
        banana.setPreco(9.0);
        banana.setQuantidade(0);
        banana.setFornecedor(Marcio);

        Produto abacaxi = new Produto();
        abacaxi.setCodigo(2);
        abacaxi.setDescricao("Abacaxi");
        abacaxi.setPreco(8.0);
        abacaxi.setQuantidade(0);
        abacaxi.setFornecedor(Marcio);

        listamercado.add(banana);
        listamercado.add(abacaxi);
 }
    public static void main(String[] args) {
        GerenciarProdutos gp = new GerenciarProdutos();
        cesta = new Cesta();
        Scanner sc = new Scanner(System.in);
        int opc;
        do {
            System.out.println("Menu Principal");
            System.out.println("1.. Adicionar item");
            System.out.println("2.. Finalizar Compra");
            System.out.println("3.. Exibir Lista");
            System.out.println("9.. SAIR");
            opc = parseInt(sc.nextLine());
            switch (opc) {
                case 1:
                    gp.adicionaritem();
                    break;
                case 2:
                    gp.calculartotal();
                    break;
                case 3:
                    gp.exibirlista();
                    break;
                case 9:
                    System.out.println("Fim do Programa");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        } while (opc != 9);
    }

    public void adicionaritem() {
        for (int i = 1; i < listamercado.size(); i++) {
            System.out.println("LISTA DE PRODUTOS  \n" + listamercado);
        }

        System.out.println("Qual Produto deseja escolher? Digite o codigo do produto ");

        Produto produtoprocurado = new Produto();
        produtoprocurado.setCodigo(Integer.parseInt(sc.nextLine()));

        if(listamercado.contains(produtoprocurado)){
            Produto produtoMercado = listamercado.get(listamercado.indexOf(produtoprocurado));
            System.out.println("Digite a quantidade: ");

            produtoprocurado.setDescricao(produtoMercado.getDescricao());
            produtoprocurado.setQuantidade(Integer.parseInt(sc.nextLine()));
            produtoprocurado.setPreco(produtoMercado.getPreco());

            cesta.adicionarItem(produtoprocurado);
            System.out.println(" Você adicionou o produto " + produtoMercado.getDescricao());
        }
        else {
            System.out.println("Produto invalido ");
        }
    }


    public void calculartotal() {
        double total = 0;
        for (Produto produto : cesta.getCesta()) {
            total += produto.getPreco() * produto.getQuantidade();
        }
        System.out.println("Total: " + total);
    }

    public void exibirlista(){
        for (Produto produto : cesta.getCesta()) {
            System.out.println("Produto: " + produto.getDescricao());
            System.out.println("Quantidade: " + produto.getQuantidade());
        }
    }
}