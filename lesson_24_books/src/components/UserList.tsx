import React from 'react';

interface User {
    id: number;
    name: string;
    email: string;
}

interface UserListProps {
    users: User[];
}

const UserList: React.FC<UserListProps> = ({ users }) => {
    return (
        <div>
            <h2>Список пользователей</h2>
            <ul>
                {users.map((user: User) => (
                    <li key={user.id}>
                        {user.name} - {user.email}
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default UserList;