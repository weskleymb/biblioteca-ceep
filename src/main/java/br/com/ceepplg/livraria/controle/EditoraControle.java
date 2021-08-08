package br.com.ceepplg.livraria.controle;

import br.com.ceepplg.livraria.modelo.Editora;
import br.com.ceepplg.livraria.modelo.Livro;
import br.com.ceepplg.livraria.repositorio.Editoras;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/editoras")
public class EditoraControle {

    @Autowired
    private Editoras editoras;

    @GetMapping
    public String home(Model model) {
        model.addAttribute("editoras", editoras.findAll());
        return "editoras/home";
    }

    @GetMapping("/cadastro")
    public String form(Model model) {
        model.addAttribute("editora", new Editora());
        return "editoras/form";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        Editora editora = editoras.findById(id).get();
        model.addAttribute("editora", editora);
        return "editoras/form";
    }

    @PostMapping
    public String cadastrar(Editora editora) {
        editoras.save(editora);
        return "redirect:/editoras";
    }

}
