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
import com.zumba.service.BatchService;

/**
 * Servlet implementation class BatchController
 */
@WebServlet("/BatchController")
public class BatchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BatchController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	BatchService bs = new BatchService();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Batch> listOfBatch = bs.allBatchDetails();
		HttpSession hs = request.getSession();
		hs.setAttribute("batchInfo", listOfBatch);
		response.sendRedirect("batchDisplay.jsp");

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		String operation = request.getParameter("operation");
		if (operation.equals("add")) {
			Batch batch = new Batch();
			int batchId = Integer.parseInt(request.getParameter("batchid"));
			String typeofbatch = request.getParameter("typeofbatch");
			String time = request.getParameter("time");

			batch.setBatchid(batchId);
			batch.setTypeofbatch(typeofbatch);
			batch.setTime(time);
			String result = bs.storeBatch(batch);
			pw.println(result);
			RequestDispatcher rd = request.getRequestDispatcher("addBatch.jsp");
			response.setContentType("text/html");
			rd.include(request, response);
		} else if (operation.equals("update")) {
			doPut(request, response);
		}

		else if (operation.equals("delete")) {
			doDelete(request, response);
		} else {
			response.sendRedirect("index.html");
		}

	}

	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		Batch batch = new Batch();
		int batchId = Integer.parseInt(request.getParameter("batchid"));
		String typeofbatch = request.getParameter("typeofbatch");
		String time = request.getParameter("time");

		batch.setBatchid(batchId);
		batch.setTypeofbatch(typeofbatch);
		batch.setTime(time);
		BatchService bs = new BatchService();
		String result = bs.updateBatch(batch);
		pw.println(result);
		RequestDispatcher rd = request.getRequestDispatcher("updateBatch.jsp");
		response.setContentType("text/html");
		rd.include(request, response);

	}

	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter pw = response.getWriter();

		int batchId = Integer.parseInt(request.getParameter("batchid"));

		BatchService bs = new BatchService();
		String result = bs.deleteBatch(batchId);
		pw.println(result);
		RequestDispatcher rd = request.getRequestDispatcher("deleteBatch.jsp");
		response.setContentType("text/html");
		rd.include(request, response);
	}

}