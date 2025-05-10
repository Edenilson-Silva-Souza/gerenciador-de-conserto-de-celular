package control;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import model.Aparelho;
import model.Cargo;
import model.Cliente;
import model.Funcionario;

public class Central {
	private Configuration conf = null;
	private Session session = null;
	Scanner input = new Scanner(System.in);
	private int id;
	private int cpf;

	private String nome;

	private String empresa;

	private float salario;

	private String cargo;

	private float horasSemanais;

	private String modelo;
	private String fabricante;

	public Central() {
		configurar();

	}

	public Session getSession() {
		return session;
	}

	public boolean cadastrar() {

		preencher();
		Funcionario fun = new Funcionario(cpf, nome, empresa, salario, cargo, horasSemanais);

		try {
			session.beginTransaction();
			session.persist(fun);
			session.getTransaction().commit();

			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean cadastrar(Funcionario fun) {

		try {
			session.beginTransaction();
			session.persist(fun);
			session.getTransaction().commit();

			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean cadastrarCliente() {
		preencherCliente();
		Cliente cliente = new Cliente(nome, cpf);

		try {
			session.beginTransaction();
			session.persist(cliente);
			session.getTransaction().commit();

			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean cadastrarCliente(Cliente cliente) {

		try {
			session.beginTransaction();
			session.persist(cliente);
			session.getTransaction().commit();

			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean cadastrarAparelho(Aparelho aparelho) {

		try {
			session.beginTransaction();
			session.persist(aparelho);
			session.getTransaction().commit();

			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean updateCadastro() {
		preencher(id);
		preencher();

		try {
			Funcionario usuario = session.get(Funcionario.class, id);

			if (usuario != null) {
				usuario.setFunNome(nome);
				usuario.setCpf(cpf);
				usuario.setEmpresa(empresa);
				usuario.setSalario(salario);
				usuario.setCargo(cargo);
				usuario.setHorasSemanais(horasSemanais);

				session.beginTransaction();
				session.merge(usuario);
				session.getTransaction().commit();

				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean updateCadastro(int id, String nome, String cpf, String empresa, String salario, String cargo,
			String horasSemanais) {

		try {

			Funcionario usuario = session.get(Funcionario.class, id);

			if (usuario != null) {
				usuario.setFunNome(nome);
				usuario.setCpf(Integer.parseInt(cpf));
				usuario.setEmpresa(empresa);
				usuario.setSalario(Float.parseFloat(salario));
				usuario.setCargo(cargo);
				usuario.setHorasSemanais(Float.parseFloat(horasSemanais));

				session.beginTransaction();
				session.merge(usuario);
				session.getTransaction().commit();

				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean updateCliente() {
		preencher(id);
		preencherCliente();

		try {
			Cliente usuario = session.get(Cliente.class, id);

			if (usuario != null) {
				usuario.setNome(nome);
				usuario.setCpf(cpf);

				session.beginTransaction();
				session.merge(usuario);
				session.getTransaction().commit();

				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean removerCargo() {
		preencher(id);

		session.beginTransaction();
		Cargo usuario = session.get(Cargo.class, id);

		if (usuario == null) {
			return false;
		}

		if (usuario != null) {
			session.remove(usuario); // Deleta o usuário
			session.getTransaction().commit();
		}

		return true;
	}

	public boolean removerAparelho() {
		preencher(id);

		session.beginTransaction();
		Aparelho aparelho = session.get(Aparelho.class, id);

		if (aparelho == null) {
			return false;
		}

		if (aparelho != null) {
			session.remove(aparelho); // Deleta o usuário
			session.getTransaction().commit();
		}

		return true;
	}
	public boolean removerAparelho(int id) {

		session.beginTransaction();
		Aparelho aparelho = session.get(Aparelho.class, id);

		if (aparelho == null) {
			return false;
		}

		if (aparelho != null) {
			session.remove(aparelho); // Deleta o usuário
			session.getTransaction().commit();
		}

		return true;
	}

	public boolean removerCliente() {
		preencher(id);

		session.beginTransaction();
		Cliente cliente = session.get(Cliente.class, id);

		if (cliente == null) {
			return false;
		}

		if (cliente != null) {
			session.remove(cliente); // Deleta o usuário
			session.getTransaction().commit();
		}

		return true;
	}

	public boolean removerCliente(int id) {

		session.beginTransaction();
		Cliente cliente = session.get(Cliente.class, id);

		if (cliente == null) {
			return false;
		}

		if (cliente != null) {
			session.remove(cliente); // Deleta o usuário
			session.getTransaction().commit();
		}

		return true;
	}

	public boolean remover() {
		preencher(id);
		// remover uma linha da tabela
		session.beginTransaction();
		Funcionario usuario = session.get(Funcionario.class, id);

		if (usuario == null) {
			return false;
		}

		if (usuario != null) {
			session.remove(usuario); // Deleta o usuário
			session.getTransaction().commit();
		}

		return true;
	}

	public boolean remover(int id) {

		session.beginTransaction();
		Funcionario usuario = session.get(Funcionario.class, id);

		if (usuario == null) {
			return false;
		}

		if (usuario != null) {
			session.remove(usuario); // Deleta o usuário
			session.getTransaction().commit();
		}

		return true;
	}



	public List<Funcionario> lista() {

		try {

			Query<Funcionario> query = session.createQuery("FROM Funcionario", Funcionario.class);
			List<Funcionario> usuarios = query.list();
			return usuarios;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public List<Cliente> listaCliente() {

		try {

			Query<Cliente> query = session.createQuery("FROM Cliente", Cliente.class);
			List<Cliente> usuarios = query.list();
			return usuarios;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public List<Aparelho> listaAparelho() {

		try {

			Query<Aparelho> query = session.createQuery("FROM Aparelho", Aparelho.class);
			List<Aparelho> usuarios = query.list();
			return usuarios;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public Map<String, String> ler() {

		preencher(id);
		Map<String, String> mapa = new HashMap<String, String>();

		try {

			Funcionario usuario = session.get(Funcionario.class, id);
			if (usuario != null) {

				mapa.put("cpf", String.valueOf(usuario.getCpf()));
				mapa.put("nome", usuario.getFunNome());
				mapa.put("empresa", usuario.getEmpresa());
				mapa.put("salario", String.valueOf(usuario.getSalario()));
				mapa.put("cargo", usuario.getCargo());
				mapa.put("horas_S", String.valueOf(usuario.getHorasSemanais()));

				return mapa;
			}
		} catch (Exception e) {

		}

		return null;
	}

	public Map<String, String> ler(int id) {

		Map<String, String> mapa = new HashMap<String, String>();

		try {

			Funcionario usuario = session.get(Funcionario.class, id);
			if (usuario != null) {

				mapa.put("cpf", String.valueOf(usuario.getCpf()));
				mapa.put("nome", usuario.getFunNome());
				mapa.put("empresa", usuario.getEmpresa());
				mapa.put("salario", String.valueOf(usuario.getSalario()));
				mapa.put("cargo", usuario.getCargo());
				mapa.put("horas_S", String.valueOf(usuario.getHorasSemanais()));

				return mapa;
			}
		} catch (Exception e) {

		}

		return null;
	}

	public Cliente getCliente(int id) {

		Cliente usuario = session.get(Cliente.class, id);

		return usuario;
	}

	public boolean existe(int cpf) {

		Query<Long> query = session.createQuery("SELECT COUNT(u) FROM Funcionario u WHERE u.cpf = :nome", Long.class);
		query.setParameter("nome", cpf);
		Long count = query.uniqueResult();

		if (count > 0) {
			return true;
		}

		return false;
	}

	public boolean ClienteExiste(int cpf) {

		Query<Long> query = session.createQuery("SELECT COUNT(u) FROM Cliente u WHERE u.cpf = :nome", Long.class);
		query.setParameter("nome", cpf);
		Long count = query.uniqueResult();

		if (count > 0) {
			return true;
		}

		return false;
	}

	public void preencher() {
		cpf = 0;
		nome = null;
		empresa = null;
		salario = 0;
		cargo = null;
		horasSemanais = 0;

		System.out.print("cpf: ");
		cpf = Integer.parseInt(input.nextLine());

		System.out.print("Seu nome: ");
		nome = input.nextLine();

		System.out.print("Nome da empresa que trabalha: ");
		empresa = input.nextLine();

		System.out.print("Salário do trabalho: ");
		salario = Float.parseFloat(input.nextLine());

		System.out.print("Cargo que trabalha: ");
		cargo = input.nextLine();

		System.out.print("horas semanais: ");
		horasSemanais = Float.parseFloat(input.nextLine());
	}

	public void preencherCliente() {
		cpf = 0;
		nome = null;

		System.out.print("cpf: ");
		cpf = Integer.parseInt(input.nextLine());

		System.out.print("Seu nome: ");
		nome = input.nextLine();

	}

	public void preencher(int id) {
		System.out.print("id: ");
		id = Integer.parseInt(input.nextLine());
		this.id = id;
	}

	public void preencherCargo() {
		System.out.print("Cargo: ");
		cargo = input.nextLine();

	}

	public void preencherAparelho() {
		System.out.print("modelo: ");
		modelo = input.nextLine();

		System.out.print("Fabricante: ");
		fabricante = input.nextLine();

	}

	public boolean relaCargoFunc() {
		preencher(id);
		preencherCargo();

		try {
			Funcionario usuario = session.get(Funcionario.class, id);
			Cargo cargoFuncionario = new Cargo(cargo, usuario);
			session.beginTransaction();

			session.persist(cargoFuncionario);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean relaClientApare() {
		preencher(id);
		preencherAparelho();

		try {
			Cliente usuario = session.get(Cliente.class, id);
			Aparelho aparelho = new Aparelho(modelo, fabricante, usuario);
			session.beginTransaction();

			session.persist(aparelho);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	private void configurar() {
		conf = new Configuration();
		conf.configure("hibernate.cfg.xml");
		conf.addAnnotatedClass(Funcionario.class);
		conf.addAnnotatedClass(Cargo.class);
		conf.addAnnotatedClass(Cliente.class);
		conf.addAnnotatedClass(Aparelho.class);

		SessionFactory sf = conf.buildSessionFactory();
		session = sf.openSession();
	}

	public Configuration getConf() {
		return conf;
	}

	public void setConf(Configuration conf) {
		this.conf = conf;
	}

	public Scanner getInput() {
		return input;
	}

	public void setInput(Scanner input) {
		this.input = input;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public void setSession(Session session) {
		this.session = session;
	}

}
