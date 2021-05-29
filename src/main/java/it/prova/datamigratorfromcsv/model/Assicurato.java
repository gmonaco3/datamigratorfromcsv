package it.prova.datamigratorfromcsv.model;

import java.util.Date;

public class Assicurato {
	private Long id;
	private String nome;
	private String cognome;
	private Date dataNascita;
	private Integer totaleSinistri;
	private String codiceFiscale;

	public Assicurato() {
		super();
	}

	public Assicurato(Long id, String nome, String cognome, Date dataNascita, Integer totaleSinistri,
			String codiceFiscale) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
		this.totaleSinistri = totaleSinistri;
		this.codiceFiscale = codiceFiscale;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Date getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}

	public Integer getTotaleSinistri() {
		return totaleSinistri;
	}

	public void setTotaleSinistri(Integer totaleSinistri) {
		this.totaleSinistri = totaleSinistri;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Assicurato other = (Assicurato) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Assicurato [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", dataNascita=" + dataNascita
				+ ", totaleSinistri=" + totaleSinistri + ", codiceFiscale=" + codiceFiscale + "]";
	}

}
