/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Carro;
import Model.DAO.CarroDAO;
import View.Carros.ModificarCarros;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

/**
 *
 * @author Guilherme
 */
public class ModificarCarrosController implements ActionListener{
    private ModificarCarros modificarCarros;
    private JTextField txtFModeloCarro;
    private JTextField txtFGasolinaCarro;
    private JTextField txtFAlcoolCarro;
    private JList lista;
    private CarroDAO carroDAO;
    private DefaultListModel defaultListModel;
    private ArrayList<Carro> carrosBanco;
    private Carro selecionado;
    
    
    public ModificarCarrosController(ModificarCarros modificarCarros) {
        this.modificarCarros = modificarCarros;
        this.modificarCarros.BotaoSelecionarCarro.addActionListener(this);
        this.modificarCarros.BotaoAlterarCarro.addActionListener(this);
        this.modificarCarros.CheckBoxFlexAlterar.addActionListener(this);
        
        this.lista = this.modificarCarros.ListaCarrosParaAlterar;
        
        this.txtFModeloCarro = this.modificarCarros.EditNomeCarroAlterar;
        this.txtFGasolinaCarro = this.modificarCarros.EditConsumoGasolinaAlterar;
        this.txtFAlcoolCarro = this.modificarCarros.EditConsumoAlcoolAlterar;
        this.modificarCarros.ListaCarrosParaAlterar = new JList();
        
       
        this.modificarCarros.ListaCarrosParaAlterar.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        this.modificarCarros.ListaCarrosParaAlterar.setLayoutOrientation(JList.VERTICAL_WRAP);
        
        
        this.carroDAO = new CarroDAO();
        this.carrosBanco = carroDAO.consultarCarros();
        System.out.println("Size: " + this.carrosBanco.size());
        this.defaultListModel = new DefaultListModel();
        
        for(int i=0; i< this.carrosBanco.size();i++){
            this.defaultListModel.addElement(this.carrosBanco.get(i));
            lista.setModel(defaultListModel);
            this.modificarCarros.ListaCarrosParaAlterar.setModel(defaultListModel);
        }
        
        lista.setVisible(true);
    }
    
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource() == this.modificarCarros.BotaoSelecionarCarro){
            this.selecionado = (Carro) lista.getSelectedValue();
            this.txtFAlcoolCarro.setText(String.valueOf(selecionado.getConsumoAlcool()));
            this.txtFGasolinaCarro.setText(String.valueOf(selecionado.getConsumoGasolina()));
            this.txtFModeloCarro.setText(selecionado.getModelo());
            if(selecionado.isFlex()){
                this.modificarCarros.CheckBoxFlexAlterar.setSelected(true);
                this.modificarCarros.EditConsumoAlcoolAlterar.setVisible(true);
                this.modificarCarros.TxtConsumoAlcoolAlterar.setVisible(true);
            }else{
                this.modificarCarros.CheckBoxFlexAlterar.setSelected(false);
                this.modificarCarros.EditConsumoAlcoolAlterar.setVisible(false);
                this.modificarCarros.TxtConsumoAlcoolAlterar.setVisible(false);
            }
        }
        
        if(ae.getSource() == this.modificarCarros.BotaoAlterarCarro){
            if(this.modificarCarros.CheckBoxFlexAlterar.isSelected()){
                this.selecionado.setFlex(true);
                this.selecionado.setModelo(this.txtFModeloCarro.getText());
                this.selecionado.setConsumoAlcool(Double.parseDouble(this.txtFAlcoolCarro.getText()));
                this.selecionado.setConsumoGasolina(Double.parseDouble(this.txtFGasolinaCarro.getText()));
                this.carroDAO.atualizarCarro(this.selecionado);
            }else{
                this.selecionado.setFlex(false);
                this.selecionado.setModelo(this.txtFModeloCarro.getText());
                this.selecionado.setConsumoAlcool(0.0);
                this.selecionado.setConsumoGasolina(Double.parseDouble(this.txtFGasolinaCarro.getText()));
                this.carroDAO.atualizarCarro(this.selecionado);
            }
            
        }
        if(ae.getSource() == this.modificarCarros.CheckBoxFlexAlterar){
            if (this.modificarCarros.CheckBoxFlexAlterar.isSelected()){
                        this.modificarCarros.EditConsumoAlcoolAlterar.setVisible(true);
                        this.modificarCarros.TxtConsumoAlcoolAlterar.setVisible(true);
               
                    } else{
                        this.modificarCarros.EditConsumoAlcoolAlterar.setVisible(false);
                        this.modificarCarros.TxtConsumoAlcoolAlterar.setVisible(false);
                    }
        }
        
    }
    
}
