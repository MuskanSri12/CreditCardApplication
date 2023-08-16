import React, { useEffect, useState } from 'react'
import { getAllCustomers } from '../services/custservice'
import { NavLink, Outlet } from 'react-router-dom';

function CustomerList() {

  const [customers, setCustomers] = useState([])

  useEffect(()=>{
      getAllCustomers().then(customers=>setCustomers(customers));
      console.log()
  },[])

  return (
    <div>
    {/* <p>{JSON.stringify(employees)}</p> */}
    <div className='row mt-5'>
        <div className='col-md-3' style={{borderRight:'2px solid black'}}>
        <ul className="list-group list-group-flush">
            {
                
                customers.length &&(
                customers.map(customer => (
                    <li key={customer.customer_Id} className="list-group-item">
                    <NavLink to={`/${customer.customer_Id}`}>
                        {customer.firstName} {customer.lastName}
                    </NavLink>
                    </li>
                ))
                )
            }
        </ul>
        </div>
        <div className='col-md-9'>
            
            <Outlet/>
        </div>
    </div>
</div>
  )
}

export default CustomerList