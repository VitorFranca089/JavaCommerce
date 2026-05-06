package javacommerce.VO;

public class Usuario {
	
	private Integer id;
	
	private String nome;
	
	private String senha;
	
	private String cpf;
	
	private String endereco;

	public Usuario(Integer id, String nome, String senha, String cpf, String endereco) {
		super();
		this.id = id;
		this.nome = nome;
		this.senha = senha;
		this.cpf = cpf;
		this.endereco = endereco;
	}

	public Usuario() {
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

}
