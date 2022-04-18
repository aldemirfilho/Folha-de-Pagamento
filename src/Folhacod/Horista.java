package Folhacod;

//import java.util.Scanner;

public class Horista extends Empregado
{
    private Ponto ponto;
    private PagamentoHorista dia_semana;
    private int dia_semana_1;

//    Scanner input = new Scanner(System.in);
    
    public void rodar_folha(Horista funcionario, int dia_semana, int dia, int mes, int ano)
    {
        float desconto, pagamento;
        if(funcionario.getDia_semana_1() == dia_semana)
        {
//          funcionario7.setAcao("pag");
//          undo.push(funcionario7);

            desconto = 0;
            int horas = funcionario.getDia_semana().getHoras_trabalhadas();
            pagamento = (funcionario.getValor() * funcionario.getDia_semana().getHoras_trabalhadas()) + ((funcionario.getValor() + (funcionario.getValor() / 2)) * funcionario.getDia_semana().getExtras());
            if (funcionario.getSind().getPart_sindicato().equals("sim")) 
            {
                desconto = (funcionario.getValor() * (funcionario.getSind().getPorcentagem_sind() / 100)) * funcionario.getDia_semana().getHoras_trabalhadas();

                if (funcionario.getSind().getPorcentagem_sind_adicional() != 0) 
                {
                    desconto = desconto + (funcionario.getValor() * (funcionario.getSind().getPorcentagem_sind_adicional() / 100) * funcionario.getDia_semana().getHoras_trabalhadas());
                }
            }
            pagamento = pagamento - desconto;

            funcionario.getDia_semana().setDia_da_semana(dia);
            funcionario.getDia_semana().setMes(mes);
            funcionario.getDia_semana().setSemanal_final(pagamento);

            System.out.println();
            System.out.println("         FOLHA DE PAGAMENTO");
            System.out.println("Nome do funcionário: " + funcionario.getName() + ".");
            System.out.println("Numero de Identificação: " + funcionario.getId() + ".");
            if (funcionario.getSind().getPart_sindicato().equals("sim")) 
            {
                System.out.println("Numero de Identificação sindical: " + funcionario.getSind().getId_sindicato() + ".");
            }
            System.out.println("Tipo de recebimento: " + funcionario.getTipo() + ".");
            System.out.println("Endereço: " + funcionario.getEndereco() + ".");
            System.out.println("Horas extras: " + funcionario.getDia_semana().getExtras() + ".");
            System.out.println("Horas normais: " + horas + ".");
            System.out.println("Data de pagamento: " + dia + "/" + mes + "/" + ano + ".");;
            System.out.println("Salário com os devidos descontos: " + funcionario.getDia_semana().getSemanal_final() + ".");
            System.out.println("Forma de pagamento: " + funcionario.getMetodo_pagamento() + ".");
            System.out.println();
        }
    }
    
    public Horista nome(Horista empregado)
    {
        System.out.print("->Digite o nome do empregado: ");
        empregado.setName(input.nextLine());
        return empregado;
    }
    
    public Horista endereco(Horista empregado)
    {
        System.out.print("->Digite o endereco do empregado: ");
        empregado.setEndereco(input.nextLine());
        return empregado;
    }
    
    public Horista metodo(Horista empregado)
    {
        System.out.print("->Digite o método de pagamento de preferencia do empregado: \n(Cheque pelos correios, Cheque em mãos, Deposito em conta bancária)\n");
        empregado.setMetodo_pagamento(input.nextLine());
        return empregado;
    }
    
    public Ponto getPonto() {
        return ponto;
    }

    public void setPonto(Ponto ponto) {
        this.ponto = ponto;
    }

    public PagamentoHorista getDia_semana() {
        return dia_semana;
    }

    public void setDia_semana(PagamentoHorista dia_semana) {
        this.dia_semana = dia_semana;
    }

    public int getDia_semana_1() {
        return dia_semana_1;
    }

    public void setDia_semana_1(int dia_semana_1) {
        this.dia_semana_1 = dia_semana_1;
    }
}
