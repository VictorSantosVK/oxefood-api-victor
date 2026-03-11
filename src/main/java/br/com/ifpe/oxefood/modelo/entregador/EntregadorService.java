package br.com.ifpe.oxefood.modelo.entregador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifpe.oxefood.api.entregador.EntregadorRequest;
import jakarta.transaction.Transactional;

@Service
public class EntregadorService {

    @Autowired
    private EntregadorRepository repository;

    @Transactional
    public Entregador save(Entregador entregador) {
        entregador.setHabilitado(Boolean.TRUE);
        return repository.save(entregador);
    }

    public List<Entregador> listarTodos() {
        return repository.findAll();
    }

    public Entregador obterPorID(Long id) {
        return repository.findById(id).get();
    }

    @Transactional
    public Entregador update(Long id, EntregadorRequest request) {
        Entregador entregador = repository.findById(id).get();

        entregador.setNome(request.getNome());
        entregador.setCpf(request.getCpf());
        entregador.setRg(request.getRg());
        entregador.setDataNascimento(request.getDataNascimento());
        entregador.setFoneCelular(request.getFoneCelular());
        entregador.setFoneFixo(request.getFoneFixo());
        entregador.setQtdEntregasRealizadas(request.getQtdEntregasRealizadas());
        entregador.setValorFrete(request.getValorFrete());
        entregador.setEnderecoRua(request.getEnderecoRua());
        entregador.setEnderecoComplemento(request.getEnderecoComplemento());
        entregador.setEnderecoNumero(request.getEnderecoNumero());
        entregador.setEnderecoBairro(request.getEnderecoBairro());
        entregador.setEnderecoCidade(request.getEnderecoCidade());
        entregador.setEnderecoCep(request.getEnderecoCep());
        entregador.setEnderecoUf(request.getEnderecoUf());
        entregador.setAtivo(request.getAtivo());

        return repository.save(entregador);
    }

    @Transactional
    public void delete(Long id) {
        Entregador entregador = repository.findById(id).get();
        entregador.setHabilitado(Boolean.FALSE);
        repository.save(entregador);
    }
}