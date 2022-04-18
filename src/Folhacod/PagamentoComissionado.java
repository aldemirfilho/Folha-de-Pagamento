package Folhacod;

public class PagamentoComissionado {
    int dia_da_semana;
    int data_mes;
    float quinzena_final;

    public float getQuinzena_final() {
        return quinzena_final;
    }

    public void setQuinzena_final(float quinzena_final) {
        this.quinzena_final = quinzena_final;
    }

    public int getData_mes() {
        return data_mes;
    }

    public void setData_mes(int data_mes) {
        this.data_mes = data_mes;
    }
    
    public int getDia_da_semana() {
        return dia_da_semana;
    }

    public void setDia_da_semana(int dia_da_semana) {
        this.dia_da_semana = dia_da_semana;
    }
}
