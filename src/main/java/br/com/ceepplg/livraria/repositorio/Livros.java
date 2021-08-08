package br.com.ceepplg.livraria.repositorio;

import br.com.ceepplg.livraria.modelo.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Livros extends JpaRepository<Livro, Integer> {
}
