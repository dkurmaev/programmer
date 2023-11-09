// компонент для управления товарами
import React, { useState } from 'react';

const ItemManager = ({ handleAddItem }) => {
    const [items, setItems] = useState([
        { id: 1, name: '"SPACE"Burger', quantity: 2, price: 9.90 },
        { id: 2, name: '“TEXAS” POMMES FRITES', quantity: 1, price: 9.90 },
        // Другие товары
    ]);

    const addItem = newItem => {
        setItems([...items, newItem]);
        handleAddItem(newItem); // Вызов функции из родительского компонента (App)
    };

    const removeItem = itemId => {
        const updatedItems = items.filter(item => item.id !== itemId);
        setItems(updatedItems);
    };

    const updateQuantity = (itemId, newQuantity) => {
        const updatedItems = items.map(item =>
            item.id === itemId ? { ...item, quantity: newQuantity } : item
        );
        setItems(updatedItems);
    };

    return (
        <div>
            <button onClick={() => addItem({ id: 3, name: 'New Item', quantity: 1, price: 12.50 })}>
                Einlegen
            </button>
        </div>
    );
};

export default ItemManager;
