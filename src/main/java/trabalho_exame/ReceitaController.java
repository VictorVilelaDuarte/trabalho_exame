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

import trabalho_exame.Receita;
import trabalho_exame.ReceitaRepository;

@RestController
@RequestMapping(path="/receita")
public class ReceitaController {
	
	@Autowired
	private ReceitaRepository receitaRepository;
	
	
	@PostMapping("/add")
	public Receita createReceita(@Valid @RequestBody Receita receita) {
	    return receitaRepository.save(receita);
	}	
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Receita> getAllReceitas() {
		return receitaRepository.findAll();
	}
	
	@PutMapping("/altera/{id}")
	public Receita updateReceita(@PathVariable(value = "id") Integer receitaId,
	                                        @Valid @RequestBody Receita receitaDetails) {

	    Receita receita = receitaRepository.findById(receitaId).orElseThrow(() -> new ResourceNotFoundException("Receita", "id", receitaId));

	    receita.setRemedio(receitaDetails.getRemedio());
	    receita.setRestricao(receitaDetails.getRestricao());

	    Receita updatedReceita = receitaRepository.save(receita);
	    return updatedReceita;
	}
		
	@DeleteMapping("/del/{id}")
	public ResponseEntity<?> deleteReceita(@PathVariable(value = "id") Integer receitaId) {
	    Receita receita = receitaRepository.findById(receitaId)
	            .orElseThrow(() -> new ResourceNotFoundException("Receita", "id", receitaId));

	    receitaRepository.delete(receita);

	    return ResponseEntity.ok().build();
	}
}