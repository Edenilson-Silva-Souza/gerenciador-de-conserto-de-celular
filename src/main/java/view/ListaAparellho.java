package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import control.Central;
import model.Aparelho;
import model.Cliente;

public class ListaAparellho {
	private JPanel painel = null;
	private JTable tabela = null;
	private JTextField aparelho = null;
	
	
	public ListaAparellho() {
		JFrame janela = new JFrame();
		janela.setSize(1000, 540);
		//janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setResizable(false);
		janela.setTitle("Lista Aparelho");
		janela.setLayout(null);
		janela.setLocationRelativeTo(null);
		iniciar(janela);
	}

	public void iniciar(JFrame janela) {
		// titulo("Cadastrar Funcionário", janela);
		tabela(janela);
		bntAtualizar(janela);
		janela.setVisible(true);
	}

	public void tabela(JFrame janela) {

		String[] colunas = { "ID", "Modelos", "Fabricante", "ID Cliente"};
		List<Object[]> lista = new ArrayList<>();
		Object[][] dados = lista.toArray(new Object[0][]);

		DefaultTableModel modelo = new DefaultTableModel(dados, colunas);
		tabela = new JTable();
		tabela.setModel(modelo);
		tabela.setPreferredScrollableViewportSize(new Dimension(900, 300));

		painel = getPainel(0, 350, janela, new Color(100, 100, 100));
		painel.add(new JScrollPane(tabela));

		JPanel painelRemoverF = getPainel(370, 40, janela, new Color(0, 0, 50));
		aparelho = new JTextField("ID Aparelho", 20);
		placehoder(aparelho, painelRemoverF);

		JButton bntRemover = new JButton("deletar");
		bntRemover.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (getAparelho().getText().equals("ID Aparelho") || getAparelho().getText().equals("")) {
					JOptionPane.showMessageDialog(janela, "Preencha o campo com ID válido");
				} else {
					Central central = new Central();
					central.removerAparelho(Integer.parseInt(getAparelho().getText()));
					central.getSession().close();
					JOptionPane.showMessageDialog(janela, "Deletado");
				}

			}
		});
		painelRemoverF.add(bntRemover);

		janela.add(painelRemoverF);
		janela.add(painel);
	}

	public void placehoder(JTextField funcionario, JPanel painelRemoverF) {
		funcionario.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (funcionario.getText().equals("ID Aparelho")) {
					funcionario.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (funcionario.getText().isEmpty()) {
					funcionario.setText("ID Aparelho");
				}
			}
		});

		painelRemoverF.add(funcionario);

	}

	public void atualizar(JTable tabela, JFrame janela) {

		janela.remove(painel);

		Central central = new Central();

		String[] colunas = { "ID", "Modelos", "Fabricante", "ID Cliente"};

		List<Object[]> lista = new ArrayList<>();

		List<Aparelho> usuarios = central.listaAparelho();
		central.getSession().close();

		for (Aparelho user : usuarios) {

			lista.add(new Object[] { user.getId() , user.getModelo(), user.getFabricante(), user.getCliente().getId()});
		}

		Object[][] dados = lista.toArray(new Object[0][]);

		DefaultTableModel modelo = new DefaultTableModel(dados, colunas);
		tabela = new JTable();

		tabela.setModel(modelo);
		tabela.setPreferredScrollableViewportSize(new Dimension(900, 300));

		painel = getPainel(0, 350, janela, new Color(100, 100, 100));
		painel.add(new JScrollPane(tabela));

		janela.add(painel);

		janela.repaint();
		janela.setVisible(true);

	}

	public void bntAtualizar(JFrame janela) {
		JButton bnt = new JButton("Atualizar");
		bnt.setFont(new Font("Arial", Font.BOLD, 14));

		bnt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				atualizar(tabela, janela);

			}
		});

		JButton bntnovo = new JButton("Adicionar");
		bntnovo.setFont(new Font("Arial", Font.BOLD, 14));

		bntnovo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new TelaAparelho();

			}
		});

		JPanel painel = getPainel(janela.getWidth() - 300, janela.getHeight() - 100, 250, 40, new Color(255, 255, 255));
		painel.setBackground(null);
		painel.add(bntnovo);
		painel.add(bnt);
		janela.add(painel);
	}

	public void titulo(String txt, JFrame janela) {
		JLabel texto = new JLabel(txt);
		texto.setFont(new Font("Arial", Font.BOLD, 25));

		JPanel painel = getPainel(0, 50, janela, new Color(200, 200, 200));
		painel.setBackground(new Color(250, 250, 250));
		painel.add(texto);
		janela.add(painel);
	}

	public JPanel getPainel(int y, int h, JFrame j, Color c) {
		JPanel p = new JPanel();
		p.setBounds(0, y, j.getWidth(), h);
		p.setBackground(c);
		return p;
	}

	public JPanel getPainel(int x, int y, int w, int h, Color c) {
		JPanel p = new JPanel();
		p.setBounds(x, y, w, h);
		p.setBackground(c);
		return p;
	}
	
	public JTextField getAparelho() {
		return aparelho;
	}
}
