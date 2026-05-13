package br.com.ifpe.oxefood.modelo.produto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.ifpe.oxefood.api.produto.ProdutoRequest;
import br.com.ifpe.oxefood.util.exception.ProdutoException;
import jakarta.transaction.Transactional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    @Transactional
    public Produto save(Produto produto) {
        if (produto.getValorUnitario() < 10) {
            throw new ProdutoException(ProdutoException.MSG_VALOR_MINIMO_PRODUTO);
        }

        produto.setHabilitado(Boolean.TRUE);
        return repository.save(produto);
    }

    @Transactional
    public Produto saveImage(Long id, MultipartFile imagem) {

        Produto produto = obterPorID(id);

        String imagemUpada = Util.fazerUploadImagem(imagem);

        if (imagemUpada != null) {
            produto.setImagem(imagemUpada);
        }

        return save(produto);
    }

    public List<Produto> listarTodos() {
        return repository.findAll();
    }

    public Produto obterPorID(Long id) {
        return repository.findById(id).get();
    }

    @Transactional
    public Produto update(Long id, ProdutoRequest request) {
        Produto produto = repository.findById(id).get();

        produto.setCodigo(request.getCodigo());
        produto.setTitulo(request.getTitulo());
        produto.setDescricao(request.getDescricao());
        produto.setValorUnitario(request.getValorUnitario());
        produto.setTempoEntregaMinimo(request.getTempoEntregaMinimo());
        produto.setTempoEntregaMaximo(request.getTempoEntregaMaximo());

        return repository.save(produto);
    }

    @Transactional
    public void delete(Long id) {
        Produto produto = repository.findById(id).get();
        produto.setHabilitado(Boolean.FALSE);
        repository.save(produto);
    }
}