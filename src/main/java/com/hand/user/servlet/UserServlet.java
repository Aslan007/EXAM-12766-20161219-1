package com.hand.user.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hand.user.bean.Customer;
import com.hand.user.bean.Film;
import com.hand.user.dao.CustomerDaoImpl;
import com.hand.user.dao.FilmDaoImpl;

public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UserServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		String submitFlag = request.getParameter("submitFlag");
		System.out.println("submitFlag==="+submitFlag);
		if("userLogin".equals(submitFlag)){
					try {
						this.userLogin(request, response);
					} catch (Exception e) {
						e.printStackTrace();
					}
			} else if("toList".equals(submitFlag)){
				try {
					this.toList(request, response);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else if("add".equals(submitFlag)){
				
				this.add(request, response);
			}else if("toUpdate".equals(submitFlag)){
				this.toUpdate(request, response);
			}else if("toDelete".equals(submitFlag)){
				try {
					this.toDelete(request, response);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else if("update".equals(submitFlag)){
				this.update(request, response);
			}
	}

	private void update(HttpServletRequest request, HttpServletResponse response) {
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		
		String str = request.getParameter("language");
		int language_id = Integer.parseInt(str);
		
		
		String film_id = request.getParameter("film_id");
		int film_id1 =Integer.parseInt(film_id);
		
		
		Film film = new Film();
		film.setTitle(title);
		film.setDescription(description);
		film.setLanguageId(language_id);
		film.setFilmId(film_id1);
		
		FilmDaoImpl fdi = new FilmDaoImpl();
		System.out.println("film in update==="+film);
		fdi.updateFilm(film);
		
		try {
			//转到修改完 回到list页面
			this.toList(request, response);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void toDelete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String str = request.getParameter("film_id");
		int film_id = Integer.parseInt(str);
		
		Film film = new Film();
		
		film.setFilmId(film_id);
		FilmDaoImpl fdi = new FilmDaoImpl();
		fdi.deleteFilm(film);
		
		this.toList(request, response);
	}

	private void toUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String film_id = request.getParameter("film_id");
		System.out.println("film_id in update====="+film_id);
		FilmDaoImpl fdi = new FilmDaoImpl();
		Film  film = new Film();
		
		String str = request.getParameter("film_id");
		int film_id1 = Integer.parseInt(str);
		film.setFilmId(film_id1);
		Film film2 = fdi.findFilm(film);
		System.out.println("film in toupdate===="+film2);
		request.setAttribute("film", film2);
		request.getRequestDispatcher("/crud/edit.jsp").forward(request, response);
	}

	private void toList(HttpServletRequest request, HttpServletResponse response) throws Exception{
		FilmDaoImpl filmDaoImpl = new FilmDaoImpl();
		List<Film>  list= filmDaoImpl.findAll();
		System.out.println("zhaodao suoyou film"+list);
		request.setAttribute("filmList", list);
		request.getRequestDispatcher("/crud/list.jsp").forward(request, response);
	}

	private void add(HttpServletRequest request, HttpServletResponse response) {
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		String str = request.getParameter("language");
		int language_id = Integer.parseInt(str);
		
		Film film = new Film();
		film.setTitle(title);
		film.setDescription(description);
		film.setLanguageId(language_id);
		
		FilmDaoImpl fdi = new FilmDaoImpl();
		System.out.println(film);
		fdi.addFilm(film);
		
		try {
			this.toList(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void userLogin(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String username = request.getParameter("name");
		Customer customer = new Customer();
		customer.setFirstName(username);
		CustomerDaoImpl cdi = new CustomerDaoImpl();
		Customer customer2 = cdi.queryCustomer(customer);
		System.out.println("通过用户名找到的用户"+customer2);
		
		if(customer2.getCustomerId() == null){
			PrintWriter pw = response.getWriter();
			pw.println("sorry! your username is wrong!");
		}else{
			//将登陆信息放在session中
			HttpSession session = ((HttpServletRequest)request).getSession();
  			session.setAttribute("customer", customer2);
  			
			this.toList(request, response);
		}
		
	}

}
