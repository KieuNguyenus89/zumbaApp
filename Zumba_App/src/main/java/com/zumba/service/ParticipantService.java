package com.zumba.service;

import java.util.List;

import com.zumba.bean.Participant;
import com.zumba.dao.ParticipantDao;

public class ParticipantService {

	ParticipantDao pd = new ParticipantDao();

	public String storeParticipatns(Participant participant) {
		if (pd.addParticipants(participant) > 0) {
			return "Participants details added successfully";
		} else {
			return "Participant details didn't add";
		}
	}

	public List<Participant> findAllParticipant() {
		return pd.findAllParticipant();
	}

	public String updateParticipatns(Participant participant) {
		if (pd.updateParticipant(participant) > 0) {
			return "updated Participants successfully";
		} else {
			return "Participants didn't update";
		}
	}

	public String deleteParticipatns(int participantid) {
		if (pd.deleteParticipant(participantid) > 0) {
			return "Participants record deleted successfully";
		} else {
			return "Participantrecord didn't delete";
		}
	}
}