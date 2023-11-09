//родительский компонент, который передает данные заказа в компонент Order:
import React from 'react';
import Order from './Order';

const OrderPage = () => {
    const orderDetails = {
        items: [
            { id: 1, name: '"SPACE" Burger', quantity: 2, price: 9.90 },
            { id: 2, name: '“TEXAS” POMMES FRITES', quantity: 1, price: 9.90 },
            // Другие товары
        ],
        // Другая информация о заказе
    };

    return (
        <div className="order-page">
            <h1>Order Details</h1>
            <Order orderDetails={orderDetails} />
            {/* Другие компоненты или информация о заказе */}
        </div>
    );
};

export default OrderPage;