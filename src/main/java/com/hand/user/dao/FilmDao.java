package com.hand.user.dao;

import java.sql.SQLException;
import java.util.List;

import com.hand.user.bean.Film;

public interface FilmDao {
	
	public List<Film> findAll();
	public Film findFilm(Film film);
	public void updateFilm(Film film);
	public void deleteFilm(Film film) throws SQLException;
	public void addFilm(Film film);

}
