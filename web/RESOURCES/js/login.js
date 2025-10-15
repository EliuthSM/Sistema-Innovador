/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/ClientSide/javascript.js to edit this template
 */

// js/login.js
document.addEventListener("DOMContentLoaded", () => {
    const form = document.getElementById("formLogin");

    if (form) {
        form.addEventListener("submit", (event) => {
            const correo = document.getElementById("correo").value.trim();
            const contrasena = document.getElementById("contrasena").value.trim();

            if (correo === "" || contrasena === "") {
                alert("Por favor, complete todos los campos.");
                event.preventDefault();
            }
        });
    }
});
// Simulación de login exitoso (luego puedes reemplazar por validación real del servidor)
document.addEventListener("DOMContentLoaded", () => {
    const form = document.getElementById("formLogin");

    if (form) {
        form.addEventListener("submit", (event) => {
            const correo = document.getElementById("correo").value.trim();
            const contrasena = document.getElementById("contrasena").value.trim();

            if (correo === "" || contrasena === "") {
                alert("Por favor, complete todos los campos.");
                event.preventDefault();
                return;
            }

            // Simular login exitoso (puedes reemplazar con llamada AJAX)
            event.preventDefault(); // Evita envío real del formulario
            let rol = correo.includes("prof") ? "Profesional" : "Cliente"; // solo ejemplo
            let nombre = correo.split("@")[0]; // toma el nombre del correo

            localStorage.setItem("usuario", nombre);
            localStorage.setItem("rol", rol);

            if (rol === "Profesional") {
                window.location.href = "bienvenidaProfesional.jsp";
            } else {
                window.location.href = "bienvenidaCliente.jsp";
            }
        });
    }
});

