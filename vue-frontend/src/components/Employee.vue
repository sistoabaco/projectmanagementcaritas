<template>
  <div class="container">
    <h1 class="text-center">Employees List</h1>
    <table class="table table-striped">
      <thead>
        <th>Id</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>E-mail</th>
      </thead>
      <tbody>
        <tr v-for="employee in employees" v-bind:key="employee.id">
          <td>{{employee.idEmployee}}</td>
          <td>{{employee.firstName}}</td>
          <td>{{employee.lastName}}</td>
          <td>{{employee.email}}</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import EmployeeService from '../services/EmployeeService'
export default {
  name: 'Employees',
  data(){
    return {
      employees : []
    }
  },
  methods: {
    getEmployees(){
      EmployeeService.getEmployees().then((response) =>{
        this.employees = response.data;
      })
    }
  },
  created() {
    this.getEmployees()
  }
}
</script>