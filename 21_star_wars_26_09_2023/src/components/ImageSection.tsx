import React from 'react';
import mainImage from '.components/images/main.jpg'; 

const ImageSection: React.FC = () => {
  return (
    <section className="left">
      <img src={mainImage} alt="hero" />
      {/* Добавьте другие изображения */}
    </section>
  );
};

export default ImageSection;
