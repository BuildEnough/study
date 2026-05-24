const nameInput = document.querySelector("#nameInput");
const addButton = document.querySelector("#addButton");
const nameList = document.querySelector("#nameList");

function addName() {
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


    li.appendChild(deleteButton); // 여기서 appendChild가 어떤 역할을 하는지 까먹었어
    nameList.appendChild(li);

    nameInput.value = "";
    nameInput.focus();
}

addButton.addEventListener('click', function() {
    addName();
});

nameInput.addEventListener('keydown', function(event) {
    if (event.key === "Enter") {
        addName();
    }
})

// 기존에 클릭 이벤트 안에 있던 리스트 추가 되는 것과 삭제 되는 것을 함수 기능으로 따로 빼고
// 클릭 이벤트와 엔터 이벤트안에 해당 함수를 넣어주는 건가?