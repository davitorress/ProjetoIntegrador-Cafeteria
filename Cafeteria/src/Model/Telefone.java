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
public class Telefone {
    private int id;
    private String contato;
    private int idPessoa;
    
    Conexao con = new Conexao();
    
    public Telefone() {
        this(0, "", 0);
    }

    public Telefone(int id, String contato, int idPessoa) {
        this.id = id;
        this.contato = contato;
        this.idPessoa = idPessoa;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getContato() {
        return contato;
    }
    public void setContato(String contato) {
        this.contato = contato;
    }

    public int getIdPessoa() {
        return idPessoa;
    }
    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public void cadastrar(String contato, int idPessoa) {
        String sql = "INSERT INTO Telefone(contato, idPessoa) VALUES ('" + contato + "', " + idPessoa + ")";
        con.executeSQL(sql);
    }
    
    public void atualizar(int idPessoa, String contato) {
        String sql = "UPDATE Telefone SET contato = '" + contato + "' WHERE idPessoa = " + idPessoa;
        con.executeSQL(sql);
    }
    
    public void excluir(int idPessoa) {
        String sql = "DELETE FROM Telefone WHERE idPessoa = " + idPessoa;
        con.executeSQL(sql);
    }
}
