import React from 'react';
import Navbar from './components/Navbar';
import Header from './components/Header';
import MainContent from './components/MainContent';
import Footer from './components/Footer';
import 'bootstrap/dist/css/bootstrap.min.css';
import './components/style.css';

function App() {
  return (
    <>
      <Navbar />
      <Header />
      <hr />
      <MainContent />
      <hr />
      <Footer />
    </>
  );
}

export default App;