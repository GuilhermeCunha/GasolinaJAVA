/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Carro;
import Model.DAO.CarroDAO;
import View.Carros.ApagarCarros;
import java.awt.ComponentOrientation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Guilherme
 */
public class ApagarCarrosController implements ActionListener, ListSelectionListener{
    private JList lista;
    private ArrayList<Carro> carrosBanco;
    private CarroDAO carroDAO;
    private ApagarCarros apagarCarros;
    private DefaultListModel defaultListModel;
   


    public ApagarCarrosController(ApagarCarros apagarCarros) {
        
        this.apagarCarros = apagarCarros;
        this.lista = this.apagarCarros.ListaCarrosParaApagar;
        this.apagarCarros.BotaoApagarCarro.addActionListener(this);
        this.apagarCarros.ButtonVoltar.addActionListener(this);
        
        
        this.carroDAO = new CarroDAO();
        this.carrosBanco = carroDAO.consultarCarros();
        defaultListModel = new DefaultListModel();
        this.apagarCarros.ListaCarrosParaApagar = new JList();
        this.apagarCarros.ListaCarrosParaApagar.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        this.apagarCarros.ListaCarrosParaApagar.setLayoutOrientation(JList.VERTICAL_WRAP);
        
        
        for(int i=0; i< this.carrosBanco.size();i++){
            this.defaultListModel.addElement(this.carrosBanco.get(i));
            lista.setModel(defaultListModel);
            this.apagarCarros.ListaCarrosParaApagar.setModel(defaultListModel);
        }
        
        lista.setVisible(true);
        //this.lista = new JList(this.defaultListModel);
        
        //this.apagarCarros.ListaCarrosParaApagar.
        
        
   
        
        
        //this.apagarCarros.ListaCarrosParaApagar.addListSelectionListener((ListSelectionListener) this);
        //this.apagarCarros
    }
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        
       if(ae.getSource() == this.apagarCarros.BotaoApagarCarro){
           Carro selecionado = (Carro) lista.getSelectedValue();
           this.carroDAO.descadastrarCarro(selecionado);
           
           int index = lista.getSelectedIndex();
            if(index >= 0){ 
                this.defaultListModel.removeElementAt(index);
            }
            JOptionPane.showMessageDialog(apagarCarros, "Carro Apagado");
            lista.setModel(defaultListModel);
       }
       if(ae.getSource() == this.apagarCarros.ButtonVoltar){
           apagarCarros.dispose();
       }
    }

    @Override
    public void valueChanged(ListSelectionEvent lse) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
