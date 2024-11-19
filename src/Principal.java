import java.sql.SQLOutput;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        // Definicion de variables y clases
        ConsultaApiMonedas consulta = new ConsultaApiMonedas();
        Scanner lectura = new Scanner(System.in);
        Monedas monedas = consulta.buscarMonedas("USD");

        // Tipos de cambio
        double USDtoARS = monedas.conversion_rates().get("ARS");
        double USDtoBRL = monedas.conversion_rates().get("BRL");
        double USDtoCOP = monedas.conversion_rates().get("COP");

        try {
            while (true){
                System.out.println("""
                        **************************************************
                        Bienvenido/a al conversor de monedas:
                        
                        Seleccione una opción entre 1 y 7 para hacer la conversión deseada o salir del programa:
                        
                        1) Dólar => Peso Argentino
                        2) Peso Argentino => Dólar
                        3) Dólar => Real Brasileño
                        4) Real Brasileño => Dólar
                        5) Dólar => Peso Colombiano
                        6) Peso Colombiano => Dólar
                        7) Salir
                        
                        **************************************************
                        """);
                // Guardar la opción elegida por el usuario
                int opcion = lectura.nextInt();

                // Evaluar si la opción es válida
                if (opcion <1||opcion>7){
                    System.out.println("Debe elegir un número entre 1 y 7.");
                    System.out.println("Programa finalizado. Gracias por usar el conversor de monedas");
                // Si la opción seleccionada es 7, sale del sistema
                } else if (opcion == 7) {
                    System.out.println("Saliendo del sistema.");
                    System.out.println("Programa finalizado. Gracias por usar el conversor de monedas");
                    return;
                }
                // Selecciona la cantidad de dinero que se quiere convertir:
                System.out.println("Ingrese la cantidad de dinero que quiere convertir: ");
                double cantidad = lectura.nextDouble();

                // Se inicia la variable que almacenará el resultado de la conversión
                double resultado = 0;

                // Se inicializan variables para almacenar las siglas de las monedas utilizadas
                String siglasConversion = "";
                String siglasBase = "";

                switch (opcion) {
                // Se realizan las operaciones de conversión para cada uno d las opciones del menú inicial
                    case 1:
                        resultado = cantidad * USDtoARS;
                        siglasBase = " [USD]";
                        siglasConversion = " [ARS]";
                        break;
                    case 2:
                        resultado = cantidad / USDtoARS;
                        siglasBase = " [ARG]";
                        siglasConversion = " [USD]";
                        break;
                    case 3:
                        resultado = cantidad * USDtoBRL;
                        siglasBase = " [USD]";
                        siglasConversion = " [BRL]";
                        break;
                    case 4:
                        resultado = cantidad / USDtoBRL;
                        siglasBase = " [BRL]";
                        siglasConversion = " [USD]";
                        break;
                    case 5:
                        resultado = cantidad * USDtoCOP;
                        siglasBase = " [USD]";
                        siglasConversion = " [COP]";
                        break;
                    case 6:
                        resultado = cantidad / USDtoCOP;
                        siglasBase = " [COP]";
                        siglasConversion = " [USD]";
                        break;
                }
                // Mostrar resultados de la conversión
                System.out.println("El resultado de convertir " + cantidad + siglasBase + " a " + siglasConversion + " es de: " + String.format("%.2f",resultado) + siglasConversion + ".");
                System.out.println("Gracias por usar el conversor de monedas, si desea hacer mas conversiones ejecute de nuevo el programa.");
                break;
            }
        } catch (Exception e){
            System.out.println("Ingrese solamente valores numéricos");
            System.out.println("Programa finzalizado. Gracias por usar el converor de monedas");
        }
    }
}

