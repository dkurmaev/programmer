import React, { useState } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { RootState } from '../../store';

export default function Counter():JSX.Element {
  const counter = useSelector((state:RootState) => state.counter.value);
  const text = useSelector((state: RootState) => state.counter.text)
  const [message, setMessage] = useState<string>('Налоговый класс 1');
  const dispatch = useDispatch();
  const handlePlus = () => {
    dispatch({type: 'counter/plus', payload: 1});
  }
  const handleClearText = () => {
    dispatch({type: 'counter/eraseText'});
  }

  const handleTextChange = (newText: string) => {
    dispatch({type: 'counter/changeText', payload: newText});
  }

  return (
    <div>Counter
      <br />
      text: {text}
      <button type="button" onClick={handleClearText}>clear</button>
      <p>{message}</p>
      
      <input 
        type="text" 
        onChange={(e)=>setMessage(e.target.value)} 
        value={message}
      />
      <button type="button" onClick={() => handleTextChange(message)}>
        Заменить текст
      </button>
      <br />
      value: {counter}
      <button type="button" onClick={handlePlus}>+1</button>
    </div>
  );
}

