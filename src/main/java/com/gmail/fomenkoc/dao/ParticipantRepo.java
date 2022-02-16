package com.gmail.fomenkoc.dao;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.gmail.fomenkoc.domain.Level;
import com.gmail.fomenkoc.domain.Participant;

@Repository
public class ParticipantRepo {

	private List<Participant> participants = new ArrayList<Participant>();

	@PostConstruct
	public void init() {
		save(new Participant("First Participant", "fparticipant@gmail.com",
				Level.L1, "Make coffee"));
		save(new Participant("Second Participant", "sparticipant@gmail.com",
				Level.L2, "Bring donuts"));
		save(new Participant("Third Participant", "tparticipant@gmail.com",
				Level.L3, "Jokes"));

	}

	public List<Participant> findAllParticipants() {
		return participants;
	}

	public Participant findOne(Integer id) {

		return participants.stream()
				.filter(participant -> participant.getId() == id).findFirst()
				.orElse(null);
	}

	public void save(Participant participant) {
		Integer newId = null;
		if (participant.getId() == null) {
			if (participants.size() != 0) {
				newId = participants.stream()
						.max(Comparator.comparing(Participant::getId))
						.orElse(null).getId() + 1;
			} else {
				newId = 1;
			}
			participant.setId(newId);
			participants.add(participant);
		} else {
			int index = participants.indexOf(findOne(participant.getId()));
			participants.set(index, participant);
		}
	}

	public void delete(Integer id) {
		Iterator<Participant> iterator = participants.iterator();
		while (iterator.hasNext()) {
			if (iterator.next().getId() == id) {
				iterator.remove();
			}
		}

	}

}
