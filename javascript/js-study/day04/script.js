const nameInput = document.querySelector("#nameInput");
const addButton = document.querySelector("#addButton");
const nameList = document.querySelector("#nameList");

addButton.addEventListener("click", function() {
    const name = nameInput.value.trim();

    if (name === "") {
        alert("이름을 입력하세요: ");
        nameInput.focus();
        return;
    }

    const li = document.createElement("li");
    li.textContent = name;

    const deleteButton = document.createElement("button");
    deleteButton.textContent = "삭제";
    deleteButton.classList.add("delete-button");

    deleteButton.addEventListener("click", function() {
        li.remove();
    });


    li.appendChild(deleteButton);
    nameList.appendChild(li);

    nameInput.value = "";
    nameInput.focus();
});