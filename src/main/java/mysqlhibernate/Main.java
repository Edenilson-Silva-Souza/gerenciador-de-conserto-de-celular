package mysqlhibernate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import control.Central;
import model.Cargo;
import model.Funcionario;

public class Main {

	public static void main(String[] args) {
		
		
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
		//remover uma linha da tabela
		Central central = new Central();
		central.remover(3);
		central.getSession().close();
		*/
		
		/*
		//UPDATE
		Central central = new Central();
		central.updateCadastro();
		central.getSession().close();
		*/
				
		
		/*
		 //CREATE	
			Central central = new Central();
			central.cadastrar();
			central.getSession().close();
		*/
		
	}

}
