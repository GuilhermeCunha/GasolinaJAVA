/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.Carro;
import Model.FabricaConexao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author aluno
 */
public class CarroDAO {
    private FabricaConexao fabrica;
    private Connection conexao;
    private PreparedStatement  declaracao;
    private ResultSet  resultados;

    public CarroDAO() {
        fabrica = new FabricaConexao();
        conexao = fabrica.conectar();
    } 
    
    
    
    public boolean cadastrarCarro(Carro carro){
        String sql = "Insert into Carro (modelo, flex, consumoGasolina, consumoAlcool) values('"+carro.getModelo()+"', "+carro.isFlex()+", '"+carro.getConsumoGasolina()+"', "+carro.getConsumoAlcool()+");";
        
        try{
            this.declaracao = (PreparedStatement) this.conexao.prepareStatement(sql);
            this.declaracao.executeUpdate();
            return true;
        }catch(Exception e){
            System.out.println("Erro: " + e.getMessage());
        }  
        return false;
    }
    
    public boolean descadastrarCarro(Carro carro){
        String sql = "delete from Carro where idCarro="+carro.getId()+";";
        try{
            this.declaracao = (PreparedStatement) this.conexao.prepareStatement(sql);
            this.declaracao.executeUpdate();
            return true;
        }catch(Exception e){
            System.out.println("Erro: " + e.getMessage());
        }  
        return false;
    }
    
    public ArrayList<Carro> consultarCarros(){
        String sql = "Select * from Carro;";
        ArrayList<Carro> carros = new ArrayList<>();
        try{
            this.declaracao = (PreparedStatement) this.conexao.prepareStatement(sql);
            resultados = declaracao.executeQuery();
            while(resultados.next()){
                Carro carro = new Carro();
                carro.setId(resultados.getInt("idCarro"));
                carro.setModelo(resultados.getString("modelo"));
                carro.setFlex(resultados.getBoolean("flex"));
                carro.setConsumoGasolina(resultados.getDouble("consumoGasolina"));
                carro.setConsumoAlcool(resultados.getDouble("consumoAlcool"));
                carros.add(carro);
            }
        }catch(Exception e){
            System.out.println("Erro: "+e.getMessage());
        }
        return carros;
    }  
    
    public boolean atualizarCarro(Carro carro){
        String sql = "UPDATE carro SET modelo = ?, flex= ?, consumoGasolina = ?, consumoAlcool = ? WHERE idCarro = ?;";
        try{
            this.declaracao = (PreparedStatement) this.conexao.prepareStatement(sql);
            this.declaracao.setString(1, carro.getModelo());
            this.declaracao.setBoolean(2, carro.isFlex());
            this.declaracao.setDouble(3, carro.getConsumoGasolina());
            this.declaracao.setDouble(4, carro.getConsumoAlcool());
            this.declaracao.setInt(5, carro.getId());

            //resultados = declaracao.executeQuery(sql);
            declaracao.executeUpdate();
            return true;
            
        }catch(SQLException e){
            System.out.println("Erro: "+e.getMessage());
        }
        return false;
    }
    
    
    
    
    
    
    
}
