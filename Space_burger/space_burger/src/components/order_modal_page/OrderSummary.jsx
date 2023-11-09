//компонент для отображения общей сводки заказа
import React from 'react';

const OrderSummary = ({ orderDetails }) => {
    const totalItems = orderDetails.items.reduce((total, item) => total + item.quantity, 0);
    const totalPrice = orderDetails.items.reduce((total, item) => total + (item.quantity * item.price), 0);

    return (
        <div className="order-summary">
            <h3>Order Summary</h3>
            <p>Total Items: {totalItems}</p>
            <p>Total Price: {totalPrice}€</p>
            {/* Другая информация о заказе */}
        </div>
    );
};

export default OrderSummary;