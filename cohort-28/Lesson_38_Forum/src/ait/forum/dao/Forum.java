package ait.forum.dao;

import ait.forum.model.Post;

import java.time.LocalDate;

//Коментарии для кода
public interface Forum {
	boolean addPost(Post post);//Добавление поста

	boolean removePost(int postId);//Удаление поста

	boolean updatePost(int postId, String newContent);//Обновление поста

	Post getPostById(int postId);//Получение поста по id

	Post[] getPostsByAuthor(String author);//Получение постов по автору

	Post[] getPostsByAuthor(String author, LocalDate dateFrom, LocalDate dateTo);//Получение постов по автору и дате

	int size();//Получение количества постов
}
