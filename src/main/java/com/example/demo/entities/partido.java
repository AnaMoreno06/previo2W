import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
public class Partido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    private Equipo equipoLocal;
    
    @ManyToOne
    private Equipo equipoVisitante;
    
    private LocalDateTime fecha;
    private int golesEquipoLocal;
    private int golesEquipoVisitante;
    
    // Constructores, getters y setters
}

