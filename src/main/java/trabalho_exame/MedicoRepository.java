package trabalho_exame;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import trabalho_exame.Medico;

@Repository
public interface MedicoRepository extends JpaRepository <Medico, Integer> {

}