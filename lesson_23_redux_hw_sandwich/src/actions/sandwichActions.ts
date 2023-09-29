

export const ADD_INGREDIENT = 'ADD_INGREDIENT';
export const clearIngredients = () => ({
  type: 'CLEAR_INGREDIENTS',
});

export const addIngredient = (ingredient: string) => {
  return {
    type: ADD_INGREDIENT,
    payload: ingredient,
  };
};
