package javacommerce.VO;

public class Produto {
	
	private Integer id;
	
	private String nome;
	
	private Double valorUnitario;
	
	private String descricao;

	public Produto(Integer id, String nome, Double valorUnitario, String descricao) {
		super();
		this.id = id;
		this.nome = nome;
		this.valorUnitario = valorUnitario;
		this.descricao = descricao;
	}

	public Produto() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
