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

import trabalho_exame.Paciente;
import trabalho_exame.PacienteRepository;

@RestController
@RequestMapping(path="/paciente")
public class PacienteController {
	
	@Autowired
	private PacienteRepository pacienteRepository;
	
	
	@PostMapping("/add")
	public Paciente createPaciente(@Valid @RequestBody Paciente paciente) {
	    return pacienteRepository.save(paciente);
	}
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Paciente> getAllPacientes() {
		return pacienteRepository.findAll();
	}
	
	@PutMapping("/altera/{id}")
	public Paciente updatePaciente(@PathVariable(value = "id") Integer pacienteId,
	                                        @Valid @RequestBody Paciente pacienteDetails) {

	    Paciente paciente = pacienteRepository.findById(pacienteId).orElseThrow(() -> new ResourceNotFoundException("Paciente", "id", pacienteId));

	    paciente.setNome(pacienteDetails.getNome());
	    paciente.setCpf(pacienteDetails.getCpf());

	    Paciente updatedPaciente = pacienteRepository.save(paciente);
	    return updatedPaciente;
	}
		
	@DeleteMapping("/del/{id}")
	public ResponseEntity<?> deletePaciente(@PathVariable(value = "id") Integer pacienteId) {
	    Paciente paciente = pacienteRepository.findById(pacienteId)
	            .orElseThrow(() -> new ResourceNotFoundException("Paciente", "id", pacienteId));

	    pacienteRepository.delete(paciente);

	    return ResponseEntity.ok().build();
	}
}