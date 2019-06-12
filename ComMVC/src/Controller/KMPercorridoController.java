
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.Carros.CadastroCarros;
import View.Carros.KmPercorrido;
import View.Carros.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Luca
 */
public class KMPercorridoController implements ActionListener {
    MenuController menuController;
    private double kmPercorridos;
    KmPercorrido kmPercorrido;
    CarroController carroController;
    private double litrosAbastecidos;
    private double resultadoCalculo;
    public KMPercorridoController(KmPercorrido kmPercorrido) {
            this.kmPercorrido = kmPercorrido;
            this.kmPercorrido.buttonKmPercorrido.addActionListener(this);
            this.carroController = new CarroController();
            this.kmPercorrido.ButtonVoltar.addActionListener(this);
        }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== kmPercorrido.buttonKmPercorrido){
        kmPercorridos = Double.parseDouble(this.kmPercorrido.EditKmPercorridos.getText().toString());
        litrosAbastecidos = Double.parseDouble(this.kmPercorrido.EditLitrosAbastecidos.getText().toString());
        resultadoCalculo = kmPercorridos/litrosAbastecidos;
        JOptionPane.showMessageDialog(kmPercorrido, "A média de consumo de KM's Percorridos é: "+ resultadoCalculo + " Km/L");
        }
        if(e.getSource()== kmPercorrido.ButtonVoltar){
            kmPercorrido.dispose();
        }
            
        }
        
    }



