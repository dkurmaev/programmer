fetch('https://jsonplaceholder.typicode.com/users')
    .then(res => res.json())
    .then(users => {
        const userList = document.getElementById('userList');
        const userDetailsModal = document.getElementById('userDetailsModal');
        const closeModal = document.getElementById('closeModal');

        users.forEach(user => {
            const li = document.createElement('li');
            li.textContent = user.name;

            li.addEventListener('click', () => {
                document.getElementById('userName').textContent = user.name;
                document.getElementById('userEmail').textContent = user.email;
                document.getElementById('userPhone').textContent = user.phone;
                document.getElementById('userWebsite').textContent = user.website;

                userDetailsModal.style.display = 'block';
            });

            userList.appendChild(li);
        });

        closeModal.addEventListener('click', () => {
            userDetailsModal.style.display = 'none';
        });

        window.addEventListener('click', (event) => {
            if (event.target === userDetailsModal) {
                userDetailsModal.style.display = 'none';
            }
        });
    })
    .catch(err => {
        const userList = document.getElementById('userList');
        const li = document.createElement('li');
        li.textContent = 'Пользователи не найдены: попробуйте повторить позднее';
        userList.appendChild(li);
    })
    .finally(() => console.log("Финиш"));
