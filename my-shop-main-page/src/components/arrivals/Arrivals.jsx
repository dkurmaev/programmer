import "./arrivals.css";
import Card from '../card/Card'

const Arrivals = () => {
  return (
    <section className="arrivals">
      <div className="container">
        <div className="arrivals__header">
            <h2 className="title-2">NEW ARRIVALS</h2>
            </div>
          <div className="arrivals__cards">
            
            <Card title="Hoodies & Sweetshirt"/>
            <Card title="Coats & Parkas"/>
            <Card title="Tees & T-Shirt"/>
         
        </div>
      </div>
    </section>
  );
};

export default Arrivals;
