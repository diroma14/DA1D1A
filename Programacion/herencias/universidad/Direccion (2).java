package universidad;

public class Direccion {
    private String calle;
    private String ciudad;
    private Integer codigoPostal;
    private String pais;

    //Constructor parametrizado
    public Direccion(String calle, String ciudad, Integer codigoPostal, String pais) {
        this.calle = calle;
        this.ciudad = ciudad;
        this.codigoPostal = codigoPostal;
        this.pais = pais;
    }

    //Constructor predeterminado

    public Direccion() {
        this.calle = "Calle Calleja";
        this.ciudad = "Torrejón De Ardoz";
        this.codigoPostal = 99999;
        this.pais = "España";
    }

    //Setters y getters
    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Integer getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(Integer codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    //Main
    

}
