function sumDigits(x) {
    let digits = x.toString().split('').map(Number);
    return digits.reduce((sum, digit) => sum + digit, 0);
}

function luckyNumber(x) {
    const digits = x.toString().split('').map(Number);
    const middle = Math.floor(digits.length / 2);

    const sumFirstHalf = digits.slice(0, middle).reduce((sum, digit) => sum + digit, 0);
    const sumSecondHalf = digits.slice(middle + (digits.length % 2)).reduce((sum, digit) => sum + digit, 0);

    return sumFirstHalf === sumSecondHalf;
}

function banana() {
    let result = '';

    while (result !== 'banana') {
        result += Math.random() < 0.5 ? 'a' : 'b';
    }

    console.log(result);
}

console.log(sumDigits(1234)); // Ожидаем увидеть 10

const isLucky = luckyNumber(123871); // 1 + 2 + 3 === 8 + 7 + 1
console.log(isLucky ? 'Lucky' : 'Unlucky');

banana();
