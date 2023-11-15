// api/apiSlice.js
import { createApi, fetchBaseQuery } from "@reduxjs/toolkit/query/react";
import { BASE_URL } from "../../utils/constants";

export const apiSlice = createApi({
    reducerPath: 'api',
    tagTypes: ['Product'],
    baseQuery: fetchBaseQuery({ baseUrl: BASE_URL }),
    endpoints: (builder) => ({
        getProduct: builder.query({
            query: ({id}) => `/products/${id}`,
            providesTags: ['Product']
        })
    })

});

export const { reducerPath, reducer, middleware } = apiSlice;

export const { useGetProductQuery } = apiSlice;
