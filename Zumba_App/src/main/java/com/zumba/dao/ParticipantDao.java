package com.zumba.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.zumba.bean.Participant;
import com.zumba.resource.DbResource;

public class ParticipantDao {

	public int addParticipants(Participant participant) {
		try {
			Connection con = DbResource.getDbConnection();
			PreparedStatement pstmt = con.prepareStatement("insert into participants values(?,?,?,?,?)");
			pstmt.setInt(1, participant.getParticipantid());
			pstmt.setString(2, participant.getPname());
			pstmt.setInt(3, participant.getAge());
			pstmt.setString(4, participant.getPhonenumber());
			pstmt.setInt(5, participant.getBatchid());
			return pstmt.executeUpdate();
		} catch (Exception e) {
			System.err.println(e);
			return 0;
		}
	}

	public List<Participant> findAllParticipant() {
		List<Participant> listParticipant = new ArrayList<>();
		try {
			Connection con = DbResource.getDbConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from participants");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Participant part = new Participant();
				part.setParticipantid(rs.getInt("participantid"));
				part.setPname(rs.getString("pname"));
				part.setAge(rs.getInt("age"));
				part.setPhonenumber(rs.getString("phonenumber"));
				part.setBatchid(rs.getInt("batchid"));
				listParticipant.add(part);
			}
		} catch (Exception e) {
			System.err.println(e);

		}
		return listParticipant;

	}

	public int updateParticipant(Participant participant) {
		try {
			Connection con = DbResource.getDbConnection();
			PreparedStatement pstmt = con.prepareStatement(
					"update participants set pname=?,age=?,phonenumber=?,batchid=? where participantid=?");
			pstmt.setInt(1, participant.getParticipantid());
			pstmt.setString(2, participant.getPname());
			pstmt.setInt(3, participant.getAge());
			pstmt.setString(4, participant.getPhonenumber());
			pstmt.setInt(5, participant.getBatchid());
			return pstmt.executeUpdate();
		} catch (Exception e) {
			System.err.println(e);
			return 0;
		}
	}

	public int deleteParticipant(int participantid) {
		try {
			Connection con = DbResource.getDbConnection();
			PreparedStatement pstmt = con.prepareStatement("delete from participants where participantid=? ");
			pstmt.setInt(1, participantid);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			System.err.println(e);
			return 0;
		}
	}

}