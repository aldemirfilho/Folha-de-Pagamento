package Folhacod;

import java.util.Calendar;
import static java.util.Calendar.DAY_OF_WEEK;
import java.util.InputMismatchException;
import java.util.Scanner;
//import java.util.Stack;

public class Function_01 
{
	public static void main(String[] args)
        {
		Scanner input = new Scanner(System.in);
                 
		System.out.println();
		System.out.print("              Bem vindo ao sistema de folha de pagamento!!!\n");
                System.out.println();
		System.out.print("Digite a opção de qual função deseja execultar...\n");
                System.out.println();
		System.out.print("1 . Adição de um empregado\n");
		System.out.print("2 . Remoção de um empregado\n");
		System.out.print("3 . Lançar um Cartão de Ponto\n");
		System.out.print("4 . Lançar um Resultado Venda\n");
		System.out.print("5 . Lançar uma taxa de serviço\n");
		System.out.print("6 . Alterar detalhes de um empregado\n");
		System.out.print("7 . Rodar a folha de pagamento para hoje\n");
		System.out.print("8 . Undo/redo\n");
		System.out.print("9 . Agenda de Pagamento\n");
		System.out.print("10 . Criação de Novas Agendas de Pagamento\n");
                System.out.println();
		System.out.print("Opção: ");
		
                int opcao = 0;
                int cont = 0, cont_aux = 0;
		int id;
		
                java.util.ArrayList<Empregado> Empregados = new java.util.ArrayList<>();
                int controle = 1;
                
                int dia, mes, ano, dia_semana;
                Calendar current = Calendar.getInstance();
                dia = current.get(Calendar.DATE);
                mes = current.get(Calendar.MONTH) + 1;
                ano = current.get(Calendar.YEAR);
                dia_semana = current.get(DAY_OF_WEEK);
                
                Agenda agenda = new Agenda();
                agenda.setMensal(1);
                agenda.setQuinzenal(2);
                agenda.setSemanalmente(3);
                
                agenda.setDia_semana(6);
                agenda.setDia_semana15(6);
                agenda.setDia_mes(50);
                
                Undo undo = new Undo();
                Redo redo = new Redo();
                
                String lixo = new String();
                while(opcao != 11)
                {
                    while(cont_aux == 0)
                    {
                        try
                        {
                            opcao = input.nextInt();
                            lixo = input.nextLine();
                            cont_aux++;
                            
                        }
                        catch(InputMismatchException Exception)
                        {
                            lixo = input.nextLine();
                            System.out.println();
                            System.out.println("Foi digitado um elemento diferente de um numero! Tente novamente...\nOpcao: ");
                        }
                    }
                    cont_aux = 0;
                    //System.out.println("cont_aux " + cont_aux); 
                    if(opcao == 1)
                    {
                            cont++;
                            System.out.println();
                            
                            String tipo;
                            System.out.print("->Digite o tipo de recebimento do empregado: \n (assalariado, horista, comissionado)\n");
                            tipo = input.nextLine();
                            
                            System.out.println();
                            
                            Sindicato sindicato1 = new Sindicato();
                            
                            switch (tipo) 
                            {
                                case "assalariado":
                                {
                                    Assalariado funcionario1 = new Assalariado();
                                    funcionario1.setTipo(tipo);
                                    System.out.print("->Digite o valor recebido do empregado: ");
                                    while(cont_aux == 0)
                                    {
                                        try
                                        {
                                            funcionario1.setValor(input.nextInt());
                                            cont_aux++;
                                        }
                                        catch(InputMismatchException Exception)
                                        {
                                            lixo = input.nextLine();
                                            System.out.println();
                                            System.out.println("Foi digitado um elemento diferente de um numero! Tente novamente...\n->Digite o valor recebido do empregado:  ");
                                        }
                                    }
                                    cont_aux = 0;
                                    funcionario1.setFreq_pagamento(agenda.getMensal());
                                    funcionario1.setDia_mes_1(agenda.getDia_mes());
                                    funcionario1.nome(funcionario1);
                                    funcionario1.endereco(funcionario1);
                                    funcionario1.metodo(funcionario1);
                                    System.out.print("\n");
                                    PagamentoAssalariado pagamentoA = new PagamentoAssalariado();
                                    funcionario1.setDia_mes(pagamentoA);
                                    lixo = input.nextLine();
                                    System.out.print("->O novo funcionário faz parte de um sindicato?\n Digite sim ou nao: ");
                                    sindicato1.setPart_sindicato(input.nextLine());
                                    System.out.print("\n");
                                    if(sindicato1.getPart_sindicato().equals("sim"))
                                    {
                                        sindicato1.prencher(sindicato1, cont);
                                    }   
                                    funcionario1.setSind(sindicato1);
                                    System.out.println("->O id empresarial do seu empregado é: " + cont);
                                    funcionario1.setId(cont);
                                    Empregados.add(funcionario1);
                                    
                                    undo.getAcoes_undo().add("add");
                                    undo.getEmpregados_undo().add(funcionario1);
                                    break;
                                }
                                case "horista":
                                {
                                    Horista funcionario1 = new Horista();
                                    funcionario1.setTipo(tipo);
                                    System.out.print("->Digite o valor recebido por hora pelo o empregado: ");
                                    while(cont_aux == 0)
                                    {
                                        try
                                        {
                                            funcionario1.setValor(input.nextInt());
                                            cont_aux++;
                                        }
                                        catch(InputMismatchException Exception)
                                        {
                                            lixo = input.nextLine();
                                            System.out.println();
                                            System.out.println("Foi digitado um elemento diferente de um numero! Tente novamente...\n->Digite o valor recebido por hora pelo o empregado: ");
                                        }
                                    }   
                                    cont_aux = 0;
                                    funcionario1.setFreq_pagamento(agenda.getSemanalmente());
                                    funcionario1.setDia_semana_1(agenda.getDia_semana());
                                    funcionario1.nome(funcionario1);
                                    funcionario1.endereco(funcionario1);
                                    funcionario1.metodo(funcionario1);
                                    System.out.print("\n");
                                    PagamentoHorista pagamentoH = new PagamentoHorista();
                                    pagamentoH.setDia_da_semana(6);
                                    pagamentoH.setHoras_trabalhadas(0);
                                    pagamentoH.setExtras(0);
                                    funcionario1.setDia_semana(pagamentoH);
                                    lixo = input.nextLine();
                                    System.out.print("->O novo funcionário faz parte de um sindicato?\n Digite sim ou nao: ");
                                    sindicato1.setPart_sindicato(input.nextLine());
                                    System.out.print("\n");
                                    if(sindicato1.getPart_sindicato().equals("sim"))
                                    {
                                        sindicato1.prencher(sindicato1, cont);
                                    }   
                                    funcionario1.setSind(sindicato1);
                                    System.out.println("->O id empresarial do seu empregado é: " + cont);
                                    funcionario1.setId(cont);
                                    Empregados.add(funcionario1);
                                    
                                    undo.getAcoes_undo().add("add");
                                    undo.getEmpregados_undo().add(funcionario1);
                                    break;
                                }
                                case "comissionado":
                                {
                                    cont_aux = 0;
                                    Vendas valor = new Vendas();
                                    valor.setValor_vendas(0);
                                    Comissionado funcionario1 = new Comissionado();
                                    funcionario1.setTipo(tipo);
                                    funcionario1.setValor_venda(valor);
                                    System.out.println("->Digite a porcentagem que este funcionário ganhará em cima de cada venda: ");
                                    int porcentagem = 0;
                                    while(cont_aux == 0)
                                    {
                                        try
                                        {
                                            porcentagem = input.nextInt();
                                            cont_aux++;
                                        }
                                        catch(InputMismatchException Exception)
                                        {
                                            lixo = input.nextLine();
                                            System.out.println();
                                            System.out.println("Foi digitado um elemento diferente de um numero! Tente novamente...\n->Digite a porcentagem que este funcionário ganhará em cima de cada venda: ");
                                        }
                                    }   
                                    cont_aux = 0;
                                    funcionario1.setPorcentagem(porcentagem);
                                    System.out.print("->Digite o valor recebido por quinzena pelo o empregado: ");
                                    while(cont_aux == 0)
                                    {
                                        try
                                        {
                                            funcionario1.setValor(input.nextInt());
                                            cont_aux++;
                                        }
                                        catch(InputMismatchException Exception)
                                        {
                                            lixo = input.nextLine();
                                            System.out.println();
                                            System.out.println("Foi digitado um elemento diferente de um numero! Tente novamente...\n->Digite o valor recebido por quinzena pelo o empregado: ");
                                        }
                                    }   
                                    cont_aux = 0;
                                    funcionario1.setFreq_pagamento(agenda.getQuinzenal());
                                    funcionario1.setDia_semana15(agenda.getDia_semana15());
                                    funcionario1.nome(funcionario1);
                                    funcionario1.endereco(funcionario1);
                                    funcionario1.metodo(funcionario1);
                                    System.out.print("\n");
                                    PagamentoComissionado pagamentoC = new PagamentoComissionado();
                                    pagamentoC.setDia_da_semana(6);
                                    pagamentoC.setData_mes(0);
                                    funcionario1.setDia_quinzena_semana(pagamentoC);
                                    lixo = input.nextLine();
                                    System.out.print("->O novo funcionário faz parte de um sindicato?\n Digite sim ou nao: ");
                                    sindicato1.setPart_sindicato(input.nextLine());
                                    System.out.print("\n");
                                    if(sindicato1.getPart_sindicato().equals("sim"))
                                    {
                                        sindicato1.prencher(sindicato1, cont);
                                    }   
                                    funcionario1.setSind(sindicato1);
                                    System.out.println("->O id empresarial do seu empregado é: " + cont);
                                    funcionario1.setId(cont);
                                    Empregados.add(funcionario1);
                                    
                                    System.out.println("valor vendas " + funcionario1.getValor_venda().getValor_vendas());
                                    
                                    undo.getAcoes_undo().add("add");
                                    undo.getEmpregados_undo().add(funcionario1);
                                    break;
                                }
                                default:
                                break;
                            }
                            if(Empregados.size() != 0){
                                System.out.println();
                                System.out.println("Foram definidos como padrão os dias de pagamento para os funcionários, seguindo as seguites regras:\n -Horistas: Todas as Sextas-Feiras, acrescido de horas extras caso exitir.\n -Assalariados: Todos os ultimos dias uteis do mês corrente.\n -Comissionados: A cada duas semanas, nas Sextas-Feiras, acrescidos das comissões de vendas, casos exista.\n");
                                System.out.println("Caso queira editar os dias, podem ser alterados na opção 10\n");
                            }
                            System.out.print("\n");
                            
                            System.out.println("---------------------------------------------");
                    }
                    if(Empregados.size() > 0)
                    {
                        if(opcao == 2)
                        {
                            System.out.println("->Digite o id do funcionario a ser removido: ");
                            int id_removed = 0;
                            while(cont_aux == 0)
                            {
                                try
                                {
                                    id_removed = input.nextInt();
                                    cont_aux++;
                                }
                                catch(InputMismatchException Exception)
                                {
                                    lixo = input.nextLine();
                                    System.out.println();
                                    System.out.println("Foi digitado um elemento diferente de um numero! Tente novamente...\nOpcao: ->Digite o id do funcionario a ser removido: ");
                                }
                            }   
                            cont_aux = 0;
                            int local;
                            Empregado funcionario2 = new Empregado();
                            local = funcionario2.search_empregado(Empregados, id_removed);
                            if(local != -1)
                            {
                                undo.getAcoes_undo().add("remove");
                                undo.getEmpregados_undo().add(Empregados.get(local));

                                Empregados.remove(local);
                                System.out.println("Removido com sucesso");
                            }
                            else
                            {
                                System.out.println("Este id não pertence a nenhum funcionário");
                            }
                            System.out.println("---------------------------------------------");
                        }
                        if(opcao == 3)
                        {
                            System.out.println("->Insira seu id, para marcar presença: ");
                            int meu_id = 0;
                            while(cont_aux == 0)
                            {
                                try
                                {
                                    meu_id = input.nextInt();
                                    cont_aux++;
                                }
                                catch(InputMismatchException Exception)
                                {
                                    lixo = input.nextLine();
                                    System.out.println();
                                    System.out.println("Foi digitado um elemento diferente de um numero! Tente novamente...\n->Insira seu id, para marcar presença: : ");
                                }
                            }   
                            cont_aux = 0;
                            int local;
                            Horista funcionario3 = new Horista();
                            Ponto p = new Ponto();
                            PagamentoHorista pagamentoH = new PagamentoHorista();

                            local = funcionario3.search_empregado(Empregados, meu_id);
                            if (local != -1) 
                            {
                                if(Empregados.get(local).getTipo().equals("horista"))
                                {
                                    undo.getAcoes_undo().add("ponto");

                                    Horista func_aux = new Horista();
                                    PagamentoHorista pagamento_aux = new PagamentoHorista();

                                    func_aux.setName(Empregados.get(local).getName());
                                    func_aux.setEndereco(Empregados.get(local).getEndereco());
                                    func_aux.setTipo(Empregados.get(local).getTipo());
                                    func_aux.setValor(Empregados.get(local).getValor());
                                    func_aux.setId(Empregados.get(local).getId());
                                    func_aux.setMetodo_pagamento(Empregados.get(local).getMetodo_pagamento());
                                    func_aux.setSind(Empregados.get(local).getSind());
                                    func_aux.setFreq_pagamento(Empregados.get(local).getFreq_pagamento());

                                    func_aux.setPonto(((Horista)Empregados.get(local)).getPonto());
                                    func_aux.setDia_semana_1(((Horista)Empregados.get(local)).getDia_semana_1());

                                    pagamento_aux.setDia_da_semana(((Horista)Empregados.get(local)).getDia_semana().getDia_da_semana());
                                    pagamento_aux.setExtras(((Horista)Empregados.get(local)).getDia_semana().getExtras());
                                    pagamento_aux.setHoras_trabalhadas(((Horista)Empregados.get(local)).getDia_semana().getHoras_trabalhadas());
                                    pagamento_aux.setMes(((Horista)Empregados.get(local)).getDia_semana().getMes());

                                    func_aux.setDia_semana(pagamento_aux);
                                    undo.getEmpregados_undo().add(func_aux);

                                    Empregados = p.marcar_ponto(Empregados, local, p, funcionario3, pagamentoH);
                                }
                                else
                                {
                                    System.out.println("Este funcionário não é um horista");
                                }
                            }
                            else
                            {
                                System.out.println("Este id não pertence a nenhum funcionário");
                            }
                            System.out.println("---------------------------------------------");
                        }
                        if(opcao == 4)
                        {
                            int id_vendedor = 0, local;
                            System.out.println("->Insira o id do funcionario, para registrar a venda: ");
                            while(cont_aux == 0)
                            {
                                try
                                {
                                    id_vendedor = input.nextInt();
                                    cont_aux++;
                                }
                                catch(InputMismatchException Exception)
                                {
                                    lixo = input.nextLine();
                                    System.out.println();
                                    System.out.println("Foi digitado um elemento diferente de um numero! Tente novamente...\n->Insira o id do funcionario, para registrar a venda: ");
                                }
                            }   
                            cont_aux = 0;
                            Comissionado funcionario4 = new Comissionado();
                            Vendas valor_venda = new Vendas();

                            local = funcionario4.search_empregado(Empregados, id_vendedor);
                            if (local != -1) 
                            {
                                if(Empregados.get(local).getTipo().equals("comissionado"))
                                {
                                    undo.getAcoes_undo().add("venda");
                                    Comissionado func_aux = new Comissionado();

                                    Vendas venda_aux = new Vendas();

                                    func_aux.setName(Empregados.get(local).getName());
                                    func_aux.setEndereco(Empregados.get(local).getEndereco());
                                    func_aux.setTipo(Empregados.get(local).getTipo());
                                    func_aux.setValor(Empregados.get(local).getValor());
                                    func_aux.setId(Empregados.get(local).getId());
                                    func_aux.setMetodo_pagamento(Empregados.get(local).getMetodo_pagamento());
                                    func_aux.setSind(Empregados.get(local).getSind());
                                    func_aux.setFreq_pagamento(Empregados.get(local).getFreq_pagamento());

                                    func_aux.setPorcentagem(((Comissionado)Empregados.get(local)).getPorcentagem());
                                    func_aux.setDia_quinzena_semana(((Comissionado)Empregados.get(local)).getDia_quinzena_semana());
                                    func_aux.setDia_semana15(((Comissionado)Empregados.get(local)).getDia_semana15());

                                    venda_aux.setValor_vendas(((Comissionado)Empregados.get(local)).getValor_venda().getValor_vendas());
                                    venda_aux.setData(((Comissionado)Empregados.get(local)).getValor_venda().getData());

                                    func_aux.setValor_venda(venda_aux);
                                    undo.getEmpregados_undo().add(func_aux);

                                    Empregados = valor_venda.add_vendas(Empregados, local, funcionario4);
                                }
                                else
                                {
                                    System.out.println("Esse id pertence a um funcionario não comissionado");
                                }
                            }
                            else
                            {
                                System.out.println("Este id não pertence a nenhum funcionário");
                            }
                            System.out.println("---------------------------------------------");
                        }
                        if(opcao == 5)
                        {   
                            int i, id_funcionario = 0, local;
                            System.out.println("->Insira o id do funcionário, para registrar a taxa de serviço: ");
                            while(cont_aux == 0)
                            {
                                try
                                {
                                    id_funcionario = input.nextInt();
                                    cont_aux++;
                                }
                                catch(InputMismatchException Exception)
                                {
                                    lixo = input.nextLine();
                                    System.out.println();
                                    System.out.println("Foi digitado um elemento diferente de um numero! Tente novamente...\n->Insira o id do funcionário, para registrar a taxa de serviço: ");
                                }
                            }   
                            cont_aux = 0;
                            //checar se ele é comissionado
                            Empregado funcionario5 = new Empregado( );
                            Sindicato sindicato5 = new Sindicato();

                            local = funcionario5.search_empregado(Empregados, id_funcionario);
                            if (local != -1) 
                            {
                                undo.getAcoes_undo().add("taxa");
                                Empregado func_aux = new Empregado();

                                Sindicato sind_aux = new Sindicato();

                                func_aux.setName(Empregados.get(local).getName());
                                func_aux.setEndereco(Empregados.get(local).getEndereco());
                                func_aux.setTipo(Empregados.get(local).getTipo());
                                func_aux.setValor(Empregados.get(local).getValor());
                                func_aux.setId(Empregados.get(local).getId());
                                func_aux.setMetodo_pagamento(Empregados.get(local).getMetodo_pagamento());
                                func_aux.setSind(Empregados.get(local).getSind());
                                func_aux.setFreq_pagamento(Empregados.get(local).getFreq_pagamento());

                                sind_aux.setId_sindicato(Empregados.get(local).getSind().getId_sindicato());
                                sind_aux.setPart_sindicato(Empregados.get(local).getSind().getPart_sindicato());
                                sind_aux.setPorcentagem_sind(Empregados.get(local).getSind().getPorcentagem_sind());
                                sind_aux.setPorcentagem_sind_adicional(Empregados.get(local).getSind().getPorcentagem_sind_adicional());

                                func_aux.setSind(sind_aux);
                                undo.getEmpregados_undo().add(func_aux);

                                Empregados = sindicato5.registrar_taxa(Empregados, local, sindicato5, id_funcionario);
                            }
                            else
                            {
                                System.out.println("Este id não pertence a nenhum funcionário");
                            }
                            //System.out.println(funcionario5.getSind().getPorcentagem_sind_adicional());
                            System.out.println("---------------------------------------------");
                        }
                        if(opcao == 6)
                        {
                            int id_edit = 0, edit = 0, i, local;
                            System.out.println("->Digite o id do funcionario que deseja alterar: ");
                            while(cont_aux == 0)
                            {
                                try
                                {
                                    id_edit = input.nextInt();
                                    cont_aux++;
                                }
                                catch(InputMismatchException Exception)
                                {
                                    lixo = input.nextLine();
                                    System.out.println();
                                    System.out.println("Foi digitado um elemento diferente de um numero! Tente novamente...\n->Digite o id do funcionario que deseja alterar: ");
                                }
                            }   
                            cont_aux = 0;
                            System.out.println();

                            Empregado funcionario6 = new Empregado( );
                            local = funcionario6.search_empregado(Empregados, id_edit);

                            if (local != -1) 
                            {
                                System.out.println("->Digite o numero de qual opção deseja alterar no cadastro do funcionário:\n1.Nome\n2.Endereço\n3.Tipo de Funcionário\n4.Método de pagamento\n5.Associação a sindicatos\n6.Identificação no sindicato\n7.Taxa sindical\nOpçaõ: ");
                                while(cont_aux == 0)
                                {
                                    try
                                    {
                                        edit = input.nextInt();
                                        cont_aux++;
                                    }
                                    catch(InputMismatchException Exception)
                                    {
                                        lixo = input.nextLine();
                                        System.out.println();
                                        System.out.println("Foi digitado um elemento diferente de um numero! Tente novamente...\n->Digite o numero de qual opção deseja alterar no cadastro do funcionário:\n1.Nome\n2.Endereço\n3.Tipo de Funcionário\n4.Método de pagamento\n5.Associação a sindicatos\n6.Identificação no sindicato\n7.Taxa sindical\nOpçaõ: ");
                                    }
                                }   
                                cont_aux = 0;

                                String lixo3 = new String();
                                lixo3 = input.nextLine();

                                undo.getAcoes_undo().add("edit");
                                Sindicato sind_aux = new Sindicato();

                                sind_aux.setId_sindicato(Empregados.get(local).getSind().getId_sindicato());
                                sind_aux.setPart_sindicato(Empregados.get(local).getSind().getPart_sindicato());
                                sind_aux.setPorcentagem_sind(Empregados.get(local).getSind().getPorcentagem_sind());
                                sind_aux.setPorcentagem_sind_adicional(Empregados.get(local).getSind().getPorcentagem_sind_adicional());

                                if(Empregados.get(local).getTipo().equals("assalariado"))
                                {
                                    Assalariado func_aux = new Assalariado();

                                    func_aux.setName(Empregados.get(local).getName());
                                    func_aux.setEndereco(Empregados.get(local).getEndereco());
                                    func_aux.setTipo(Empregados.get(local).getTipo());
                                    func_aux.setValor(Empregados.get(local).getValor());
                                    func_aux.setId(Empregados.get(local).getId());
                                    func_aux.setMetodo_pagamento(Empregados.get(local).getMetodo_pagamento());
                                    func_aux.setSind(Empregados.get(local).getSind());
                                    func_aux.setFreq_pagamento(Empregados.get(local).getFreq_pagamento());

                                    func_aux.setSind(sind_aux);
                                    undo.getEmpregados_undo().add(func_aux);
                                    //desenvolver
                                }
                                if(Empregados.get(local).getTipo().equals("horista"))
                                {
                                    Horista func_aux = new Horista();

                                    func_aux.setName(Empregados.get(local).getName());
                                    func_aux.setEndereco(Empregados.get(local).getEndereco());
                                    func_aux.setTipo(Empregados.get(local).getTipo());
                                    func_aux.setValor(Empregados.get(local).getValor());
                                    func_aux.setId(Empregados.get(local).getId());
                                    func_aux.setMetodo_pagamento(Empregados.get(local).getMetodo_pagamento());
                                    func_aux.setSind(Empregados.get(local).getSind());
                                    func_aux.setFreq_pagamento(Empregados.get(local).getFreq_pagamento());

                                    func_aux.setSind(sind_aux);
                                    undo.getEmpregados_undo().add(func_aux);
                                    //desenvolver
                                }
                                if(Empregados.get(local).getTipo().equals("comissionado"))
                                {
                                    Comissionado func_aux = new Comissionado();

                                    func_aux.setName(Empregados.get(local).getName());
                                    func_aux.setEndereco(Empregados.get(local).getEndereco());
                                    func_aux.setTipo(Empregados.get(local).getTipo());
                                    func_aux.setValor(Empregados.get(local).getValor());
                                    func_aux.setId(Empregados.get(local).getId());
                                    func_aux.setMetodo_pagamento(Empregados.get(local).getMetodo_pagamento());
                                    func_aux.setSind(Empregados.get(local).getSind());
                                    func_aux.setFreq_pagamento(Empregados.get(local).getFreq_pagamento());

                                    func_aux.setSind(sind_aux);
                                    undo.getEmpregados_undo().add(func_aux);
                                    //desenvolver
                                }

                                funcionario6 = Empregados.get(local);
                                Empregados = funcionario6.edit(Empregados, local, funcionario6, edit, agenda);
                            }
                            else
                            {
                                System.out.println("Este id não pertence a nenhum funcionário");
                            }
                            System.out.println("---------------------------------------------");
                        }
                        if(opcao == 7)
                        {
                            Empregado funcionario7 = new Empregado();
                            System.out.println();
                            System.out.println("DATA ATUAL " + dia + "/" + mes + "/" + ano + ".");

                            undo.getAcoes_undo().add("roda");

                            int j;

                            for(j = 0; j < Empregados.size(); j++)
                            {
                                funcionario7 = Empregados.get(j);

                                if(funcionario7.getFreq_pagamento() == 3)
                                {
                                    Horista funcionario7_3 = new Horista();
                                    funcionario7_3 = (Horista)funcionario7;

                                    funcionario7_3.rodar_folha(funcionario7_3, dia_semana, dia, mes, ano);
                                }
                                if(funcionario7.getFreq_pagamento() == 2)
                                {
                                    Comissionado funcionario7_2 = new Comissionado();
                                    funcionario7_2 = (Comissionado)funcionario7;

                                    controle = funcionario7_2.rodar_folha(funcionario7_2, dia_semana, dia, mes, ano, controle);
                                }
                                if(funcionario7.getFreq_pagamento() == 1)
                                {   
                                    Assalariado funcionario7_1 = new Assalariado();
                                    funcionario7_1 = (Assalariado)funcionario7;

                                    int primeiro_dia_mes_semanal = 0;
                                    int diff = dia - dia_semana;
                                    int resto_dias_atras = diff % 7;
                                    if(resto_dias_atras == 0) //mes comecou num domingo
                                    {
                                        primeiro_dia_mes_semanal = 1;
                                    }
                                    else if(resto_dias_atras == 1) //mes comecou num sabado
                                    {
                                        primeiro_dia_mes_semanal = 7;
                                    }
                                    else if(resto_dias_atras == 2) //mes comecou numa sexta
                                    {
                                        primeiro_dia_mes_semanal = 6;
                                    }
                                    else if(resto_dias_atras == 3) //mes comecou numa quinta
                                    {
                                        primeiro_dia_mes_semanal = 5;
                                    }
                                    else if(resto_dias_atras == 4) //mes comecou numa quarta
                                    {
                                        primeiro_dia_mes_semanal = 4;
                                    }
                                    else if(resto_dias_atras == 5) //mes comecou num terca
                                    {
                                        primeiro_dia_mes_semanal = 3;
                                    }
                                    else if(resto_dias_atras == 6) //mes comecou numa segunda
                                    {
                                        primeiro_dia_mes_semanal = 2;
                                    }
                                    //----------------------------------------------------------------------------------------------
                                    funcionario7_1.rodar_folha(funcionario7_1, dia_semana, dia, mes, ano, primeiro_dia_mes_semanal);
                                }
                            }
                            if((mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12))
                            {
                                if(mes == 12 && dia == 31)
                                {
                                    mes = 1;
                                    dia = 1;
                                    ano++;
                                    if(dia_semana != 7)
                                    {
                                        dia_semana++;
                                   }
                                    else
                                    {
                                        dia_semana = 1;
                                   }
                                }
                                else if (dia != 31)
                                {
                                    dia++;
                                    if(dia_semana != 7)
                                    {
                                        dia_semana++;
                                    }
                                    else
                                    {
                                        dia_semana = 1;
                                    }
                                }
                                else if(dia == 31)
                                {
                                    dia = 1;
                                    mes++;
                                    if(dia_semana != 7)
                                    {
                                        dia_semana++;
                                    }
                                    else
                                    {
                                        dia_semana = 1;
                                    }
                                }
                            }
                            else if((mes == 4 || mes == 6 || mes == 9 || mes == 11))
                            {
                                if (dia != 30)
                                {
                                    dia++;
                                    if(dia_semana != 7)
                                    {
                                        dia_semana++;
                                    }
                                    else
                                    {
                                        dia_semana = 1;
                                    }
                                }
                                else if(dia == 30)
                                {
                                    dia = 1;
                                    mes++;
                                    if(dia_semana != 7)
                                    {
                                        dia_semana++;
                                    }
                                    else
                                    {
                                        dia_semana = 1;
                                    }
                                }
                            }
                            else if(mes == 2)
                            {
                                if (dia != 28)
                                {
                                    dia++;
                                    if(dia_semana != 7)
                                    {
                                        dia_semana++;
                                    }
                                    else
                                    {
                                        dia_semana = 1;
                                    }
                                }
                                else if (dia == 28)
                                {
                                    dia = 1;
                                    mes++;
                                    if(dia_semana != 7)
                                    {
                                        dia_semana++;
                                    }
                                    else
                                    {
                                        dia_semana = 1;
                                    }
                                }
                            }
                            System.out.println("---------------------------------------------");
                        }
                    }
                    else
                    {
                        System.out.println("Não há funcionários cadastrados");
                    }
                    if(opcao == 8)
                    {
                        System.out.println();
                        System.out.println("->Digite undo ou redo: ");
                        String acao = input.nextLine();
                        
                        if(undo.getAcoes_undo().size() > 0)
                        {
                            if(acao.equals("undo"))
                            {
                                if(undo.getAcoes_undo().size() != 0)
                                {
                                    if(undo.getAcoes_undo().get(undo.getAcoes_undo().size() - 1).equals("add"))
                                    {
                                        Empregados = undo.undo_add(redo, Empregados);
                                    }
                                    if(undo.getAcoes_undo().get(undo.getAcoes_undo().size() - 1).equals("remove"))
                                    {
                                        Empregados = undo.undo_remove(redo, Empregados);
                                    }
                                    if(undo.getAcoes_undo().get(undo.getAcoes_undo().size() - 1).equals("ponto"))
                                    {
                                        Empregados = undo.undo_geral(redo, Empregados);
                                    }
                                    if(undo.getAcoes_undo().get(undo.getAcoes_undo().size() - 1).equals("venda"))
                                    {
                                        Empregados = undo.undo_geral(redo, Empregados);
                                    }
                                    if(undo.getAcoes_undo().get(undo.getAcoes_undo().size() - 1).equals("taxa"))
                                    {
                                        Empregados = undo.undo_geral(redo, Empregados);
                                    }
                                    if(undo.getAcoes_undo().get(undo.getAcoes_undo().size() - 1).equals("edit"))
                                    {
                                        Empregados = undo.undo_geral(redo, Empregados);
                                    }
                                    if(undo.getAcoes_undo().get(undo.getAcoes_undo().size() - 1).equals("roda"))
                                    {
                                        int[] aux1 = new int[4];
                                        aux1 = undo.undo_7(redo, dia_semana, dia, mes, ano);
                                        dia_semana = aux1[0];
                                        dia = aux1[1];
                                        mes = aux1[2];
                                        ano = aux1[3];
                                    }
                                }
                            }
                        }
                        else
                        {
                            System.out.println("Não há modificações para serem desfeitas...");
                        }
                        if(acao.equals("redo"))
                        {
                            if(redo.getAcoes_redo().size() != 0)
                            {
                                if(redo.getAcoes_redo().get(redo.getAcoes_redo().size() - 1).equals("add"))
                                {
                                    Empregados = redo.redo_add(undo, Empregados);
                                }
                                if(redo.getAcoes_redo().get(redo.getAcoes_redo().size() - 1).equals("remove"))
                                {
                                    Empregados = redo.redo_remove(undo, Empregados);
                                }
                                if(redo.getAcoes_redo().get(redo.getAcoes_redo().size() - 1).equals("ponto"))
                                {
                                    Empregados = redo.redo_geral(undo, Empregados);
                                }
                                if(redo.getAcoes_redo().get(redo.getAcoes_redo().size() - 1).equals("venda"))
                                {
                                    Empregados = redo.redo_geral(undo, Empregados);
                                }
                                if(redo.getAcoes_redo().get(redo.getAcoes_redo().size() - 1).equals("taxa"))
                                {
                                    Empregados = redo.redo_geral(undo, Empregados);
                                }
                                if(redo.getAcoes_redo().get(redo.getAcoes_redo().size() - 1).equals("edit"))
                                {
                                    Empregados = redo.redo_geral(undo, Empregados);
                                }
                                if(redo.getAcoes_redo().get(redo.getAcoes_redo().size() - 1).equals("roda"))
                                {
                                    int[] aux2 = new int[4];
                                    aux2 = redo.redo_7(undo, dia_semana, dia, mes, ano);
                                    dia_semana = aux2[0];
                                    dia = aux2[1];
                                    mes = aux2[2];
                                    ano = aux2[3];
                                }
                            }
                        }
                        System.out.println("---------------------------------------------");
                    }
                    if(opcao == 9)
                    {
                        agenda.print_agenda(agenda);
                    }
                    if(opcao == 10)
                    {
                        int edit_pagamento = 0;
                        System.out.println();
                        System.out.println("Crie uma nova agenda, alterando as datas de pagamento dos funcionarios!");
                        System.out.println();
                        System.out.println("Se deseja alterar a data do mês a se pagar o assalariado, digite 1: ");
                        System.out.println("Se deseja alterar o dia da semana a se pagar o horista, digite 2: ");
                        System.out.println("Se deseja alterar o dia da semana a se pagar o comissionado, digite 3: ");
                        System.out.println("Opcao: ");
                        while(cont_aux == 0)
                        {
                            try
                            {
                                edit_pagamento = input.nextInt();
                                cont_aux++;
                            }
                            catch(InputMismatchException Exception)
                            {
                                lixo = input.nextLine();
                                System.out.println();
                                System.out.println("Foi digitado um elemento diferente de um numero! Tente novamente...\nOpcao: ");
                            }
                        }   
                        cont_aux = 0;
                        System.out.println();
                        
                        if(edit_pagamento == 1)
                        {
                            System.out.println("Digite o novo dia do mês, sendo  50, o ultimo dia util do mes...");
                            while(cont_aux == 0)
                            {
                                try
                                {
                                    agenda.setDia_mes(input.nextInt());
                                    cont_aux++;
                                }
                                catch(InputMismatchException Exception)
                                {
                                    lixo = input.nextLine();
                                    System.out.println();
                                    System.out.println("Foi digitado um elemento diferente de um numero! Tente novamente...\nDigite o novo dia do mês, sendo  50, o ultimo dia util do mes...");
                                }
                            }   
                            cont_aux = 0;
                            Empregados = agenda.add_new_agenda_ass(Empregados, agenda);
                        }
                        if(edit_pagamento == 2)
                        {
                            System.out.println("Digite o novo dia da semana da forma a seguir:\nSegunda-Feira: 2\nTerca-Feira: 3\nQuarta-Feira: 4\nQuinta-Feira: 5\nSexta-Feira: 6");
                            System.out.println("Dia: ");
                            while(cont_aux == 0)
                            {
                                try
                                {
                                    agenda.setDia_semana(input.nextInt());
                                    cont_aux++;
                                }
                                catch(InputMismatchException Exception)
                                {
                                    lixo = input.nextLine();
                                    System.out.println();
                                    System.out.println("Foi digitado um elemento diferente de um numero! Tente novamente...\nDigite o novo dia da semana da forma a seguir:\nSegunda-Feira: 2\nTerca-Feira: 3\nQuarta-Feira: 4\nQuinta-Feira: 5\nSexta-Feira: 6\nDia: ");
                                }
                            }   
                            cont_aux = 0;
                            Empregados = agenda.add_new_agenda_hor(Empregados, agenda);
                        }
                        if(edit_pagamento == 3)
                        {
                            System.out.println("Digite o novo dia da semana da forma a seguir:\nSegunda-Feira: 2\nTerca-Feira: 3\nQuarta-Feira: 4\nQuinta-Feira: 5\nSexta-Feira: 6");
                            System.out.println("Dia: ");
                            while(cont_aux == 0)
                            {
                                try
                                {
                                    agenda.setDia_semana15(input.nextInt());
                                    cont_aux++;
                                }
                                catch(InputMismatchException Exception)
                                {
                                    lixo = input.nextLine();
                                    System.out.println();
                                    System.out.println("Foi digitado um elemento diferente de um numero! Tente novamente...\nDigite o novo dia da semana da forma a seguir:\nSegunda-Feira: 2\nTerca-Feira: 3\nQuarta-Feira: 4\nQuinta-Feira: 5\nSexta-Feira: 6\nDia: ");
                                }
                            }   
                            cont_aux = 0;
                            Empregados = agenda.add_new_agenda_com(Empregados, agenda);
                        }
                        System.out.println();
                        System.out.println("Operação concluida com sucesso...\n");
                        System.out.println("---------------------------------------------");
                    }
                    
                    System.out.println();
                    System.out.println("DATA ATUAL " + dia + "/" + mes + "/" + ano + ".");
                    int j;      
                    System.out.println("Seus funcioários:");
                    for(j = 0; j < Empregados.size(); j++)
                    {
                        System.out.println("-" + Empregados.get(j).getName());
                    }
                    System.out.println("---------------------------------------------");
                    System.out.println();
                    System.out.println("Digite a proxima funcao caso deseje execultar, caso contrário, digite 11 para fechar o programa...");
                    System.out.println();
                    System.out.print("Digite a opção de qual função deseja execultar...\n");
                    System.out.println();
                    System.out.print("1 . Adição de um empregado\n");
                    System.out.print("2 . Remoção de um empregado\n");
                    System.out.print("3 . Lançar um Cartão de Ponto\n");
                    System.out.print("4 . Lançar um Resultado Venda\n");
                    System.out.print("5 . Lançar uma taxa de serviço\n");
                    System.out.print("6 . Alterar detalhes de um empregado\n");
                    System.out.print("7 . Rodar a folha de pagamento para hoje\n");
                    System.out.print("8 . Undo/redo\n");
                    System.out.print("9 . Agenda de Pagamento\n");
                    System.out.print("10 . Criação de Novas Agendas de Pagamento\n");
                    System.out.println();
                    System.out.print("Opção: \n"); 
                }
        }
}
