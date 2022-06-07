package application.controllers; // Define que este arquivo pertence ao pacote "controllers"
 

// Importações dos pacotes;
import java.util.Optional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
 
import application.models.Autor; // Importa o model "Autor" (Classe)
import application.repositories.AutorRepository; // Importa o repositório "Autor" (Classe)
 
@Controller // Diz que a próxima class é um controller
@RequestMapping("/autor") // Diz que a próxima classe será chamada na rota /autor. (O usuário que acessar www.linkdosite.com/autor irá acessar essa classe)
public class AutorController {
    @Autowired
    private AutorRepository autorRepo; // Cria um objeto da classe AutorRepository
 
    @RequestMapping("/list") // Cria uma subrota dentro da rota autor/ (Significa que o usuário que acessar www.linkdosite.com/autor/list acessará esse próximo método)
    public String list(Model model) { // Cria um método chamado list que espera um objeto chamado Model da classe model ao ser chamada
        model.addAttribute("autores", autorRepo.findAll()); // Cria um atributo que será reutilizado pelo arquivo list.jsp. Este atributo receberá a lista de autores cadastrados no sistema
        return "list.jsp"; // Retorna o nome do arquivo .jsp que será apresentado ao usuário quando ele acessar essa rota.
    }
 
    @RequestMapping("/insert")// Cria uma subrota dentro da rota autor/ (Significa que o usuário que acessar www.linkdosite.com/autor/insert acessará esse próximo método)
    public String formInsert() { // Cria um método com o nome formInsert que retornará o tipo String
        return "insert.jsp"; // Retorna o nome do jsp insert, que será a pasta de cadastro de autores.
    }
 
    @RequestMapping(value = "/insert", method = RequestMethod.POST) // Define uma função caso a rota /insert estiver sendo requisitada pelo método POST do HTTP.
    public String saveInsert(@RequestParam("nome") String nome) { // Cria um método que pega o que foi passado no corpo da requisição (o nome do autor, no caso) para ser usado pelas próximas linhas
        Autor autor = new Autor(); // Cria um objeto a partir do model autor.
        autor.setNome(nome); // Seta o nome do objeto autor para o nome que foi recebido do jsp.
 
        autorRepo.save(autor); ;// Salva o autor no banco de dados.
 
        return "redirect:/autor/list"; // Redireciona o usuário para a lista de autores;
    }
 
    @RequestMapping("/update/{id}") // Cria uma rota esperando um parâmetro na URL
    public String formUpdate(Model model, @PathVariable int id) { // cria uma função chamada formUpdate() que espera dois parâmetros e retorna uma string.
        Optional<Autor> autor = autorRepo.findById(id); // Acha o autor pelo id e recupera seus dados;
        if(!autor.isPresent()) // Verifica se o autor não existe e o redireciona para a lista de autores caso isso seja verdade.
            return "redirect:/autor/list";
        model.addAttribute("autor", autor.get()); // passa o autor agora encontrado como atributo para o arquivo update.jsp.
        return "/autor/update.jsp";
    }
 
    @RequestMapping(value = "/update", method = RequestMethod.POST) // Cria um método POST para a rota autor/update
    public String saveUpdate(@RequestParam("nome") String nome, @RequestParam("id") int id) { // Pega o id do autor e o novo nome como parâmetros, os requisitando do update.jsp
        Optional<Autor> autor = autorRepo.findById(id); // Acha o autor pelo id e recupera seus dados;
        if(!autor.isPresent()) // Verifica se o autor não existe e o redireciona para a lista de autores caso isso seja verdade.
            return "redirect:/autor/list";
        autor.get().setNome(nome); // seta o novo nome
 
        autorRepo.save(autor.get()); // salva o novo nome
 
        return "redirect:/autor/list"; // redireciona o usuário para a lista de autores
    }
 
    @RequestMapping("/delete/{id}") //Cria uma rota esperando um parâmetro na URL
    public String formDelete(Model model, @PathVariable int id) { // cria uma função chamada formDelete() que espera dois parâmetros e retorna uma string.
        Optional<Autor> autor = autorRepo.findById(id); // Acha o autor pelo id e recupera seus dados;
        if(!autor.isPresent()) // Verifica se o autor não existe e o redireciona para a lista de autores caso isso seja verdade.
            return "redirect:/autor/list";
        model.addAttribute("autor", autor.get()); // Passa os dados recuperados de autor como atributo para o delete.jsp
        return "/autor/delete.jsp";
    }
 
    @RequestMapping(value = "/delete", method = RequestMethod.POST) // Cria um método POST para a rota autor/update
    public String confirmDelete(@RequestParam("id") int id) { // cria uma função chamada formDelete() que espera um parâmetro e retorna uma string.
        autorRepo.deleteById(id); // Deleta o autor por Id
        return "redirect:/autor/list"; // Redireciona o usuário para a lista de autores
    }
}