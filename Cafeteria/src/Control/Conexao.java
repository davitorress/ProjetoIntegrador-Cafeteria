/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

/**
 *
 * @author fatec_aluno
 */

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conexao {
    final private String driver = "com.mysql.jdbc.Driver";
    
    final private String url = "jdbc:mysql://127.0.0.1/cafeteria";
    final private String usuario = "root";
    final private String senha = "";
    
    private Connection conexao;
    public Statement statement;
    public ResultSet resultset; 
    
    public boolean conectar() {  
        boolean result = true;  
  
        try {  
            Class.forName(driver);  
            conexao = DriverManager.getConnection(url, usuario, senha);
            //JOptionPane.showMessageDialog(null,"Conectou com o Banco de Dados");
        } catch(ClassNotFoundException Driver) {
               JOptionPane.showMessageDialog(null, "Driver nao localizado: " + Driver);
               result = false;
        } catch(SQLException Fonte) {
            JOptionPane.showMessageDialog(null, "Erro na conexão com a fonte de dados: " + Fonte);
            result = false;
        }
        
        return result;  
    }
    
    public void desconectar(){
        boolean result = true;
        
        try {
            conexao.close();
            //JOptionPane.showMessageDialog(null, "Banco fechado");
        } catch(SQLException fecha) {
            JOptionPane.showMessageDialog(null, "Não foi possivel fechar o banco de dados" + fecha);
            result = false;
        }
    }
     
    public void executeSQL(String sql) {
        conectar();
        
        try {
            statement = conexao.createStatement();
            statement.execute(sql);
            //desconectar();
        } catch(SQLException sqle){
           JOptionPane.showMessageDialog(null, "Driver não encontrado1" + sqle.getMessage());
        }
}
    
    public ResultSet RetornarResultset(String sql) {
        ResultSet resultSet = null;
        conectar();
        
        try {
            statement = conexao.createStatement();
            resultSet = statement.executeQuery(sql);
            resultSet.next();
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao retornar resultset" + e.getMessage());
        }
        
        return resultSet;
    }
}
