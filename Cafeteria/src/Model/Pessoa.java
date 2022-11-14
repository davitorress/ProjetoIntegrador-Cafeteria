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
public class Pessoa {
    private int id;
    private String cpf;
    private String rg;
    private String nome;
    private String nomeSocial;
    private String sexo;
    
    Conexao con = new Conexao();
    
    public Pessoa() {
        this(0, "", "", "", "", "");
    }

    public Pessoa(int id, String cpf, String rg, String nome, String nomeSocial, String sexo) {
        this.id = id;
        this.cpf = cpf;
        this.rg = rg;
        this.nome = nome;
        this.nomeSocial = nomeSocial;
        this.sexo = sexo;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }
    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeSocial() {
        return nomeSocial;
    }
    public void setNomeSocial(String nomeSocial) {
        this.nomeSocial = nomeSocial;
    }

    public String getSexo() {
        return sexo;
    }
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public ResultSet listarPessoasNome(String nome) {
        String sql = "SELECT idPessoa, nome, nomeSocial, cpf, rg, sexo, contato FROM Pessoa "
                + "LEFT JOIN Telefone USING (idPessoa) WHERE nome LIKE '" + nome + "%'";
        ResultSet retorno = con.RetornarResultset(sql);
        
        return retorno;
    }
    
    public void cadastrar(String nome, String nomeSocial, String cpf, String rg, String sexo) {
        String sql = "INSERT INTO Pessoa(nome, nomeSocial, cpf, rg, sexo) VALUES ('" + nome + "', '"
            + nomeSocial + "', '" + cpf + "', '" + rg + "', '" + sexo + "')";
        con.executeSQL(sql);
    }
    
    public ResultSet buscarIdPeloCpf(String cpf) {
        String sql = "SELECT idPessoa FROM Pessoa WHERE cpf LIKE '" + cpf + "'";
        ResultSet retorno = con.RetornarResultset(sql);
        
        return retorno;
    }
    
    public ResultSet consultar(int idPessoa) {
        String sql = "SELECT idPessoa, nome, nomeSocial, cpf, rg, sexo, contato FROM Pessoa "
                + "LEFT JOIN Telefone USING (idPessoa) WHERE idPessoa = " + idPessoa;
        ResultSet retorno = con.RetornarResultset(sql);
        
        return retorno;
    }
    
    public void atualizar(int idPessoa, String nome, String nomeSocial, String cpf, String rg, String sexo) {
        String sql = "UPDATE Pessoa SET nome = '" + nome + "', nomeSocial = '" + nomeSocial 
            + "', cpf = '" + cpf + "', rg = '" + rg + "', sexo = '" + sexo + "' WHERE idPessoa = " + idPessoa;
        con.executeSQL(sql);
    }
    
    public void excluir(int idPessoa) {
        String sql = "DELETE FROM Pessoa WHERE idPessoa = " + idPessoa;
        con.executeSQL(sql);
    }
}
