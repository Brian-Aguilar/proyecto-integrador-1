const btnAgregar = document.getElementById("btnAgregar");
if (btnAgregar) {
    btnAgregar.addEventListener("click", () => {
        document.querySelector('.modal').classList.toggle('show');
    });
}
const btnClose = document.querySelector('.close');
if (btnClose) {
    btnClose.addEventListener("click", () => {
        document.querySelector('.modal').classList.toggle('show');

    });
}