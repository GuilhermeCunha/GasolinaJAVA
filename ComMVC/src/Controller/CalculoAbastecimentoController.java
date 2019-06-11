/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.Carros.CadastroCarros;
import View.Carros.CalculoAbastecimento;
import View.Carros.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author ANGELO
 */
public class CalculoAbastecimentoController implements ActionListener {
    MenuController menuController;
    private double valorgasolina;
    CalculoAbastecimento calculoAbastecimento;
    CarroController carroController;
    private double valorAbastecimento;
    private double precoCombustivel;
    private double resultadoCalculo;
    public CalculoAbastecimentoController(CalculoAbastecimento calculoAbastecimento) {
            this.calculoAbastecimento = calculoAbastecimento;
            this.calculoAbastecimento.buttonAbastecimento.addActionListener(this);
            this.calculoAbastecimento.ButtonVoltar.addActionListener(this);
            this.carroController = new CarroController();  
        }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== calculoAbastecimento.buttonAbastecimento){
        valorAbastecimento= Double.parseDouble(this.calculoAbastecimento.EditValorAbastecimento.getText().toString());
        precoCombustivel = Double.parseDouble(this.calculoAbastecimento.EditLitroCombus.getText().toString());
        System.out.println("Recebi os Valores valor de Abastecimento e preço do combustivel");
        resultadoCalculo = valorAbastecimento/precoCombustivel;
        System.out.println("Calculando abastecimento"+"\n"+ resultadoCalculo );
            JOptionPane.showMessageDialog(calculoAbastecimento, "O abastecimento possível é: "+ resultadoCalculo + " L");
        }
        if(e.getSource()== calculoAbastecimento.ButtonVoltar){
            System.out.println("Dispose");
            calculoAbastecimento.dispose();
            
            //Menu menu = new Menu();
            //menu.setVisible(true);
            //menu.setAlwaysOnTop(true);
            
            
        }
        
    }
}
