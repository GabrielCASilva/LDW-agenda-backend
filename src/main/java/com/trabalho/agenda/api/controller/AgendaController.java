package com.trabalho.agenda.api.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.trabalho.agenda.api.dto.AgendaDTO;
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
		agenda.setContato(dto.getContato());
		agenda.setCompromisso(dto.getCompromisso());
		return agenda;
	}

	@GetMapping("/registro")
	public ResponseEntity<List<Agenda>> buscar(@RequestParam(value = "nome", required = false) String nome,
			@RequestParam(value = "data", required = false) LocalDate data,
			@RequestParam(value = "horario", required = false) Integer horario,
			@RequestParam(value = "contato", required = false) String contato,
			@RequestParam(value = "compromisso", required = false) String compromisso) {
		Agenda agendaFiltro = new Agenda();
		agendaFiltro.setNome(nome);
		agendaFiltro.setData(data);
		agendaFiltro.setHorario(horario);
		agendaFiltro.setContato(contato);
		agendaFiltro.setCompromisso(compromisso);
		List<Agenda> agendas = _service.buscar(agendaFiltro);
		return ResponseEntity.ok(agendas);
	}
}
