package Folhacod;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Empregado 
{
   private String name;
   private String endereco;
   private String tipo;
   private float valor;
   private int id;
   private String metodo_pagamento;
   private Sindicato sind;
   private int freq_pagamento;
   private String acao;
   
   Scanner input = new Scanner(System.in);
   
   public int search_empregado(java.util.ArrayList<Empregado> Empregados, int id)
   {
       int i, result = -1;
       for (i = 0; i < Empregados.size(); i++) 
       {
           if(Empregados.get(i).getId() == id) 
           {
               result = i;
           }
       }
       return result;
   }
   
   public Assalariado edit_tipo_ass(Assalariado funcionario, Agenda agenda)
   {
       String lixo = new String();
       int cont_aux = 0;
       System.out.println("->Digite o salaraio por mes desse empregado: ");
       while(cont_aux == 0)
        {
            try
            {
                funcionario.setValor(input.nextInt());
                cont_aux++;
            }
            catch(InputMismatchException Exception)
            {
                lixo = input.nextLine();
                System.out.println();
                System.out.println("Foi digitado um elemento diferente de um numero! Tente novamente...\n->Digite o salaraio por mes desse empregado: ");
            }
        }   
        cont_aux = 0;
       PagamentoAssalariado pagamentoA = new PagamentoAssalariado();
       funcionario.setDia_mes(pagamentoA);
       funcionario.setFreq_pagamento(agenda.getMensal());
       funcionario.setDia_mes_1(agenda.getDia_mes());
       
       return funcionario;
   }
   
   public Horista edit_tipo_hor(Horista funcionario, Agenda agenda)
   {
       String lixo = new String();
       int cont_aux = 0;
       System.out.println("->Digite o salaraio por hora desse empregado: ");
       while(cont_aux == 0)
        {
            try
            {
                funcionario.setValor(input.nextInt());
                cont_aux++;
            }
            catch(InputMismatchException Exception)
            {
                lixo = input.nextLine();
                System.out.println();
                System.out.println("Foi digitado um elemento diferente de um numero! Tente novamente...\n->Digite o salaraio por hora desse empregado: ");
            }
        }   
       cont_aux = 0;
       PagamentoHorista pagamentoH = new PagamentoHorista();
       funcionario.setDia_semana(pagamentoH);
       funcionario.setFreq_pagamento(agenda.getSemanalmente());
       funcionario.setDia_semana_1(agenda.getDia_semana());
       
       return funcionario;
   }
   
   public Comissionado edit_tipo_com(Comissionado funcionario, Agenda agenda)
   {
       String lixo = new String();
       int cont_aux = 0;
       System.out.println("->Digite o salaraio quinzenal desse empregado: ");
       while(cont_aux == 0)
        {
            try
            {
                funcionario.setValor(input.nextInt());
                cont_aux++;
            }
            catch(InputMismatchException Exception)
            {
                lixo = input.nextLine();
                System.out.println();
                System.out.println("Foi digitado um elemento diferente de um numero! Tente novamente...\n->Digite o salaraio quinzenal desse empregado: ");
            }
        }   
        cont_aux = 0;
       PagamentoComissionado pagamentoC = new PagamentoComissionado();
       funcionario.setDia_quinzena_semana(pagamentoC);

       Vendas venda = new Vendas();
       funcionario.setValor_venda(venda);
       funcionario.getValor_venda().setValor_vendas(0);
       System.out.println("->Digite a porcentagem que este funcionário irá ganhar por venda: ");
       while(cont_aux == 0)
        {
            try
            {
                funcionario.setPorcentagem(input.nextInt());
                cont_aux++;
            }
            catch(InputMismatchException Exception)
            {
                lixo = input.nextLine();
                System.out.println();
                System.out.println("Foi digitado um elemento diferente de um numero! Tente novamente...\n->Digite a porcentagem que este funcionário irá ganhar por venda: ");
            }
        }   
        cont_aux = 0;

       funcionario.setFreq_pagamento(agenda.getQuinzenal());
       funcionario.setDia_semana15(agenda.getDia_semana15());
       
       return funcionario;
   }
   
   public java.util.ArrayList<Empregado> edit(java.util.ArrayList<Empregado> Empregados, int local, Empregado funcionario, int edit, Agenda agenda)
   {
       if (edit == 1) 
       {
           System.out.println("->Digite o novo nome do funcionário escolhido: ");
           funcionario.setName(input.nextLine());
           Empregados.set(local, funcionario);
           System.out.print("\n");
       } 
       else if (edit == 2) 
       {
           System.out.println("->Digite o novo endereço do funcinário escolhido: ");
           funcionario.setEndereco(input.nextLine());
           Empregados.set(local, funcionario);
           System.out.print("\n");
       } 
       else if (edit == 3) 
       {
           if (funcionario.getTipo().equals("assalariado")) 
           {
               System.out.println("->Digite o novo tipo de funcinário, do funcionário escolhido: ");
               funcionario.setTipo(input.nextLine());
               if (funcionario.getTipo().equals("horista")) 
               {
                   Horista funcionario_aux = new Horista();
                   funcionario_aux.setName(funcionario.getName());
                   funcionario_aux.setEndereco(funcionario.getEndereco());
                   funcionario_aux.setTipo(funcionario.getTipo());
                   funcionario_aux.setValor(funcionario.getValor());
                   funcionario_aux.setId(funcionario.getId());
                   funcionario_aux.setMetodo_pagamento(funcionario.getMetodo_pagamento());
                   funcionario_aux.setSind(funcionario.getSind());
                   funcionario_aux.setAcao(funcionario.getAcao());
                   
                   funcionario_aux = funcionario.edit_tipo_hor(funcionario_aux, agenda);
                   Empregados.set(local, funcionario_aux);
               } 
               else if (funcionario.getTipo().equals("comissionado")) 
               {
                   Comissionado funcionario_aux = new Comissionado();
                   funcionario_aux.setName(funcionario.getName());
                   funcionario_aux.setEndereco(funcionario.getEndereco());
                   funcionario_aux.setTipo(funcionario.getTipo());
                   funcionario_aux.setValor(funcionario.getValor());
                   funcionario_aux.setId(funcionario.getId());
                   funcionario_aux.setMetodo_pagamento(funcionario.getMetodo_pagamento());
                   funcionario_aux.setSind(funcionario.getSind());
                   funcionario_aux.setAcao(funcionario.getAcao());
                   
                   funcionario_aux = funcionario.edit_tipo_com(funcionario_aux, agenda);
                   Empregados.set(local, funcionario_aux);
               }
               System.out.print("\n");
           } 
           else if (funcionario.getTipo().equals("horista")) 
           {
               System.out.println("->Digite o novo tipo de funcinário, do funcionário escolhido: ");
               funcionario.setTipo(input.nextLine());
               if (funcionario.getTipo().equals("assalariado")) 
               {
                   Assalariado funcionario_aux = new Assalariado();
                   funcionario_aux.setName(funcionario.getName());
                   funcionario_aux.setEndereco(funcionario.getEndereco());
                   funcionario_aux.setTipo(funcionario.getTipo());
                   funcionario_aux.setValor(funcionario.getValor());
                   funcionario_aux.setId(funcionario.getId());
                   funcionario_aux.setMetodo_pagamento(funcionario.getMetodo_pagamento());
                   funcionario_aux.setSind(funcionario.getSind());
                   funcionario_aux.setAcao(funcionario.getAcao());
                   
                   funcionario_aux = funcionario.edit_tipo_ass(funcionario_aux, agenda);
                   Empregados.set(local, funcionario_aux);
               } 
               else if (funcionario.getTipo().equals("comissionado")) 
               {
                   Comissionado funcionario_aux = new Comissionado();
                   funcionario_aux.setName(funcionario.getName());
                   funcionario_aux.setEndereco(funcionario.getEndereco());
                   funcionario_aux.setTipo(funcionario.getTipo());
                   funcionario_aux.setValor(funcionario.getValor());
                   funcionario_aux.setId(funcionario.getId());
                   funcionario_aux.setMetodo_pagamento(funcionario.getMetodo_pagamento());
                   funcionario_aux.setSind(funcionario.getSind());
                   funcionario_aux.setAcao(funcionario.getAcao());
                   
                   funcionario_aux = funcionario.edit_tipo_com(funcionario_aux, agenda);
                   Empregados.set(local, funcionario_aux);
               }
               System.out.print("\n");
           } 
           else if (funcionario.getTipo().equals("comissionado")) 
           {
               System.out.println("->Digite o novo tipo de funcinário, do funcionário escolhido: ");
               funcionario.setTipo(input.nextLine());
               if (funcionario.getTipo().equals("assalariado")) 
               {
                   Assalariado funcionario_aux = new Assalariado();
                   funcionario_aux.setName(funcionario.getName());
                   funcionario_aux.setEndereco(funcionario.getEndereco());
                   funcionario_aux.setTipo(funcionario.getTipo());
                   funcionario_aux.setValor(funcionario.getValor());
                   funcionario_aux.setId(funcionario.getId());
                   funcionario_aux.setMetodo_pagamento(funcionario.getMetodo_pagamento());
                   funcionario_aux.setSind(funcionario.getSind());
                   funcionario_aux.setAcao(funcionario.getAcao());
                   
                   funcionario_aux = funcionario.edit_tipo_ass(funcionario_aux, agenda);
                   Empregados.set(local, funcionario_aux);
               } 
               else if (funcionario.getTipo().equals("horista")) 
               {
                   Horista funcionario_aux = new Horista();
                   funcionario_aux.setName(funcionario.getName());
                   funcionario_aux.setEndereco(funcionario.getEndereco());
                   funcionario_aux.setTipo(funcionario.getTipo());
                   funcionario_aux.setValor(funcionario.getValor());
                   funcionario_aux.setId(funcionario.getId());
                   funcionario_aux.setMetodo_pagamento(funcionario.getMetodo_pagamento());
                   funcionario_aux.setSind(funcionario.getSind());
                   funcionario_aux.setAcao(funcionario.getAcao());
                   
                   funcionario_aux = funcionario.edit_tipo_hor(funcionario_aux, agenda);
                   Empregados.set(local, funcionario_aux);
               }
               System.out.print("\n");
           }
       } 
       else if (edit == 4) 
       {
           System.out.println("->Digite o novo método de pagamento do funcionário escolhido: ");
           funcionario.setMetodo_pagamento(input.nextLine());
           Empregados.set(local, funcionario);
           System.out.print("\n");
       } 
       else if (edit == 5) 
       {
           Sindicato sindicato6_5 = new Sindicato();
           sindicato6_5 = funcionario.getSind();

           System.out.println("->Digite o novo status do funcinário em relação a participação de um sindicato:\n Digite sim ou nao: ");
           
           sindicato6_5.setPart_sindicato(input.nextLine());

           funcionario.setSind(sindicato6_5);
           
           Empregados.set(local, funcionario);
           System.out.print("\n");
       } 
       else if (edit == 6) 
       {
           if(funcionario.getSind().getPart_sindicato().equals("sim"))
           {
                int cont_aux = 0;
                int j;
                String lixo = new String();
                
                Empregado funcionario6_6 = new Empregado();

                Sindicato sindicato6_6 = new Sindicato();
                sindicato6_6 = funcionario.getSind();

                System.out.println("->Digite um novo id que represente o trabalhador no sindicato:\n (não insira id's pertencentes a outros funcionários)\n");
                while(cont_aux == 0)
                {
                    try
                    {
                        sindicato6_6.setId_sindicato(input.nextInt());
                        cont_aux++;
                    }
                    catch(InputMismatchException Exception)
                    {
                        lixo = input.nextLine();
                        System.out.println();
                        System.out.println("Foi digitado um elemento diferente de um numero! Tente novamente...\n->Digite um novo id que represente o trabalhador no sindicato:\n (não insira id's pertencentes a outros funcionários)\n");
                    }
                }   
                cont_aux = 0;

                sindicato6_6 = sindicato6_6.search_id_sindical(Empregados, funcionario6_6, sindicato6_6, funcionario.getId());
                funcionario.setSind(sindicato6_6);

                Empregados.set(local, funcionario);
                System.out.println("id sindicato " + funcionario.getSind().getId_sindicato());
           }
           else
           {
               System.out.println("O funcionario não faz parte de um sindicato");
           }
       } 
       else if (edit == 7) 
       {
           if(funcionario.getSind().getPart_sindicato().equals("sim"))
           {
                int cont_aux = 0;
                String lixo = new String();
                System.out.println("->Digite a nova taxa sindical básica do funcionário: ");
                while(cont_aux == 0)
                {
                    try
                    {
                        funcionario.getSind().setPorcentagem_sind(input.nextInt());
                        cont_aux++;
                    }
                    catch(InputMismatchException Exception)
                    {
                        lixo = input.nextLine();
                        System.out.println();
                        System.out.println("Foi digitado um elemento diferente de um numero! Tente novamente...\n->Digite a nova taxa sindical básica do funcionário: ");
                    }
                }   
                cont_aux = 0;
                Empregados.set(local, funcionario);
                System.out.print("\n");
           }
           else
           {
               System.out.println("O funcionario não faz parte de um sindicato");
           }
       }
       return Empregados;
   }
   
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMetodo_pagamento() {
        return metodo_pagamento;
    }

    public void setMetodo_pagamento(String metodo_pagamento) {
        this.metodo_pagamento = metodo_pagamento;
    }

    public Sindicato getSind() {
        return sind;
    }

    public void setSind(Sindicato sind) {
        this.sind = sind;
    }

    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }
    
    public int getFreq_pagamento() {
        return freq_pagamento;
    }

    public void setFreq_pagamento(int freq_pagamento) {
        this.freq_pagamento = freq_pagamento;
    }
}
