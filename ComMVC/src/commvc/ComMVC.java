/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commvc;

import Controller.CarrosController;
import Model.Carro;
import Model.DAO.CarroDAO;
import View.Carros.CadastroCarros;
import java.util.ArrayList;

/**
 *
 * @author Guilherme
 */
public class ComMVC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CadastroCarros cadastroCarros = new CadastroCarros();
        cadastroCarros.setVisible(true);
        CarrosController carrosController = new CarrosController(cadastroCarros);
        
        /*
        CarroDAO carroDAO = new CarroDAO();
        Carro carro = new Carro();
        carro.setId(7);
        carro.setModelo("Fiat");
        carro.setFlex(false);
        carro.setConsumoGasolina(10.5);
        carro.setConsumoAlcool(10);
        
        
        if(carroDAO.cadastrarCarro(carro)){
            System.out.println("Carro cadastrado");
        }else{
            System.out.println("Carro não cadastrado");
        }
        */
        
        /*
        if(carroDAO.descadastrarCarro(carro)){
            System.out.println("Carro descadastrado");
        }else{
            System.out.println("Carro não descadastrado");
        }*/
        /*
        if(carroDAO.atualizarCarro(carro)){
            System.out.println("Carro atualizado");
        }else{
            System.out.println("Carro não atualizado");
        }
*/
        /*
        ArrayList<Carro> carros = new ArrayList();
        carros = carroDAO.consultarCarros();
        
        for(int i=0; i<carros.size();i++){
            System.out.println("\nID: " + carros.get(i).getId() + "\nModelo: " + carros.get(i).getModelo());
        }
        */
        
    }
    
}