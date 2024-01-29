import "./App.css";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import { Shop } from "./pages/shop/shop";
import { Contact } from "./pages/contact";
import { Cart } from "./pages/cart/cart";
import { ShopContextProvider } from "./context/shop-context";
import {Login} from "./pages/login/login";
import {Register} from "./pages/login/register";
import {Admin} from "./pages/admin";


function App() {
  return (
      <div className="App">
        <ShopContextProvider>
          <Router>
            {/*<Navbar />*/}
            <Routes>
                <Route path={"/"} element={<Login />}/>
                <Route path={"/register"} element={<Register/>}/>
              <Route path="/shop" element={<Shop />} />
              <Route path="/contact" element={<Contact />} />
              <Route path="/cart" element={<Cart />} />
                <Route path="/admin" element={<Admin />} />
            </Routes>
          </Router>
        </ShopContextProvider>
      </div>
  );
}

export default App;