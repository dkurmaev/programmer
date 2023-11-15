import { configureStore } from "@reduxjs/toolkit";
import { middleware } from "./api/apiSlice";
import { reducerPath } from "./api/apiSlice";
import { reducer } from "./api/apiSlice";

import categoriesSlice from "./categories/categoriesSlice";
import productsSlice from "./products/productsSlice";
import userSlice from "./user/userSlice";

export const store = configureStore({
    reducer: {
        categories: categoriesSlice,
        products: productsSlice,
        user: userSlice,
        [reducerPath]: reducer,
    },
    middleware: (getDefaultMiddleware) =>
        getDefaultMiddleware().concat(middleware),
    devTools: true,
});