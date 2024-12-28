import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.Scanner;

public class ConversorMoneda {

    // Método para convertir entre dos monedas dadas las tasas
    public static double convertirMoneda(double cantidad, double tasaDeCambio) {
        return cantidad * tasaDeCambio;
    }

    public static void main(String[] args) {
        // Simulación de la respuesta de la API
        String respuesta = "{ \"base\": \"USD\", \"fecha\": \"2024-12-28\", \"rates\": {\"ARS\": 346.50, \"BRL\": 5.20, \"COP\": 4500.10}}";

        // Usamos Gson para convertir el JSON en un objeto JsonObject
        JsonObject jsonObject = JsonParser.parseString(respuesta).getAsJsonObject();
        JsonObject rates = jsonObject.getAsJsonObject("rates");

        // Crear un escáner para tomar las entradas del usuario
        Scanner scanner = new Scanner(System.in);

        // Menú de opciones
        while (true) {
            System.out.println("*************************************");
            System.out.println("Sea bienvenido/a al Conversor de Moneda");
            System.out.println("1) Dólar =>> Peso argentino");
            System.out.println("2) Peso argentino =>> Dólar");
            System.out.println("3) Dólar =>> Real brasileño");
            System.out.println("4) Real brasileño =>> Dólar");
            System.out.println("5) Dólar =>> Peso colombiano");
            System.out.println("6) Peso colombiano =>> Dólar");
            System.out.println("7) Salir");
            System.out.println("Elija una opción válida:");
            System.out.println("*******************************");

            int opcion = scanner.nextInt();
            double cantidad, resultado;
            String monedaOrigen = "", monedaDestino = "";
            double tasaDeCambio = 0.0;

            switch (opcion) {
                case 1:
                    monedaOrigen = "USD";
                    monedaDestino = "ARS";
                    tasaDeCambio = rates.get("ARS").getAsDouble();
                    break;
                case 2:
                    monedaOrigen = "ARS";
                    monedaDestino = "USD";
                    tasaDeCambio = 1 / rates.get("ARS").getAsDouble();
                    break;
                case 3:
                    monedaOrigen = "USD";
                    monedaDestino = "BRL";
                    tasaDeCambio = rates.get("BRL").getAsDouble();
                    break;
                case 4:
                    monedaOrigen = "BRL";
                    monedaDestino = "USD";
                    tasaDeCambio = 1 / rates.get("BRL").getAsDouble();
                    break;
                case 5:
                    monedaOrigen = "USD";
                    monedaDestino = "COP";
                    tasaDeCambio = rates.get("COP").getAsDouble();
                    break;
                case 6:
                    monedaOrigen = "COP";
                    monedaDestino = "USD";
                    tasaDeCambio = 1 / rates.get("COP").getAsDouble();
                    break;
                case 7:
                    System.out.println("¡Gracias por usar el conversor de moneda!");
                    scanner.close();
                    return; // Salir del programa
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    continue;
            }

            // Solicitar la cantidad a convertir
            System.out.println("Ingrese la cantidad a convertir de " + monedaOrigen + ": ");
            cantidad = scanner.nextDouble();

            // Realizar la conversión
            resultado = convertirMoneda(cantidad, tasaDeCambio);

            // Mostrar el resultado
            System.out.println(cantidad + " " + monedaOrigen + " es igual a " + String.format("%.2f", resultado) + " " + monedaDestino);
        }
    }
}




