let url = "http://localhost:8080/customers";

export async function getAllCustomers() {
  let response = await fetch(`${url}`);
  let customers = await response.json();
  console.log(customers);
  return customers;
}