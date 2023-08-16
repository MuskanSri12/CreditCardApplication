import React from 'react';
import '../styles/TransparentButton.css'; // Create this CSS file in the same directory as your component
import { Link } from 'react-router-dom';


const TransparentButton = ({ label, onClick }) => {

  return (
    <button onClick={onClick}className="transparent-button">
      {label}
    </button>
  );
}

export default TransparentButton;
