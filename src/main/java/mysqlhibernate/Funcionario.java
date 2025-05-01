package mysqlhibernate;

import jakarta.persistence.*;

@Entity
@Table(name="bd")
public class Funcionario {
	@Id @Column(name="funId") @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int funId;
	
	@Column(name = "funNome")
	private String funNome;
	
	@Column(name = "empresa")
	private String empresa;

	public Funcionario(int funId, String funNome, String empresa) {
		super();
		this.funId = funId;
		this.funNome = funNome;
		this.empresa = empresa;
	}

	public int getFunId() {
		return funId;
	}

	public void setFunId(int funId) {
		this.funId = funId;
	}

	public String getFunNome() {
		return funNome;
	}

	public void setFunNome(String funNome) {
		this.funNome = funNome;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public Funcionario() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
