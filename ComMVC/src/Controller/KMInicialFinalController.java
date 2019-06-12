/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.Carros.CadastroCarros;
import View.Carros.KmInicialFinal;
import View.Carros.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Luca
 */
public class KMInicialFinalController implements ActionListener {
    MenuController menuController;
    private double kmInicio;
    KmInicialFinal kmInicialFinal;
    CarroController carroController;
    private double kmFinal;
    private double litrosAbastecidos;
    private double resultadoCalculo;
    public KMInicialFinalController(KmInicialFinal kmInicialFinal) {
            this.kmInicialFinal = kmInicialFinal;
            this.kmInicialFinal.buttonKmInicialFinal.addActionListener(this);
            this.carroController = new CarroController();
            this.kmInicialFinal.ButtonVoltar.addActionListener(this);
        }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== kmInicialFinal.buttonKmInicialFinal){
        kmInicio = Double.parseDouble(this.kmInicialFinal.EditKmInicio.getText().toString());
        kmFinal = Double.parseDouble(this.kmInicialFinal.EditKmFinal.getText().toString());
        litrosAbastecidos = Double.parseDouble(this.kmInicialFinal.EditLitrosAbastecidos.getText().toString());
        resultadoCalculo = (kmFinal - kmInicio)/ litrosAbastecidos;
        JOptionPane.showMessageDialog(kmInicialFinal, "A média de consumo de KM Inicial / KM Final é: "+ resultadoCalculo + " Km/L");
        }
        if(e.getSource()== kmInicialFinal.ButtonVoltar){
            kmInicialFinal.dispose();
        }
        
            
            
        }
        
    }


