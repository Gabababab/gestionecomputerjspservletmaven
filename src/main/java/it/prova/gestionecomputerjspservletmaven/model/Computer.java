package it.prova.gestionecomputerjspservletmaven.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "computer")
public class Computer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "marca")
	private String marca;
	@Column(name = "modello")
	private String modello;
	@Column(name = "prezzo")
	private Integer prezzo;
	@Column(name = "datarilascio")
	private Date dataRilascio;

	public Computer() {
	};
	
	

	public Computer(String marca, String modello) {
		super();
		this.marca = marca;
		this.modello = modello;
	}



	public Computer(String marca, String modello, Integer prezzo, Date dataRilascio) {
		super();
		this.marca = marca;
		this.modello = modello;
		this.prezzo = prezzo;
		this.dataRilascio = dataRilascio;
	}



	public Computer(Long id, String marca, String modello, Integer prezzo, Date dataRilascio) {
		super();
		this.id = id;
		this.marca = marca;
		this.modello = modello;
		this.prezzo = prezzo;
		this.dataRilascio = dataRilascio;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModello() {
		return modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public Integer getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(Integer prezzo) {
		this.prezzo = prezzo;
	}

	public Date getDataRilascio() {
		return dataRilascio;
	}

	public void setDataRilascio(Date dataRilascio) {
		this.dataRilascio = dataRilascio;
	}

}
