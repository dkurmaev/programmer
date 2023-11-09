import React, { useState } from 'react';
import Modal from './CardModal';
import styles from './MyComponent.css'; // вместо YourComponent подставьте свое название

const MyComponent = () => {
    const [isModalOpen, setIsModalOpen] = useState(false);

    const openModal = () => {
        setIsModalOpen(true);
    };

    const closeModal = () => {
        setIsModalOpen(false);
    };

    return (
        <div className={styles.container}>
            <button onClick={openModal}>Открыть модальное окно</button>
            <Modal isOpen={isModalOpen} onClose={closeModal}>
                <h2>Мой модальный заголовок</h2>
                <p>Содержимое модального окна...</p>
            </Modal>
        </div>
    );
};

export default MyComponent;
