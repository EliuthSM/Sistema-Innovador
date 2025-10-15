/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/ClientSide/javascript.js to edit this template
 */
document.addEventListener("DOMContentLoaded", function () {

    function searchProfessionals() {
        const searchTerm = document.getElementById('searchInput').value.trim();
        if (searchTerm === "") {
            alert("Por favor, ingresa un término de búsqueda.");
            return;
        }
        alert("Buscando: " + searchTerm);
        // Aquí iría la lógica de búsqueda real
    }

    function selectRating(rating, event) {
        const ratingFilters = document.querySelectorAll('.rating-filter');
        ratingFilters.forEach(filter => filter.classList.remove('active'));
        event.currentTarget.classList.add('active');
        alert("Filtrando por calificación: " + rating + " estrellas o más");
    }

    function clearFilters() {
        document.querySelectorAll('input[type="checkbox"], input[type="radio"]').forEach(el => el.checked = false);
        document.getElementById('priceMin').value = '';
        document.getElementById('priceMax').value = '';
        document.querySelectorAll('.rating-filter').forEach(filter => filter.classList.remove('active'));
        alert("Filtros limpiados");
    }

    function sortResults() {
        const sortValue = document.getElementById('sortSelect').value;
        alert("Ordenando por: " + sortValue);
        // Aquí iría la lógica de ordenamiento real
    }

    function viewProfile(professionalId) {
        window.location.href = 'perfil-profesional.html?id=' + professionalId;
    }

    function contactProfessional(professionalId) {
        window.location.href = 'solicitar-servicio.html?prof=' + professionalId;
    }

    // Filtros en tiempo real
    document.querySelectorAll('input[type="checkbox"], input[type="radio"]').forEach(input => {
        input.addEventListener('change', function () {
            console.log('Aplicando filtros...');
            // Aquí iría la lógica para aplicar filtros en tiempo real
        });
    });

    document.getElementById('priceMin').addEventListener('input', function () {
        console.log('Filtrando por precio mínimo: ' + this.value);
    });

    document.getElementById('priceMax').addEventListener('input', function () {
        console.log('Filtrando por precio máximo: ' + this.value);
    });

    // Asignar funciones al ámbito global si se usan en HTML
    window.searchProfessionals = searchProfessionals;
    window.selectRating = selectRating;
    window.clearFilters = clearFilters;
    window.sortResults = sortResults;
    window.viewProfile = viewProfile;
    window.contactProfessional = contactProfessional;
});
