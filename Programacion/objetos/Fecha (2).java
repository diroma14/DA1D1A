package objetos;

public class Fecha {
    private Integer dia;
    private Integer mes;
    private Integer año;

    

    //Constructor Parametrizado
    public Fecha(Integer dia, Integer mes, Integer año) {
        this.dia = dia;
        this.mes = mes;
        this.año = año;
        valida();
    }

    //Constructor por defecto
    public Fecha(){
        this.dia = 1;
        this.mes = 1;
        this.año = 1900;
    }

    //Setters y getters 
    public Integer getDia() {
        return dia;
    }

    public void setDia(Integer dia) {
        this.dia = dia;
    }

    public Integer getMes() {
        return mes;
    }

    public void setMes(Integer mes) {
        this.mes = mes;
    }

    public Integer getAño() {
        return año;
    }

    public void setAño(Integer año) {
        this.año = año;
    }

    //Funciones
    
    public void leer(int dia,int mes,int año){
        if (!(dia >= 1 && dia <= 31)) {
            System.out.println("El día debe de estar entre el 1 y el 31");
        }else if(!(mes >= 1 && mes <= 12)){
            System.out.println("El mes debe de estar entre el 1 y el 12");
        }else if(!(año >= 1900 && año <= 2050)){
            System.out.println("El año debe de estar entre 1900 y 2050");
        }else{
            setAño(año);
            setMes(mes);
            setDia(dia);
            System.out.println("Se ha actualizado la fecha.");
        }
    }

    public boolean bisiesto() {
        int año = this.año;
        if ((año % 4 == 0 && año % 100 != 0) || (año % 400 == 0)) {
            return true; 
        } else {
            return false; 
        }
    }
    
    public int diaMes(){
        int mes = this.mes;
        if(mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12){
            return 31;
        }else if(mes == 4 || mes == 6 || mes == 9 || mes == 11){
            return 30;
        }else if(mes == 2 && bisiesto()){
            return 28;
        }else{
            return 29;
        }
    }

    private void valida(){
        año = getAño();
        mes = getMes();
        dia = getDia();
        
        if(dia < 1 || dia > diaMes()){
            System.out.println("Día incorrecto. Cambiado al 1.");
            setDia(1);
        }
        if(mes < 1 || mes > 12){
            System.out.println("Mes incorrecto. Cambiado al 1.");
            setMes(1);
        }
        if(año < 1900 || año > 2050 ){
            System.out.println("Año incorrecto. Cambiado al 1900.");
            setAño(1900);
        }
    }

    //Main
    public static void main(String[] args) {
        Fecha fecha1 = new Fecha();
        fecha1.leer(30, 2, 2000);
        System.out.println("Bisiesto:" + fecha1.bisiesto());
        System.out.println("El mes tiene los siguientes días " + fecha1.diaMes());
        System.out.println("");
        Fecha fecha2 = new Fecha(28, 2, 1902);
    }
}
