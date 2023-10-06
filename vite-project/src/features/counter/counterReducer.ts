import Action from "./type/Action";
import CounterState from "./type/CounterState";

const initialState: CounterState = {
  value: 0,
};

export default function counterReducer(
  state: CounterState = initialState,
  action: Action
): CounterState {
  switch(action.type){
    case 'counter/plus': 
      return {...state, value: state.value + action.payload};
    case 'counter/minus': 
      return {...state, value: state.value - action.payload};
    default: return state;
  }
}