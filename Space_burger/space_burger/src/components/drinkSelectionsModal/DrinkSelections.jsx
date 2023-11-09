// DrinkSelection.js
import React, { useState } from 'react';

const DrinkSelection = () => {
    const [selectedDrink, setSelectedDrink] = useState(null);

    const handleDrinkSelection = (drink) => {
        setSelectedDrink(drink);
    };

    return (
        <div className="drink-selection">
            <h2>Выберите напиток:</h2>
            <button onClick={() => handleDrinkSelection('Coca-Cola')}>Coca-Cola</button>
            <button onClick={() => handleDrinkSelection('Pepsi')}>Pepsi</button>
            <button onClick={() => handleDrinkSelection('Sprite')}>Sprite</button>
            <p>Выбранный напиток: {selectedDrink}</p>
        </div>
    );
};

export default DrinkSelection;
