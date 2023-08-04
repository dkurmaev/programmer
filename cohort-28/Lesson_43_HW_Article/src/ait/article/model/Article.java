package ait.article.model;

import java.util.function.Predicate;

public class Article {
	public enum Role {
		DRAFT;
	}

	public enum State {
		ON_REVIEW,
		PUBLISHED,
		DECLINED,
		DELETED,
		NOT_PUBLISHED,

		ON_EDIT

	}

	private String titel;
	private String text;
	private String author;
	private Role role;
	private State state;

	public State isPublished;

	public Article(String titel, String text, String author, Role role, State state) {
		this.titel = titel;
		this.text = text;
		this.author = author;
		this.role = role;
		this.state = state;
	}

	public String getTitel() {
		return titel;
	}

	public String getText() {
		return text;
	}

	public String getAuthor() {
		return author;
	}

	public Role getRole() {
		return role;
	}

	public State getState() {
		return state;
	}


	public void setPublished(State isPublished) {
		this.isPublished = isPublished;
	}

	public void changeState(Predicate<State> predicate, State newState, String errorMessage) {
		if (predicate.test(state)) {
			state = newState;
		} else {
			throw new IllegalStateException(errorMessage + " Текущее состояние: " + this.state);
		}
	}

	public void publish() {
		changeState(state -> isNotPublished(),
				State.PUBLISHED,
				"Не удалось опубликовать статью");
	}

	public void notPublish() {
		changeState(state -> isPublished(),
				State.NOT_PUBLISHED,
				"Статья не доступна для публикации");
	}

	public void decline() {
		changeState(state -> isOnReview(),
				State.DECLINED,
				"Нельзя отклонить статью");
	}

	public void delete() {
		changeState(state -> isOnReview() || !isOnReview(),
				State.DELETED,
				"Нельзя удалить статью");
	}

	public void edit() {
		changeState(state -> isPublished(),
				State.ON_EDIT,
				"Нельзя редактировать статью");
	}

	public void review() {
		changeState(state -> isOnEdit(),
				State.ON_REVIEW,
				"Нельзя отредактировать статью");
	}

	public boolean isOnReview() {
		return state.equals(State.ON_REVIEW);
	}

	public boolean isOnEdit() {
		return state.equals(State.ON_EDIT);
	}

	public boolean isDeclined() {
		return state.equals(State.DECLINED);
	}

	public boolean isDeleted() {
		return state.equals(State.DELETED);
	}

	public boolean isPublished() {
		return state.equals(State.PUBLISHED);
	}

	public boolean isNotPublished() {
		return !state.equals(State.NOT_PUBLISHED);
	}


	public void setState(State state) {
		this.state = state;
	}
}


