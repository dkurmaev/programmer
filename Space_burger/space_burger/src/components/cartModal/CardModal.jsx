import React from 'react';
import styles from './MyComponent.css';

const cardModal = ({ isOpen, onClose, children }) => {
    if (!isOpen) {
        return null;
    }

    return (
        <div className={styles.modalOverlay} onClick={onClose}>
            <div className={styles.modal}>
                <div className={styles.modalContent} onClick={(e) => e.stopPropagation()}>
                    <span className={styles.closeButton} onClick={onClose}>X</span>
                    {children}
                </div>
            </div>
        </div>
    );
};

export default cardModal;
