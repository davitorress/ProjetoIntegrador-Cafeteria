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
public class Comanda {
    private int id;
    private String data;
    private String hora;
    private int idAtendente;
    
    Conexao con = new Conexao();
    
    public Comanda() {
        this(0, "", "", 0);
    }

    public Comanda(int id, String data, String hora, int idAtendente) {
        this.id = id;
        this.data = data;
        this.hora = hora;
        this.idAtendente = idAtendente;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }
    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getIdAtendente() {
        return idAtendente;
    }
    public void setIdAtendente(int idAtendente) {
        this.idAtendente = idAtendente;
    }
    
    public void criarComanda(int idAtendente) {
        String sql = "INSERT INTO Comanda(dataComanda, hora, idAtendente) VALUES (current_date(), current_time(), " + idAtendente + ")";
        con.executeSQL(sql);
    }
    
    public ResultSet consultarIdComanda(int idAtendente) {
        String sql = "SELECT idComanda FROM Comanda WHERE idAtendente = " + idAtendente + " ORDER BY idComanda DESC LIMIT 1";
        ResultSet retorno = con.RetornarResultset(sql);
        
        return retorno;
    }
    
    public ResultSet vendasGerais() {
        String sql = "SELECT sum(ItensComanda.preco), sum(ItensComanda.quantidade) FROM ItensComanda INNER JOIN Comanda USING (idComanda) WHERE dataComanda = current_date()";
        ResultSet retorno = con.RetornarResultset(sql);
        
        return retorno;
    }
    
    public ResultSet vendasUnicas(int idProduto) {
        String sql = "SELECT sum(ItensComanda.preco), sum(ItensComanda.quantidade) FROM ItensComanda INNER JOIN Comanda USING (idComanda) WHERE dataComanda = current_date() AND idProduto = " + idProduto;
        ResultSet retorno = con.RetornarResultset(sql);
        
        return retorno;
    }
    
    public ResultSet listarVendas(String dataComanda, String hora, String nomeFunc) {
        String sql = "SELECT idComanda, nome, dataComanda, hora, sum(ItensComanda.preco) FROM Comanda INNER JOIN ItensComanda USING (idComanda) "
            + "INNER JOIN Atendente USING (idAtendente) INNER JOIN Pessoa USING (idPessoa) "
            + "WHERE dataComanda LIKE '" + dataComanda + "' AND hora LIKE '" + hora + "' AND nome LIKE '" + nomeFunc + "' GROUP BY idComanda ORDER BY idComanda DESC";
        ResultSet retorno = con.RetornarResultset(sql);
        
        return retorno;
    }
    
    public ResultSet listarVendasTotais() {
        String sql = "SELECT sum(ItensComanda.preco), sum(ItensComanda.quantidade) FROM ItensComanda INNER JOIN Comanda USING (idComanda)";
        ResultSet retorno = con.RetornarResultset(sql);
        
        return retorno;
    }
    
    public ResultSet listarVendasProduto() {
        String sql = "SELECT sum(ItensComanda.preco), sum(ItensComanda.quantidade), nome FROM ItensComanda INNER JOIN Comanda USING (idComanda) INNER JOIN Produto USING (idProduto) GROUP BY idProduto";
        ResultSet retorno = con.RetornarResultset(sql);
        
        return retorno;
    }
    
    public void retirarAtendente(int idAtendente) {
        String sql = "UPDATE Comanda SET idAtendente = null WHERE idAtendente = " + idAtendente;
        con.executeSQL(sql);
    }
}
