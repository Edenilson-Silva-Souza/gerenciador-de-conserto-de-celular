package model;

import jakarta.persistence.*;

@Entity
@Table(name = "aparelhos")
public class Aparelho {

	@Id
	@Column(name = "aparId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "modelo")
	private String modelo;

	@Column(name = "fabricante")
	private String fabricante;

    @ManyToOne
	@JoinColumn(name = "id", nullable = false)
	private Cliente cliente;

	public Aparelho(String modelo, String fabricante, Cliente cliente) {
		super();
		this.modelo = modelo;
		this.fabricante = fabricante;
		this.cliente = cliente;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public Aparelho() {
		super();
	}

}
