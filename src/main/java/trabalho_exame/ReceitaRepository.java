package trabalho_exame;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import trabalho_exame.Receita;

@Repository
public interface ReceitaRepository extends JpaRepository <Receita, Integer> {

}