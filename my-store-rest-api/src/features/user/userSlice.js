import { createAsyncThunk, createSlice } from "@reduxjs/toolkit";
import axios from "axios";
import { BASE_URL } from "../../utils/constants";

// Thunk для создания пользователя
export const createUser = createAsyncThunk(
    'users/createUser', // Уникальное имя для этого Thunk
    async (payload, thunkAPI) => {
        try {
            // Отправляем POST-запрос для создания пользователя
            const res = await axios.post(`${BASE_URL}/users`, payload);
            return res.data;
        } catch (err) {
            console.log(err);
            // Если возникает ошибка, отклоняем Thunk с информацией об ошибке
            return thunkAPI.rejectWithValue({ error: err.message });
        }
    }
);

// Thunk для входа пользователя
export const loginUser = createAsyncThunk(
    'users/loginUser', // Уникальное имя для этого Thunk
    async (payload, thunkAPI) => {
        try {
            // Отправляем POST-запрос для входа пользователя
            const res = await axios.post(`${BASE_URL}/auth/login`, payload);
            // Получаем профиль пользователя после успешного входа
            const login = await axios(`${BASE_URL}/auth/profile`, {
                headers: {
                    "Authorization": `Bearer ${res.data.access_token}`
                }
            });
            return login.data;
        } catch (err) {
            console.log(err);
            // Если возникает ошибка, отклоняем Thunk с информацией об ошибке
            return thunkAPI.rejectWithValue({ error: err.message });
        }
    }
);

// Thunk для обновления данных пользователя
export const updateUser = createAsyncThunk(
    'users/updateUser', // Уникальное имя для этого Thunk
    async (payload, thunkAPI) => {
        try {
            // Отправляем PUT-запрос для обновления данных пользователя
            const res = await axios.put(`${BASE_URL}/users${payload.id}`, payload);
            return res.data;
        } catch (err) {
            console.log(err);
            // Если возникает ошибка, отклоняем Thunk с информацией об ошибке
            return thunkAPI.rejectWithValue({ error: err.message });
        }
    }
);

// Редюсер для обработки данных пользователя
const addCurrentUser = (state, { payload }) => {
    state.currentUser = payload;
}

// Создаем срез состояния и редюсеры для пользовательского стора
const userSlice = createSlice({
    name: 'user',
    initialState: {
        currentUser: null,
        cart: [],
        favorites: [],
        isLoading: false,
        formType: 'signup',
        showForm: false,
    },
    reducers: {
        // Редюсер для добавления товара в корзину
        addItemToCart: (state, { payload }) => {
            let newCart = [...state.cart];
            const found = state.cart.find(({ id }) => id === payload.id);
            if (found) {
                newCart = newCart.map((item) => {
                    return item.id === payload.id
                        ? { ...item, quantity: payload.quantity || item.quantity + 1 }
                        : item;
                });
            } else {
                newCart.push({ ...payload, quantity: 1 });
            }
            state.cart = newCart;
        },

        // Редюсер для добавления товара в избранное
        addItemToFavorites: (state, { payload }) => {
            const found = state.favorites.find(({ id }) => id === payload.id);
            if (!found) {
                state.favorites.push({ ...payload, isFavorite: true });
            }
        },

        // Редюсер для переключения видимости формы
        toggleForm: (state, { payload }) => {
            state.showForm = payload;
        },

        // Редюсер для переключения типа формы (signup/login)
        toggleFormType: (state, { payload }) => {
            state.formType = payload;
        },

        // Редюсер для удаления товара из корзины
        removeItemFromCart: (state, { payload }) => {
            state.cart = state.cart.filter(({ id }) => id !== payload);
        },
    },
    extraReducers: (builder) => {
        // Добавляем обработку успешного завершения Thunk'ов для обновления данных пользователя
        builder.addCase(createUser.fulfilled, addCurrentUser);
        builder.addCase(loginUser.fulfilled, addCurrentUser);
        builder.addCase(updateUser.fulfilled, addCurrentUser);
    },
});

// Экспортируем созданные редюсеры и действия
export const { addItemToCart, addItemToFavorites, toggleForm, toggleFormType, removeItemFromCart } = userSlice.actions;
export default userSlice.reducer;
