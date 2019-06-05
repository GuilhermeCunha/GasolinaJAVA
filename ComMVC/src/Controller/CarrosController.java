/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Carro;
import View.Carros.CadastroCarros;
import View.Carros.InsercaoCombustivel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author aluno
 */
    public class CarrosController implements ActionListener{
        private double precoAlcool;
        private double precoGasolina;
        CarroController carroController;
        CadastroCarros cadastroCarros;
        InsercaoCombustivel insercaoCombustivel;


        public double getPrecoAlcool() {
            return precoAlcool;
        }

        public void setPrecoAlcool(double precoAlcool) {
            this.precoAlcool = precoAlcool;
        }

        public double getPrecoGasolina() {
            return precoGasolina;
        }

        public void setPrecoGasolina(double precoGasolina) {
            this.precoGasolina = precoGasolina;
        }



        public CarrosController(CadastroCarros cadastroCarros) {
            this.cadastroCarros = cadastroCarros;
            this.cadastroCarros.BotaoCriarCarro.addActionListener(this);
            this.cadastroCarros.CheckBoxFlex.addActionListener(this);
            this.carroController = new CarroController();
        }
        
        public CarrosController(InsercaoCombustivel insercaoCombustivel) {
            this.insercaoCombustivel = insercaoCombustivel;
            this.insercaoCombustivel.BotaoInserirCombustivel.addActionListener(this);
        }
        
        @Override
        public void actionPerformed(ActionEvent ae){
            if(this.cadastroCarros != null){
                
                if(ae.getSource() == cadastroCarros.CheckBoxFlex){
                    if (this.cadastroCarros.CheckBoxFlex.isSelected()){
                        this.cadastroCarros.EditConsumoAlcool.setVisible(true);
                        this.cadastroCarros.TxtConsumoAlcool.setVisible(true);
                    } else{
                        this.cadastroCarros.EditConsumoAlcool.setVisible(false);
                        this.cadastroCarros.TxtConsumoAlcool.setVisible(false);
                    }
                }
                
                if(ae.getSource() == cadastroCarros.BotaoCriarCarro){
                    String nomeCarro = this.cadastroCarros.EditNomeCarro.getText().toString();
                    double consumoGasolina = 0;
                    double consumoAlcool = 0;
                    boolean flex = this.cadastroCarros.CheckBoxFlex.isSelected();
                    if(this.cadastroCarros.EditConsumoGasolina.getText().toString() != null){
                        consumoGasolina = Double.parseDouble(this.cadastroCarros.EditConsumoGasolina.getText().toString());
                    } 
                    if(this.cadastroCarros.EditConsumoAlcool.getText().toString() != null){
                        consumoAlcool = Double.parseDouble(this.cadastroCarros.EditConsumoAlcool.getText().toString());
                    }
                    Carro carro = new Carro();
                    carro.setFlex(flex);
                    carro.setModelo(nomeCarro);
                    if(flex) carro.setConsumoAlcool(consumoAlcool);
                    carro.setConsumoGasolina(consumoGasolina);
                    this.carroController.cadastrarCarro(carro);
                    System.out.println("BOTÃO CLICADO");
                }
            }   
            if(this.insercaoCombustivel != null){
                if(ae.getSource() == insercaoCombustivel.BotaoInserirCombustivel){
                    System.out.println("BOTÃO CLICADO");

                }
            }


        }
    }   

