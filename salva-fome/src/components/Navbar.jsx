import React from 'react';

export default function Navbar() {
  return (
    <nav className="navbar navbar-expand-lg navbar-light" id="menu">
      <div className="container">
        <div className="row" id="row">
          <div className="col-12 col-md-6 col-lg-3" id="col">
            <a href="../../usuario/pages/usuarios_login.html">Login</a>
          </div>
          <div className="col-12 col-md-6 col-lg-3" id="col">
            <a href="../pages/index.html">home(index)</a>
          </div>
          <div className="col-12 col-md-6 col-lg-3" id="col">
            <a href="../pages/atividade-3.html">atividade-3</a>
          </div>
          <div className="col-12 col-md-6 col-lg-3" id="col">
            <a href="../pages/atividade-5.html">atividade-5</a>
          </div>
          <div className="col-12 col-md-6 col-lg-3" id="col">
            <a href="../../usuario/pages/lista_usuario.html">lista de usuarios</a>
          </div>
        </div>
      </div>
    </nav>
  );
}