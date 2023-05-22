        package ClaseJson;
        
        import java.time.LocalDate;
        import lombok.AllArgsConstructor;
        import lombok.Data;
        import lombok.NoArgsConstructor;
        
        @Data
        @NoArgsConstructor
        @AllArgsConstructor
        public class Oferta {
            private Producto producto;
            private Descuento descuento;
            private LocalDate fechaDesde;
            private LocalDate fechaHasta;
        }
