//компонент для отображения отдельного товара в заказе
import React from 'react';

const OrderItem = ({ item }) => {
    return (
        <div className="order-item">
            <p>{item.name} - Quantity: {item.quantity} - Price: {item.price}€</p>
            {/* Другая информация о товаре */}
        </div>
    );
};

export default OrderItem;
