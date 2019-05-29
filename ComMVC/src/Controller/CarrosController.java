/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.Carros.CadastroCarros;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author aluno
 */
public class CarrosController implements ActionListener{

    
    CadastroCarros cadastroCarros;

    public CarrosController(CadastroCarros cadastroCarros) {
        this.cadastroCarros = cadastroCarros;
        this.cadastroCarros.BotaoCriar.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == cadastroCarros.BotaoCriar){
            System.out.println("BOTÃO CLICADO");
        }
    }
    

    
}
