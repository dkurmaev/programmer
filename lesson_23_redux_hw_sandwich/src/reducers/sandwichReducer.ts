const initialState: string[] = [];

export const sandwichReducer = (state = initialState, action: any) => {
  switch (action.type) {
    case 'ADD_INGREDIENT':
      return [...state, action.payload];
    case 'CLEAR_INGREDIENTS':
      return [];
    default:
      return state;
  }
};
