package application.models; // Define que este arquivo pertence ao pacote models

// Importação das bibliotecas
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // Define a classe a seguir como uma entidade do banco de dados MySQL

@Table(name="autores") // Define o nome da entidade como "autores"

// Criação da classe
public class Autor {
    @Id // Diz que o próximo campo será uma primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Diz que o próximo campo incrementará a cada registro.
    private int id; // Cria o "id" como inteiro.
    private String nome; // Cria outro campo chamado "nome", do tipo varchar() ou String;
    
    // Getters e setters dos atributos "id" e "nome" (Recuperar e setar).
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

    


}
