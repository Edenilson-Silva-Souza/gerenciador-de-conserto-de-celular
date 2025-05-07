package model;

import jakarta.persistence.*;

@Entity
@Table(name="bd")
public class Funcionario {
	@Id @Column(name="funId") @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int funId;
	
	@Column(name = "cpf")
	private int cpf;
	
	@Column(name = "funNome")
	private String funNome;
	
	@Column(name = "empresa")
	private String empresa;
	
	@Column(name = "salario")
	private float salario;
	
	@Column(name = "cargo")
	private String cargo;
	
	@Column(name = "horasSemanais")
	private float horasSemanais;

	public Funcionario(int cpf, String funNome, String empresa, float salario, String cargo, float horasSemanais) {
		super();
		this.cpf = cpf;
		this.funNome = funNome;
		this.empresa = empresa;
		this.salario = salario;
		this.cargo = cargo;
		this.horasSemanais = horasSemanais;
	}
	




	public int getCpf() {
		return cpf;
	}





	public void setCpf(int cpf) {
		this.cpf = cpf;
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





	public float getSalario() {
		return salario;
	}





	public void setSalario(float salario) {
		this.salario = salario;
	}





	public String getCargo() {
		return cargo;
	}





	public void setCargo(String cargo) {
		this.cargo = cargo;
	}





	public float getHorasSemanais() {
		return horasSemanais;
	}





	public void setHorasSemanais(float horasSemanais) {
		this.horasSemanais = horasSemanais;
	}





	public Funcionario() {
		super();
	}
	
	
}