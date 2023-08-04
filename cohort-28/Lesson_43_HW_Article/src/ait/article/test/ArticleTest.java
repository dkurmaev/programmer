package ait.article.test;

import ait.article.model.Article;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArticleTest {

	private Article article;

	@BeforeEach
	public void setup() {
		article = new Article("Test Article",
				"Sample text",
				"Dan Kur",
				Article.Role.DRAFT,
				Article.State.ON_REVIEW);
	}

	@Test
	public void testCorrectPublish() {
		article.setState(Article.State.ON_REVIEW);
		article.publish();
		assertTrue(article.isPublished());

	}

	@Test
	public void testIncorrectPublish() {
		article.setState(Article.State.NOT_PUBLISHED);
		assertThrows(IllegalStateException.class, () -> article.publish());
	}


	@Test
	public void testCorrectNotPublish() {
		article.setState(Article.State.ON_EDIT);
		assertTrue(article.isNotPublished());
	}
	@Test
    public void testIncorrectNotPublish() {
        article.setState(Article.State.ON_REVIEW);
        assertThrows(IllegalStateException.class, () -> article.notPublish());
    }

	@Test
	public void testDelete() {
		article.delete();
		assertEquals(Article.State.DELETED, article.getState());
	}

	@Test
	public void testEdit() {
		article.setState(Article.State.ON_EDIT);
		assertEquals(Article.State.ON_EDIT, article.getState());
	}
	@Test
	public void testIncorrectEdit() {
		article.setState(Article.State.ON_EDIT);
		assertThrows(IllegalStateException.class, () -> article.edit());
	}

	@Test
	public void testReview() {
		article.setState(Article.State.ON_REVIEW);
		assertEquals(Article.State.ON_REVIEW, article.getState());
	}

	@Test
	public void testIsOnReview() {
		assertTrue(article.isOnReview());
	}

	@Test
	public void testIsOnEdit() {
		assertFalse(article.isOnEdit());
	}

	@Test
	public void testIsDeclined() {
		assertFalse(article.isDeclined());
	}

	@Test
	public void testIsDeleted() {
		assertFalse(article.isDeleted());
	}

	@Test
	public void testIsPublished() {
		assertFalse(article.isPublished());
	}

	@Test
	public void testIsNotPublished() {
		assertTrue(article.isNotPublished());
	}
}
