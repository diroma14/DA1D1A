package objetos;

public class Libro {

    // Atributos
    private String titulo;
    private String autor;
    private Integer isbn;
    private Integer numPaginas;
    private String tipo;
    private String formato;
    private String idioma;
    private Integer añoPublicacion;
    private Boolean disponible;

    // Constructor
    public Libro(String titulo, String autor, Integer isbn, Integer numPaginas, String tipo, String formato,
            String idioma, Integer añoPublicacion, Boolean disponible) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.numPaginas = numPaginas;
        this.tipo = tipo;
        this.formato = formato;
        this.idioma = idioma;
        this.añoPublicacion = añoPublicacion;
        this.disponible = disponible;
    }

    // Getters y setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Integer getIsbn() {
        return isbn;
    }

    public void setIsbn(Integer isbn) {
        this.isbn = isbn;
    }

    public Integer getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(Integer numPaginas) {
        this.numPaginas = numPaginas;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Integer getAñoPublicacion() {
        return añoPublicacion;
    }

    public void setAñoPublicacion(Integer añoPublicacion) {
        this.añoPublicacion = añoPublicacion;
    }

    public Boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }

    // Métodos
    // Método época
    public String epoca() {
        Integer fecha = getAñoPublicacion();
        String epoca;

        if (fecha < 1800) {
            System.out.println("Libro antiguo.");
            epoca = "Antiguo";
            return epoca;
        } else if (fecha >= 1800 && fecha <= 2000) {
            System.out.println("Libro moderno.");
            epoca = "Moderno";
            return epoca;
        } else {
            System.out.println("Libro contemporaneo.");
            epoca = "Contemporaneo";
            return epoca;
        }

    }

    // Método prestar libro
    public void prestarLibro() {
        if (disponible) {
            System.out.println("Se te ha prestado el libro.");
            setDisponible(false);
        } else {
            System.out.println("El libro ya ha sido prestado, vuelve en otro momento.");
        }
    }

    // Método devolver libro
    public void devolverLibro() {
        if (!disponible) {
            System.out.println("Se ha devuelto el libro, muchas gracias.");
            setDisponible(true);
        } else {
            System.out.println("El libro ya ha sido devuelto anteriormente.");
        }
    }

    // Método calcular tiempo lectura
    public void calcularTiempoLectura() {
        String epoca = epoca().toLowerCase();
        String tipo = getTipo().toLowerCase();
        // System.out.println(epoca + " " + tipo);
        switch (epoca) {
            case "antiguo":
                switch (tipo) {
                    case "ficcion":
                        System.out.println("40 páginas por hora.");
                        break;

                    case "academico":
                        System.out.println("20 páginas por hora.");
                        break;

                    case "biografias":
                        System.out.println("40 páginas por hora.");
                        break;

                    case "historia":
                        System.out.println("30 páginas por hora.");
                        break;

                    case "poesia":
                        System.out.println("10 páginas por hora.");
                        break;

                    default:
                        System.out.println("Tipo no encontrado");
                        break;
                }
                break;
            case "moderno":
                switch (tipo) {
                    case "ficcion":
                        System.out.println("50 páginas por hora.");
                        break;

                    case "academico":
                        System.out.println("30 páginas por hora.");
                        break;

                    case "biografias":
                        System.out.println("50 páginas por hora.");
                        break;

                    case "historia":
                        System.out.println("40 páginas por hora.");
                        break;

                    case "poesia":
                        System.out.println("20 páginas por hora.");
                        break;

                    default:
                        System.out.println("Tipo no encontrado");
                        break;
                }
                break;
            case "contemporaneo":

                switch (tipo) {
                    case "ficcion":
                        System.out.println("60 páginas por hora.");
                        break;

                    case "academico":
                        System.out.println("40 páginas por hora.");
                        break;

                    case "biografias":
                        System.out.println("60 páginas por hora.");
                        break;

                    case "historia":
                        System.out.println("50 páginas por hora.");
                        break;

                    case "poesia":
                        System.out.println("30 páginas por hora.");
                        break;

                    default:
                        System.out.println("Tipo no encontrado");
                        break;
                }
                break;

            default:
                System.out.println("Época no encontrada");
                break;
        }
    }

    //Método clasificar por páginas
    public void clasificarPorPáginas(){
        Integer paginas = getNumPaginas();
        if (paginas < 100) {
            System.out.println("Corto");
        }else if(paginas >= 100 && paginas <= 300){
            System.out.println("Mediano");
        }else{
            System.out.println("Extenso");
        }
    }

    //Método calcular costo prestamo
    public void calcularCostoPrestamo(){
        String formato = getFormato().toLowerCase();
        Double paginas = getNumPaginas().doubleValue();
        Double costo;

        switch (formato) {
            case "fisico":
                costo = paginas*0.005/10;
                System.out.println(costo);
                break;

                case "digital":
                costo = paginas*0.003/10;
                System.out.println(costo);
                break;

                case "audiolibro":
                costo = paginas*0.003/10;
                System.out.println(costo);
                break;
        
            default:
            System.out.println("Formato no encontrado");
                break;
        }
    }

    // Main
    public static void main(String[] args) {
        Libro libro1 = new Libro("El Lazarillo de Tormes", "Diego Hurtado De Mendoza", 202122, 128, "Ficcion", "Fisico", "Español", 1554, true);
        libro1.epoca();
        libro1.prestarLibro();
        libro1.prestarLibro();
        libro1.devolverLibro();
        libro1.devolverLibro();
        libro1.calcularTiempoLectura();
        libro1.clasificarPorPáginas();
        libro1.calcularCostoPrestamo();
    }
}
