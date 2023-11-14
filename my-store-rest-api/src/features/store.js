import {configureStore} from "@reduxjs/toolkit";
import categorieSlice from "./categories/categorieSlice";

export const store = configureStore({
    reducer: {
        categories: categorieSlice,
    },
    devTools: true,
})