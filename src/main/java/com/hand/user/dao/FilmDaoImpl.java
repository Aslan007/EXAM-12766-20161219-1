package com.hand.user.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import com.hand.dbutil.DbUtil;
import com.hand.user.bean.Film;

public class FilmDaoImpl implements FilmDao{
	
	
	
	public List<Film> findAll() {
		
		List<Film> list = new ArrayList<Film>(); 
		
		//select film_id,title,description,name language from film,language where film.language_id = language.language_id
		String sql= "select film_id,title,description,name language "
				+ "from film,language where film.language_id = language.language_id";
		Connection conn = null;
		conn = DbUtil.getConnection();
		Statement stmt;
		try {
			stmt = conn.createStatement();
			 ResultSet rs =stmt.executeQuery(sql);//执行
			 while(rs.next()){
				Film film = new Film();
				film.setFilmId(rs.getInt("film_id"));
				film.setLanguage(rs.getString("language"));
				film.setTitle(rs.getString("title"));
				film.setDescription(rs.getString("description"));
				list.add(film); 
			 }
			 
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public static void main(String[] args) {
		FilmDaoImpl fdi = new FilmDaoImpl();
//		List<Film> list = fdi.findAll();
//		System.out.println(list);
//		Film film = new Film();
//		film.setDescription("12312312");
//		film.setLanguageId(2);
//		film.setTitle("titles3123");
//		fdi.addFilm(film);
	}

	public Film findFilm(Film film) {
		Integer id = film.getFilmId();
		//select title,description,name language from film,language where film.language_id = language.language_id and film_id =  
		String sql ="select film_id,title,description,name language from film,language where film.language_id = language.language_id and film_id ="+id;
		
		Connection conn = null;
		conn = DbUtil.getConnection();
		Statement stmt;
		
		Film film2 = new Film();
		try {
			stmt = conn.createStatement();
			 ResultSet rs =stmt.executeQuery(sql);//执行
			 while(rs.next()){
				film2.setLanguage(rs.getString("language"));
				film2.setTitle(rs.getString("title"));
				film2.setDescription(rs.getString("description"));
				film2.setFilmId(rs.getInt("film_id"));
			 }
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return film2;
	}

	public void updateFilm(Film film) {
		//update film set title = ? ,	description = ?,	language =?
		String title =film.getTitle();
		String description = film.getDescription();
		Integer  language_id =  film.getLanguageId();
		Integer film_id = film.getFilmId();
		
		String sql ="update film set title = '"+title+ "',	description = '"+description+"',	language_id ="+language_id +" where film_id = "+film_id ;
		System.out.println("sql in update"+sql);
		
		Connection conn = null;
		conn = DbUtil.getConnection();
		 try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);//执行
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	public void deleteFilm(Film film) throws SQLException {
		//delete from film where film_id =
		Integer id = film.getFilmId();
		String sql = "DELETE from film where film_id="+id;
		System.out.println(sql);
		//异常处理，如不能删除，提示，在 servlet里面处理
		Connection conn = null;
		conn = DbUtil.getConnection();
			
				Statement stmt = conn.createStatement();
				stmt.executeUpdate(sql);
				conn.close();
				
		
	}

	public void addFilm(Film film) {
		String title =film.getTitle();
		String description = film.getDescription();
		Integer  language_id =  film.getLanguageId();
		String sql = "insert into film(title,description,language_id) values('"+title+"','"+description+"',"+language_id+")";
		System.out.println("新增filmsql   "+sql);
		Connection conn = null;
		conn = DbUtil.getConnection();
		 try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);//执行
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	

}
