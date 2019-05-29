/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Guilherme
 */
public class Carro {
    private int id;
    private String modelo;
    private boolean flex;
    private double consumoGasolina;
    private double consumoAlcool;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public boolean isFlex() {
        return flex;
    }

    public void setFlex(boolean flex) {
        this.flex = flex;
        if(!this.flex) this.setConsumoAlcool(0);
    }

    public double getConsumoGasolina() {
        return consumoGasolina;
    }

    public void setConsumoGasolina(double consumoGasolina) {
        this.consumoGasolina = consumoGasolina;
    }

    public double getConsumoAlcool() {
        return consumoAlcool;
    }

    public void setConsumoAlcool(double consumoAlcool) {
        this.consumoAlcool = consumoAlcool;
    }
}
