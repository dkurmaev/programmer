//компонент для отображения заказа со списком товаров и сводкой
import React from 'react';
import OrderItem from './OrderItem';
import OrderSummary from './OrderSummary';

const Order = ({ orderDetails }) => {
    return (
        <div className="order">
            <h2>Your Order</h2>
            {orderDetails.items.map(item => (
                <OrderItem key={item.id} item={item} />
            ))}
            <OrderSummary orderDetails={orderDetails} />
        </div>
    );
};

export default Order;