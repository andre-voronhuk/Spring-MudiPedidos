package br.com.alura.mvc.mudi.dto;

import javax.validation.constraints.NotBlank;

import br.com.alura.mvc.mudi.model.Pedido;

/**
 * RequestNovoProduto
 */
public class RequestNovoProduto {
    @NotBlank(message = "O nome não pode ser vazio")
    private String nome;
    @NotBlank(message = "Link não pode ser vazio")
    private String url;
    @NotBlank(message = "Link não pode ser vazio")
    private String imagem;

    private String descricao;

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImagem() {
        return this.imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public Pedido toPedido() {
        Pedido pedido = new Pedido();
        pedido.setNome(this.nome);
        pedido.setDescricao(this.descricao);
        pedido.setUrlProduto(this.url);
        pedido.setValor(1200.00);
        pedido.setUrlImagem(this.imagem);
        return pedido;
    }

}