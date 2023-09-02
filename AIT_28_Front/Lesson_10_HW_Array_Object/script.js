/*
    Необходимо создать объект bankAccount(дебет), представляющий банковский счёт со
    следующими свойствами:

    1. accountNumber: 123456789 (для номера счёта);
    2. accountHolderName для имени владельца счёта;
    3. balance для баланса;
    4. deposit() для описания действия по добавлению денег на счёт;
    5. withdraw() для описания действия по снятию денег со счёта;
    6. checkBalance() для проверки баланса.
*/
// Создаем объект bankAccount
const bankAccount = {
    accountNumber: 1234567890,
    accountHolderName: "Danil Kurmayev",
    balance: 0,

    // Метод для депозита (добавления денег на счет)
    deposit: function (amount) {
        if (amount > 0) {
            this.balance += amount;
            console.log(`Депозит на ${amount} успешно выполнен.`);
        } else {
            console.log("Неверная сумма для депозита.");
        }
    },

    // Метод для снятия денег со счета
    withdraw: function (amount) {
        if (amount > 0 && amount <= this.balance) {
            this.balance -= amount;
            console.log(`Снятие ${amount} успешно выполнено.`);
        } else {
            console.log("Недостаточно средств на счете или неверная сумма для снятия.");
        }
    },

    // Метод для проверки баланса
    checkBalance: function () {
        console.log(`Баланс на счете: ${this.balance}`);
    },
};

// Пример использования объекта bankAccount
console.log(`Номер счета: ${bankAccount.accountNumber}`);
console.log(`Владелец счета: ${bankAccount.accountHolderName}`);
bankAccount.deposit(25000);
bankAccount.checkBalance();
bankAccount.withdraw(15000);
bankAccount.checkBalance();

