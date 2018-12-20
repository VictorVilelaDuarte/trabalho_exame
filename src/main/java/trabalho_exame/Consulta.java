package trabalho_exame;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="consulta")
public class Consulta {
	
	 @Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	 @Column
	 private Integer id;
	 @Column
	 private Date dia;
	 @Column
	 private Time hora;
	 @Column
	 private String obs;
	 
	 @JoinColumn(name = "paciente_id")
	 @OneToOne(cascade = CascadeType.ALL)
	 private Paciente paciente;
	 
	 @JoinColumn(name = "medico_id")
	 @OneToOne(cascade = CascadeType.ALL)
	 private Medico medico;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDia() {
		return dia;
	}

	public void setDia(Date dia) {
		this.dia = dia;
	}

	public Time getHora() {
		return hora;
	}

	public void setHora(Time hora) {
		this.hora = hora;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	
	 
}
