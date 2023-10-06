// src/features/books/booksSlice.js
import { createSlice } from '@reduxjs/toolkit';

const booksSlice = createSlice({
  name: 'books',
  initialState: [],
  reducers: {
    addBook: (state, action) => {
      state.push(action.payload);
    },
    removeBook: (state, action) => {
      return state.filter((book) => book.id !== action.payload);
    },
    editBook: (state, action) => {
      const editedBook = state.find((book) => book.id === action.payload.id);
      if (editedBook) {
        editedBook.title = action.payload.title;
        editedBook.author = action.payload.author;
      }
    },
  },
});

export const { addBook, removeBook, editBook } = booksSlice.actions;
export default booksSlice.reducer;
