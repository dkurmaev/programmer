import React, { useState } from "react";

const Counter = function()  {
    const[count, setCount] = useState(0)

    function  decrement() {
        setCount(count - 1);
    }

    function increment() {
        setCount(count + 1);
    }
    return (
        <div>
            <h1>Counter</h1>
            <p>Current Count: {count}</p>
            <button onClick={() => setCount(count + 1)}>Increment</button>
            <button onClick={() => setCount(count - 1)}>Decrement</button>
            <button onClick={() => setCount(0)}>Reset</button>
        </div>
    );
};

export default Counter;