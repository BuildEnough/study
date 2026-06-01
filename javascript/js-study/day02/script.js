const nameInput = document.querySelector("#nameInput");
const addButton = document.querySelector("#addButton");
const nameList = document.querySelector("#nameList");

addButton.addEventListener("click", function() {
    const name = nameInput.value;

    if (name === "") {
        alert("이름을 입력하세요: ");
        return;
    }

    const li = document.createElement("li");
    li.textContent = name;

    nameList.appendChild(li);

    nameInput.value = "";
    
})