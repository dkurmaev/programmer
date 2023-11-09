// корзина с выбором количества товаров
import React, { useState } from 'react';

const Cart = () => {
    const [items, setItems] = useState([
        { name: 'Burger 1', quantity: 1 },
        { name: 'Burger 2', quantity: 2 },
        // Другие товары
    ]);

    const handleQuantityChange = (index, newQuantity) => {
        const updatedItems = [...items];
        updatedItems[index].quantity = newQuantity;
        setItems(updatedItems);
    };

    return (
        <div className="cart">
            <h2>Корзина</h2>
            {items.map((item, index) => (
                <div key={index}>
                    <p>{item.name}</p>
                    <input
                        type="number"
                        value={item.quantity}
                        onChange={(e) => handleQuantityChange(index, e.target.value)}
                    />
                </div>
            ))}
        </div>
    );
};

export default Cart;
