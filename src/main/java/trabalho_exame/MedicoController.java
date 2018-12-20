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

import trabalho_exame.Medico;
import trabalho_exame.MedicoRepository;

@RestController
@RequestMapping(path="/medico")
public class MedicoController {
	
	@Autowired
	private MedicoRepository medicoRepository;
	
	
	@PostMapping("/add")
	public Medico createMedico(@Valid @RequestBody Medico medico) {
	    return medicoRepository.save(medico);
	}	
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Medico> getAllMedicos() {
		return medicoRepository.findAll();
	}
	
	@PutMapping("/altera/{id}")
	public Medico updateMedico(@PathVariable(value = "id") Integer medicoId,
	                                        @Valid @RequestBody Medico medicoDetails) {

	    Medico medico = medicoRepository.findById(medicoId).orElseThrow(() -> new ResourceNotFoundException("Medico", "id", medicoId));

	    medico.setNome(medicoDetails.getNome());
	    medico.setCPF(medicoDetails.getCPF());

	    Medico updatedMedico = medicoRepository.save(medico);
	    return updatedMedico;
	}
		
	@DeleteMapping("/del/{id}")
	public ResponseEntity<?> deleteMedico(@PathVariable(value = "id") Integer medicoId) {
	    Medico medico = medicoRepository.findById(medicoId)
	            .orElseThrow(() -> new ResourceNotFoundException("Medico", "id", medicoId));

	    medicoRepository.delete(medico);

	    return ResponseEntity.ok().build();
	}
}