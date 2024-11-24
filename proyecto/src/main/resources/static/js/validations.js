document.addEventListener("DOMContentLoaded", () => {
    const nombreFacturacion = document.getElementById("nombre-facturacion");
    const apellidoFacturacion = document.getElementById("apellido-facturacion");
    const emailFacturacion = document.getElementById("email-facturacion");
    const telefonoFacturacion = document.getElementById("telefono-facturacion");

    // Añade validación en tiempo real para cada campo
    nombreFacturacion.addEventListener("input", () => validateName(nombreFacturacion));
    apellidoFacturacion.addEventListener("input", () => validateName(apellidoFacturacion));
    emailFacturacion.addEventListener("input", () => validateEmail(emailFacturacion));
    telefonoFacturacion.addEventListener("input", () => validatePhone(telefonoFacturacion));

    function validateName(inputField) {
        const warning = inputField.nextElementSibling;
        if (inputField.value.trim() === "") {
            warning.textContent = "Este campo es obligatorio.";
        } else {
            warning.textContent = ""; // Limpiar advertencia si es válido
        }
    }

    function validateEmail(inputField) {
        const emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
        const warning = inputField.nextElementSibling;
        if (!emailPattern.test(inputField.value.trim())) {
            warning.textContent = "Ingrese un correo electrónico válido.";
        } else {
            warning.textContent = "";
        }
    }

    function validatePhone(inputField) {
        const telefonoPattern = /^\d{7,10}$/;
        const warning = inputField.nextElementSibling;
        if (!telefonoPattern.test(inputField.value.trim())) {
            warning.textContent = "Ingrese un número de teléfono válido (7 a 10 dígitos).";
        } else {
            warning.textContent = "";
        }
    }
});
