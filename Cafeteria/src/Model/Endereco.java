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
public class Endereco {
    private int id;
    private int cep;
    private String pais;
    private String estado;
    private String cidade;
    private String bairro;
    private String logradouro;
    private int numero;
    private String complemento;
    private int idAtendente;
    
    Conexao con = new Conexao();
    
    public Endereco() {
        this(0, 0, "", "", "", "", "", 0, "", 0);
    }

    public Endereco(int id, int cep, String pais, String estado, String cidade, String bairro, String logradouro, int numero, String complemento, int idAtendente) {
        this.id = id;
        this.cep = cep;
        this.pais = pais;
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.idAtendente = idAtendente;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getCep() {
        return cep;
    }
    public void setCep(int cep) {
        this.cep = cep;
    }

    public String getPais() {
        return pais;
    }
    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLogradouro() {
        return logradouro;
    }
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public int getIdAtendente() {
        return idAtendente;
    }
    public void setIdAtendente(int idAtendente) {
        this.idAtendente = idAtendente;
    }
    
    public ResultSet listarEndereco(String nomeFunc) {
        String sql = "SELECT idEndereco, idAtendente, nome, nomeSocial, bairro, logradouro FROM Endereco "
            + "RIGHT JOIN Atendente USING (idAtendente) INNER JOIN Pessoa USING (idPessoa) "
            + "WHERE nome LIKE '" + nomeFunc + "%'";
        ResultSet retorno = con.RetornarResultset(sql);
        
        return retorno;
    }
    
    public ResultSet consultar(int idEndereco) {
        String sql = "SELECT idEndereco, idAtendente, cep, estado, cidade, bairro, logradouro, numero complemento FROM Endereco "
            + "RIGHT JOIN Atendente USING (idAtendente) "
            + "WHERE idEndereco = " + idEndereco;
        ResultSet retorno = con.RetornarResultset(sql);
        
        return retorno;
    }
    
    public void cadastrar(int idFunc, String cep, String estado, String cidade, String bairro, String logradouro, int numero, String complemento) {
        String sql = "INSERT INTO Endereco(idAtendente, pais, cep, estado, cidade, bairro, logradouro, numero, complemento) "
                + "VALUES (" + idFunc + ", 'Brasil', '" + cep + "', '" + estado + "', '" + cidade + "', '" + bairro + "', '" + logradouro + "', " + numero + ", '" + complemento + "')";
        con.executeSQL(sql);
    }
    
    public void atualizar(int idEnd, int idFunc, String cep, String estado, String cidade, String bairro, String logradouro, int numero, String complemento) {
        String sql = "UPDATE Endereco SET idAtendente = " + idFunc + ", cep = '" + cep + "', estado = '" + estado
            + "', cidade = '" + cidade + "', bairro = '" + bairro + "', logradouro = '" + logradouro 
            + "', numero = " + numero + ", complemento = '" + complemento + "' WHERE idEndereco = " + idEnd;
        con.executeSQL(sql);
    }
    
    public void excluir(int idEnd) {
        String sql = "DELETE FROM Endereco WHERE idEndereco = " + idEnd;
        con.executeSQL(sql);
    }
}
