/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author aluno
 */
public class FabricaConexao {
    //String servidor = "jdbc:mysql://localhost:3306/gasolina?autoReconnect=true&useSSL=false";
    //String senha = "cimatec";
    String usuario = "root";
    String driver = "com.mysql.jdbc.Driver";
    String servidor = "jdbc:mysql://localhost:3306/gasolina?useTimezone=true&serverTimezone=UTC";
    String senha = "g159263g";
    //String driver = "com.mysql.cj.jdbc.Driver";
    
    public Connection conectar(){
            try {
                Class.forName(driver);
                return (Connection) DriverManager.getConnection(servidor,usuario, senha);
            } catch (Exception e){
                System.out.println("Erro "+ e.getMessage());
                return null;
            }
    }
    
    
}
