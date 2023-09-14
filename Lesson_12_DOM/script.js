function updateCount(value) {
    let count = document.getElementById('count');
    count.textContent = +count.textContent + value + '';
}

let decrement = document.getElementById('decrement');
decrement.addEventListener('click', () => updateCount(-1))

let decrement10 = document.getElementById('decrement10');
decrement10.addEventListener('click', () => updateCount(-10))

let increment = document.getElementById('increment');
increment.addEventListener('click', () => updateCount(1))

let increment10 = document.getElementById('increment10');
increment10.addEventListener('click', () => updateCount(10))

let reset = document.getElementById('reset');
reset.addEventListener('click', () => {
    let count = document.getElementById('count');
    count.textContent = '0';
})
