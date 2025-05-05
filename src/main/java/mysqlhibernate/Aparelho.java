package mysqlhibernate;

import jakarta.persistence.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


@Entity
@Table(name="aparelhos")
public class Aparelho {
    @Id @Column (name = "id")@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "modelo")
    private String modelo;

    @Column(name = "fabricante")
    private String fabricante;

    public Aparelho(int id, String modelo, String fabricante) {
        super();
        this.id = id;
        this.modelo = modelo;
        this.fabricante = fabricante;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Aparelho() {
        super();
    }

    public static void main(String[] args) {

        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");
        config.addAnnotatedClass(Aparelho.class);

        try {
            SessionFactory sf = config.buildSessionFactory();
            Session session = sf.openSession();

            Aparelho aparelho = new Aparelho();
            aparelho.setFabricante("Samsung");
            aparelho.setModelo("Galaxy S10");

            session.beginTransaction();
            session.persist(aparelho);
            session.getTransaction().commit();

            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
