package com.trabalho.agenda.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.trabalho.agenda.model.entity.Agenda;
import com.trabalho.agenda.model.repository.AgendaRepository;

import jakarta.transaction.Transactional;

@Service
public class AgendaServiceImpl implements AgendaService {

	private AgendaRepository _repository;

	public AgendaServiceImpl(AgendaRepository repository) {
		super();
		this._repository = repository;
	}

	@Override
	@Transactional
	public Agenda salvar(Agenda agenda) {
		return _repository.save(agenda);
	}

	@Override
	@Transactional
	public Agenda atualizar(Agenda agenda) {
		Objects.requireNonNull(agenda.getId());
		return _repository.save(agenda);
	}

	@Override
	@Transactional
	public void deletar(Agenda agenda) {
		Objects.requireNonNull(agenda.getId());
		_repository.delete(agenda);

	}

	@Override
	@Transactional
	public List<Agenda> buscar(Agenda agenda) {
		Example<Agenda> example = Example.of(agenda);
		return (List<Agenda>) _repository.findAll(example);
	}

	@Override
	@Transactional
	public Optional<Agenda> consultarPorId(Long id) {
		return _repository.findById(id);
	}
}
