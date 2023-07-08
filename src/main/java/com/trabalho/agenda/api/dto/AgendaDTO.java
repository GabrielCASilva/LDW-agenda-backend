package com.trabalho.agenda.api.dto;

import java.time.LocalDate;

import com.trabalho.agenda.model.entity.Agenda;

public class AgendaDTO {

	private Long id;
	private String nome;
	private LocalDate data;
	private Integer horario;
	private String telefone;
	private String compromisso;

	public AgendaDTO() {
	}

	public AgendaDTO(Agenda entity) {
		this.id = entity.getId();
		this.nome = entity.getNome();
		this.data = entity.getData();
		this.horario = entity.getHorario();
		this.telefone = entity.getTelefone();
		this.compromisso = entity.getCompromisso();
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

}
