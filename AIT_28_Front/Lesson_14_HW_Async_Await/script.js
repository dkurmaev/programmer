const userDetails = document.getElementById('userDetails');
let users = [];

// Асинхронная функция для загрузки пользователей
async function fetchUsers() {
    try {
        const res = await fetch('https://jsonplaceholder.typicode.com/users');
        return await res.json();
    } catch (error) {
        console.error('Ошибка загрузки пользователей:', error);
        throw error;
    }
}

// Асинхронная функция для отображения пользователей
async function displayUsers() {
    const userList = document.getElementById('userList');
    const userDetailsModal = document.getElementById('userDetailsModal');
    const closeModal = document.getElementById('closeModal');
    const searchInput = document.getElementById('searchInput');

    try {
        users = await fetchUsers();

        // обработчик события для поля поиска
        searchInput.addEventListener('input', () => {
            const searchTerm = searchInput.value.toLowerCase();
            const filteredUsers = users.filter(user => user.name.toLowerCase().includes(searchTerm));
            displayUsersList(filteredUsers);
        });

        // обработчик события для кнопки закрытия модального окна
        closeModal.addEventListener('click', () => {
            userDetailsModal.style.display = 'none';
        });

        // обработчик события для клика за пределами модального окна
        window.addEventListener('click', (event) => {
            if (event.target === userDetailsModal) {
                userDetailsModal.style.display = 'none';
            }
        });

        displayUsersList(users); // Отображаем всех пользователей при загрузке страницы
    } catch (error) {
        const li = document.createElement('li');
        li.textContent = 'Пользователи не найдены: попробуйте повторить позднее';
        userList.appendChild(li);
    }
}

// Функция для отображения списка пользователей
function displayUsersList(usersToDisplay) {
    const userList = document.getElementById('userList');
    userList.innerHTML = '';

    usersToDisplay.forEach(user => {
        const li = document.createElement('li');
        li.textContent = user.name;

        li.addEventListener('click', () => {
            displayUserDetails(user);
        });

        userList.appendChild(li);
    });
}

// Функция для отображения деталей пользователя
function displayUserDetails(user) {
    userDetails.innerHTML = '';

    const nameHeading = document.createElement('h2');
    nameHeading.textContent = user.name;

    const userName = document.createElement('p');
    userName.innerHTML = `<strong>Username:</strong> ${user.username}`;

    const email = document.createElement('p');
    email.innerHTML = `<strong>Email:</strong> ${user["email"]}`;

    const phone = document.createElement('p');
    phone.innerHTML = `<strong>Phone:</strong> ${user["phone"]}`;

    const website = document.createElement('p');
    website.innerHTML = `<strong>Website:</strong> ${user["website"]}`;

    userDetails.append(nameHeading, userName, email, phone, website);

    const userDetailsModal = document.getElementById('userDetailsModal');
    userDetailsModal.style.display = 'block';
}

// Функция для отображения пользователей и обработки успешного завершения и ошибки
displayUsers()
    .then(() => console.log("Финиш"))
    .catch(error => console.error('Ошибка:', error));
