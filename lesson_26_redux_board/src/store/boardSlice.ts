import { createSlice, PayloadAction } from '@reduxjs/toolkit';
import { RootState } from '../app/store';

interface BoardState {
  squares: (string | null)[];
  xIsNext: boolean;
}

const initialState: BoardState = {
  squares: Array(9).fill(null),
  xIsNext: true,
};

const boardSlice = createSlice({
  name: 'board',
  initialState,
  reducers: {
    makeMove: (state, action: PayloadAction<number>) => {
      if (state.squares[action.payload] || calculateWinner(state.squares)) {
        return;
      }
      state.squares[action.payload] = state.xIsNext ? 'X' : 'O';
      state.xIsNext = !state.xIsNext;
    },
    restart: (state) => {
      state.squares = Array(9).fill(null);
      state.xIsNext = true;
    },
  },
});

export const { makeMove, restart } = boardSlice.actions;
export const selectSquares = (state: RootState) => state.board.squares;
export const selectXIsNext = (state: RootState) => state.board.xIsNext;

export default boardSlice.reducer;

export function calculateWinner(squares: (string | null)[]): string | null {
  const lines = [
    [0, 1, 2],
    [3, 4, 5],
    [6, 7, 8],
    [0, 3, 6],
    [1, 4, 7],
    [2, 5, 8],
    [0, 4, 8],
    [2, 4, 6],
  ];
  for (const [a, b, c] of lines) {
    if (squares[a] && squares[a] === squares[b] && squares[b] === squares[c]) {
      return squares[a];
    }
  }
  if (squares.every((square) => square !== null)) {
    return 'Draw';
  }
  return null;
}
