/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Control.Conexao;

import java.sql.ResultSet;

/**
 *
 * @author fatec_aluno
 */
public class Produto {
    private int id;
    private String nome;
    private double preco;
    
    Conexao con = new Conexao();
    
    public Produto() {
        this(0, "", 0.0);
    }

    public Produto(int id, String nome, double preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }
    
    public ResultSet consultar() {        
        String sql = "SELECT * FROM Produto";
        ResultSet retorno = con.RetornarResultset(sql);
        
        return retorno;
    }
    
    public ResultSet consultarNome(String nome) {
        String sql = "SELECT * FROM Produto WHERE nome LIKE '%" + nome + "%'";
        ResultSet retorno = con.RetornarResultset(sql);
        
        return retorno;
    }
    
    public void cadastrar(String nome, double preco) {
        String sql = "INSERT INTO Produto(nome, preco) VALUES ('" + nome + "', " + preco + ")";
        con.executeSQL(sql);
    }
    
    public void atualizar(int idProduto, String nome, double preco) {
        String sql = "UPDATE Produto SET nome = '" + nome + "', preco = " + preco + " WHERE idProduto = " + idProduto;
        con.executeSQL(sql);
    }
    
    public void excluir(int idProduto) {
        String sql = "DELETE FROM Produto WHERE idProduto = " + idProduto;
        con.executeSQL(sql);
    }
}
