import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/selecciones")
public class SeleccionController {
    private final SeleccionService seleccionService;

    @Autowired
    public SeleccionController(SeleccionService seleccionService) {
        this.seleccionService = seleccionService;
    }

    @GetMapping
    public ResponseEntity<List<Seleccion>> listarSelecciones() {
        List<Seleccion> selecciones = seleccionService.listarSelecciones();
        return ResponseEntity.ok(selecciones);
    }

    @PostMapping
    public ResponseEntity<Seleccion> registrarSeleccion(@RequestBody Seleccion seleccion) {
        Seleccion nuevaSeleccion = seleccionService.registrarSeleccion(seleccion);
        return ResponseEntity.ok(nuevaSeleccion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Seleccion> actualizarSeleccion(
            @PathVariable("id") Long id,
            @RequestBody Seleccion seleccion) {
        Seleccion seleccionActualizada = seleccionService.actualizarSeleccion(id, seleccion);
        return ResponseEntity.ok(seleccionActualizada);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Seleccion> mostrarSeleccion(@PathVariable("id") Long id) {
        Seleccion seleccion = seleccionService.mostrarSeleccion(id);
        return ResponseEntity.ok(seleccion);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarSeleccion(@PathVariable("id") Long id) {
        seleccionService.eliminarSeleccion(id);
        return ResponseEntity.noContent().build();
    }
}

