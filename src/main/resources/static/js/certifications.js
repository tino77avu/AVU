// Script para mostrar descripciones de certificaciones en el carrusel horizontal
document.addEventListener('DOMContentLoaded', function() {
    const certCards = document.querySelectorAll('.cert-image-card');
    const certDescription = document.getElementById('certDescription');
    
    certCards.forEach((card) => {
        card.addEventListener('mouseenter', function() {
            const description = this.getAttribute('data-description');
            if (description) {
                certDescription.textContent = description;
                certDescription.classList.add('show');
            }
        });
        
        card.addEventListener('mouseleave', function() {
            certDescription.classList.remove('show');
        });
    });
});

