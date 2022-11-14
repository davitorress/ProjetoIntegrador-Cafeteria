/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Control.Conexao;

/**
 *
 * @author fatec_aluno
 */
public class ItensComanda {
    private int id;
    private int quantidade;
    private double preco;
    private int idProduto;
    private int idComanda;
    
    Conexao con = new Conexao();
    
    public ItensComanda() {
        this(0, 0, 0.0, 0, 0);
    }

    public ItensComanda(int id, int quantidade, double preco, int idProduto, int idComanda) {
        this.id = id;
        this.quantidade = quantidade;
        this.preco = preco;
        this.idProduto = idProduto;
        this.idComanda = idComanda;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getIdProduto() {
        return idProduto;
    }
    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getIdComanda() {
        return idComanda;
    }
    public void setIdComanda(int idComanda) {
        this.idComanda = idComanda;
    }
    
    public void criarItemComanda(int quantidade, double preco, int idComanda, int idProduto) {
        String sql = "INSERT INTO ItensComanda(quantidade, preco, idComanda, idProduto) VALUES (" + quantidade + ", " + preco + ", " + idComanda + ", " + idProduto + ")";
        con.executeSQL(sql);
    }
}
