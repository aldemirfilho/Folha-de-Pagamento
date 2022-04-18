package Folhacod;

import java.util.ArrayList;

public class Agenda {
    int semanalmente;
    int dia_semana;
    
    int quinzenal;
    int dia_semana15;
    
    int mensal;
    int dia_mes;

    public void print_agenda(Agenda agenda)
    {
        String dia_s, dia_s15;
        System.out.println();
        System.out.println("                         AGENDA\n");
        System.out.println("A agenda de pagamento esta organizada da seguinte forma: \n");
        //-----------------------------Horistas----------------------------------------
        if (agenda.getDia_semana() == 1) {
            dia_s = "Domingo";
            System.out.println("-Os horistas sao pagos toda semana no " + dia_s + ".");
        } else if (agenda.getDia_semana() == 2) {
            dia_s = "Segunda-Feira";
            System.out.println("-Os horistas sao pagos toda semana na " + dia_s + ".");
        } else if (agenda.getDia_semana() == 3) {
            dia_s = "Terca-Feira";
            System.out.println("-Os horistas sao pagos toda semana na " + dia_s + ".");
        } else if (agenda.getDia_semana() == 4) {
            dia_s = "Quarta-Feira";
            System.out.println("-Os horistas sao pagos toda semana na " + dia_s + ".");
        } else if (agenda.getDia_semana() == 5) {
            dia_s = "Quinta-Feira";
            System.out.println("-Os horistas sao pagos toda semana na " + dia_s + ".");
        } else if (agenda.getDia_semana() == 6) {
            dia_s = "Sexta-Feira";
            System.out.println("-Os horistas sao pagos toda semana na " + dia_s + ".");
        } else if (agenda.getDia_semana() == 7) {
            dia_s = "Sabado";
            System.out.println("-Os horistas sao pagos toda semana no " + dia_s + ".");
        }
        System.out.println();
        //-------------------------------comissionados-------------------------------------
        if (agenda.getDia_semana15() == 1) {
            dia_s15 = "Domingo";
            System.out.println("-Os comissionados sao pagos a cada duas semanas no " + dia_s15 + ".");
        } else if (agenda.getDia_semana15() == 2) {
            dia_s15 = "Segunda-Feira";
            System.out.println("-Os comissionados sao pagos a cada duas semanas na " + dia_s15 + ".");
        } else if (agenda.getDia_semana15() == 3) {
            dia_s15 = "Terca-Feira";
            System.out.println("-Os comissionados sao pagos a cada duas semanas na " + dia_s15 + ".");
        } else if (agenda.getDia_semana15() == 4) {
            dia_s15 = "Quarta-Feira";
            System.out.println("-Os comissionados sao pagos a cada duas semanas na " + dia_s15 + ".");
        } else if (agenda.getDia_semana15() == 5) {
            dia_s15 = "Quinta-Feira";
            System.out.println("-Os comissionados sao pagos a cada duas semanas na " + dia_s15 + ".");
        } else if (agenda.getDia_semana15() == 6) {
            dia_s15 = "Sexta-Feira";
            System.out.println("-Os comissionados sao pagos a cada duas semanas na " + dia_s15 + ".");
        } else if (agenda.getDia_semana15() == 7) {
            dia_s15 = "Sabado";
            System.out.println("-Os comissionados sao pagos a cada duas semanas no " + dia_s15 + ".");
        }
        System.out.println();
        //-------------------------------assalariado-------------------------------------

        if (agenda.getDia_mes() == 50) {
            System.out.println("-Os assalariados sao pagos todo mês no ultimo dia util do mês.");
        } else {
            System.out.println("-Os assalariados sao pagos todo mês no dia " + agenda.getDia_mes() + ".");
        }
        System.out.println();
        System.out.println("---------------------------------------------");
        System.out.println();
    }
    
    public java.util.ArrayList<Empregado> add_new_agenda_ass(java.util.ArrayList<Empregado> Empregados, Agenda agenda)
    {
        int k, tam = Empregados.size();
        for (k = 0; k < tam; k++) 
        {
            if(Empregados.get(k).getTipo().equals("assalariado")) 
            {
                Assalariado funcionario_aux = new Assalariado();
                funcionario_aux = (Assalariado) Empregados.get(k);

                funcionario_aux.setDia_mes_1(agenda.getDia_mes());
                Empregados.set(k, funcionario_aux);
            }
        }
        return Empregados;
    }
    
    public java.util.ArrayList<Empregado> add_new_agenda_hor(java.util.ArrayList<Empregado> Empregados, Agenda agenda)
    {
        int k, tam = Empregados.size();
        for (k = 0; k < tam; k++) 
        {
            if (Empregados.get(k).getTipo().equals("horista")) 
            {
                Horista funcionario_aux = new Horista();
                funcionario_aux = (Horista) Empregados.get(k);

                funcionario_aux.setDia_semana_1(agenda.getDia_semana());
                Empregados.set(k, funcionario_aux);
            }
        }
        return Empregados;
    }
    
    public java.util.ArrayList<Empregado> add_new_agenda_com(java.util.ArrayList<Empregado> Empregados, Agenda agenda)
    {
        int k, tam = Empregados.size();
        for (k = 0; k < tam; k++) 
        {
            if (Empregados.get(k).getTipo().equals("comissionado")) 
            {
                Comissionado funcionario_aux = new Comissionado();
                funcionario_aux = (Comissionado) Empregados.get(k);

                funcionario_aux.setDia_semana15(agenda.getDia_semana15());
                Empregados.set(k, funcionario_aux);
            }
        }
        return Empregados;
    }
    
    public int getDia_semana() {
        return dia_semana;
    }

    public void setDia_semana(int dia_semana) {
        this.dia_semana = dia_semana;
    }

    public int getDia_semana15() {
        return dia_semana15;
    }

    public void setDia_semana15(int dia_semana15) {
        this.dia_semana15 = dia_semana15;
    }

    public int getDia_mes() {
        return dia_mes;
    }

    public void setDia_mes(int dia_mes) {
        this.dia_mes = dia_mes;
    }

    public int getSemanalmente() {
        return semanalmente;
    }

    public void setSemanalmente(int semanalmente) {
        this.semanalmente = semanalmente;
    }

    public int getQuinzenal() {
        return quinzenal;
    }

    public void setQuinzenal(int quinzenal) {
        this.quinzenal = quinzenal;
    }

    public int getMensal() {
        return mensal;
    }

    public void setMensal(int mensal) {
        this.mensal = mensal;
    }
}

