// App.jsx
import React from 'react';
import OrderPage from './components/order_modal_page/OrderPage';
import ItemManager from "./components/poductSections/ItemManager";

const App = () => {
    const handleAddItem = newItem => {
        console.log('Danke für Ihre wahl:', newItem); // Замените эту строку на свою логику добавления товара в корзину
    };

    return (
        <div className="App">
            <OrderPage />
            <ItemManager handleAddItem={handleAddItem} />
            {/* Другие компоненты вашего приложения */}
        </div>
    );
};

export default App;
