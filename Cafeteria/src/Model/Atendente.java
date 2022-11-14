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
public class Atendente {
    private int id;
    private double salario;
    private String situacao;
    private int idPessoa;
    
    Conexao con = new Conexao();
    
    public Atendente() {
        this(0, 0.0, "", 0);
    }

    public Atendente(int id, double salario, String situacao, int idPessoa) {
        this.id = id;
        this.salario = salario;
        this.situacao = situacao;
        this.idPessoa = idPessoa;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public double getSalario() {
        return salario;
    }
    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getSituacao() {
        return situacao;
    }
    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public int getIdPessoa() {
        return idPessoa;
    }
    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }
    
    public ResultSet buscarIdPeloLogin(String login) {
        String sql = "SELECT idAtendente FROM Pessoa INNER JOIN Login USING (idPessoa) INNER JOIN Atendente USING (idPessoa) WHERE email LIKE '" + login + "'";
        ResultSet retorno = con.RetornarResultset(sql);
        
        return retorno;
    }
    
    public ResultSet buscarIdPeloCpf(String cpf) {
        String sql = "SELECT idAtendente FROM Pessoa INNER JOIN Atendente USING (idPessoa) WHERE cpf LIKE '" + cpf + "'";
        ResultSet retorno = con.RetornarResultset(sql);
        
        return retorno;
    }
    
    public ResultSet listarFuncionariosEmail(String email) {
        String sql = "SELECT idPessoa, nome, rg, cpf, situacao, email FROM Atendente"
            + " RIGHT JOIN Pessoa USING (idPessoa)"
            + " LEFT JOIN Login USING (idPessoa)"
            + " WHERE email LIKE '" + email + "'";
        ResultSet retorno = con.RetornarResultset(sql);
        
        return retorno;
    }
    
    public ResultSet listarFuncionariosNome(String nome) {
        String sql = "SELECT idPessoa, nome, rg, cpf, situacao, email FROM Atendente"
            + " RIGHT JOIN Pessoa USING (idPessoa)"
            + " LEFT JOIN Login USING (idPessoa)"
            + " WHERE nome LIKE '" + nome + "%'";
        ResultSet retorno = con.RetornarResultset(sql);
        
        return retorno;
    }
    
    public ResultSet consultarFuncionariosNome(String nome) {
        String sql = "SELECT idPessoa, nome, nomeSocial, salario, situacao, email FROM Atendente"
            + " RIGHT JOIN Pessoa USING (idPessoa)"
            + " LEFT JOIN Login USING (idPessoa)"
            + " WHERE nome LIKE '" + nome + "%'";
        ResultSet retorno = con.RetornarResultset(sql);
        
        return retorno;
    }
    
    public ResultSet consultar(int idPessoa) {
        String sql = "SELECT idPessoa, nome, nomeSocial, salario, situacao, email, nivel FROM Atendente"
            + " RIGHT JOIN Pessoa USING (idPessoa)"
            + " LEFT JOIN Login USING (idPessoa)"
            + " WHERE idPessoa = " + idPessoa;
        ResultSet retorno = con.RetornarResultset(sql);
        
        return retorno;
    }
    
    public void excluir(int idPessoa) {
        String sql = "DELETE FROM Atendente WHERE idPessoa = " + idPessoa;
        con.executeSQL(sql);
    }
    
    public void atualizar(int idPessoa, double salario, String situacao) {
        String sql = "UPDATE Atendente SET salario = " + salario + ", situacao = '" + situacao + "' WHERE idPessoa = " + idPessoa;
        con.executeSQL(sql);
    }
    
    public void preCadastro(int idPessoa) {
        String sql = "INSERT INTO Atendente(idPessoa) VALUES (" + idPessoa + ")";
        con.executeSQL(sql);
    }
}
