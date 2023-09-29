type Action =
| {type: 'counter/plus', payload: number}
| {type: 'counter/minus', payload: number}
| {type: 'counter/eraseText'}
| {type: 'counter/changeText', payload: string}
;

export default Action;