package mysqlhibernate;

import view.TelaCliente;
import view.ListaAparellho;
import view.ListaCliente;
import view.ListaFuncionario;
import view.TelaAparelho;
import view.TelaFuncionario;
import view.TelaMain;

public class Main {

	public static void main(String[] args) {
		
		//Falta criar a tela para gerenciar as outras telas(Tela padrão).
		TelaMain app = new TelaMain();
		
		
		//new TelaFuncionario();
		//new ListaAparellho();
		//TelaAparelho apare = new TelaAparelho();
		
		//TelaCliente app = new TelaCliente();
		//ListaCliente cli = new ListaCliente();
		//Cliente c = new Cliente();
		//ListaFuncionario f = new ListaFuncionario();
		
		
		/*
		//verificar se um cliente já existe.
		Central central = new Central();
		Boolean existe1 = central.ClienteExiste(100);
		Boolean existe2 = central.ClienteExiste(2);
		central.getSession().close();
		System.out.println(existe1);
		System.out.println(existe2);
		*/
		
		/*
		 tela feita
		//remover cliente
		Central central = new Central();
		central.removerCliente();
		central.getSession().close();
		*/
		
		/*
		//update cliente
		Central central = new Central();
		central.updateCliente();
		central.getSession().close();
		*/
		
		
		/*
		//remover aparelho
		Central central = new Central();
		central.removerAparelho();
		central.getSession().close();	
		*/
		
		/*
		//relacao cliente e aparelho
		Central central = new Central();
		central.relaClientApare();
		central.getSession().close();		
		*/
		
		/*
		//cadastrar cliente
		Central central = new Central();
		central.cadastrarCliente();
		central.getSession().close();
		*/
		
		/*
		//remover Cargo
		Central central = new Central();
		central.removerCargo();
		central.getSession().close();
		*/
		
		/*
		//relacionar o funcionário com a tabela cargo
		Central central = new Central();
		central.relaCargoFunc();
		central.getSession().close();
		*/
		
		/*
		//verificar se um funcionário já existe.
		Central central = new Central();
		Boolean existe1 = central.existe(34);
		Boolean existe2 = central.existe(4);
		central.getSession().close();
		System.out.println(existe1);
		System.out.println(existe2);
		 */
		
	
		/*
		 * 
		 tela feita
		//Mostra a lista de entidades do banco de dados
		Central central = new Central();
		List<Funcionario> usuarios= central.lista();
		central.getSession().close();
		for (Funcionario user : usuarios) {
		    System.out.println("cpf: " + user.getCpf());
		    System.out.println("Nome: " + user.getFunNome());
		    System.out.println("empresa: " + user.getEmpresa());
		    System.out.println("salário: " + user.getSalario());
		    System.out.println("cargo: " + user.getCargo());
		    System.out.println("horas semanais: " + user.getHorasSemanais());
		    System.out.println("");

		*/
		
		/*
		//READ
		 //tela feita
		//ler um dados de um usuário (read)
		Central central = new Central();
		Map mapa = central.ler();
		central.getSession().close();
		System.out.println(mapa.get("cpf"));
		System.out.println(mapa.get("nome"));
		System.out.println(mapa.get("empresa"));
		System.out.println(mapa.get("salario"));
		System.out.println(mapa.get("cargo"));
		System.out.println(mapa.get("horas_S"));
		*/
		
		
		/*
		//DELETE
		//tela feita
		//remover uma linha da tabela
		Central central = new Central();
		central.remover(3);
		central.getSession().close();
		*/
		
		/*
		//tela feita
		//UPDATE
		Central central = new Central();
		central.updateCadastro();
		central.getSession().close();
		*/
				
		
		/*
		 //tela feita
		 //CREATE	
			Central central = new Central();
			central.cadastrar();
			central.getSession().close();
		*/
		

	}

}
