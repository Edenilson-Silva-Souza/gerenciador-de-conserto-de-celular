package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import control.Central;
import model.Aparelho;
import model.Cliente;

public class TelaAparelho {
	private JTextField modelo = new JTextField(20);
	private JTextField fabricante = new JTextField(20);
	private JTextField clienteID = new JTextField(20);;
	
	public TelaAparelho() {
		JFrame janela = new JFrame();
		janela.setSize(700, 540);
		//janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setResizable(false);
		janela.setTitle("Cadastro de Aparelho");
		janela.setLayout(null);
		janela.setLocationRelativeTo(null);
		iniciar(janela);
	}

	public void iniciar(JFrame janela) {
		titulo("Cadastrar Aparelho", janela);
		addTextFild(janela);
		bntCadastrar(janela);
		janela.setVisible(true);
	}
	
	public void bntCadastrar(JFrame janela ) {
		JButton bnt = new JButton("Cadastrar");
		bnt.setFont(new Font("Arial",Font.BOLD,14));
		
		bnt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int d = JOptionPane.showConfirmDialog(janela, "Cadastrar novo Aparelho?","Confirmar",JOptionPane.OK_CANCEL_OPTION);
				
				/*
				String id = JOptionPane.showInputDialog(janela, "ID do Cliente");
				if(id!=null) {
					
				}
				*/
				if(d==0 && getClienteID().getText()!="") {
					
					
					Central central = new Central();
					
					Aparelho aparelho = new Aparelho();
					aparelho.setModelo(getModelo().getText());
					aparelho.setFabricante(getFabricante().getText());
					Cliente c = central.getCliente(Integer.parseInt(getClienteID().getText()) );
					aparelho.setCliente(c);
					
					
					central.cadastrarAparelho(aparelho);
					
					
					central.getSession().close();
					JOptionPane.showMessageDialog(janela, "Cadastrado");
					
				}
				else {
					JOptionPane.showMessageDialog(janela, "Preencha todos os campos");
				}
				
			}
		});
		
		JButton bntListaF = new JButton("Aparelhos");
		bntListaF.setFont(new Font("Arial",Font.BOLD,14));
		bntListaF.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ListaAparellho();
				
			}
		});
		
		
		
		JPanel painel =  getPainel(janela.getWidth()-300,janela.getHeight()-40-40-20,250,40,new Color(200,100,200));
		painel.setBackground(null);
		painel.add(bntListaF);
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

	public void addTextFild(JFrame janela) {

		JLabel n = new JLabel("Modelo: ");
		n.setFont(new Font("Arial", Font.BOLD, 14));
		n.setForeground(new Color(0, 0, 0));
		n.setFont(new Font("Arial", Font.BOLD, 14));
		JPanel painel = getPainel(100, 25, janela, new Color(200, 100, 200));
		painel.setBackground(new Color(250, 250, 250));
		painel.add(n);
		painel.add(modelo);
		janela.add(painel);
		
		n = new JLabel("Fabricate: ");
		n.setFont(new Font("Arial",Font.BOLD,14));
		n.setForeground(new Color(0,0,0));
		n.setFont(new Font("Arial",Font.BOLD,14));
		painel = getPainel(125,25, janela,new Color(200,100,200));
		painel.setBackground(new Color(250,250,250));
		painel.add(n);
		painel.add(fabricante);
		janela.add(painel);	
		
		n = new JLabel("ID Cliente: ");
		n.setFont(new Font("Arial",Font.BOLD,14));
		n.setForeground(new Color(0,0,0));
		n.setFont(new Font("Arial",Font.BOLD,14));
		painel = getPainel(150,25, janela,new Color(200,100,200));
		painel.setBackground(new Color(250,250,250));
		painel.add(n);
		painel.add(clienteID);
		janela.add(painel);	
	}
	
	public JPanel getPainel(int y,int h, JFrame j, Color c) {
		JPanel p = new JPanel();
		p.setBounds(0,y,j.getWidth(),h);
		p.setBackground(c);
		return p;
	}

	public JPanel getPainel(int x, int y,int w,int  h, Color c) {
		JPanel p = new JPanel();
		p.setBounds(x,y,w,h);
		p.setBackground(c);
		return p;
	}

	public JTextField getModelo() {
		return modelo;
	}

	public JTextField getFabricante() {
		return fabricante;
	}

	public JTextField getClienteID() {
		return clienteID;
	}


}
