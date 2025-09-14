function showModal(title, message, confirmUrl) {
  const modal = document.getElementById("customModal");
  const msgElem = document.getElementById("modalMessage");
  const titleElem = document.getElementById("modalTitle");
  const cancelBtn = document.getElementById("modalCancel");
  const okBtn = document.getElementById("modalOk");

  titleElem.textContent = title;
  msgElem.textContent = message;
  modal.style.display = "block";

  // Remove old listeners before adding new ones
  const newOkBtn = okBtn.cloneNode(true);
  okBtn.parentNode.replaceChild(newOkBtn, okBtn);

  newOkBtn.addEventListener("click", function() {
    window.location.href = confirmUrl;
  });

  cancelBtn.onclick = function() {
    modal.style.display = "none";
  };

  window.onclick = function(event) {
    if (event.target === modal) {
      modal.style.display = "none";
    }
  };
}
