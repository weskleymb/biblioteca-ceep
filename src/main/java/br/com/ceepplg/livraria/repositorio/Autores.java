package br.com.ceepplg.livraria.repositorio;

import br.com.ceepplg.livraria.modelo.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Autores extends JpaRepository<Autor, Integer> {
}
