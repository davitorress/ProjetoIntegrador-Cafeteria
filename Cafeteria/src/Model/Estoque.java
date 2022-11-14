/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Control.Conexao;

import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author fatec_aluno
 */
public class Estoque {
    private int id;
    private int quantidade;
    private int idProduto;
    
    Conexao con = new Conexao();
    
    public Estoque() {
        this(0, 0, 0);
    }

    public Estoque(int id, int quantidade, int idProduto) {
        this.id = id;
        this.quantidade = quantidade;
        this.idProduto = idProduto;
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

    public int getIdProduto() {
        return idProduto;
    }
    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }
    
    public ResultSet consultar(int idProduto){
        String sql = "SELECT * FROM Estoque WHERE idProduto = " + idProduto;
        ResultSet retorno = con.RetornarResultset(sql);
        
        return retorno;
    }
    
    public void diminuirEstoque(int idEstoque, int quantidade) {
        String sql = "UPDATE Estoque SET quantidade = (quantidade - " + quantidade + ") WHERE idEstoque = " + idEstoque;
        con.executeSQL(sql);
    }
    
    public void aumentarEstoque(int idProduto, int quantidade) {
        String sql = "UPDATE Estoque SET quantidade = (quantidade + " + quantidade + ") WHERE idProduto = " + idProduto;
        con.executeSQL(sql);
    }
    
    public void cadastrar(int quantidade, int idProduto) {
        String sql = "INSERT INTO Estoque(quantidade, idProduto) VALUES (" + quantidade + ", " + idProduto + ")";
        con.executeSQL(sql);
    }
    
    public void atualizar(int idProduto, int quantidade) {
        String sql = "UPDATE Estoque SET quantidade = " + quantidade + " WHERE idProduto = " + idProduto;
        con.executeSQL(sql);
    }
    
    public void excluir(int idProduto) {
        String sql = "DELETE FROM Estoque WHERE idProduto = " + idProduto;
        con.executeSQL(sql);
    }
}
