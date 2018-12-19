package trabalho_exame;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import trabalho_exame.Paciente;
import trabalho_exame.PacienteRepository;

@Controller
@RequestMapping(path="/paciente")
public class PacienteController {
	
	@Autowired
	private PacienteRepository pacienteRepository;
	
	@GetMapping(path="/add")
	public @ResponseBody String addNewPaciente (@RequestParam String nome, @RequestParam String cpf) {

		Paciente n = new Paciente();
		n.setNome(nome);
		n.setCpf(cpf);
		pacienteRepository.save(n);
		return "Saved";
	}
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Paciente> getAllPacientes() {
		// This returns a JSON or XML with the users
		return pacienteRepository.findAll();
	}
}