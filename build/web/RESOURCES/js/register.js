/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/ClientSide/javascript.js to edit this template
 */
// js/register.js
document.addEventListener("DOMContentLoaded", () => {
    const form = document.getElementById("formRegistro");

    if (form) {
        form.addEventListener("submit", (event) => {
            const nombre = document.getElementById("nombre").value.trim();
            const correo = document.getElementById("correo").value.trim();
            const telefono = document.getElementById("telefono").value.trim();
            const contrasena = document.getElementById("contrasena").value.trim();

            if (!nombre || !correo || !telefono || !contrasena) {
                alert("Por favor, complete todos los campos.");
                event.preventDefault();
                return;
            }

            // Validación extra: formato de correo
            const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
            if (!emailRegex.test(correo)) {
                alert("Ingrese un correo electrónico válido.");
                event.preventDefault();
            }
        });
    }
});

