const shoppingCart = {
    items: [], // массив товаров  item => name, price, quantity
    totalCost: 0, // итогова стоимость всех продуктов
    addItem(item) {
        const existingItem = this.items.find(e => e.name === item.name);
        if (existingItem) {
            existingItem.quantity += item.quantity;
            existingItem.price = existingItem.price < item.price ? item.price : existingItem.price
        } else {
            this.items.push(item);
        }
        this.updateTotalCost();
    }, removeItem(itemName) {
        const index = this.items.findIndex(elem => elem.name === itemName);
        if (index !== -1) {
            this.items.splice(index, 1);
            this.updateTotalCost();
        }
    }, updateTotalCost() {
        this.totalCost = this.items.reduce((acc, item) => {
            return acc + item.price * item.quantity;
        }, 0);
    }
}

// const add = document.getElementById('add');
// '     555     '.trim() => '555'

add.onclick = addHandler;
stats.onclick = statsHandler;

stats.onclick = statsHandler;

function statsHandler() {
    const statsOur = document.getElementById('statsOur');
    statsOur.innerHTML = '';
    const itemCount = shoppingCart.items.length;

    const item1 = document.createElement('li');

    item1.textContent = `Количество позиций: ${itemCount}`;
    statsOur.appendChild(item1);

    const totalCost = shoppingCart.totalCost;
    const item2 = document.createElement('li');
    item2.textContent = `Итоговая стоимость всех продуктов: ${totalCost}`;
    statsOur.appendChild(item2);

    const totalQuantity = shoppingCart.items.reduce((acc, item) => acc + item.quantity, 0);
    const item3 = document.createElement('li');
    item3.textContent = `Итоговое количество всех продуктов: ${totalQuantity}`;
    statsOur.appendChild(item3);


    const maxPrice = Math.max(...shoppingCart.items.map(item => item.price));
    const item4 = document.createElement('li');
    item4.textContent = `Максимальная цена: ${maxPrice}`;
    statsOur.appendChild(item4);


    const minPrice = Math.min(...shoppingCart.items.map(item => item.price));
    const item5 = document.createElement('li');
    item5.textContent = `Минимальная цена: ${minPrice}`;
    statsOur.appendChild(item5);


    const averagePrice = totalCost / itemCount;
    const item6 = document.createElement('li');
    item6.textContent = `Средняя цена: ${averagePrice.toFixed(2)}`;
    statsOur.appendChild(item6);
}


function addHandler() {
    shoppingCart.addItem({
        name: productName.value.trim(), price: +price.value.trim(), quantity: +quantity.value.trim()
    })

    productList.innerHTML = '';

    shoppingCart.items.forEach(e => {
        const li = document.createElement('li');
        li.textContent = `
            Product name: ${e.name},
            Product price: ${e.price},
            Quantity of product: ${e.quantity},
        `;
        let productList = document.getElementById('productList');
        productList.appendChild(li);
    })
}

const item = {
    name: 'Alice',

}

// item.name === 'Хлеб'
