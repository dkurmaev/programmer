import React, { useRef } from 'react';

const ScrollButton = ({ targetSection }) => {
    const scrollButton = useRef(null);

    const scrollToSection = () => {
        targetSection.current.scrollIntoView({ behavior: 'smooth' });
    };

    const scrollButtonToSection = () => {
        scrollButton.current.scrollIntoView({ behavior: 'smooth' });
        scrollToSection();
    };

    return (
        <button ref={scrollButton} onClick={scrollButtonToSection}>
            Кнопка скролла
        </button>
    );
};

export default ScrollButton;


// пример кода
// import React, { useRef } from 'react';
// import ScrollButton from './ScrollButton';
//
// function App() {
//   const sectionRef = useRef(null);
//
//   const scrollToSection = () => {
//     sectionRef.current.scrollIntoView({ behavior: 'smooth' });
//   };
//
//   return (
//     <div>
//       <button onClick={scrollToSection}>Прокрутить к секции</button>
//
//       {/* Секция, куда нужно прокрутить страницу */}
// <div ref={sectionRef}>Целевая секция</div>
//
// {/* Использование компонента кнопки скролла */}
// <ScrollButton targetSection={sectionRef} />
// </div>
// );
// }
//
// export default App;


