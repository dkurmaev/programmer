import React from 'react';
import BookList from './components/BookList';
import UserList from './components/UserList';
import { Provider } from 'react-redux';
import { store } from './store';

const users = [
  { id: 1, name: 'Иван', email: 'ivan@example.com' },
  { id: 2, name: 'Мария', email: 'maria@example.com' },
  // Другие пользователи
];

const App = () => {
  return (
    <Provider store={store}>
      <div>
        <h1>Моя библиотека</h1>
        <BookList />
        <h1>Список пользователей</h1>
        <UserList users={users} />
      </div>
    </Provider>
  );
};

export default App;