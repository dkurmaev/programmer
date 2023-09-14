console.log('Hello world!');

let x;
console.log(x);

x = 7;
x = 'bye';
console.log(x);

const pi = 3.1415926;

let y = x;

console.log(y);

console.log('pi = ' + pi);

const exp = pi;

console.log(`exp = ${exp} or ${pi}`);

x = true;
console.log(x);

x = null;
console.log(x);

let res = 7 % 2;
console.log(`res = ${res}`);

res = 'true' + 5;
console.log(`res = ${res}`);

res = true + 5;
console.log(`res = ${res}`);

x = '2' === '2';
console.log(`x = ${x}`);

x = '2' == 2;
console.log(`x = ${x}`);

res = 5 + '';
console.log(typeof res);

res = +'5';
console.log(res);

switch (res) {
    case '5':
        console.log(`string: ${res}`);
        break;
    case 5:
        console.log(`number: ${res}`);
        break;
    default:
        console.log("It's not a 5");
}

let age = 16;
let vol = age >= 16 ? 42 : 1.5;
console.log(`vol = ${vol}`);

console.log(+pi.toFixed(2));

++age;
age++;

let xValue = 10; // Заменил x на xValue, чтобы избежать дублирования
let resValue = xValue++ + ++xValue;
console.log(`res = ${resValue}`);

let yValue = 5; // Заменил y на yValue, чтобы избежать дублирования
resValue = add(xValue, yValue);
console.log(`res = ${resValue}`);

function add(a, b) {
    return a + b;
}

xValue = !!xValue;
console.log(xValue);

let example = 'hello';
console.log(!!example);

let userName = null;
let nickName = 'Anonymous';

greeting();
greeting('Rabbinate');

function greeting(nickName1 = 'Anonymous') {
    console.log(`Hello ${nickName1}`);
}

function sumDigits(x) {
    let digits = x.toString().split('').map(Number);
    return digits.reduce((sum, digit) => sum + digit, 0);
}

function luckyNumber(x) {
    const sumFirstHalf = x
        .toString()
        .slice(0, x.toString().length / 2)
        .split('')
        .map(Number)
        .reduce((sum, digit) => sum + digit, 0);

    const sumSecondHalf = x
        .toString()
        .slice(x.toString().length / 2)
        .split('')
        .map(Number)
        .reduce((sum, digit) => sum + digit, 0);

    return sumFirstHalf === sumSecondHalf;
}

console.log(`res = ${sumDigits(1234)}`);

const isLucky = luckyNumber(123871);
console.log(isLucky ? 'Lucky' : 'Unlucky');
