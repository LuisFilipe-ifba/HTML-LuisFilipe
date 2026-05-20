import React from 'react';

export default function Footer() {
  return (
    <footer className="bg-success text-white p-3">
      <p>links:</p>
      <ol>
        <li>
          github:{' '}
          <a href="https://github.com/LuisFilipe-ifba/HTML-LuisFilipe" target="_blank" rel="noreferrer">
            github
          </a>
        </li>
        <li>
          Atividade-05:{' '}
          <a href="../pages/atividade-5.html" target="_blank" rel="noreferrer">
            atividade-5
          </a>
        </li>
        <li>
          Atividade-03:{' '}
          <a href="../pages/atividade-3.html" target="_blank" rel="noreferrer">
            atividade-3
          </a>
        </li>
      </ol>
    </footer>
  );
}