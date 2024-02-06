import React, { useContext } from "react";
import { ShopContext } from "../../context/shop-context";

export const AdminProduct = (props) => {
    const { id, productImage, name, quantity, price } = props.data;
    const handleUpdate = () =>{
        fetch('http://localhost:8080/proj-1.0-SNAPSHOT/admin/update', {
            method: 'PUT',
            mode: 'cors',
            headers: {
                'Content-Type': 'application/json'
            },
            body: {
                name: name,
                newQuantity: Number(document.getElementById("#quantityInput").value)
            }
        }).then((response) => response.json())
            .then((result) =>{
                console.log(result);
            })
    }
    return (
        <div className="product">
            <img src={productImage} />
            <div className="description">
                <p>
                    <b>{name}</b>
                </p>
                <p> ${price}</p>
                <p>{quantity}</p>
            </div>
            <input id={"#quantityInput"} placeholder={"Modify quantity: "}/>
            <button onClick={handleUpdate}>Update</button>
        </div>
    );
};