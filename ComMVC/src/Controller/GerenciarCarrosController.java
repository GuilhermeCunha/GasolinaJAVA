/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.Carros.ApagarCarros;
import View.Carros.CadastroCarros;
import View.Carros.MenuGerenciarCarros;
import View.Carros.ModificarCarros;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Guilherme
 */
public class GerenciarCarrosController implements ActionListener{
    private MenuGerenciarCarros menuGerenciarCarros;

    public GerenciarCarrosController(MenuGerenciarCarros menuGerenciarCarros) {
        this.menuGerenciarCarros = menuGerenciarCarros;
        this.menuGerenciarCarros.BotaoApagarCarros.addActionListener(this);
        this.menuGerenciarCarros.BotaoCadastrarCarros.addActionListener(this);
        this.menuGerenciarCarros.BotaoModificarCarro.addActionListener(this);
    }
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == this.menuGerenciarCarros.BotaoApagarCarros){
            ApagarCarros apagarCarros = new ApagarCarros();
            apagarCarros.setVisible(true);
            ApagarCarrosController apagarCarrosController = new ApagarCarrosController(apagarCarros);
        }
        
        if (ae.getSource() == this.menuGerenciarCarros.BotaoCadastrarCarros){
            CadastroCarros cadastroCarros = new CadastroCarros();
            cadastroCarros.setVisible(true);
            CarrosController carrosController = new CarrosController(cadastroCarros);
        }
        
        if (ae.getSource() == this.menuGerenciarCarros.BotaoModificarCarro){
            ModificarCarros modificarCarros = new ModificarCarros();
            modificarCarros.setVisible(true);
            ModificarCarrosController modificarCarrosController = new ModificarCarrosController(modificarCarros);
        }
        
        
        
        
    }
    
}
