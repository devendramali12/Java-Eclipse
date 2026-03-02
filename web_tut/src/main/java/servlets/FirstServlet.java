package servlets;

import java.io.IOException;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/first")
public class FirstServlet implements Servlet {

	private ServletConfig servletConfig;

	// LifeCycle Method
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("Destroying Servelt");

	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		this.servletConfig = arg0;
		System.out.println("Initialing Servlet");

	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Service request");
	}

	// Non Lifecycle method

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return this.servletConfig;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return "This Servlet is Created by Author :- Devendra Mali";
	}

}
