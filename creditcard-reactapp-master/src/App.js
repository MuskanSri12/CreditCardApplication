
import './App.css';
import About from './components/About';
import Contact from './components/Contact';
import CustomerList from './components/CustomerList';
import GradientBackground from './components/GradientBackground';
import Home from './components/Home';
import NavigationBar from './components/NavigationBar';
import RegisterCustomer from './components/RegisterCustomer';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';


function App() {

  return (
    <Routes>
      <Route path="/" exact element={<CustomerList />}/>
      <Route path="/register-customer" element={<RegisterCustomer />} />
      <Route path="/about" element={<About />} />
      <Route path="/home" element={<Home />} />
      <Route path="/contact" element={<Contact />} />
    </Routes>
  );
}

export default App;
