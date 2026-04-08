package br.com.ifpe.oxefood.modelo.promocao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifpe.oxefood.api.promocao.PromocaoRequest;
import jakarta.transaction.Transactional;

@Service
public class PromocaoService {

    @Autowired
    private PromocaoRepository repository;

    @Transactional
    public Promocao save(Promocao promocao) {
        promocao.setHabilitado(Boolean.TRUE);
        promocao.setPromoValida(Boolean.TRUE);
        return repository.save(promocao);
    }

    public List<Promocao> listarTodos() {
        return repository.findAll();
    }

    public Promocao obterPorID(Long id) {
        return repository.findById(id).get();
    }

    @Transactional
    public Promocao update(Long id, PromocaoRequest request) {
        Promocao promocao = repository.findById(id).get();

        promocao.setTitulo(request.getTitulo());
        promocao.setDataInicio(request.getDataInicio());
        promocao.setDataFim(request.getDataFim());
        promocao.setRegra(request.getRegra());
        promocao.setValorDesconto(request.getValorDesconto());

        return repository.save(promocao);
    }

    @Transactional
    public void delete(Long id) {
        Promocao promocao = repository.findById(id).get();
        promocao.setHabilitado(Boolean.FALSE);
        repository.save(promocao);
    }

    @Transactional
    public Promocao alternarPromoValida(Long id) {
        Promocao promocao = repository.findById(id).get();
        promocao.setPromoValida(!promocao.getPromoValida());
        return repository.save(promocao);
    }
}