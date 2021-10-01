package br.com.ceepplg.livraria.controle;

import br.com.ceepplg.livraria.modelo.Livro;
import br.com.ceepplg.livraria.repositorio.Autores;
import br.com.ceepplg.livraria.repositorio.Editoras;
import br.com.ceepplg.livraria.repositorio.Livros;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/livros")
public class LivroControle {

    @Autowired
    private Livros livros;
    @Autowired
    private Editoras editoras;
    @Autowired
    private Autores autores;

    @GetMapping
    public String home(Model model) {
        model.addAttribute("livros", livros.findAll());
        return "livros/home";
    }

    @GetMapping("/cadastro")
    public String form(Model model) {
        model.addAttribute("livro", new Livro());
        model.addAttribute("editoras", editoras.findAll());
        model.addAttribute("autores", autores.findAll());
        return "livros/form";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        Livro livro = livros.findById(id).get();
        model.addAttribute("editoras", editoras.findAll());
        model.addAttribute("autores", autores.findAll());
        model.addAttribute("livro", livro);
        return "livros/form";
    }

    @PostMapping
    public String cadastrar(Livro livro) {
        livros.save(livro);
        return "redirect:/livros";
    }

}
