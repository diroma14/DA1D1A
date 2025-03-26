import java.util.Scanner;

public class luis {

    /*
        Registro de un hospital, permite al usuario registrarse e iniciar sesión, una vez dentro el usuario puede actualizar sus datos personales
         y pedir o revisar sus citas.
    */
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);


        Integer seguir = 1;
        Integer opcion;
        String usuario_almacenado = "aaa";
        String usuario;
        String contrasena1 = "aaa";
        String contrasena2 = "aaa";
        Integer iniciar = 0;
        Integer opcionSesion;
        String datos = "aa";
        int cita = 0;
        
        
        do{
            System.out.println("Elige una opción:");
            System.out.println("1.Iniciar sesión.");
            System.out.println("2.Registrarse.");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                        System.out.println("Iniciaste sesión.");
                        System.out.println("");
                        System.out.println("Introduce el usuario:");
                        System.out.println("");
                        usuario = sc.nextLine();
                        System.out.println("Introduce la contraseña:");
                        System.out.println("");
                        contrasena1 = sc.nextLine();

                        if (usuario_almacenado.equals(usuario) && contrasena1.equals(contrasena2)) {
                            System.out.println("Iniciaste sesión.");
                            System.out.println("");

                            iniciar = 1;

                            do{
                                System.out.println("Bienvenid@ " + usuario + " elige una opción.");
                                System.out.println("1. Ver datos personales.");
                                System.out.println("2. Actualizar datos personales.");
                                System.out.println("3. Ver próxima cita.");
                                System.out.println("4. Pedir cita.");
                                System.out.println("5. Cerrar sesión.");
                                opcionSesion = sc.nextInt();

                                switch (opcionSesion) {
                                    case 1:
                                            System.out.println("Elegiste ver tus datos personales.");
                                            System.out.println(datos);
                                            System.out.println("");
                                        break;
                                    case 2:
                                            System.out.println("Elegiste actualizar tus datos personales.");
                                            System.out.println("Introduce tus nuevos datos personales.");
                                            datos = sc.nextLine();
                                            System.out.println("");
                                        break;
                                    case 3:
                                            System.out.println("Elegiste ver tu próxima cita");
                                            System.out.println();
                                            if (cita > 0) {
                                                System.out.println("Tienes cita el día " + cita + " de este mes");
                                            }else{
                                                System.out.println("No tienes ninguna cita este mes.");
                                            }
                                        break;
                                    case 4:
                                            System.out.println("Introduce el día de tu cita.");
                                            cita = sc.nextInt();
                                        break;
                                    case 5:
                                        System.out.println("Elegiste cerrar sesión:");
                                        iniciar = 0;
                                        break;
                                
                                    default:
                                        break;
                                }
                            }while(iniciar==1);
                        }else{
                            System.out.println("El usuario y la contraseña no coinciden.");
                            System.out.println("");
                        }

                        
                    break;
                case 2:
                        System.out.println("Regístrate.");  
                        System.out.println(""); 

                        System.out.println("Introduce el usuario: ");
                        System.out.println(""); 
                        usuario_almacenado = sc.nextLine();
                        System.out.println("Introduce la contraseña:");
                        System.out.println("");
                        contrasena1 = sc.nextLine();
                        System.out.println("Introduce la contraseña de nuevo:");
                        System.out.println("");
                        contrasena2 = sc.nextLine();

                        if (contrasena1.equals(contrasena2)) {
                            System.out.println("Las contraseñas coinciden.");
                            System.out.println("Ahora introduce tus datos personales.");
                            datos = sc.nextLine();
                            System.out.println("Ahora puedes iniciar sesión.");
                            System.out.println("");
                        }else{
                            System.out.println("Las contraseñas no coinciden, regístrate de nuevo.");
                            System.out.println("");
                        }
                    break;

                default:
                        System.out.println("Introduce una opción válida.");
                        System.out.println("");
                    break;
            }
        }while(seguir==1);
        
        sc.close();
    }
}
