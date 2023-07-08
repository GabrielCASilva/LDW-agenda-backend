package com.trabalho.agenda.model.entity;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "agenda", schema = "agenda")
public class Agenda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "nome", nullable = false)
	private String nome;
	@Column(name = "data", nullable = false)
	private LocalDate data;
	@Column(name = "horario", nullable = false)
	private Integer horario;
	@Column(name = "telefone", nullable = false)
	private String telefone;
	@Column(name = "compromisso", nullable = false)
	private String compromisso;

	public Agenda() {
	}

	public Agenda(Long id, String nome, LocalDate data, Integer horario, String telefone, String compromisso) {
		this.id = id;
		this.nome = nome;
		this.data = data;
		this.horario = horario;
		this.telefone = telefone;
		this.compromisso = compromisso;
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

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Integer getHorario() {
		return horario;
	}

	public void setHorario(Integer horario) {
		this.horario = horario;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCompromisso() {
		return compromisso;
	}

	public void setCompromisso(String compromisso) {
		this.compromisso = compromisso;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Agenda other = (Agenda) obj;
		return Objects.equals(id, other.id);
	}

}
