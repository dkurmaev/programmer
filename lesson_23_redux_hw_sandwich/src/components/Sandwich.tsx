import React from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { RootState } from './../store'; 

import { addIngredient, clearIngredients } from '../actions/sandwichActions';

const Sandwich: React.FC = () => {
  const ingredients = useSelector((state: RootState) => state.sandwich);
  const dispatch = useDispatch();

  const handleAddIngredient = (ingredient: string) => {
    dispatch(addIngredient(ingredient));
  };

  const displaySandwich = () => {
    if (ingredients.length === 0) {
      return 'Бутерброд: пусто';
    }
    return `Бутерброд: ${ingredients.join(' ')}`;
  };

  const handleClearIngredients = () => {
    dispatch(clearIngredients());
  };

  return (
    <div>
      <h2>Собери свой бутерброд</h2>
      <div>
        <button onClick={() => handleAddIngredient('хлеб')}>Добавить хлеб</button>
        <button onClick={() => handleAddIngredient('колбаса')}>Добавить колбасу</button>
        <button onClick={() => handleAddIngredient('сыр')}>Добавить сыр</button>
        <button onClick={handleClearIngredients}>Очистить список</button>
      </div>
      <div>
        <p className='sandwich'>{displaySandwich()}</p>
      </div>
    </div>
  );
};

export default Sandwich;
