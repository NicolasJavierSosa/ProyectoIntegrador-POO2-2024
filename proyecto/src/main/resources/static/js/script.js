function openTab(event, tabId) {
  event.preventDefault(); // Evita que la página se recargue

  // Remover la clase "active" de todos los botones y pestañas
  const buttons = document.querySelectorAll('.tab-button');
  const tabs = document.querySelectorAll('.tab-content');

  buttons.forEach(button => button.classList.remove('active'));
  tabs.forEach(tab => tab.style.display = 'none');

  // Agregar la clase "active" al botón actual
  event.currentTarget.classList.add('active');

  // Mostrar el contenido de la pestaña seleccionada
  document.getElementById(tabId).style.display = 'block';
}
document.addEventListener('DOMContentLoaded', function() {
  const tabButtons = document.querySelectorAll('.tab-button');
  const tabContents = document.querySelectorAll('.tab-content');

  tabButtons.forEach(button => {
    button.addEventListener('click', function(event) {
      event.preventDefault();
      const targetClass = this.dataset.target;
      tabContents.forEach(content => content.classList.remove('active'));
      document.querySelector(targetClass).classList.add('active');
      tabButtons.forEach(btn => btn.classList.remove('active'));
      this.classList.add('active');
    });
  });
});
  
  document.getElementById('decrement').addEventListener('click', () => {
    const quantity = document.getElementById('quantity');
    if (quantity.value > 1) {
      quantity.value = parseInt(quantity.value) - 1;
    }
  });
  
  document.getElementById('increment').addEventListener('click', () => {
    const quantity = document.getElementById('quantity');
    quantity.value = parseInt(quantity.value) + 1;
  });

  