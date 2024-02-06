import { createContext, useEffect, useState } from "react";
import {Shop} from "../pages/shop/shop";

export const ShopContext = createContext(null);
const Load = () => {
    const [products, setProducts] = useState({productsList: []});
    useEffect(() => {
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
    function getDefaultCart() {
        let cart = {};
        for (let i = 1; i < products.productsList.length + 1; i++) {
            cart[products.productsList[i].id] = 0;
        }
        return cart;
    }
}


export const ShopContextProvider = (props) => {
    const [cartItems, setCartItems] = useState({cart: {}});

    const getTotalCartAmount = () => {
        let totalAmount = 0;
        for (const item in cartItems) {
            if (cartItems[item] > 0) {
                let itemInfo = props.productsList.find((product) => product.id === Number(item));
                totalAmount += cartItems[item] * itemInfo.price;
            }
        }
        return totalAmount;
    };

    const addToCart = (itemId) => {
        setCartItems((prev) => ({ ...prev, [itemId]: prev[itemId] + 1 }));
    };

    const removeFromCart = (itemId) => {
        setCartItems((prev) => ({ ...prev, [itemId]: prev[itemId] - 1 }));
    };

    const updateCartItemCount = (newAmount, itemId) => {
        setCartItems((prev) => ({ ...prev, [itemId]: newAmount }));
    };

    const checkout = () => {
        setCartItems({});
    };

    const contextValue = {
        cartItems,
        addToCart,
        updateCartItemCount,
        removeFromCart,
        getTotalCartAmount,
        checkout,
    };

    return (
        <ShopContext.Provider value={contextValue}>
            {props.children}
        </ShopContext.Provider>
    );
};