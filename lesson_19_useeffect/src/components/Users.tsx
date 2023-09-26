import React, { useEffect, useState } from "react";

interface IUser {
    id: number;
    name: string;
    username: string;
}

// {
// "id": 1,
// "name": "Leanne Graham",
// "username": "Bret",
// "email": "Sincere@april.biz",
// "address": {
// "street": "Kulas Light",
// "suite": "Apt. 556",
// "city": "Gwenborough",
// "zipcode": "92998-3874",
// "geo": {
// "lat": "-37.3159",
// "lng": "81.1496"
// }
// },
// "phone": "1-770-736-8031 x56442",
// "website": "hildegard.org",
// "company": {
// "name": "Romaguera-Crona",
// "catchPhrase": "Multi-layered client-server neural-net",
// "bs": "harness real-time e-markets"
// }
// }

const Users = () => {
    const [users, setUsers] = useState<IUser[]>([]);
    
    useEffect(() => {
        fetch("https://jsonplaceholder.typicode.com/users")
            .then(response => response.json())
            .then(data => setUsers((data)));
    }, []);
    
    return (
        <div>
            <h1>Users List</h1>
            <ul>
                {users.map(({id, name, username}) => (
                    <li key={id} style={{ border: '1px solid black', width: '30%' }}>
                        <p>a. {name}</p>
                        <p>b. {username}</p>
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default Users;