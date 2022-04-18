package Folhacod;

//import java.util.Scanner;

public class Assalariado extends Empregado
{
    private PagamentoAssalariado dia_mes;
    private int dia_mes_1;
    
//    Scanner input = new Scanner(System.in);
    
    public void rodar_folha(Assalariado funcionario, int dia_semana, int dia, int mes, int ano, int primeiro_dia_mes_semanal)
    {
        float desconto, pagamento;
        if(funcionario.getDia_mes_1() == 50) //ultimo dia util do mes
        {
//          funcionario7.setAcao("pag");
//          undo.push(funcionario7);
            int ultimo_dia, ultimo_dia_mes = 0;
            if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
                int diff2;
                diff2 = 31 - ((7 - primeiro_dia_mes_semanal) + 1);
                ultimo_dia = diff2 % 7;
            } 
            else if (mes == 2) 
            {
                int diff2;
                diff2 = 28 - ((7 - primeiro_dia_mes_semanal) + 1);
                ultimo_dia = diff2 % 7;
            } 
            else 
            {
                int diff2;
                diff2 = 30 - ((7 - primeiro_dia_mes_semanal) + 1);
                ultimo_dia = diff2 % 7;
            }
            if (ultimo_dia != 7 && ultimo_dia != 1) {
                if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
                    ultimo_dia_mes = 31;
                } else if (mes == 2) {
                    ultimo_dia_mes = 28;
                } else {
                    ultimo_dia_mes = 30;
                }
            } 
            else 
            {
                if ((mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) && ultimo_dia == 7) {
                    ultimo_dia_mes = 30;
                } else if ((mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) && ultimo_dia == 1) {
                    ultimo_dia_mes = 29;
                } else if ((mes == 2) && ultimo_dia == 7) {
                    ultimo_dia_mes = 27;
                } else if ((mes == 2) && ultimo_dia == 1) {
                    ultimo_dia_mes = 26;
                } else if ((mes == 4 || mes == 6 || mes == 9 || mes == 11) && ultimo_dia == 7) {
                    ultimo_dia_mes = 29;
                } else if ((mes == 4 || mes == 6 || mes == 9 || mes == 11) && ultimo_dia == 1) {
                    ultimo_dia_mes = 28;
                }
            }
            desconto = 0;
            pagamento = funcionario.getValor();
            if (funcionario.getSind().getPart_sindicato().equals("sim")) {
                desconto = funcionario.getValor() * (funcionario.getSind().getPorcentagem_sind() / 100);

                if (funcionario.getSind().getPorcentagem_sind_adicional() != 0) {
                    desconto = desconto + (funcionario.getValor() * (funcionario.getSind().getPorcentagem_sind_adicional() / 100));
                }
            }

            pagamento = pagamento - desconto;

            if (dia == ultimo_dia_mes) {
                funcionario.getDia_mes().setDia_do_mes(dia);
                funcionario.getDia_mes().setMensal_final(pagamento);

                System.out.println();
                System.out.println("         FOLHA DE PAGAMENTO");
                System.out.println("Nome do funcionário: " + funcionario.getName() + ".");
                System.out.println("Numero de Identificação: " + funcionario.getId() + ".");
                if (funcionario.getSind().getPart_sindicato().equals("sim")) {
                    System.out.println("Numero de Identificação Sindical: " + funcionario.getSind().getId_sindicato() + ".");
                }
                System.out.println("Tipo de recebimento: " + funcionario.getTipo() + ".");
                System.out.println("Endereço: " + funcionario.getEndereco() + ".");
                System.out.println("Data de pagamento: " + dia + "/" + mes + "/" + ano + ".");
                System.out.println("Salário com os devidos descontos: " + funcionario.getDia_mes().getMensal_final() + ".");
                System.out.println("Forma de pagamento: " + funcionario.getMetodo_pagamento() + ".");
                System.out.println();
            }
        } 
        else if (funcionario.getDia_mes_1() == dia) 
        {
//          funcionario7.setAcao("pag");
//          undo.push(funcionario7);

            desconto = 0;
            pagamento = funcionario.getValor();
            if (funcionario.getSind().getPart_sindicato().equals("sim")) {
                desconto = funcionario.getValor() * (funcionario.getSind().getPorcentagem_sind() / 100);

                if (funcionario.getSind().getPorcentagem_sind_adicional() != 0) {
                    desconto = desconto + (funcionario.getValor() * (funcionario.getSind().getPorcentagem_sind_adicional() / 100));
                }
            }

            pagamento = pagamento - desconto;

            funcionario.getDia_mes().setDia_do_mes(dia);
            funcionario.getDia_mes().setMensal_final(pagamento);

            System.out.println();
            System.out.println("         FOLHA DE PAGAMENTO");
            System.out.println("Nome do funcionário: " + funcionario.getName() + ".");
            System.out.println("Numero de Identificação: " + funcionario.getId() + ".");
            if (funcionario.getSind().getPart_sindicato().equals("sim")) {
                System.out.println("Numero de Identificação Sindical: " + funcionario.getSind().getId_sindicato() + ".");
            }
            System.out.println("Tipo de recebimento: " + funcionario.getTipo() + ".");
            System.out.println("Endereço: " + funcionario.getEndereco() + ".");
            System.out.println("Data de pagamento: " + dia + "/" + mes + "/" + ano + ".");
            System.out.println("Salário com os devidos descontos: " + funcionario.getDia_mes().getMensal_final() + ".");
            System.out.println("Forma de pagamento: " + funcionario.getMetodo_pagamento() + ".");
            System.out.println();
        }
    }
    
    public Assalariado nome(Assalariado empregado)
    {
        System.out.print("->Digite o nome do empregado: ");
        empregado.setName(input.nextLine());
        return empregado;
    }
    
    public Assalariado endereco(Assalariado empregado)
    {
        System.out.print("->Digite o endereco do empregado: ");
        empregado.setEndereco(input.nextLine());
        return empregado;
    }
    
    public Assalariado metodo(Assalariado empregado)
    {
        System.out.print("->Digite o método de pagamento de preferencia do empregado: \n(Cheque pelos correios, Cheque em mãos, Deposito em conta bancária)\n");
        empregado.setMetodo_pagamento(input.nextLine());
        return empregado;
    }
    
    public PagamentoAssalariado getDia_mes() {
        return dia_mes;
    }

    public void setDia_mes(PagamentoAssalariado dia_mes) {
        this.dia_mes = dia_mes;
    }

    public int getDia_mes_1() {
        return dia_mes_1;
    }

    public void setDia_mes_1(int dia_mes_1) {
        this.dia_mes_1 = dia_mes_1;
    }
}
