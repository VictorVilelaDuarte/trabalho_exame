package trabalho_exame;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import trabalho_exame.Consulta;

@Repository
public interface ConsultaRepository extends JpaRepository <Consulta, Integer> {

}