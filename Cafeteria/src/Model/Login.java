/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Control.Conexao;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author fatec_aluno
 */
public class Login {
    private int id;
    private String email;
    private String senha;
    private int nivel;
    private int idPessoa;
    
    Conexao con = new Conexao();
    
    public Login() {
        this(0, "", "", 0, 0);
    }

    public Login(int id, String email, String senha, int nivel, int idPessoa) {
        this.id = id;
        this.email = email;
        this.senha = senha;
        this.nivel = nivel;
        this.idPessoa = idPessoa;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public int getNivel() {
        return nivel;
    }
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getIdPessoa() {
        return idPessoa;
    }
    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }
    
    public String hashing(String senha) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
        byte messageDigest[] = algorithm.digest(senha.getBytes("UTF-8"));

        StringBuilder hexString = new StringBuilder();
        for (byte b : messageDigest) {
            hexString.append(String.format("%02X", 0xFF & b));
        }
        String senhahex = hexString.toString();

        return senhahex;
    }
    
    public ResultSet consultar(){
        String sql = "SELECT * FROM Login";
        ResultSet retorno = con.RetornarResultset(sql);
        
        return retorno;
    }
    
    public ResultSet logar(String email, String senha) throws SQLException {
        String sql = "SELECT email, senha, nivel FROM Login WHERE email = '" + email + "' AND senha = '" + senha + "'";
        ResultSet retorno = con.RetornarResultset(sql);
        
        return retorno;
    }
    
    public ResultSet consultarSenha(String email) {
        String sql = "SELECT senha FROM Login WHERE email LIKE '" + email + "'";
        ResultSet retorno = con.RetornarResultset(sql);
        
        return retorno;
    }

    public void atualizar(int idPessoa, String email, String senha, int nivel) {
        String sql = "UPDATE Login SET email = '" + email + "', senha = '" + senha + "', nivel = " + nivel + " WHERE idPessoa = " + idPessoa;
        con.executeSQL(sql);
    }
    
    public void excluir(int idPessoa) {
        String sql = "DELETE FROM Login WHERE idPessoa = " + idPessoa;
        con.executeSQL(sql);
    }
    
    public void cadastrar(int idPessoa, String email, String senha, int nivel) {
        String sql = "INSERT INTO Login(email, senha, nivel, idPessoa) VALUES ('" + email + "', '" + senha + "', " + nivel + ", " + idPessoa + ")";
        con.executeSQL(sql);
    }
}
