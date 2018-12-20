package trabalho_exame;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import trabalho_exame.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository <Paciente, Integer> {

}