import { createSlice, PayloadAction } from '@reduxjs/toolkit';

interface User {
  id: number;
  name: string;
  email: string;
}

interface UserState {
  users: User[];
}

const initialState: UserState = {
  users: [],
};

const userSlice = createSlice({
  name: 'user',
  initialState,
  reducers: {
    setUser: (state, action: PayloadAction<User>) => {
      state.users.push(action.payload);
    },
    clearUser: (state) => {
      state.users = [];
    },
  },
});

export const { setUser, clearUser } = userSlice.actions;
export default userSlice.reducer;