// nav.js — barra lateral, página activa, progreso de ejercicios y preguntas rápidas.

const PARTS = [
  { file: "index.html",  num: "",  title: "Inicio / Cómo usar el curso" },
  { file: "parte1.html", num: "1", title: "Arreglos de objetos" },
  { file: "parte2.html", num: "2", title: "Listas dinámicas (ArrayList)" },
  { file: "parte3.html", num: "3", title: "Diseño con colecciones" },
];

// Ejercicios publicados hasta ahora (se actualiza al publicar cada parte).
const TOTAL_EJERCICIOS = 20;

const current = location.pathname.split("/").pop() || "index.html";

// ---- Barra lateral ----
const aside = document.createElement("aside");
aside.id = "sidebar";
aside.innerHTML = `
  <a class="brand" href="index.html">Arreglos<span>&amp;Listas</span></a>
  <p class="tagline">Del arreglo de objetos al ArrayList, escribiendo código</p>
  <nav>
    ${PARTS.map(p => `
      <a href="${p.file}" class="${p.file === current ? "active" : ""}">
        ${p.num !== "" ? `<span class="num">${p.num}</span>` : ""}${p.title}
      </a>`).join("")}
  </nav>
  <div class="side-progress">
    <span id="progress-label">Progreso de ejercicios</span>
    <div class="bar"><i id="progress-bar"></i></div>
  </div>
`;
document.body.insertAdjacentElement("afterbegin", aside);

// Botón hamburguesa (móvil)
const btn = document.createElement("button");
btn.className = "menu-btn";
btn.innerHTML = "☰";
btn.onclick = () => aside.classList.toggle("open");
document.body.appendChild(btn);

// ---- Progreso de ejercicios (localStorage) ----
const STORE_KEY = "curso-arreglos-progreso";
const done = JSON.parse(localStorage.getItem(STORE_KEY) || "{}");

function refreshProgress() {
  const completed = Object.values(done).filter(Boolean).length;
  const pct = TOTAL_EJERCICIOS ? Math.round((completed / TOTAL_EJERCICIOS) * 100) : 0;
  const bar = document.getElementById("progress-bar");
  const label = document.getElementById("progress-label");
  if (bar) bar.style.width = pct + "%";
  if (label) label.textContent = `Ejercicios: ${completed} de ${TOTAL_EJERCICIOS} (${pct}%)`;
}

document.addEventListener("DOMContentLoaded", () => {
  // Casilla para marcar cada ejercicio como hecho
  document.querySelectorAll(".ejercicio[data-id]").forEach(ej => {
    const id = ej.dataset.id;
    const header = ej.querySelector("header");
    if (!header) return;
    const cb = document.createElement("input");
    cb.type = "checkbox";
    cb.title = "Marcar como completado";
    cb.checked = !!done[id];
    ej.classList.toggle("hecho", cb.checked);
    cb.addEventListener("change", () => {
      done[id] = cb.checked;
      localStorage.setItem(STORE_KEY, JSON.stringify(done));
      ej.classList.toggle("hecho", cb.checked);
      refreshProgress();
    });
    header.insertAdjacentElement("afterbegin", cb);
  });
  refreshProgress();

  // Preguntas rápidas
  document.querySelectorAll(".quiz").forEach(quiz => {
    const correcta = quiz.dataset.respuesta;
    const fb = quiz.querySelector(".fb");
    quiz.querySelectorAll(".ops button").forEach(b => {
      b.addEventListener("click", () => {
        const acerto = b.dataset.op === correcta;
        b.classList.add(acerto ? "bien" : "mal");
        if (!acerto) {
          const buena = quiz.querySelector(`.ops button[data-op="${correcta}"]`);
          if (buena) buena.classList.add("bien");
        }
        quiz.querySelectorAll(".ops button").forEach(x => x.disabled = true);
        if (fb) fb.classList.add("visible");
      });
    });
  });
});
