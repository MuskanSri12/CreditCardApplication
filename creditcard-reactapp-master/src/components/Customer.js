import React, { useEffect, useState } from 'react'
import { useNavigate, useParams } from 'react-router-dom'
import { deleteEmployee, getEmployeeById } from '../services/empservice'

export default function Customer() {
    let {id} = useParams()
    let navigate = useNavigate()
    const [customer, setCustomer] = useState({})

    useEffect(()=>{
        getCustomerById(Number(id)).then(res=>setCustomer(res))
    })

    const delCustomre = ()=>{
        deleteCustomer(Number(id))
        .then(res=>navigate('/'))
    }
  return (
    <div className='container mt-5'>
        <h1>Name : {employee?.name}</h1>
        <p>Region: {employee?.region}</p>
        <p>Salary: {employee?.dosh}</p>
        <p><button onClick={delEmployee}>DEl</button></p>
    </div>
  )
}