import {useState} from "react";
import {useNavigate} from "react-router-dom";

export const Login = () =>{
    const [loggedUser, setLoggedUser] = useState({username: "", password: "", role: "", loggedIn: false});
    const navigate = useNavigate();
    const handleLogin = () =>{
        fetch('http://localhost:8080/proj-1.0-SNAPSHOT/login', {
            method: 'POST',
            mode: 'cors',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                username: document.getElementById("#usernameInput").value,
                password:  document.getElementById("#passwordInput").value,
                role: ""
            })
        }).then((response) => response.json())
            .then((result) => {
                console.log(result);
                if(result !== null){
                    console.log("HERE");
                    setLoggedUser({username: document.getElementById("#usernameInput").value,
                        password: document.getElementById("#usernameInput").value,
                        role: result.role, loggedIn: true});
                    console.log(result.role);
                    if(result.role === "CLIENT"){
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