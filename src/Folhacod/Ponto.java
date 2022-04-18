package Folhacod;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ponto 
{
   private int hora_entrada;
   private int hora_saida;
   private int presenca;

   Scanner input = new Scanner(System.in);
   
   public java.util.ArrayList<Empregado> marcar_ponto(java.util.ArrayList<Empregado> Empregados, int local, Ponto p, Horista funcionario, PagamentoHorista pagamentoH)
   {
       int momento = 0, cont_aux = 0;
       String lixo = new String();
       if (Empregados.get(local).getTipo().equals("horista")) 
       {
           funcionario = (Horista)Empregados.get(local);
           pagamentoH = funcionario.getDia_semana();
           System.out.println("->Para marcar o ponto de entrada digite 1 ou 2 para marcar o ponto de saida: ");
           while(cont_aux == 0)
            {
                try
                {
                    momento = input.nextInt();
                    cont_aux++;
                }
                catch(InputMismatchException Exception)
                {
                    lixo = input.nextLine();
                    System.out.println();
                    System.out.println("Foi digitado um elemento diferente de um numero! Tente novamente...\n->Para marcar o ponto de entrada digite 1 ou 2 para marcar o ponto de saida: ");
                }
            }   
            cont_aux = 0;
           if (momento == 1) 
           {
               System.out.println("->Insira a hora de chegada: \n(Inserindo um numero de 7 a 23)\n");
               while(cont_aux == 0)
                {
                    try
                    {
                        p.setHora_entrada(input.nextInt());
                        cont_aux++;
                    }
                    catch(InputMismatchException Exception)
                    {
                        lixo = input.nextLine();
                        System.out.println();
                        System.out.println("Foi digitado um elemento diferente de um numero! Tente novamente...\n->Insira a hora de chegada: \n(Inserindo um numero de 7 a 23)\n");
                    }
                }   
                cont_aux = 0;
               funcionario.setPonto(p);
           } 
           else 
           {
               p = funcionario.getPonto();
               System.out.println("->Insira a hora de saida: \n(Inserindo um numero de 7 a 23)\n");
               while(cont_aux == 0)
                {
                    try
                    {
                        p.setHora_saida(input.nextInt());
                        cont_aux++;
                    }
                    catch(InputMismatchException Exception)
                    {
                        lixo = input.nextLine();
                        System.out.println();
                        System.out.println("Foi digitado um elemento diferente de um numero! Tente novamente...\n->Insira a hora de saida: \n(Inserindo um numero de 7 a 23)\n");
                    }
                }   
                cont_aux = 0;
               int total_dia = p.getHora_saida() - p.getHora_entrada();
               if (total_dia < 8) 
               {
                   pagamentoH.setHoras_trabalhadas(total_dia + pagamentoH.getHoras_trabalhadas());
               }
               if (total_dia >= 8) 
               {
                   pagamentoH.setHoras_trabalhadas(8 + pagamentoH.getHoras_trabalhadas());
                   int extra;
                   extra = total_dia - 8;
                   pagamentoH.setExtras(extra + pagamentoH.getExtras());
               }
           }
           funcionario.setDia_semana(pagamentoH);
           System.out.println();
           System.out.println("Horas normais registradas: " + funcionario.getDia_semana().getHoras_trabalhadas());
           System.out.println("Horas extras registradas: " + funcionario.getDia_semana().getExtras());
           //funcionario.ponto.hora_entrada
           funcionario.setPonto(p);
           System.out.println();
           System.out.println("Presença registrada com sucesso!!!\n");
        } 
        else 
        {
            System.out.println("Este id pertence a um funcionário não horista");
        }
        return Empregados;
   }
   
    public int getPresenca() {
        return presenca;
    }

    public void setPresenca(int presenca) {
        this.presenca = presenca;
    }

    public int getHora_entrada() {
        return hora_entrada;
    }

    public void setHora_entrada(int hora_entrada) {
        this.hora_entrada = hora_entrada;
    }

    public int getHora_saida() {
        return hora_saida;
    }

    public void setHora_saida(int hora_saida) {
        this.hora_saida = hora_saida;
    }
}
