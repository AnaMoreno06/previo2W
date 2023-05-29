import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/grupos")
public class GrupoController {
    private final GrupoService grupoService;

    @Autowired
    public GrupoController(GrupoService grupoService) {
        this.grupoService = grupoService;
    }

    @GetMapping("/{nombreGrupo}/selecciones")
    public ResponseEntity<List<Seleccion>> listarSeleccionesPorGrupo(@PathVariable("nombreGrupo") String nombreGrupo) {
        List<Seleccion> selecciones = grupoService.listarSeleccionesPorGrupo(nombreGrupo);
        return ResponseEntity.ok(selecciones);
    }
}
