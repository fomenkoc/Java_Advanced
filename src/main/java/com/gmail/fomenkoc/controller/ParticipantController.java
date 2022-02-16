package com.gmail.fomenkoc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gmail.fomenkoc.domain.Level;
import com.gmail.fomenkoc.domain.Participant;
import com.gmail.fomenkoc.service.ParticipantService;

@Controller
public class ParticipantController {

	@Autowired
	private ParticipantService participantService;

	@GetMapping("/")
	public String init(HttpServletRequest req) {
		req.setAttribute("participants",
				participantService.findAllParticipants());
		req.setAttribute("mode", "PARTICIPANT_VIEW");
		
		return "index";
	}

	@GetMapping("/new")
	public String newParticipant(HttpServletRequest req) {
		req.setAttribute("mode", "PARTICIPANT_CREATE");
		req.setAttribute("levels", Level.getList());
		return "index";
	}

	@PostMapping("/save")
	public String save(@ModelAttribute Participant participant,
			HttpServletRequest req) {
		participantService.save(participant);
		req.setAttribute("participants",
				participantService.findAllParticipants());
		req.setAttribute("mode", "PARTICIPANT_VIEW");
		return "index";
	}

	@GetMapping("/update")
	public String update(@RequestParam Integer id, HttpServletRequest req) {
		req.setAttribute("participant", participantService.findOne(id));
		req.setAttribute("mode", "PARTICIPANT_EDIT");
		req.setAttribute("levels", Level.getList());
		return "index";
	}

	@GetMapping("/delete")
	public String deleteParticipant(@RequestParam Integer id,
			HttpServletRequest req) {
		participantService.delete(id);
		req.setAttribute("participants",
				participantService.findAllParticipants());
		req.setAttribute("mode", "PARTICIPANT_VIEW");
		return "index";
	}
}
