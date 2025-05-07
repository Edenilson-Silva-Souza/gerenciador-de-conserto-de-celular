package model;

import jakarta.persistence.*;

@Entity
@Table(name="cargo")
public class Cargo {
	
	@Id @Column(name="cargoId") @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cargoId;
	
    @Column(name="nome")
    private String nome;

    //@ManyToOne(cascade = CascadeType.REMOVE)
    @ManyToOne
    @JoinColumn(name="funId", nullable=false)
    private Funcionario funcionario;
    
    

	public Cargo(String nome, Funcionario funcionario) {
		super();
		this.nome = nome;
		this.funcionario = funcionario;
	}
	
	public Cargo() {
		super();
	}

	public int getCargoId() {
		return cargoId;
	}


	public String getNome() {
		return nome;
	}


	public Funcionario getFuncionario() {
		return funcionario;
	}
    
    
    
}
