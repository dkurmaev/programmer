// src/components/BookList.js
import React, { useState } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { addBook, removeBook, editBook } from '../features/books/booksSlice';

const BookList = () => {
  const dispatch = useDispatch();
  const books = useSelector((state) => state.books);
  const [newBookTitle, setNewBookTitle] = useState('');
  const [newBookAuthor, setNewBookAuthor] = useState('');
  const [editingBook, setEditingBook] = useState(null);
  const [editedBookTitle, setEditedBookTitle] = useState('');
  const [editedBookAuthor, setEditedBookAuthor] = useState('');

  const handleAddBook = () => {
    const newBook = {
      id: Date.now(),
      title: newBookTitle,
      author: newBookAuthor,
    };
    dispatch(addBook(newBook));
    setNewBookTitle('');
    setNewBookAuthor('');
  };

  const handleRemoveBook = (bookId) => {
    dispatch(removeBook(bookId));
  };

  const handleStartEditing = (book) => {
    setEditingBook(book.id);
    setEditedBookTitle(book.title);
    setEditedBookAuthor(book.author);
  };

  const handleCancelEditing = () => {
    setEditingBook(null);
    setEditedBookTitle('');
    setEditedBookAuthor('');
  };

  const handleSaveEditing = () => {
    dispatch(
      editBook({
        id: editingBook,
        title: editedBookTitle,
        author: editedBookAuthor,
      })
    );
    setEditingBook(null);
    setEditedBookTitle('');
    setEditedBookAuthor('');
  };

  return (
    <div>
      <h2>Book List</h2>
      <div>
        <input
          type="text"
          placeholder="Title"
          value={newBookTitle}
          onChange={(e) => setNewBookTitle(e.target.value)}
        />
        <input
          type="text"
          placeholder="Author"
          value={newBookAuthor}
          onChange={(e) => setNewBookAuthor(e.target.value)}
        />
        <div className="button" onClick={handleAddBook}>Add Book</div>
      </div>
      <ul>
        {books.map((book) => (
          <li key={book.id}>
            {editingBook === book.id ? (
              <>
                <input
                  type="text"
                  value={editedBookTitle}
                  onChange={(e) => setEditedBookTitle(e.target.value)}
                />
                <input
                  type="text"
                  value={editedBookAuthor}
                  onChange={(e) => setEditedBookAuthor(e.target.value)}
                />
                <button onClick={handleSaveEditing}>Save</button>
                <button onClick={handleCancelEditing}>Cancel</button>
              </>
            ) : (
              <>
                {book.title} - {book.author}
                <button onClick={() => handleRemoveBook(book.id)}>Remove</button>
                <button onClick={() => handleStartEditing(book)}>Edit</button>
              </>
            )}
          </li>
        ))}
      </ul>
    </div>
  );
};

export default BookList;
