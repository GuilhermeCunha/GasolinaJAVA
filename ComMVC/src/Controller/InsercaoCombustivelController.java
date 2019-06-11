/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.Carros.CombustivelUsar;
import View.Carros.InsercaoCombustivel;
import View.Carros.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author ANGELO
 */
public class InsercaoCombustivelController implements ActionListener {
    InsercaoCombustivel insercaoCombustivel;
    private double valorGasolina;
    private double valorAlcool;
    private double resultadoCalculo;
    
    public InsercaoCombustivelController(InsercaoCombustivel insercaoCombustivel){
        this.insercaoCombustivel = insercaoCombustivel;
        this.insercaoCombustivel.BotaoInserirCombustivel.addActionListener(this);
    }
    
    
   
    @Override
    public void actionPerformed(ActionEvent e) {
        String mensagem;
        if(e.getSource()== insercaoCombustivel.BotaoInserirCombustivel){
            valorGasolina= Double.parseDouble(this.insercaoCombustivel.PrecoGasolina.getText().toString());
            valorAlcool = Double.parseDouble(this.insercaoCombustivel.PrecoAlcool.getText().toString());
            System.out.println("Recebendo os dados gasolina e alcool");
            resultadoCalculo = valorGasolina*0.7;
            System.out.println("Calculando a rentabilidade");
            if(resultadoCalculo<valorAlcool){
                mensagem = "Gasolina";
            }else{
                mensagem = "Alcool";
            }
            System.out.println("O combustível mais rentável é o/a " + mensagem);
            JOptionPane.showMessageDialog(insercaoCombustivel, "O combustível mais rentável é o/a " + mensagem);
            
            
            Menu menu = new Menu();
            menu.setVisible(true);
            MenuController menuController = new MenuController(menu, valorGasolina, valorAlcool);
            insercaoCombustivel.dispose();
        }
    }
    
}
