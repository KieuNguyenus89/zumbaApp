package com.zumba.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zumba.bean.Batch;
import com.zumba.bean.Participant;
import com.zumba.service.BatchService;
import com.zumba.service.ParticipantService;

/**
 * Servlet implementation class ParticipantController
 */
@WebServlet("/ParticipantController")
public class ParticipantController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ParticipantController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		BatchService bs = new BatchService();
		HttpSession hs = request.getSession();

		List<Batch> listOfBatch = bs.allBatchDetails();
		hs.setAttribute("batchInfo", listOfBatch);
		RequestDispatcher rd1 = request.getRequestDispatcher("addParticipants.jsp");
		rd1.forward(request, response);

		List<Participant> listOfParticipant = ps.findAllParticipant();
		hs.setAttribute("participantinfo", listOfParticipant);
		RequestDispatcher rd2 = request.getRequestDispatcher("participantDisplay.jsp");
		rd2.forward(request, response);

	}

	ParticipantService ps = new ParticipantService();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		String operation = request.getParameter("operation");
		if (operation.equals("add")) {
			int participantid = Integer.parseInt(request.getParameter("participantid"));
			String pname = request.getParameter("pname");
			int age = Integer.parseInt(request.getParameter("age"));
			String phonenumber = request.getParameter("phonenumber");
			int batchd = Integer.parseInt(request.getParameter("batchid"));
			Participant pp = new Participant();
			pp.setParticipantid(participantid);
			pp.setPname(pname);
			pp.setAge(age);
			pp.setPhonenumber(phonenumber);
			pp.setBatchid(batchd);
			String result = ps.storeParticipatns(pp);
			pw.println(result);
			RequestDispatcher rd = request.getRequestDispatcher("addParticipants.jsp");
			response.setContentType("text/html");
			rd.include(request, response);

		} else if (operation.equals("update")) {
			doPut(request, response);
		} else if (operation.equals("delete")) {
			doDelete(request, response);
		} else {
			response.sendRedirect("index.html");
		}

	}

	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		int participantId = Integer.parseInt(request.getParameter("participantid"));

		String result = ps.deleteParticipatns(participantId);
		pw.println(result);
		RequestDispatcher rd = request.getRequestDispatcher("deleteParticipant.jsp");
		response.setContentType("text/html");
		rd.include(request, response);
	}

	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter pw = response.getWriter();
		String operation = request.getParameter("operation");

		int participantid = Integer.parseInt(request.getParameter("participantid"));
		String pname = request.getParameter("pname");
		int age = Integer.parseInt(request.getParameter("age"));
		String phonenumber = request.getParameter("phonenumber");
		BatchService bs = new BatchService();
		HttpSession hs = request.getSession();
		List<Batch> listOfBatch = bs.allBatchDetails();
		hs.setAttribute("batchInfo", listOfBatch);
//		RequestDispatcher rd1 = request.getRequestDispatcher("updateParticipants.jsp");
//		rd1.forward(request, response);
		int batchid = Integer.parseInt(request.getParameter("batchid"));
		Participant pp = new Participant();
		pp.setParticipantid(participantid);
		pp.setPname(pname);
		pp.setAge(age);
		pp.setPhonenumber(phonenumber);
		pp.setBatchid(batchid);
		String result = ps.updateParticipatns(pp);
		pw.println(result);
		RequestDispatcher rd = request.getRequestDispatcher("updateParticipants.jsp");
		response.setContentType("text/html");
		rd.include(request, response);

	}

}