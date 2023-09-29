import { createStore, combineReducers } from "redux";
import { sandwichReducer } from "./reducers/sandwichReducer";

export type RootState = ReturnType<typeof rootReducer>;

const rootReducer = combineReducers({
  sandwich: sandwichReducer,
});

const store = createStore(rootReducer);

export default store;
