package objetos;

public class Personaje {
    // Atributos
    private String nombre;
    private String clase;
    private Integer nivel;
    private double hp;
    private double hpMax;
    private Integer atk;

    // Constructor

    public Personaje(String nombre, String clase, Integer nivel, Integer hp, Integer hpMax, Integer atk) {
        this.nombre = nombre;
        this.clase = clase;
        this.nivel = nivel;
        this.hp = hp;
        this.hpMax = hpMax;
        this.atk = atk;
    }

    // Métodos

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClase() {
        return this.clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public Integer getNivel() {
        return this.nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public double getHp() {
        return this.hp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

    public double getHpMax() {
        return this.hpMax;
    }

    public void setHpMax(Integer hpMax) {
        this.hpMax = hpMax;
    }

    public Integer getAtk() {
        return this.atk;
    }

    public void setAtk(Integer atk) {
        this.atk = atk;
    }

    // Métodos

    // Atacar
    public void atacar(Personaje objetivo) {
        if (hp == 0) {
            System.out.println(nombre + " no puede atacar porque ha muerto.");
        } else if (objetivo.hp == 0) {
            System.out.println(nombre + " no puede atacar a un personaje muerto. " + nombre + " no tiene honor.");
        } else {
            objetivo.hp = objetivo.hp - atk;
            System.out.println(nombre + " ha infligido " + atk + " puntos de daño a " + objetivo.nombre + ".");
            if (objetivo.hp <= 0) {
                System.out.println(nombre + " ha derrotado a " + objetivo.nombre + ".");
                objetivo.hp = 0;
            }
        }

        System.out.println("");
    }

    // Curar
    public void curar() {
        if (hp == 0) {
            System.out.println(nombre + " no puede curarse porque ha muerto.");
        }else if(hp == hpMax){
            System.out.println(nombre + " no puede curarse porque tiene la vida al máximo.");
        }else {
            System.out.println(nombre + " se ha curado " + (hp + (0.3 * hpMax)) + " hp.");
            hp = hp + (0.3 * hpMax);
            if (hp > hpMax) {
                hp = hpMax;
            }
            System.out.println(nombre + " tiene " + hp + " hp.");
            System.out.println("");
        }
        
        

    }

    // Subir de nivel
    public void subirDeNivel() {
        nivel = nivel + 1;
        System.out.println(nombre + " ha subido de nivel, ahora es de nivel " + nivel + " .");
        hpMax = hpMax + hpMax * 0.5;
        System.out.println("Los puntos de vida máximos de " + nombre + " han aumentado a " + hpMax + " .");
        atk = (int) Math.round(atk + atk * 0.3);
        System.out.println("Los puntos de ataque de " + nombre + " han aumentado a " + atk + " ." );
        System.out.println("");
    }

    // Main
    public static void main(String[] args) {
        Personaje Uthat = new Personaje("Uthat", "Bárcaro", 2, 33, 33, 8);
        Personaje Bilko = new Personaje("Bilko", "Pícaro", 2, 20, 20, 5);

        Uthat.atacar(Bilko);
        Uthat.atacar(Bilko);
        
        

        Bilko.atacar(Uthat);

        Bilko.curar();
        Bilko.curar();
        Bilko.curar();
        Bilko.curar();
        
        Bilko.subirDeNivel();
        Uthat.subirDeNivel();
        Uthat.subirDeNivel();

    }
}

// Cosas que añadir





//Cosas añadidas
//// No se puede atacar/curar si estás muerto.
/// // Al curarte no puedes pasar tus puntos de vida máximos.