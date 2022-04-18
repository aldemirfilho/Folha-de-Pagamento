package Folhacod;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Vendas 
{
    private float valor_vendas;
    private String data;
    
    Scanner input = new Scanner(System.in);
    
    public java.util.ArrayList<Empregado> add_vendas(java.util.ArrayList<Empregado> Empregados, int local, Comissionado funcionario)
    {
        int cont_aux = 0;
        float valor = 0;
        String lixo = new String();
        if (Empregados.get(local).getTipo().equals("comissionado")) 
        {
            funcionario = (Comissionado)Empregados.get(local);
            System.out.println("->Digite o valor da venda: ");
            while(cont_aux == 0)
            {
                try
                {
                    valor = input.nextInt();
                    cont_aux++;
                }
                catch(InputMismatchException Exception)
                {
                    lixo = input.nextLine();
                    System.out.println();
                    System.out.println("Foi digitado um elemento diferente de um numero! Tente novamente...\n->Digite o valor da venda: ");
                }
            }   
            cont_aux = 0;
            valor = valor * (funcionario.getPorcentagem() / 100);

            if ((funcionario.getValor_venda().getValor_vendas()) == 0) 
            {
                Vendas valor_total = new Vendas();
                valor_total.setValor_vendas(valor);

                funcionario.setValor_venda(valor_total);
            } 
            else 
            {
                valor = valor + (funcionario.getValor_venda().getValor_vendas());

                Vendas valor_total = new Vendas();
                valor_total.setValor_vendas(valor);

                funcionario.setValor_venda(valor_total);
            }
            System.out.println();
            // System.out.println("vendas" + funcionario4.getValor_venda().getValor_vendas());
        } 
        else 
        {
            System.out.println("Obs: Este id pertence a um funcionario não comissionado...\n");
        }
        return Empregados;
    }
    
    public float getValor_vendas() {
        return valor_vendas;
    }

    public void setValor_vendas(float valor_vendas) {
        this.valor_vendas = valor_vendas;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
