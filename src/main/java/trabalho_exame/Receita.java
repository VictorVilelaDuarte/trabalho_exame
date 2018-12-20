package trabalho_exame;


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
@Table(name="receita")
public class Receita {
	
	 @Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	 @Column
	 private Integer id;
	 @Column
	 private String restricao;
	 @Column
	 private String remedio;
	 @Column
	 private String obs;
	 
	 @JoinColumn(name = "consulta_id")
	 @OneToOne(cascade = CascadeType.ALL)
	 private Consulta consulta;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRestricao() {
		return restricao;
	}

	public void setRestricao(String restricao) {
		this.restricao = restricao;
	}

	public String getRemedio() {
		return remedio;
	}

	public void setRemedio(String remedio) {
		this.remedio = remedio;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public Consulta getConsulta() {
		return consulta;
	}

	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}
	 	
}
