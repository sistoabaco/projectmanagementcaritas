<template>
 <main class="login" @submit.prevent="submit">
   <section class="forms">
     <form class="login" >
       <h2>E-mail</h2>
       <input type="email" name="email" placeholder="email address" v-model="data.email"/>
       <h2>Password</h2>
       <input type="password" name = "password" placeholder="password" v-model="data.password"/>
       <button type="submit" class="">ENTRAR</button>
     </form>
   </section>
 </main>
</template>

<script lang="ts">
  import {reactive} from "@nuxtjs/composition-api";

  export default {
    name: 'Login',
    setup(){
       const data = reactive({
          email : '',
          password: '',
        });

      const submit = async() =>{
        const response =  await axios.post('http://localhost:8080/login', data)
      }
      return{
        data,
        submit
      }
    }
  }
</script>
