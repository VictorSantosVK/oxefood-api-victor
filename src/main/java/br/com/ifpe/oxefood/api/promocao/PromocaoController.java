package br.com.ifpe.oxefood.api.promocao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.ifpe.oxefood.modelo.promocao.Promocao;
import br.com.ifpe.oxefood.modelo.promocao.PromocaoService;

@RestController
@RequestMapping("/api/promocao")
@CrossOrigin
public class PromocaoController {

    @Autowired
    private PromocaoService promocaoService;

    @PostMapping
    public ResponseEntity<Promocao> save(@RequestBody PromocaoRequest request) {
        Promocao promocao = promocaoService.save(request.build());
        return new ResponseEntity<>(promocao, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Promocao> listarTodos() {
        return promocaoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Promocao obterPorID(@PathVariable Long id) {
        return promocaoService.obterPorID(id);
    }

    @PutMapping("/{id}")
    public Promocao update(@PathVariable Long id, @RequestBody PromocaoRequest request) {
        return promocaoService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        promocaoService.delete(id);
    }

    @PutMapping("/ativar-desativar/{id}")
    public Promocao alternarPromoValida(@PathVariable Long id) {
        return promocaoService.alternarPromoValida(id);
    }
}