package com.trabalho.agenda.api.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.trabalho.agenda.api.dto.AgendaDTO;
import com.trabalho.agenda.exceptions.RegraNegocioException;
import com.trabalho.agenda.model.entity.Agenda;
import com.trabalho.agenda.service.AgendaService;

@RestController
@RequestMapping("/api/agenda")
public class AgendaController {

	AgendaService _service;

	public AgendaController(AgendaService service) {
		this._service = service;
	}

	private Agenda converter(AgendaDTO dto) {
		Agenda agenda = new Agenda();

		agenda.setNome(dto.getNome());
		agenda.setData(dto.getData());
		agenda.setHorario(dto.getHorario());
		agenda.setTelefone(dto.getTelefone());
		agenda.setCompromisso(dto.getCompromisso());
		return agenda;
	}

	@GetMapping("/registro")
	public ResponseEntity<List<Agenda>> buscar(@RequestParam(value = "nome", required = false) String nome,
			@RequestParam(value = "data", required = false) LocalDate data,
			@RequestParam(value = "horario", required = false) Integer horario,
			@RequestParam(value = "telefone", required = false) String telefone,
			@RequestParam(value = "compromisso", required = false) String compromisso) {
		Agenda agendaFiltro = new Agenda();
		agendaFiltro.setNome(nome);
		agendaFiltro.setData(data);
		agendaFiltro.setHorario(horario);
		agendaFiltro.setTelefone(telefone);
		agendaFiltro.setCompromisso(compromisso);
		List<Agenda> agendas = _service.buscar(agendaFiltro);
		return ResponseEntity.ok(agendas);
	}

	@PostMapping("/registro")
	public ResponseEntity<?> salvar(@RequestBody AgendaDTO dto) {
		try {
			Agenda entidadeAgenda = converter(dto);
			entidadeAgenda = _service.salvar(entidadeAgenda);
			return ResponseEntity.ok(entidadeAgenda);
		} catch (RegraNegocioException regraNegocioException) {
			return ResponseEntity.badRequest().body(regraNegocioException.getMessage());
		}
	}

	@PutMapping("/registro/{id}")
	public ResponseEntity<? extends Object> atualizar(@PathVariable("id") Long id, @RequestBody AgendaDTO dto) {
		return _service.consultarPorId(id).map(entity -> {
			try {
				Agenda agenda = converter(dto);
				agenda.setId(entity.getId());
				_service.atualizar(agenda);
				return ResponseEntity.ok(agenda);
			} catch (RegraNegocioException regraNegocioException) {
				return ResponseEntity.badRequest().body(regraNegocioException.getMessage());
			}
		}).orElseGet(() -> ResponseEntity.badRequest()
				.body("O id do registro informado não foi encontrado na base de dados"));
	}

	@DeleteMapping("/registro/{id}")
	public ResponseEntity<?> deletar(@PathVariable("id") Long id) {
		return _service.consultarPorId(id).map(entity -> {
			_service.deletar(entity);
			return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
		}).orElseGet(() -> ResponseEntity.badRequest()
				.body("O id do registro informado não foi encontrado na base de dados"));
	}
}
