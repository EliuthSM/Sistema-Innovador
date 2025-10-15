/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/ClientSide/javascript.js to edit this template
 */
document.addEventListener("DOMContentLoaded", () => {
    const userInfo = document.getElementById("userInfo");
    const nombreUsuario = document.body.dataset.usuarioNombre;
    const rolUsuario = document.body.dataset.usuarioRol;

    if (userInfo && nombreUsuario) {
        userInfo.innerHTML = `
            <div class="user-box">
                <span class="user-avatar">👤</span>
                <div class="user-details">
                    <span class="user-name">${nombreUsuario}</span>
                    <span class="user-role">${rolUsuario}</span>
                </div>
                <button class="btn btn-outline" onclick="cerrarSesion()">Cerrar sesión</button>
            </div>
        `;
    }
});

function cerrarSesion() {
    window.location.href = "logout.jsp";
}




