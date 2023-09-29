// reducers/bookSlice.ts
import { createSlice, PayloadAction } from '@reduxjs/toolkit';

interface Book {
  id: string;
  title: string;
  author: string;
}

interface BookState {
  books: Book[];
}

const initialState: BookState = {
  books: [],
};

const bookSlice = createSlice({
  name: 'book',
  initialState,
  reducers: {
    addBook: (state, action: PayloadAction<Book>) => {
      state.books.push(action.payload);
    },
    removeBook: (state, action: PayloadAction<string>) => {
      state.books = state.books.filter((book) => book.id !== action.payload);
    },
  },
});

export const { addBook, removeBook } = bookSlice.actions;
export default bookSlice.reducer;
export type { Book };