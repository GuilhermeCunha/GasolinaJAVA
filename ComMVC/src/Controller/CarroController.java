/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Carro;
import Model.DAO.CarroDAO;
import Model.FabricaConexao;
import java.util.ArrayList;

/**
 *
 * @author aluno
 */
public class CarroController {
    CarroDAO carroDAO;
    
    public CarroController(){
        this.carroDAO = new CarroDAO();
    }
    
    public boolean cadastrarCarro(Carro carro){
        System.out.println("Cadastrando o carro \n" +
                carro.getModelo() + "\nConsumo Gasolina: " + carro.getConsumoGasolina() + 
                "\nConsumo Alcool: " + carro.getConsumoAlcool());
        return this.carroDAO.cadastrarCarro(carro);
    }
    
    public boolean descadastrarCarro(Carro carro){
        return this.carroDAO.descadastrarCarro(carro);
    }
    
    public ArrayList<Carro> consultarCarros(){
        return this.carroDAO.consultarCarros();
    }
    
    public boolean atualizarCarro(Carro carro){
        return this.carroDAO.atualizarCarro(carro);
    }
    
}
