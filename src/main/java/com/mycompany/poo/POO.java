package com.mycompany.poo;

import java.awt.HeadlessException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class POO {

    public static void main(String[] args) {

        ArrayList<User> cadastro = new ArrayList<>();
        int op = 0, OpcaoUser = 0;
        String nome, cpf, cell;
        int id = 0;
        float valor;
        long num;

        while (op != 6) {
            JOptionPane.showMessageDialog(null, "Bem-vindo ao cadastro");
            op = Integer.parseInt(JOptionPane.showInputDialog("1-Cadastro \n 2-Login"));

            switch (op) {
                case 1: {
                    int op2 = 0;
                    id = id + 1;
                    nome = JOptionPane.showInputDialog("Informe seu nome:");
                    cpf = JOptionPane.showInputDialog("Informe o CPF:");
                    while (op2 != 2) {

                        if (cpf.length() == 11) {
                            op2 = 2;
                            try {
                                num = Long.parseLong(cpf);
                                JOptionPane.showMessageDialog(null, "CPF valido!");
                            } catch (Exception e) {
                                JOptionPane.showMessageDialog(null, "Informe um CPF válido!");
                                cpf = JOptionPane.showInputDialog("Informe o CPF:");
                                op2 = 1;
                            }
                        }
                    }
                    cell = JOptionPane.showInputDialog("Informe o celular:");
                    valor = 0;
                    User usuario = new User(nome, cpf, cell, id, valor);
                    cadastro.add(usuario);

                    break;
                }
                case 2: {
                    String cpfSearch;
                    boolean aux = false;
                    int j = 0;
                    cpfSearch = JOptionPane.showInputDialog("Informe seu CPF:");
                    OpcaoUser = 0;
                    for (int i = 0; i < cadastro.size(); i++) {
                        aux = cadastro.get(i).Login(cpfSearch);
                        System.out.println(aux);
                        if (aux == true) {
                            j = i;
                            i = 1000;

                            JOptionPane.showMessageDialog(null,
                                    "Seja bem-vindo "
                                    + cadastro.get(j).getNome());
                        }
                        if (i == cadastro.size()) {
                            JOptionPane.showMessageDialog(null, "Cpf não existe em nosso banco de dados.");            
                            OpcaoUser = 6;
                        }
                    }
                    if (aux == false) {
                        JOptionPane.showMessageDialog(null, "Cpf não existe.");
                        OpcaoUser = 6;
                    }

                    while (OpcaoUser != 6) {
                        OpcaoUser = Integer.parseInt(JOptionPane.showInputDialog("1-Atualizar cadastro \n 2-Vizualizar Perfil \n 3- Depositar \n 4-Sacar \n 5-Remover conta \n 6-Sair"));
                        switch (OpcaoUser) {

                            case 1: {
                                JOptionPane.showMessageDialog(null, "Atualização de cadastro.");
                                JOptionPane.showMessageDialog(null, "Celular atual:" + cadastro.get(j).getCell());
                                cell = JOptionPane.showInputDialog("Informe o novo celular:");
                                cadastro.get(j).setCell(cell);
                                JOptionPane.showMessageDialog(null, "Celular novo:" + cadastro.get(j).getCell());
                                break;
                            }
                            case 2: {
                                for (User ususario : cadastro) {
                                    JOptionPane.showInputDialog(null, ususario.toString());
                                }
                                break;
                            }
                            case 3: {
                                cadastro.get(j).Depositar();
                                break;
                            }
                            case 4: {
                                cadastro.get(j).Sacar();
                                break;
                            }
                            case 5: {
                                cadastro.remove(j);
                                OpcaoUser = 6;
                                break;
                            }
                            case 6: {
                                OpcaoUser = 6;
                                break;
                            }

                        }
                    }
                }

            }
        }

    }

}
