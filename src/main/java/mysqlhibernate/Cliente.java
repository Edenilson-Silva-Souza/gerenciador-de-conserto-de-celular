package mysqlhibernate;

import jakarta.persistence.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@Entity
@Table(name="clientes")
public class Cliente {

    @Id @Column (name = "id")@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cpf")
    private String cpf;

    public Cliente(int id, String nome, String cpf) {
        super();
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Cliente() {
    }

    public static void main(String[] args) {

        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");
        config.addAnnotatedClass(Cliente.class);

        try {
            SessionFactory sf = config.buildSessionFactory();
            Session session = sf.openSession();

            Cliente cliente = new Cliente();
            cliente.setNome("Marcos");
            cliente.setCpf("11827832163");

            session.beginTransaction();
            session.persist(cliente);
            session.getTransaction().commit();

            session.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
