

import { configureStore } from "@reduxjs/toolkit";
import boardReducer from "../store/boardSlice"; 

export const store = configureStore({
  reducer: {
    board: boardReducer,
    
  },
});

export type RootState = ReturnType<typeof store.getState>;
