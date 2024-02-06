import React, {useContext, useEffect, useState} from "react";
import { ShopContext } from "../../context/shop-context";
import { CartItem } from "./cart-item";
import { useNavigate } from "react-router-dom";

import "./cart.css";
import {Navbar} from "../../components/navbar";
export const Cart = () => {
    const { cartItems, getTotalCartAmount, checkout } = useContext(ShopContext);
    const totalAmount = getTotalCartAmount();

    const navigate = useNavigate();
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
        <div className="cart">
            <Navbar/>
            <div>
                <h1>Your Cart Items</h1>
            </div>
            <div className="cart">
                {products.productsList.map((product) => {
                    if (cartItems[product.id] !== 0) {
                        return <CartItem data={product} />;
                    }
                })}
            </div>

            {totalAmount > 0 ? (
                <div className="checkout">
                    <p> Subtotal: ${totalAmount} </p>
                    <button onClick={() => navigate("/")}> Continue Shopping </button>
                    <button
                        onClick={() => {
                            checkout();
                            navigate("/checkout");
                        }}
                    >
                        {" "}
                        Checkout{" "}
                    </button>
                </div>
            ) : (
                <h1> Your Shopping Cart is Empty</h1>
            )}
        </div>
    );
};