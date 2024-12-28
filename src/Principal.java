public class Principal {
    public static void main(String[] args) {
        ConsultaMoneda consulta = new ConsultaMoneda();
        Conversion conversion = consulta.nuevaConversion();

        System.out.println("Moneda base: " + conversion.getBase());
        System.out.println("Fecha: " + conversion.getDate());
        System.out.println("Tasa de EUR: " + conversion.getRates().get("EUR"));
    }
}

