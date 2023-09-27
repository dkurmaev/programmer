// src/components/App.tsx
import React from 'react';
import './App.css';
import Header from './components/Header';
import ImageSection from './components/ImageSection';
import TeamSection from './components/TeamSection';
import FarGalaxySection from './components/FarGalaxySection';
import Footer from './components/Footer';

function App() {
  return (
    <div className="App">
      <header>
        <nav>
          <ul>
            <li className="commonButton">Home</li>
            <li className="commonButton">About Me</li>
            <li className="commonButton">Star Wars</li>
            <li className="commonButton">Contact</li>
          </ul>
        </nav>
        <h1>Luke Skywalker</h1>
      </header>
      <main>
        <section className="left">
          <img src="/images/main.jpg" alt="hero" />
        </section>
        <section className="right">
          <h2>Dream Team</h2>
          <img src="/images/friend1.jpg" alt="friend1" />
          <img src="/images/friend2.jpg" alt="friend2" />
          <img src="/images/friend3.jpg" alt="friend3" />
          <img src="/images/friend4.jpg" alt="friend4" />
          <img src="/images/friend5.jpg" alt="friend5" />
          <img src="/images/friend6.jpg" alt="friend6" />
          <img className="bottomLeft" src="/images/friend7.jpg" alt="friend7" />
          <img src="/images/friend8.jpg" alt="friend8" />
          <img className="bottomRight" src="/images/friend9.jpg" alt="friend9" />
        </section>
        <FarGalaxySection />
      </main>
      <Footer />
    </div>
  );
}

export default App;
