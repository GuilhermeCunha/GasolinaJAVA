/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.Carros.CalculoAbastecimento;
import View.Carros.CombustivelUsar;
import View.Carros.Menu;
import View.Carros.MenuGerenciarCarros;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Guilherme
 */
public class MenuController implements ActionListener{
    private Menu menu;

    public MenuController(Menu menu) {
        this.menu = menu;
        this.menu.BotalQualCombustivel.addActionListener(this);
        this.menu.BotaoCalculoAbastecimento.addActionListener(this);
        this.menu.BotaoMediaKmInicialFinal.addActionListener(this);
        this.menu.BotaoMediaKmsRodados.addActionListener(this);
        this.menu.BotaoValorPorTrajeto.addActionListener(this);
        this.menu.BotaoGerenciarCarros.addActionListener(this);
    }
    
    
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        
        if(ae.getSource()== this.menu.BotalQualCombustivel){
            CombustivelUsar combustivelUsar = new CombustivelUsar();
            combustivelUsar.setVisible(true);
            CombustivelRentavelController combutivelRentavelController = 
                new CombustivelRentavelController(combustivelUsar);
        }
        if(ae.getSource()== this.menu.BotaoCalculoAbastecimento){
            CalculoAbastecimento calculoAbastecimento = new CalculoAbastecimento();
            calculoAbastecimento.setVisible(true);
            CalculoAbastecimentoController calculoAbastecimentoController = new CalculoAbastecimentoController(calculoAbastecimento);
        }
        
        if(ae.getSource()== this.menu.BotaoMediaKmInicialFinal){
            
        }
        
        if(ae.getSource()== this.menu.BotaoMediaKmsRodados){
            
        }
        
        if(ae.getSource()== this.menu.BotaoValorPorTrajeto){
            
        }
        if(ae.getSource()== this.menu.BotaoGerenciarCarros){
            MenuGerenciarCarros menuGerenciarCarros = new MenuGerenciarCarros();
            menuGerenciarCarros.setVisible(true);
            GerenciarCarrosController gerenciarCarrosController = new GerenciarCarrosController(menuGerenciarCarros);
            
        }
        
        
    }
    
    
}