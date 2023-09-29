import React, { Component } from 'react';

// Определение типа состояния компонента
interface SandwichState {
  ingredients: string[];
}

class Sandwich extends Component<{}, SandwichState> {
  constructor(props: {}) {
    super(props);
    this.state = {
      ingredients: [], // Тип определен в интерфейсе SandwichState
    };
  }

  // Функция для добавления ингредиентов
  addIngredient = (ingredient: string) => {
    this.setState((prevState) => ({
      ingredients: [...prevState.ingredients, ingredient],
    }));
  };

  // Функция для отображения текущего бутерброда
  displaySandwich = () => {
    const { ingredients } = this.state;
    if (ingredients.length === 0) {
      return 'Бутерброд: пусто';
    }
    return `Бутерброд: ${ingredients.join(' ')}`;
  };

  render() {
    return (
      <div>
        <h2>Собери свой бутерброд</h2>
        <div>
          <button onClick={() => this.addIngredient('хлеб')}>Добавить хлеб</button>
          <button onClick={() => this.addIngredient('колбаса')}>Добавить колбасу</button>
          <button onClick={() => this.addIngredient('сыр')}>Добавить сыр</button>
        </div>
        <div>
          <p>{this.displaySandwich()}</p>
        </div>
      </div>
    );
  }
}

export default Sandwich;
