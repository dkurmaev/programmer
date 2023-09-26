import React, { useEffect, useState } from "react";

interface IUser {
  id: number;
  name: string;
  username: string;
}

interface IAddress {
  city: string;
}

interface IGeo {
  lat: string;
  lng: string;
}

interface ICompany {
  name: string;
  catchPhrase: string;
  bs: string;
}

interface IUserDetails {
  id: number;
  name: string;
  username: string;
  email: string;
  address: IAddress;
  phone: string;
  website: string;
  company: ICompany;
  geo: IGeo;
}

const Users = () => {
  const [users, setUsers] = useState<IUser[]>([]);
  const [userDetails, setUserDetails] = useState<IUserDetails | null>(null);

  useEffect(() => {
    fetch("https://jsonplaceholder.typicode.com/users")
      .then((response) => response.json())
      .then((data) => setUsers(data));
  }, []);

  const handleUserDetails = async (id: number) => {
    const response = await fetch(
      `https://jsonplaceholder.typicode.com/users/${id}`
    );
    const data = await response.json();
    setUserDetails(data);
  };

  return (
    <div>
      <h1>Users List</h1>
      <ul>
        {users.map(({ id, name, username }) => (
          <li
            key={id}
            style={{ border: "1px solid black", width: "30%" }}
            onClick={() => handleUserDetails(id)}
          >
            <p>a. {name}</p>
            <p>b. {username}</p>
          </li>
        ))}
      </ul>
      {userDetails && (
        <div>
          <h2>User Details</h2>
          <p>Name: {userDetails.name}</p>
          <p>Username: {userDetails.username}</p>
          <p>Email: {userDetails.email}</p>
          <p>Phone: {userDetails.phone}</p>
          <p>Website: {userDetails.website}</p>
          <p>Company: {userDetails.company.name}</p>
        </div>
      )}
    </div>
  );
};

export default Users;