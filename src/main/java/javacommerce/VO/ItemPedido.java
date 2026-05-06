package javacommerce.VO;

public class ItemPedido {
	
	private Integer id;
	
	private Produto produto;
	
	private Integer quantidade;

	public ItemPedido(Integer id, Produto produto, Integer quantidade) {
		super();
		this.id = id;
		this.produto = produto;
		this.quantidade = quantidade;
	}

	public ItemPedido() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

}
