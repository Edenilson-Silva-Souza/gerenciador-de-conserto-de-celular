package view;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class TelaMain {

	JMenuItem itemNovoClente = new JMenuItem("Novo Cliente");
	JMenuItem itemNovoAparelho = new JMenuItem("Novo Aparelho");
	JMenuItem itemListaCliente = new JMenuItem("Lista Cliente");
	JMenuItem itemListaAparelho = new JMenuItem("Lista Aparelho");

	JMenuItem itemNovoFuncionario = new JMenuItem("Novo Funcionário");
	JMenuItem itemListaFuncionario = new JMenuItem("Lista Funcionário");

	public TelaMain() {
		JFrame janela = new JFrame();
		janela.setSize(700, 540);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setResizable(false);
		janela.setTitle("Inicio");
		janela.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		janela.setLocationRelativeTo(null);
		iniciar(janela);
		ouvintes();

		janela.setVisible(true);
	}

	public void iniciar(JFrame janela) {
		JMenuBar menu = new JMenuBar();
		janela.add(menu);

		JMenu opFile = new JMenu("Funcionário");
		opFile.setFont(new Font("Arial", Font.BOLD, 12));
		opFile.add(itemNovoFuncionario);
		opFile.add(itemListaFuncionario);
		menu.add(opFile);

		JMenu opFinancas = new JMenu("Cliente");
		opFile.setFont(new Font("Arial", Font.BOLD, 12));
		opFinancas.add(itemNovoClente);
		opFinancas.add(itemNovoAparelho);
		opFinancas.add(itemListaAparelho);
		opFinancas.add(itemListaCliente);
		opFinancas.add(itemListaAparelho);
		
		menu.add(opFinancas);

	}

	public void ouvintes() {
		itemNovoClente.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new TelaCliente();

			}
		});

		itemListaCliente.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new ListaCliente();

			}
		});

		itemListaAparelho.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new ListaAparellho();

			}
		});
		
		itemNovoAparelho.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new TelaAparelho();

			}
		});
		
		itemNovoFuncionario.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new TelaFuncionario();

			}
		});
		
		itemListaFuncionario.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new ListaFuncionario();

			}
		});
	}

}
