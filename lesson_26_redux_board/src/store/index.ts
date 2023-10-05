import { configureStore } from "@reduxjs/toolkit";
import boardSlice from '../store/boardSlice';

const store = configureStore({
    reducer: {

        board: boardSlice

    }
})

export default store;
