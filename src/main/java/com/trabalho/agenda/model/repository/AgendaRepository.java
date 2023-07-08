package com.trabalho.agenda.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trabalho.agenda.model.entity.Agenda;

public interface AgendaRepository extends JpaRepository<Agenda, Long> {

}
