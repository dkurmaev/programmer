import { useNavigate, useParams } from "react-router-dom";
import { useEffect } from "react";
import { useGetProductQuery } from '../../features/api/apiSlice';
import { ROUTES } from "../../utils/routes";
import Product from "./Product";

const SingleProduct = () => {
    const { id } = useParams();
    const navigate = useNavigate();
    const { data, isLoading, isFetching, isSuccess } = useGetProductQuery({ id });

    useEffect(() => {
        if (!isFetching && !isLoading && !isSuccess) {
            navigate (ROUTES.HOME); // redirect to home if product not found
        }
    },[isLoading, isFetching, isSuccess, navigate]);

    return (
       !data ? (
          <section className="preloader">
               <h2>Product not found</h2>
          </section>
       ) : (
           < >
                <Product {...data} />
           < />
       ));

};

export default SingleProduct;