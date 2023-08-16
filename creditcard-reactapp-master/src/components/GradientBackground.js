import React from 'react';
import '../styles/GradientBackground.css'
// import { useHistory } from 'react-router-dom';
import TransparentButton from './TransparentButton';

const GradientBackground = () => {

    // const history = useHistory();
    const handleRegisterButtonClick = () => {
        // history.push('/register-customer'); // Replace with the desired route
        window.location.href = '/register-customer';
      };

  return (
    <div className="gradient-background">
      <TransparentButton label="Register for credit card" onClick={handleRegisterButtonClick}/>
    </div>
  );
}

export default GradientBackground;