import {useState} from "react";
import {useNavigate} from "react-router-dom";

export const Register = () => {
    const [registeredUser, setRegisteredUser] = useState({username: "", password: "", role: "", registered: false});

    const navigate = useNavigate();

    const handleRegister = () => {
        fetch('http://localhost:8080/register', {
            method: 'POST',
            mode: 'cors',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                username: document.getElementById("#usernameInput").value,
                password: document.getElementById("#passwordInput").value,
                role: document.getElementById("#roleInput").value
            }),
        }).then((response) => response.json())
            .then((result) => {
                if(result.message === "SUCCESS"){
                    setRegisteredUser({username: document.getElementById("#usernameInput").value,
                        password: document.getElementById("#usernameInput").value,
                        role: result.body.role, registered: true});
                    if(registeredUser.role === "CLIENT"){
                        navigate('/shop')
                    }
                    else{
                        navigate('/admin')
                    }
                }
            })
    }
    return (
        <div>
            <input id={"#usernameInput"} placeholder={"Enter your username"}/>
            <input id={"#passwordInput"} placeholder={"Enter your password"}/>
            <input id={"#roleInput"} placeholder={"Enter your role"}/>
            <button onClick={handleRegister}>Register</button>
        </div>
    );
}