import { configureStore } from '@reduxjs/toolkit';
import bookSlice from './reducers/bookSlice';
import userSlice from './reducers/userSlice';

export const store = configureStore({
  reducer: {
    books: bookSlice,
    users: userSlice,
  },
});

export interface Book {
  id: string;
  title: string;
  author: string;
}

export type RootState = {
  books: Book[];
};