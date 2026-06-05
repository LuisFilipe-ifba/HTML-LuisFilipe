import React from 'react';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Navbar from './components/Navbar';
import Header from './components/Header';
import MainContent from './components/MainContent';
import Footer from './components/Footer';
import LoginPage from './components/LoginPage';
import ListaUsuariosPage from './components/ListaUsuariosPage';
import 'bootstrap/dist/css/bootstrap.min.css';
import './components/style.css';

function App() {
  return (
    <BrowserRouter>
      <Navbar />
      <Routes>
        <Route path="/" element={
          <>
            <Header />
            <hr />
            <MainContent />
            <hr />
          </>
        } />
        <Route path="/login" element={<LoginPage />} />
        <Route path="/usuarios" element={<ListaUsuariosPage />} />
      </Routes>
      <Footer />
    </BrowserRouter>
  );
}

export default App;