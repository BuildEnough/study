const nameInput = document.querySelector("#nameInput");
const addButton = document.querySelector("#addButton");
const result = document.querySelector("#result");

addButton.addEventListener("click", function() {
    const name = nameInput.value;

    result.textContent = name + "님, 반갑습니다";
})