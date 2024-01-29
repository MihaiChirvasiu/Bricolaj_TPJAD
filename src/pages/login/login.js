import {useState} from "react";
import {useNavigate} from "react-router-dom";

export const Login = () =>{
    const [loggedUser, setLoggedUser] = useState({username: "", password: "", role: "", loggedIn: false});
    const navigate = useNavigate();
    const handleLogin = () =>{
        fetch('http://localhost:8080/login', {
            method: 'POST',
            mode: 'cors',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                username: document.getElementById("#usernameInput").value,
                password:  document.getElementById("#passwordInput").value,
                role: ""
            }),
        }).then((response) => response.json())
            .then((result) => {
                if(result.message === "SUCCESS"){
                    setLoggedUser({username: document.getElementById("#usernameInput").value,
                        password: document.getElementById("#usernameInput").value,
                        role: result.body.role, loggedIn: true});
                    if(loggedUser.role === "CLIENT"){
                        navigate('/shop')
                    }
                    else{
                        navigate('/admin')
                    }
                }
            })
    }
    const goToRegister = () =>{
        navigate('/register');
    }
    return (
        <div>
            <input id={"#usernameInput"} placeholder={"Enter your username"}/>
            <input id={"#passwordInput"} placeholder={"Enter your password"}/>
            <button onClick={handleLogin}>Login</button>
            <label>Don't have an account/ Register Now!</label>
            <button onClick={goToRegister}>Register</button>
        </div>
    );
}