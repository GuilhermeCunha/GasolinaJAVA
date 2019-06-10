/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Carro;
import Model.DAO.CarroDAO;
import View.Carros.ValorPorTrajeto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Guilherme
 */
public class ValorPorTrajetoController implements ActionListener, ListSelectionListener{
    
    private ValorPorTrajeto valorPorTrajeto;
    private double precoGasolina;
    private double precoAlcool;
    
    private JList lista;
    private ArrayList<Carro> carrosBanco;
    private CarroDAO carroDAO;
    private DefaultListModel defaultListModel;
    private Carro selecionado;

    public ValorPorTrajetoController(ValorPorTrajeto valorPorTrajeto, double precoGasolina, double precoAlcool) {
        this.valorPorTrajeto = valorPorTrajeto;
        this.precoGasolina = precoGasolina;
        this.precoAlcool = precoAlcool;
        this.selecionado = new Carro();
        this.lista = this.valorPorTrajeto.ListaCarrosValorTrajeto;
    
        this.valorPorTrajeto.BotaoCalcularCusto.addActionListener(this);
        this.valorPorTrajeto.BotaoSelecionarCarroTrajeto.addActionListener(this);
        this.valorPorTrajeto.CheckBoxAlcool.addActionListener(this);
        this.valorPorTrajeto.CheckBoxGasolina.addActionListener(this);
        
        
        this.carroDAO = new CarroDAO();
        this.carrosBanco = carroDAO.consultarCarros();
        defaultListModel = new DefaultListModel();
        this.valorPorTrajeto.ListaCarrosValorTrajeto = new JList();
        this.valorPorTrajeto.ListaCarrosValorTrajeto.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        this.valorPorTrajeto.ListaCarrosValorTrajeto.setLayoutOrientation(JList.VERTICAL_WRAP);
        
        
        for(int i=0; i< this.carrosBanco.size();i++){
            this.defaultListModel.addElement(this.carrosBanco.get(i));
            lista.setModel(defaultListModel);
            this.valorPorTrajeto.ListaCarrosValorTrajeto.setModel(defaultListModel);
        }
        
        lista.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource() == this.valorPorTrajeto.BotaoSelecionarCarroTrajeto){
            this.selecionado = (Carro) lista.getSelectedValue();
            System.out.println("Carro Selecionado: " + this.selecionado.getModelo() + 
                    "Consumos: " + this.selecionado.getConsumoGasolina() + 
                    " - " + this.selecionado.getConsumoAlcool());
            
            if(selecionado.isFlex()){
                this.valorPorTrajeto.CheckBoxAlcool.setVisible(true);
            }else{
                this.valorPorTrajeto.CheckBoxAlcool.setVisible(false);
            }
        }
        
        if(ae.getSource() == this.valorPorTrajeto.CheckBoxGasolina){
            if(selecionado.isFlex()){
                if(this.valorPorTrajeto.CheckBoxGasolina.isSelected()){
                    this.valorPorTrajeto.CheckBoxAlcool.setSelected(false);
                }else{
                    this.valorPorTrajeto.CheckBoxAlcool.setSelected(true);
                    
                }
            }else{
                this.valorPorTrajeto.CheckBoxGasolina.setSelected(true);
            }
        }
        
        if(ae.getSource() == this.valorPorTrajeto.CheckBoxAlcool){
            if(this.valorPorTrajeto.CheckBoxAlcool.isSelected()){
                    this.valorPorTrajeto.CheckBoxGasolina.setSelected(false);
                }else{
                    this.valorPorTrajeto.CheckBoxGasolina.setSelected(true);
                }
        }
        
        if(ae.getSource() == this.valorPorTrajeto.BotaoCalcularCusto){
            String origem = "";
            String destino = "";
            if(!this.valorPorTrajeto.TxtEnderecoOrigem.equals("")){
                origem = this.valorPorTrajeto.EditEnderecoOrigem.getText();
            }
            
            if(!this.valorPorTrajeto.TxtEnderecoDestino.equals("")){
                destino = this.valorPorTrajeto.EditEnderecoDestino.getText();
            }
            
            double distancia = Distance.getDistance(origem, destino);
            System.out.println("Origem: " + origem);
            System.out.println("Destino: " + destino);
            System.out.println("Distancia: " + distancia);
            System.out.println("Carro Consumo Gasolina: " + this.selecionado.getConsumoGasolina());
            System.out.println("Carro Consumo Alcool: " + this.selecionado.getConsumoAlcool());
            if(this.valorPorTrajeto.ToglleIdaeVolta.isSelected()){
                    distancia *= 2;
            }
            
            if(this.valorPorTrajeto.CheckBoxGasolina.isSelected()){
                System.out.println("Custo : " + ((distancia/this.selecionado.getConsumoGasolina())* this.precoGasolina));
            }else{
                System.out.println("Custo : " + ((distancia/this.selecionado.getConsumoAlcool())* this.precoAlcool));
          
            }
       
            

        }
      
    }

    @Override
    public void valueChanged(ListSelectionEvent lse) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
