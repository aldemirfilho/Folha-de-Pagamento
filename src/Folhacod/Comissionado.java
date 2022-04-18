package Folhacod;

//import java.util.Scanner;

public class Comissionado extends Empregado
{
    private Vendas valor_venda;
    private float porcentagem;
    private PagamentoComissionado dia_quinzena_semana;
    private int dia_semana15;

//    Scanner input = new Scanner(System.in);
    
    public int rodar_folha(Comissionado funcionario, int dia_semana, int dia, int mes, int ano, int controle)
    {
        float desconto, pagamento;
        if(funcionario.getDia_semana15() == dia_semana)
        {
//          funcionario7.setAcao("pag");
//          undo.push(funcionario7);

            desconto = 0;
            pagamento = funcionario.getValor() + funcionario.getValor_venda().getValor_vendas();
            if (funcionario.getSind().getPart_sindicato().equals("sim")) {
                desconto = funcionario.getValor() * (funcionario.getSind().getPorcentagem_sind() / 100);

                if (funcionario.getSind().getPorcentagem_sind_adicional() != 0) {
                    desconto = desconto + (funcionario.getValor() * (funcionario.getSind().getPorcentagem_sind_adicional() / 100));
                }
            }

            pagamento = pagamento - desconto;

            if (controle == 2) {
                funcionario.getDia_quinzena_semana().setDia_da_semana(dia);
                funcionario.getDia_quinzena_semana().setData_mes(mes);
                funcionario.getDia_quinzena_semana().setQuinzena_final(pagamento);

                controle = 1;

                System.out.println();
                System.out.println("         FOLHA DE PAGAMENTO");
                System.out.println("Nome do funcionário: " + funcionario.getName() + ".");
                System.out.println("Numero de Identificação: " + funcionario.getId() + ".");
                if (funcionario.getSind().getPart_sindicato().equals("sim")) 
                {
                    System.out.println("Numero de Identificação: " + funcionario.getSind().getId_sindicato() + ".");
                }
                System.out.println("Tipo de recebimento: " + funcionario.getTipo() + ".");
                System.out.println("Endereço: " + funcionario.getEndereco() + ".");
                System.out.println("Total arrecadado por comissão com as vendas: " + funcionario.getValor_venda().getValor_vendas() + ".");
                System.out.println("Data de pagamento: " + dia + "/" + mes + "/" + ano + ".");
                System.out.println("Salário com os devidos descontos: " + funcionario.getDia_quinzena_semana().getQuinzena_final() + ".");
                System.out.println("Forma de pagamento: " + funcionario.getMetodo_pagamento() + ".");
                System.out.println();
            } 
            else 
            {
                controle++;
            }
        }
        return controle;
    }
    
    public Comissionado nome(Comissionado empregado)
    {
        System.out.print("->Digite o nome do empregado: ");
        empregado.setName(input.nextLine());
        return empregado;
    }
    
    public Comissionado endereco(Comissionado empregado)
    {
        System.out.print("->Digite o endereco do empregado: ");
        empregado.setEndereco(input.nextLine());
        return empregado;
    }
    
    public Comissionado metodo(Comissionado empregado)
    {
        System.out.print("->Digite o método de pagamento de preferencia do empregado: \n(Cheque pelos correios, Cheque em mãos, Deposito em conta bancária)\n");
        empregado.setMetodo_pagamento(input.nextLine());
        return empregado;
    }
    
    public Vendas getValor_venda() {
        return valor_venda;
    }

    public void setValor_venda(Vendas valor_venda) {
        this.valor_venda = valor_venda;
    }

    public float getPorcentagem() {
        return porcentagem;
    }

    public void setPorcentagem(float porcentagem) {
        this.porcentagem = porcentagem;
    }

    public PagamentoComissionado getDia_quinzena_semana() {
        return dia_quinzena_semana;
    }

    public void setDia_quinzena_semana(PagamentoComissionado dia_quinzena_semana) {
        this.dia_quinzena_semana = dia_quinzena_semana;
    }

    public int getDia_semana15() {
        return dia_semana15;
    }

    public void setDia_semana15(int dia_semana15) {
        this.dia_semana15 = dia_semana15;
    }
}
