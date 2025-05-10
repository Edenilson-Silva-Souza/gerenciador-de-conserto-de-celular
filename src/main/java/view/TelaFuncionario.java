package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import control.Central;
import model.Funcionario;

public class TelaFuncionario {
	
	private JTextField nome = new JTextField(20);
	private JTextField cpf = new JTextField(20);
	private JTextField empresa = new JTextField(20);
	private JTextField salario = new JTextField(20);
	private JTextField cargo = new JTextField(20);
	private JTextField horasSemanais = new JTextField(20);
	
	private int id;
	
	public TelaFuncionario() {
		JFrame janela = new JFrame();
		janela.setSize(700, 540);
		//janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setResizable(false);
		janela.setTitle("Inicio");
		janela.setLayout(null);
		janela.setLocationRelativeTo(null);
		iniciar(janela);
	}
	
	
	public void iniciar(JFrame janela ) {
		titulo("Cadastrar Funcionário", janela);
		addTextFild(janela);
		bntCadastrar(janela);
		janela.setVisible(true);
	}
	
	
	public void bntCadastrar(JFrame janela ) {
		JButton bntImporte= new JButton("Importar");
		bntImporte.setFont(new Font("Arial",Font.BOLD,14));
		
		bntImporte.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = JOptionPane.showInputDialog(janela, "ID funcionário");

				if(id!=null) {
					Central central = new Central();
					Map mapa = central.ler(Integer.parseInt(id));
					central.getSession().close();
				
					getCpf().setText((String) mapa.get("cpf"));
					getNome().setText((String) mapa.get("nome"));
					getEmpresa().setText((String) mapa.get("empresa"));
					getSalario().setText((String) mapa.get("salario"));
					getCargo().setText((String) mapa.get("cargo"));
					getHorasSemanais().setText((String) mapa.get("horas_S"));
					
				}
			
			}
		});
		
		JButton bnt = new JButton("Cadastrar");
		bnt.setFont(new Font("Arial",Font.BOLD,14));
		
		bnt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int d = JOptionPane.showConfirmDialog(janela, "Cadastrar novo funcionário?","Confirmar",JOptionPane.OK_CANCEL_OPTION);
				
				if(d==0) {
					Central central = new Central();
					Funcionario fun = new Funcionario(Integer.parseInt(cpf.getText()) , nome.getText(), empresa.getText(),Float.parseFloat(salario.getText()) , cargo.getText(), Integer.parseInt(horasSemanais.getText()) );
					central.cadastrar(fun);
					central.getSession().close();
					JOptionPane.showMessageDialog(janela, "Cadastrado");
					
				}
				
			}
		});
		
		JButton bntListaF = new JButton("Funcionarios");
		bntListaF.setFont(new Font("Arial",Font.BOLD,14));
		bntListaF.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ListaFuncionario();
				
			}
		});
		
		JButton bntAtualize = new JButton("Atualizar");
		bntAtualize.setFont(new Font("Arial",Font.BOLD,14));
		bntAtualize.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = JOptionPane.showInputDialog(janela, "ID funcionário");
				setId(Integer.parseInt(id));
				
				
				Central central = new Central();
				central.updateCadastro(getId(), nome.getText(), cpf.getText(), empresa.getText(), salario.getText(), cargo.getText(), horasSemanais.getText());
				central.getSession().close();
				
				
				JOptionPane.showMessageDialog(janela, "Atualizado");
			}
		});
		
		
		
		JPanel painel =  getPainel(janela.getWidth()-400-100,janela.getHeight()-100,450,40,new Color(200,100,200));
		painel.setBackground(null);
		painel.add(bntImporte);
		painel.add(bntAtualize);
		painel.add(bntListaF);
		painel.add(bnt);
		janela.add(painel);
	}
	
	public void addTextFild(JFrame janela) {
		
		JLabel n = new JLabel("Nome: ");
		n.setFont(new Font("Arial",Font.BOLD,14));
		n.setForeground(new Color(0,0,0));
		n.setFont(new Font("Arial",Font.BOLD,14));
		JPanel painel = getPainel(100,25, janela,new Color(200,100,200));
		painel.setBackground(new Color(250,250,250));
		painel.add(n);
		painel.add(nome);
		janela.add(painel);
		
		n = new JLabel("Cpf: ");
		n.setFont(new Font("Arial",Font.BOLD,14));
		n.setForeground(new Color(0,0,0));
		n.setFont(new Font("Arial",Font.BOLD,14));
		painel = getPainel(125,25, janela,new Color(200,100,200));
		painel.setBackground(new Color(250,250,250));
		painel.add(n);
		painel.add(cpf);
		janela.add(painel);		

		n = new JLabel("empresa: ");
		n.setFont(new Font("Arial",Font.BOLD,14));
		n.setForeground(new Color(0,0,0));
		n.setFont(new Font("Arial",Font.BOLD,14));
		painel = getPainel(150,25, janela,new Color(200,100,200));
		painel.setBackground(new Color(250,250,250));
		painel.add(n);
		painel.add(empresa);
		janela.add(painel);	
		
		n = new JLabel("Salário: ");
		n.setFont(new Font("Arial",Font.BOLD,14));
		n.setForeground(new Color(0,0,0));
		n.setFont(new Font("Arial",Font.BOLD,14));
		painel = getPainel(175,25, janela,new Color(200,100,200));
		painel.setBackground(new Color(250,250,250));
		painel.add(n);
		painel.add(salario);
		janela.add(painel);
		
		n = new JLabel("Cargo: ");
		n.setFont(new Font("Arial",Font.BOLD,14));
		n.setForeground(new Color(0,0,0));
		n.setFont(new Font("Arial",Font.BOLD,14));
		painel = getPainel(200,25, janela,new Color(200,100,200));
		painel.setBackground(new Color(250,250,250));
		painel.add(n);
		painel.add(cargo);
		janela.add(painel);
		
		n = new JLabel("Horas Semanais: ");
		n.setFont(new Font("Arial",Font.BOLD,14));
		n.setForeground(new Color(0,0,0));
		n.setFont(new Font("Arial",Font.BOLD,14));
		painel = getPainel(225,25, janela,new Color(200,100,200));
		painel.setBackground(new Color(250,250,250));
		painel.add(n);
		painel.add(horasSemanais);
		janela.add(painel);	
	}
	
	public void titulo(String txt, JFrame janela) {
		JLabel texto = new JLabel(txt);
		texto.setFont(new Font("Arial",Font.BOLD,25));
		
		
		JPanel painel= getPainel(0,50, janela,new Color(200,200,200));
		painel.setBackground(new Color(250,250,250));
		painel.add(texto);
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
	
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}


	public JTextField getNome() {
		return nome;
	}


	public JTextField getCpf() {
		return cpf;
	}


	public JTextField getEmpresa() {
		return empresa;
	}


	public JTextField getSalario() {
		return salario;
	}


	public JTextField getCargo() {
		return cargo;
	}


	public JTextField getHorasSemanais() {
		return horasSemanais;
	}
	
	
}
