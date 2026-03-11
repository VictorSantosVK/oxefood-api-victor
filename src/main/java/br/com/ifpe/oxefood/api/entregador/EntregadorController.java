package br.com.ifpe.oxefood.api.entregador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.ifpe.oxefood.modelo.entregador.Entregador;
import br.com.ifpe.oxefood.modelo.entregador.EntregadorService;

@RestController
@RequestMapping("/api/entregador")
@CrossOrigin
public class EntregadorController {

    @Autowired
    private EntregadorService entregadorService;

    @PostMapping
    public ResponseEntity<Entregador> save(@RequestBody EntregadorRequest request) {
        Entregador entregador = entregadorService.save(request.build());
        return new ResponseEntity<>(entregador, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Entregador> listarTodos() {
        return entregadorService.listarTodos();
    }

    @GetMapping("/{id}")
    public Entregador obterPorID(@PathVariable Long id) {
        return entregadorService.obterPorID(id);
    }

    @PutMapping("/{id}")
    public Entregador update(@PathVariable Long id, @RequestBody EntregadorRequest request) {
        return entregadorService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        entregadorService.delete(id);
    }
}