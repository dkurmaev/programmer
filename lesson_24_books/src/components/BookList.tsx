import React from 'react';
import { useSelector, useDispatch } from 'react-redux';
import { addBook, removeBook } from './../reducers/bookSlice'; 
import { RootState } from '../store';
import { Book } from './../reducers/bookSlice'

const BookList: React.FC = (): JSX.Element => {
  const books = useSelector((state: RootState) => state.books);
  const dispatch = useDispatch();

  const handleAddBook = () => {
    const newBook: Book = {
      id: Math.random().toString(),
      title: 'Название книги',
      author: 'Автор книги',
    };
    dispatch(addBook(newBook));
  };

  const handleRemoveBook = (bookId: string) => {
    dispatch(removeBook(bookId));
  };

  return (
    <div>
      <h2>Список книг</h2>
      <button onClick={handleAddBook}>Добавить книгу</button>
      <ul>
        {Array.isArray(books) && books.map((book) => (
          <li key={book.id}>
            {book.title} - {book.author}
            <button onClick={() => handleRemoveBook(book.id)}>Удалить</button>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default BookList;
