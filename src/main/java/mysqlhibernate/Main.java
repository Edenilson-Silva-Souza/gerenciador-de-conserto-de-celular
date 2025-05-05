package mysqlhibernate;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		config.addAnnotatedClass(Funcionario.class);
		
		try {
			SessionFactory sf = config.buildSessionFactory();
			Session session = sf.openSession();
			
			Funcionario fun = new Funcionario();
			Scanner input = new Scanner(System.in);
			
			System.out.print("Seu nome: ");
			String nomeFun = input.nextLine();
			
			System.out.print("Nome da empresa que trabalha: ");
			String nomeEmp = input.next();


			fun.setEmpresa(nomeEmp);
			fun.setFunNome(nomeFun);
			
			session.beginTransaction();
			session.persist(fun);
			session.getTransaction().commit();
			
			session.close();
			
		}catch(Exception e){
			
		}
	}

}
