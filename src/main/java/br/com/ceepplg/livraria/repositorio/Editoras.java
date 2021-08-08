package br.com.ceepplg.livraria.repositorio;

import br.com.ceepplg.livraria.modelo.Editora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Editoras extends JpaRepository<Editora, Integer> {
}
