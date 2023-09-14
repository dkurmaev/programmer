const taskInput = document.getElementById('taskInput');
const addTaskButton = document.getElementById('addTask');
const taskList = document.getElementById('taskList');


function addTask() {
    const taskName = taskInput.value.trim();
    if (taskName) {
        const li = document.createElement('li');
        const span = document.createElement('span');
        span.textContent = taskName;

        const deleteButton = document.createElement('button');
        deleteButton.textContent = 'Delete';
        deleteButton.className = 'delete-button';

        const checkbox = document.createElement('input');
        checkbox.type = 'checkbox';

        li.appendChild(checkbox);
        li.appendChild(span);
        li.appendChild(deleteButton);

        taskList.appendChild(li);

        taskInput.value = '';
    }
}

// Функция для удаления задачи
function deleteTask(taskItem) {
    taskList.removeChild(taskItem);
}

// Обработчик события для кнопки "Add Task"
addTaskButton.addEventListener('click', addTask);

// Обработчик события для нажатия клавиши Enter в поле ввода
taskInput.addEventListener('keypress', (e) => {
    if (e.key === 'Enter') {
        addTask();
    }
});

// Обработчик события для списка задач
taskList.addEventListener('click', (e) => {
    const taskItem = e.target.closest('li');
    if (!taskItem) return;

    if (e.target.classList.contains('delete-button')) {
        // Если была нажата кнопка "Delete", удаляем задачу
        deleteTask(taskItem);
    } else if (e.target.tagName === 'INPUT' && e.target.type === 'checkbox') {
        // Если был изменен чекбокс, изменяем стиль задачи
        taskItem.classList.toggle('done', e.target.checked);
    }
});
