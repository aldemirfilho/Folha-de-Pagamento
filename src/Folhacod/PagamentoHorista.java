package Folhacod;

public class PagamentoHorista {
    int dia_da_semana;
    int mes;
    private int horas_trabalhadas;
    private int extras;

    public int getHoras_trabalhadas() {
        return horas_trabalhadas;
    }

    public void setHoras_trabalhadas(int horas_trabalhadas) {
        this.horas_trabalhadas = horas_trabalhadas;
    }

    public int getExtras() {
        return extras;
    }

    public void setExtras(int extras) {
        this.extras = extras;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }
    float semanal_final;

    public float getSemanal_final() {
        return semanal_final;
    }

    public void setSemanal_final(float semanal_final) {
        this.semanal_final = semanal_final;
    }

    public int getDia_da_semana() {
        return dia_da_semana;
    }

    public void setDia_da_semana(int dia_da_semana) {
        this.dia_da_semana = dia_da_semana;
    }
}
