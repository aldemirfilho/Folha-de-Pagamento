package Folhacod;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Sindicato {
   private String part_sindicato;
   private int id_sindicato;
   private float porcentagem_sind;
   private float porcentagem_sind_adicional;
   
   Scanner input = new Scanner(System.in);
   
   public Sindicato prencher(Sindicato sindicato, int cont)
   {
        int cont_aux = 0;
        String lixo = new String();
        System.out.println("->Digite a porcentagem da taxa básica descontada do salario dedicada ao sindicato: ");
        while(cont_aux == 0)
        {
            try
            {
                sindicato.setPorcentagem_sind(input.nextInt());
                cont_aux++;
            }
            catch(InputMismatchException Exception)
            {
                lixo = input.nextLine();
                System.out.println();
                System.out.println("Foi digitado um elemento diferente de um numero! Tente novamente...\n->Digite a porcentagem da taxa básica descontada do salario dedicada ao sindicato: ");
            }
        }   
        cont_aux = 0;
        sindicato.setPorcentagem_sind_adicional(0);
        sindicato.setId_sindicato(cont + 999);
        System.out.print("\n");
        System.out.println("->O id do sindicato do seu empregado é: " + sindicato.getId_sindicato());
        System.out.print("\n");
        return sindicato;
    }

   public java.util.ArrayList<Empregado> registrar_taxa(java.util.ArrayList<Empregado> Empregados, int local, Sindicato sindicato, int id_funcionario)
   {
       int cont_aux = 0;
       String lixo = new String();
//     funcionario.setAcao("taxa");
//     undo.push(funcionario);
       sindicato = Empregados.get(local).getSind();
       if (sindicato.getPart_sindicato().equals("sim")) 
       {
           System.out.println("->Digite a porcentagem das taxas adicionais de serviços ligadas ao sidicato: ");
           while(cont_aux == 0)
            {
                try
                {
                    sindicato.setPorcentagem_sind_adicional(input.nextFloat());
                    cont_aux++;
                }
                catch(InputMismatchException Exception)
                {
                    lixo = input.nextLine();
                    System.out.println();
                    System.out.println("Foi digitado um elemento diferente de um numero! Tente novamente...\n->Digite a porcentagem das taxas adicionais de serviços ligadas ao sidicato: ");
                }
            }   
            cont_aux = 0;
           Empregados.get(local).setSind(sindicato);
           System.out.println();
       } 
       else 
       {
           System.out.println("Obs: Tal funcionario não esta associado a um sindicato.\n");
       }
       return Empregados;
   }
   
   public Sindicato search_id_sindical(java.util.ArrayList<Empregado> Empregados, Empregado funcionario, Sindicato sindicato, int id_emp)
   {
       int cont_aux = 0;
       String lixo = new String();
       int existe = 1, j;
       while (existe == 1) 
       {
           for (j = 0; j < Empregados.size(); j++) 
           {
               funcionario = Empregados.get(j);
               //System.out.println(funcionario.getId());
               if ((funcionario.getSind().getId_sindicato() == sindicato.getId_sindicato()) && (funcionario.getId() != id_emp))
               {
                   System.out.println("Obs: Este id ja exite, tente outro...\nId: ");
                   while(cont_aux == 0)
                    {
                        try
                        {
                            sindicato.setId_sindicato(input.nextInt());
                            cont_aux++;
                        }
                        catch(InputMismatchException Exception)
                        {
                            lixo = input.nextLine();
                            System.out.println();
                            System.out.println("Foi digitado um elemento diferente de um numero! Tente novamente...\nObs: Este id ja exite, tente outro...\nId: ");
                        }
                    }   
                    cont_aux = 0;
                   j = -1;
               } 
               else if(j == (Empregados.size() - 1))
               {
                   existe = 0;
               }
           }
       }
       return sindicato;
   }
   
    public int getId_sindicato() {
        return id_sindicato;
    }

    public void setId_sindicato(int id_sindicato) {
        this.id_sindicato = id_sindicato;
    }
    
   public String getPart_sindicato() {
        return part_sindicato;
    }

    public void setPart_sindicato(String part_sindicato) {
        this.part_sindicato = part_sindicato;
    }

    public float getPorcentagem_sind() {
        return porcentagem_sind;
    }

    public void setPorcentagem_sind(float porcentagem_sind) {
        this.porcentagem_sind = porcentagem_sind;
    }

    public float getPorcentagem_sind_adicional() {
        return porcentagem_sind_adicional;
    }

    public void setPorcentagem_sind_adicional(float porcentagem_sind_adicional) {
        this.porcentagem_sind_adicional = porcentagem_sind_adicional;
    }
}
