// src/components/UserList.js
import React, { useState } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { addUser, removeUser } from '../features/users/usersSlice';

const UserList = () => {
  const dispatch = useDispatch();
  const users = useSelector((state) => state.users);
  const [newUserName, setNewUserName] = useState('');
  const [newUserEmail, setNewUserEmail] = useState('');

  const handleAddUser = () => {
    const newUser = {
      id: Date.now(),
      name: newUserName,
      email: newUserEmail,
    };
    dispatch(addUser(newUser));
    setNewUserName('');
    setNewUserEmail('');
  };

  const handleRemoveUser = (userId) => {
    dispatch(removeUser(userId));
  };

  return (
    <div>
      <h2>User List</h2>
      <div>
        <input
          type="text"
          placeholder="Name"
          value={newUserName}
          onChange={(e) => setNewUserName(e.target.value)}
        />
        <input
          type="email"
          placeholder="Email"
          value={newUserEmail}
          onChange={(e) => setNewUserEmail(e.target.value)}
        />
        <div className="button" onClick={handleAddUser}>Add User</div>
      </div>
      <ul>
        {users.map((user) => (
          <li key={user.id}>
            {user.name} - {user.email}
            <button onClick={() => handleRemoveUser(user.id)}>Remove</button>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default UserList;
