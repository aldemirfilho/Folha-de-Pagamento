package Folhacod;

import java.util.ArrayList;

public class Redo
{
    java.util.ArrayList<Empregado> Empregados_redo = new java.util.ArrayList<>();
    java.util.ArrayList<String> acoes_redo = new java.util.ArrayList<>();
    
    public java.util.ArrayList<Empregado> redo_add(Undo undo, java.util.ArrayList<Empregado> Empregados)
    {
        int local, tam = Empregados_redo.size() - 1;
        int id_removed = Empregados_redo.get(tam).getId();
        Empregado funcionario = new Empregado();
        local = funcionario.search_empregado(Empregados, id_removed);
        if (local != -1) {
            undo.getAcoes_undo().add("remove");
            undo.getEmpregados_undo().add(Empregados_redo.get(tam));

            Empregados.remove(local);
            Empregados_redo.remove(tam);
            //System.out.println("Removido com sucesso");
        }
        return Empregados;
    }
    
    public java.util.ArrayList<Empregado> redo_remove(Undo undo, java.util.ArrayList<Empregado> Empregados)
    {
        int tam = Empregados_redo.size() - 1;
        Empregados.add(Empregados_redo.get(tam));

        undo.getAcoes_undo().add("add");
        undo.getEmpregados_undo().add(Empregados_redo.get(tam));

        Empregados_redo.remove(tam);
        return Empregados;
    }
    
     public java.util.ArrayList<Empregado> redo_geral(Undo undo, java.util.ArrayList<Empregado> Empregados)
    {
        int local, tam = Empregados_redo.size() - 1;
        int id_corrige = Empregados_redo.get(tam).getId();
        Empregado funcionario = new Empregado();
        local = funcionario.search_empregado(Empregados, id_corrige);
        if (local != -1) 
        {
            if(acoes_redo.get(acoes_redo.size() - 1).equals("ponto"))
            {
                undo.getAcoes_undo().add("ponto");
            }
            if(acoes_redo.get(acoes_redo.size() - 1).equals("venda"))
            {
                undo.getAcoes_undo().add("venda");
            }
            if(acoes_redo.get(acoes_redo.size() - 1).equals("taxa"))
            {
                undo.getAcoes_undo().add("taxa");
            }
            if(acoes_redo.get(acoes_redo.size() - 1).equals("edit"))
            {
                undo.getAcoes_undo().add("edit");
            }
            
            undo.getEmpregados_undo().add(Empregados.get(local));
            Empregados.set(local, Empregados_redo.get(tam));
            Empregados_redo.remove(tam);
        }
        return Empregados;
    }
     
    public int[] redo_7(Undo undo, int dia_semana, int dia, int mes, int ano)
    {
        int[] aux = new int[4];
        int tam =  acoes_redo.size() - 1;
        if ((mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12)) 
        {
            if (mes == 12 && dia == 31) {
                mes = 1;
                dia = 1;
                ano++;
                if (dia_semana != 7) {
                    dia_semana++;
                } else {
                    dia_semana = 1;
                }
            } else if (dia != 31) {
                dia++;
                if (dia_semana != 7) {
                    dia_semana++;
                } else {
                    dia_semana = 1;
                }
            } else if (dia == 31) {
                dia = 1;
                mes++;
                if (dia_semana != 7) {
                    dia_semana++;
                } else {
                    dia_semana = 1;
                }
            }
        } else if ((mes == 4 || mes == 6 || mes == 9 || mes == 11)) {
            if (dia != 30) {
                dia++;
                if (dia_semana != 7) {
                    dia_semana++;
                } else {
                    dia_semana = 1;
                }
            } else if (dia == 30) {
                dia = 1;
                mes++;
                if (dia_semana != 7) {
                    dia_semana++;
                } else {
                    dia_semana = 1;
                }
            }
        } else if (mes == 2) {
            if (dia != 28) {
                dia++;
                if (dia_semana != 7) {
                    dia_semana++;
                } else {
                    dia_semana = 1;
                }
            } else if (dia == 28) {
                dia = 1;
                mes++;
                if (dia_semana != 7) {
                    dia_semana++;
                } else {
                    dia_semana = 1;
                }
            }
        }
        undo.getAcoes_undo().add("roda");
        acoes_redo.remove(tam);
        aux[0] = dia_semana;
        aux[1] = dia;
        aux[2] = mes;
        aux[3] = ano;
        return aux;
    }

    public ArrayList<String> getAcoes_redo() {
        return acoes_redo;
    }

    public void setAcoes_redo(ArrayList<String> acoes_redo) {
        this.acoes_redo = acoes_redo;
    }

    public ArrayList<Empregado> getEmpregados_redo() {
        return Empregados_redo;
    }

    public void setEmpregados_redo(ArrayList<Empregado> Empregados_undo) {
        this.Empregados_redo = Empregados_undo;
    }
}
