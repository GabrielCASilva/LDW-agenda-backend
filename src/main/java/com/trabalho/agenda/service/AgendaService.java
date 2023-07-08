package com.trabalho.agenda.service;

import java.util.List;
import java.util.Optional;

import com.trabalho.agenda.model.entity.Agenda;

public interface AgendaService {
	Agenda salvar(Agenda agenda);

	Agenda atualizar(Agenda agenda);

	void deletar(Agenda agenda);

	List<Agenda> buscar(Agenda agenda);

	Optional<Agenda> consultarPorId(Long id);
}
