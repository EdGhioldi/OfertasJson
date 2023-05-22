package ClaseJson;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Descuento {
    private String tipo;
    private double cantidad;
    private double tope;
}

