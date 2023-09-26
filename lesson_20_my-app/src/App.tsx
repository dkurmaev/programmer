import React from 'react';
import './App.css';
import FlowerShop from './components/FlowerShop/FlowerShop'; // Импортируем компонент FlowerShop

function App() {
  return (
    <div className="App">
      <header className="App-header">
        {/* Здесь может быть ваш заголовок или логотип */}
      </header>
      <main className="App-main">
        {/* Используем компонент FlowerShop как основное содержимое */}
        <FlowerShop />
      </main>
      <footer className="App-footer">
        {/* Здесь может быть ваш футер */}
      </footer>
    </div>
  );
}

export default App;
