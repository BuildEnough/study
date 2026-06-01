const todoInput = document.querySelector("#todoInput");
const addButton = document.querySelector("#addButton");
const todoList = document.querySelector("#todoList");

function addTodo() {
    const todo = todoInput.value.trim();

    if (todo === "") {
        alert("할 일을 입력하세요");
        todoInput.focus();
        return;
    }

    const li = document.createElement("li");
    li.textContent = todo;

    const deleteButton = document.createElement("button");
    deleteButton.textContent = "삭제";
    deleteButton.classList.add("delete-button");

    deleteButton.addEventListener("click", function() {
        li.remove();
    });

    li.appendChild(deleteButton);
    todoList.appendChild(li);

    todoInput.value = "";
    todoInput.focus();
}

addButton.addEventListener("click", function() {
    addTodo();
});

todoInput.addEventListener("keydown", function(event) {
    if (event.key === "Enter") {
        addTodo();
    }
});