package trabalho_exame;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import trabalho_exame.Consulta;
import trabalho_exame.ConsultaRepository;

@RestController
@RequestMapping(path="/consulta")
public class ConsultaController {
	
	@Autowired
	private ConsultaRepository consultaRepository;
	
	
	@PostMapping("/add")
	public Consulta createConsulta(@Valid @RequestBody Consulta consulta) {
	    return consultaRepository.save(consulta);
	}	
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Consulta> getAllConsultas() {
		return consultaRepository.findAll();
	}
	
	@PutMapping("/altera/{id}")
	public Consulta updateConsulta(@PathVariable(value = "id") Integer consultaId,
	                                        @Valid @RequestBody Consulta consultaDetails) {

	    Consulta consulta = consultaRepository.findById(consultaId).orElseThrow(() -> new ResourceNotFoundException("Consulta", "id", consultaId));

	    consulta.setDia(consultaDetails.getDia());
	    consulta.setHora(consultaDetails.getHora());

	    Consulta updatedConsulta = consultaRepository.save(consulta);
	    return updatedConsulta;
	}
		
	@DeleteMapping("/del/{id}")
	public ResponseEntity<?> deleteConsulta(@PathVariable(value = "id") Integer consultaId) {
	    Consulta consulta = consultaRepository.findById(consultaId)
	            .orElseThrow(() -> new ResourceNotFoundException("Consulta", "id", consultaId));

	    consultaRepository.delete(consulta);

	    return ResponseEntity.ok().build();
	}
}