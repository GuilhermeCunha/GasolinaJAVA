/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.Carros.CombustivelUsar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author ANGELO
 */
public class CombustivelRentavelController implements ActionListener {
    CombustivelUsar combustivelUsar;
    private double valorGasolina;
    private double valorAlcool;
    private double resultadoCalculo;
    
    public CombustivelRentavelController(CombustivelUsar combustivelUsar){
        this.combustivelUsar = combustivelUsar;
        this.combustivelUsar.ButtonCalcularRentavel.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String mensagem;
        if(e.getSource()== combustivelUsar.ButtonCalcularRentavel){
        valorGasolina= Double.parseDouble(this.combustivelUsar.EditValorGasolina.getText().toString());
        valorAlcool = Double.parseDouble(this.combustivelUsar.ValorAlcool.getText().toString());
        System.out.println("Recebendo os dados gasolina e alcool");
        resultadoCalculo = valorGasolina*0.7;
        System.out.println("Calculando a rentabilidade");
        if(resultadoCalculo<valorAlcool){
                    mensagem = "Gasolina";
                }else{
                    mensagem = "Alcool";
                }
        }
    }
    
}
