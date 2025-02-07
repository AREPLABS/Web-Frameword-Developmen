const imagenes = {
  "El señor de los anillos": "https://images.unsplash.com/photo-1506466010722-395aa2bef877",
  "1984": "https://images.unsplash.com/photo-1544716278-ca5e3f4abd8c",
  "Matar a un ruiseñor": "https://images.unsplash.com/photo-1589829085413-56de8ae18c73"
};

function crearTarjetaLibro(libro) {
  return `
    <div class="libro-card">
      <img class="libro-imagen" src="${libro.imagen}" alt="${libro.titulo}">
      <h2 class="libro-titulo">${libro.titulo}</h2>
      <p class="libro-autor">por ${libro.autor}</p>
      <p class="libro-anio">Publicado en ${libro.anio}</p>
      <a href="#" class="ver-mas" onclick="mostrarModal('${libro.titulo}', '${libro.autor}', '${libro.anio}', '${libro.imagen}')">Ver más</a>
    </div>
  `;
}

function mostrarLibros() {
  fetch('/api/libros')
    .then(response => response.json())
    .then(data => {
      const contenedor = document.getElementById('libros');
      const librosHTML = data.libros.map(crearTarjetaLibro).join('');
      contenedor.innerHTML = librosHTML;
    })
    .catch(error => console.error('Error al obtener los libros:', error));
}

// Función para mostrar el modal con los detalles del libro
function mostrarModal(titulo, autor, anio, imagen) {
  const modal = document.getElementById("myModal");
  const modalTitle = document.querySelector(".modal-title");
  const modalText = document.querySelector(".modal-text");
  const modalImg = document.querySelector(".modal-img");

  modalTitle.textContent = titulo;
  modalText.textContent = `Autor: ${autor} | Año: ${anio}`;
  modalImg.src = imagen;

  modal.style.display = "block"; // Mostrar el modal
}

// Cerrar el modal
const closeModal = document.querySelector(".close");
closeModal.addEventListener('click', () => {
  document.getElementById("myModal").style.display = "none";
});

// Inicializar la página
document.addEventListener('DOMContentLoaded', mostrarLibros);
