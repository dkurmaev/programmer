// src/App.js
import React from "react";
import { Provider } from "react-redux";
import { store } from "./app/store";
import BookList from "./components/BookList";
import UserList from "./components/UserList";

function App() {
  return (
    <Provider store={store}>
      <div className="container">
        <div className="row">
          <div className="col custom-style">
            <h1>Book Manager</h1>
            <BookList />
            <UserList />
          </div>
        </div>
      </div>
    </Provider>
  );
}

export default App;
