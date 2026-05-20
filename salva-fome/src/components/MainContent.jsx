import React from 'react';

export default function MainContent() {
  return (
    <main className="container bs-primary">
      <h2>testando Main e section</h2>
      <hr />
      
      <section className="bg-secondary border border-dark">
        <p>
          Texto de Section 1:
          <hr />
          Testando section
        </p>
      </section>

      <section>
        <p>Section 2:</p>
        <hr />

        <article>
          <p>article-1:</p>
          <hr />
        </article>

        <article>
          <p>article-2: video e audio:</p>
          <audio preload="metadata" controls autoPlay loop>
            <source src="../assets/sound/musicasinha.mp3" type="audio/mp3" />
          </audio>
          
          <iframe
            width="560"
            height="315"
            src="https://www.youtube.com/embed/UtTaz3O_WJM?si=FfDtaMwoW619insv"
            title="YouTube video player"
            frameBorder="0"
            allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
            referrerPolicy="strict-origin-when-cross-origin"
            allowFullScreen
          ></iframe>
        </article>
      </section>
    </main>
  );
}