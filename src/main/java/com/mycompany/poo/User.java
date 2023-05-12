package com.mycompany.poo;

import javax.swing.JOptionPane;

public class User {

    public String nome;
    public String cpf;
    public String cell;
    public int id;
    public float valor;

    public User(String nome, String cpf, String cell, int id, float valor) {
        this.nome = nome;
        this.cpf = cpf;
        this.cell = cell;
        this.id = id;
        this.valor = valor;

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
    //metodos

    public float Depositar() {
        float deposit = 0;

        deposit = Float.parseFloat(JOptionPane.showInputDialog("Informe um valor que deseja depositar:"));
        this.valor = this.valor + deposit;

        return deposit;
    }

    public boolean Login(String cpfSearch) {
        int op = 0;
        long num;
        boolean aux;

        aux = this.cpf.equals(cpfSearch);

        if (aux == true) {
            num = Long.parseLong(cpfSearch);
            return true;
        }
        return false;
    }

    public float Sacar() {
        float  saque = 0;

        saque = Float.parseFloat(JOptionPane.showInputDialog("Informe o valor que deseja sacar:"));
        this.valor = this.valor - saque;
     
        return saque;
    }
    public void Remove(){
    JOptionPane.showMessageDialog(null, "Conta excluída.");  
    
    }

    /**
     *
     */
    @Override
    public String toString() {

        return "oi";

    }

  

}
