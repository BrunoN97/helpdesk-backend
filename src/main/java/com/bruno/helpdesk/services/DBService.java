package com.bruno.helpdesk.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bruno.helpdesk.domain.Chamado;
import com.bruno.helpdesk.domain.Cliente;
import com.bruno.helpdesk.domain.Tecnico;
import com.bruno.helpdesk.domain.enums.Perfil;
import com.bruno.helpdesk.domain.enums.Prioridade;
import com.bruno.helpdesk.domain.enums.Status;
import com.bruno.helpdesk.repositories.ChamadoRepository;
import com.bruno.helpdesk.repositories.ClienteRepository;
import com.bruno.helpdesk.repositories.TecnicoRepository;

@Service
public class DBService {

	@Autowired
	private TecnicoRepository tecnicoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ChamadoRepository chamadoRepository;

	public void instanciaDB() {
		Tecnico tec1 = new Tecnico(null, "Bruno Nobre", "63653230268", "nobre.piaget@gmail.com", "123");
		tec1.addPerfil(Perfil.ADMIN);
		Tecnico tec2 = new Tecnico(null, "Victor Nobre", "45163688898", "nobre@gmail.com", "123");
		Tecnico tec3 = new Tecnico(null, "João Freire", "45186899956", "piaget@gmail.com", "123");

		Cliente cli1 = new Cliente(null, "Linus Torvades", "80527954780", "torvades@mail.com", "123");
		Cliente cli2 = new Cliente(null, "Maria Torvades", "12378955544", "Maria@mail.com", "123");
		Cliente cli3 = new Cliente(null, "Jorge Tonho", "11222211213", "Jorge@mail.com", "123");

		Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 01", "Primeiro chamado", tec1,
				cli1);
		Chamado c2 = new Chamado(null, Prioridade.ALTA, Status.ANDAMENTO, "Chamado 02", "Segundo chamado", tec2,
				cli2);
		Chamado c3 = new Chamado(null, Prioridade.BAIXA, Status.ANDAMENTO, "Chamado 03", "Terceiro chamado", tec2,
				cli3);

		tecnicoRepository.saveAll(Arrays.asList(tec1, tec2, tec3));
		clienteRepository.saveAll(Arrays.asList(cli1, cli2, cli3));
		chamadoRepository.saveAll(Arrays.asList(c1, c2, c3));
	}
}
