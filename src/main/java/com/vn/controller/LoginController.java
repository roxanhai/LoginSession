package com.vn.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String rememberMe = request.getParameter("rememberme");
		//Validate
		boolean checkUsernameOK = username !=null && username.trim().length()>0;
		boolean checkPasswordOK = password !=null && password.trim().length()>0;
		//Check Database
		if(checkUsernameOK && checkPasswordOK) {
			if(username.equals("admin")&&password.equals("admin")) {
				//save session => home.jsp
				HttpSession session = request.getSession();
				session.setAttribute("userLogged",username);
				session.setMaxInactiveInterval(15*60);
				//save cookies
				
				//send response and redirect => home.jsp
				response.sendRedirect(request.getContextPath()+"/");
			}else {
				//user is incorrect 
				HttpSession session = request.getSession();
				session.setAttribute("message","Sai tên đăng nhập hoặc mật khẩu");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}else {
			//bat buoc nhap thong tin
			HttpSession session = request.getSession();
			session.setAttribute("message","Vui lòng nhập đầy đủ thông tin");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}

	}

}
