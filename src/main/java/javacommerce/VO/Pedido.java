package javacommerce.VO;

import java.util.ArrayList;

public class Pedido {
	
	private Integer id;
	
	private Usuario usuario;
	
	private ArrayList<ItemPedido> itensPedido;

	public Pedido(Integer id, Usuario usuario, ArrayList<ItemPedido> itensPedido) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.itensPedido = itensPedido;
	}

	public Pedido() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public ArrayList<ItemPedido> getItensPedido() {
		return itensPedido;
	}

	public void setItensPedido(ArrayList<ItemPedido> itensPedido) {
		this.itensPedido = itensPedido;
	}

	
	
}
