package com.hand.user.dao;

import java.util.List;

import com.hand.user.bean.Film;

public interface FilmDao {
	
	public List<Film> findAll();
	public Film findFilm(Film film);
	public void updateFilm(Film film);
	public void deleteFilm(Film film);
	public void addFilm(Film film);

}
