package ClaseJson;

import java.io.IOException;
import java.nio.file.Paths;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class Main {
    public static void main(String[] args){

        String ofertaCsv = Paths.get("src/main/java/ClaseJson/OFERTAS.csv").toString();
        List<Oferta> ofertas = new ArrayList<>();

        try {
            File file = new File(ofertaCsv);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] datos = line.split(",");

                //Datos de "Producto"

                String nombreProducto = datos[0].trim();
                String peso = datos[1].trim();
                String unidadMedida = datos[2].trim();
                double precioProducto = Double.parseDouble(datos[3].trim());

                Producto producto = new Producto(nombreProducto, new String[]{peso, unidadMedida}, precioProducto);

                //Datos de "Descuento"
                String tipoDesc = datos[4].trim();
                double cantDesc = Double.parseDouble(datos[5].trim());
                double topeDesc = Double.parseDouble(datos[6].trim());

                Descuento descuento = new Descuento(tipoDesc, cantDesc, topeDesc);

                //Datos de "Oferta"
                LocalDate fechaInicio = LocalDate.parse(datos[7].trim());
                LocalDate fechaFinal = LocalDate.parse(datos[8].trim());

                Oferta oferta = new Oferta(producto, descuento, fechaInicio, fechaFinal);

                // Agregar la oferta a la lista
                ofertas.add(oferta);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

// Crear el ObjectMapper y el ObjectWriter con PrettyDefaultPrinter
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        ObjectWriter writer = mapper.writerWithDefaultPrettyPrinter();
        try {
            // Escribir la lista de ofertas en el archivo JSON
            String jsonFilePath = "src/main/java/ClaseJson/OfertasdelMes.json";
            File jsonFile = new File(jsonFilePath);
            writer.writeValue(jsonFile, ofertas);
            System.out.println("Archivo JSON generado con éxito: " + jsonFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}