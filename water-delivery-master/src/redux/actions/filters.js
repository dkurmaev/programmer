export const setVolume= (volume) => ({
  type: 'SET_VOLUME',
  payload: volume
});

export const setPrice = (price) => ({
  type: 'SET_PRICE',
  payload: price
});

export const resetFilters = () => ({
  type: 'RESET_FILTERS',
});