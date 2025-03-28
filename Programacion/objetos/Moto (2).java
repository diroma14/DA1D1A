package objetos;

public class Moto {
    //Atributos
    private Integer litros_deposito;
    private String modelo;
    private Integer cilindrada;
    private Integer caballos;
    private String matricula;

    

    //Constructor

    //Setters y getters

    public Integer getLitros_deposito() {
        return this.litros_deposito;
    }

    public void setLitros_deposito(Integer litros_deposito) {
        this.litros_deposito = litros_deposito;
    }

    public String getModelo() {
        return this.modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getCilindrada() {
        return this.cilindrada;
    }

    public void setCilindrada(Integer cilindrada) {
        this.cilindrada = cilindrada;
    }

    public Integer getCaballos() {
        return this.caballos;
    }

    public void setCaballos(Integer caballos) {
        this.caballos = caballos;
    }

    public String getMatricula() {
        return this.matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}
