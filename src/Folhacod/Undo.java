package Folhacod;

import java.util.ArrayList;

public class Undo 
{
    java.util.ArrayList<Empregado> Empregados_undo = new java.util.ArrayList<>();
    java.util.ArrayList<String> acoes_undo = new java.util.ArrayList<>();
    
    public java.util.ArrayList<Empregado> undo_add(Redo redo, java.util.ArrayList<Empregado> Empregados)
    {
        int local, tam = Empregados_undo.size() - 1;
        int id_removed = Empregados_undo.get(tam).getId();
        Empregado funcionario = new Empregado();
        local = funcionario.search_empregado(Empregados, id_removed);
        if (local != -1) 
        {
            redo.getAcoes_redo().add("remove");
            redo.getEmpregados_redo().add(Empregados.get(local));

            Empregados.remove(local);
            Empregados_undo.remove(tam);
            //System.out.println("Removido com sucesso");
        }
        return Empregados;
    }
    
    public java.util.ArrayList<Empregado> undo_remove(Redo redo, java.util.ArrayList<Empregado> Empregados)
    {
        int tam = Empregados_undo.size() - 1;
        Empregados.add(Empregados_undo.get(tam));

        redo.getAcoes_redo().add("add");
        redo.getEmpregados_redo().add(Empregados_undo.get(tam));

        Empregados_undo.remove(tam);
        return Empregados;
    }
    
    public java.util.ArrayList<Empregado> undo_geral(Redo redo, java.util.ArrayList<Empregado> Empregados)
    {
        int local, tam = Empregados_undo.size() - 1;
        int id_corrige = Empregados_undo.get(tam).getId();
        Empregado funcionario = new Empregado();
        local = funcionario.search_empregado(Empregados, id_corrige);
        if (local != -1) 
        {
            if(acoes_undo.get(acoes_undo.size() - 1).equals("ponto"))
            {
                redo.getAcoes_redo().add("ponto");
            }
            if(acoes_undo.get(acoes_undo.size() - 1).equals("venda"))
            {
                redo.getAcoes_redo().add("venda");
            }
            if(acoes_undo.get(acoes_undo.size() - 1).equals("taxa"))
            {
                redo.getAcoes_redo().add("taxa");
            }
            if(acoes_undo.get(acoes_undo.size() - 1).equals("edit"))
            {
                redo.getAcoes_redo().add("edit");
            }
            
            redo.getEmpregados_redo().add(Empregados.get(local));
            Empregados.set(local, Empregados_undo.get(tam));
            Empregados_undo.remove(tam);
        }
        return Empregados;
    }
    
    public int[] undo_7(Redo redo, int dia_semana, int dia, int mes, int ano)
    {
        int[] aux = new int[4];
        int tam = acoes_undo.size() - 1;
        if ((mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12)) 
        {//31
            if (mes == 1 && dia == 1) {
                mes = 12;
                dia = 31;
                ano--;
                if (dia_semana != 1) {
                    dia_semana--;
                } else {
                    dia_semana = 7;
                }
            } else if (mes == 3) {
                if (dia != 1) {
                    dia--;
                    if (dia_semana != 1) {
                        dia_semana--;
                    } else {
                        dia_semana = 7;
                    }
                } else if (dia == 1) {
                    dia = 28;
                    mes--;
                    if (dia_semana != 1) {
                        dia_semana--;
                    } else {
                        dia_semana = 7;
                    }
                }
            } else if (dia != 1) {
                dia--;
                if (dia_semana != 1) {
                    dia_semana--;
                } else {
                    dia_semana = 7;
                }
            } else if (dia == 1) {
                dia = 31;
                mes--;
                if (dia_semana != 1) {
                    dia_semana--;
                } else {
                    dia_semana = 7;
                }
            }
        } else if ((mes == 4 || mes == 6 || mes == 9 || mes == 11)) {
            if (dia != 1) {
                dia--;
                if (dia_semana != 1) {
                    dia_semana--;
                } else {
                    dia_semana = 7;
                }
            } else if (dia == 1) {
                dia = 30;
                mes--;
                if (dia_semana != 1) {
                    dia_semana--;
                } else {
                    dia_semana = 7;
                }
            }
        } else if (mes == 2) {
            if (dia != 1) {
                dia--;
                if (dia_semana != 1) {
                    dia_semana--;
                } else {
                    dia_semana = 7;
                }
            } else if (dia == 1) {
                dia = 31;
                mes--;
                if (dia_semana != 1) {
                    dia_semana--;
                } else {
                    dia_semana = 7;
                }
            }
        }
        redo.getAcoes_redo().add("roda");
        acoes_undo.remove(tam);
        aux[0] = dia_semana;
        aux[1] = dia;
        aux[2] = mes;
        aux[3] = ano;
        return aux;
    }

    public ArrayList<String> getAcoes_undo() {
        return acoes_undo;
    }

    public void setAcoes_undo(ArrayList<String> acoes_undo) {
        this.acoes_undo = acoes_undo;
    }
    
    public ArrayList<Empregado> getEmpregados_undo() {
        return Empregados_undo;
    }

    public void setEmpregados_undo(ArrayList<Empregado> Empregados_undo) {
        this.Empregados_undo = Empregados_undo;
    }
}
