import React, {useEffect, useState} from "react";
import { ClientProduct } from "./product";
import "./shop.css";
import {Navbar} from "../../components/navbar";

export const Shop = () => {
    const [products, setProducts] = useState({productsList: []});
    useEffect(() =>{
        fetch('http://localhost:8080/proj-1.0-SNAPSHOT/admin/load', {
            method: "GET",
            mode: 'cors',
            headers: {
            'Content-Type': 'application/json'
        }
        }).then((response) => response.json())
            .then((result) => {
                setProducts({productsList: result});
            })
    }, []);
    return (
        <div>
            <Navbar/>
        <div className="shop">
            <div className="shopTitle">
                <h1>Brico Store</h1>
            </div>

            <div className="products">
                {products.productsList.map((product) => (
                    <ClientProduct data={product} />
                ))}
            </div>
        </div>
        </div>
    );
};