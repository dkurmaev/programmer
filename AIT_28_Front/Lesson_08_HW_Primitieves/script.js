res = sumDigits(1234);
console.log(`res = ${res}`); // Ожидаем увидеть 10

res = luckyNumber(123871); // 1 + 2 + 3 === 8 + 7 + 1
console.log(res ? 'Lucky' : 'Unlucky');

banana();

function sumDigits(x) {
    // создаём результирующую переменную
    let sum = 0;
    // цикл while будет отрабатывать до того момента, пока x не будет равен 0
    while (x) {
        // Аккумулируем в sum остаток от деления на 10 (т.е. последнюю цифру числа)
        sum += x % 10;
        // Отбрасываем последнюю цифру от числа
        x = (x - x % 10) / 10;
    }
    return sum;
}

function luckyNumber(x) {
    // TODO
    let secondHalf = x % 1000;
    let firstHalf = (x - secondHalf) / 1000;

    return sumDigits(firstHalf) === sumDigits(secondHalf);
}

function banana() {
    let a = 'a';
    let b = 'b';
    // TODO
    console.log((b + a + +a + a).toLowerCase());
}

// 'b', 'a' => banana

let d = 5;
console.log(Math.floor(19 / 10));

// x = 4 || x = 7
function returnNumber(x) {
    return 11 - x;
}

// function returnNumber(x) {
//     return 28 / x;
// }