// Slider
let index = 0;
const slides = document.getElementById("slides");
const total = slides.children.length;

function moveSlide(step) {
      index = (index + step + total) % total;
      slides.style.transform = `translateX(-${index * 100}%)`;
}

// Auto-slide
setInterval(() => moveSlide(1), 4000);