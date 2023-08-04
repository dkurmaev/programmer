package ait.article;

import ait.article.model.Article;

public class ArticleAppl {
	public static void main(String[] args) {
		Article article = new Article("Test Article",
				"Sample text",
				"Dan Kur",
				Article.Role.DRAFT,
				Article.State.ON_REVIEW
		);
		Article article1 = new Article("Java",
				"Java is a programming language",
				"Unknow",
				Article.Role.DRAFT,
				Article.State.ON_EDIT
		);

		Article article2 = new Article("Java",
				"Java is a programming language",
				"Unknow",
				Article.Role.DRAFT,
				Article.State.DECLINED
		);
		Article article3 = new Article("Java",
				"Java is a programming language",
				"Unknow",
				Article.Role.DRAFT,
				Article.State.DELETED
		);
		Article article4 = new Article("Java",
				"Java is a programming language",
				"Unknow",
				Article.Role.DRAFT,
				Article.State.PUBLISHED
		);

		article.publish();
		System.out.println(article.getState());
		if (article.isPublished()) {
			System.out.println("Статья опубликована");
		}
		article1.isNotPublished();
		System.out.println(article1.getState());
		if (article1.isNotPublished()) {
			System.out.println("Статья на редактировании");
		}
	}
}
