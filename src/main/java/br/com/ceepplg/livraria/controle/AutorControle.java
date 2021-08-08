package br.com.ceepplg.livraria.controle;


import br.com.ceepplg.livraria.modelo.Autor;
import br.com.ceepplg.livraria.modelo.Editora;
import br.com.ceepplg.livraria.repositorio.Autores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/autores")
public class AutorControle {

    @Autowired
    private Autores autores;

    @GetMapping
    public String home(Model model) {
        model.addAttribute("autores", autores.findAll());
        return "autores/home";
    }

    @GetMapping("/cadastro")
    public String form(Model model) {
        model.addAttribute("autor", new Autor());
        return "autores/form";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        Autor autor = autores.findById(id).get();
        model.addAttribute("autor", autor);
        return "autores/form";
    }

    @PostMapping
    public String cadastrar(Autor autor) {
        autores.save(autor);
        return "redirect:/autores";
    }

}
