
import React from 'react';
import './App.css';
import Board from './components/Board';
import { Provider } from 'react-redux';
import { store } from './app/store';

function App() {
  return (
    <Provider store={store}>
      <div className="App">
        <header className="App-header">
          <h1>Tic-Tac-Toe Game</h1>
          <Board />
        </header>
      </div>
    </Provider>
  );
}

export default App;
