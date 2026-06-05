import React from 'react';
import { Link } from 'react-router-dom';

export default function Navbar() {
  return (
    <nav className="navbar navbar-expand-lg navbar-light" id="menu">
      <div className="container">
        <div className="row" id="row">
          <div className="col-12 col-md-6 col-lg-3" id="col">
            <Link to="/login">Login</Link>
          </div>
          <div className="col-12 col-md-6 col-lg-3" id="col">
            <Link to="/">Home</Link>
          </div>
          <div className="col-12 col-md-6 col-lg-3" id="col">
            <a href="../pages/atividade-3.html">Atividade-3</a>
          </div>
          <div className="col-12 col-md-6 col-lg-3" id="col">
            <a href="../pages/atividade-5.html">Atividade-5</a>
          </div>
          <div className="col-12 col-md-6 col-lg-3" id="col">
            <Link to="/usuarios">Lista de Usuários</Link>
          </div>
        </div>
      </div>
    </nav>
  );
}