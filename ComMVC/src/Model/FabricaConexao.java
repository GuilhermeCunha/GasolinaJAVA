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
    String servidor = "jdbc:mysql://localhost:3306/gasolina";
    String usuario = "root";
    String senha = "cimatec";
    String driver = "com.mysql.jdbc.Driver";
    
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
