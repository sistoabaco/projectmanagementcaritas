<template>
  <div class="flex min-h-screen">
    <div class="hidden lg:block lg:w-1/2">
      <img
        src="~/assets/images/login-cover.png"
        class="h-screen object-cover"
      />
    </div>
    <div class="flex flex-wrap flex-col w-full justify-center lg:w-1/2">
      <div class="flex justify-center w-full">
        <img class="w-16" src="~/assets/images/caritas.png" alt="caritas-Logo" />
      </div>
      <div class="flex flex-wrap flex-col w-full items-center space-y-5 mt-8">
        <div class="w-1/3">
          <label for="email-address" class="sr-only">Email address</label>
          <input
            id="email-address"
            v-model="form.email"
            name="email"
            type="email"
            autocomplete="email"
            required
            class="
              appearance-none
              rounded-none
              relative
              block
              w-full
              px-3
              py-2
              border border-gray-300
              placeholder-gray-500
              text-gray-900
              rounded-t-md
              focus:outline-none
              focus:ring-green-500
              focus:border-green-500
              focus:z-10
              sm:text-sm
            "
            placeholder="Email address"
          />
        </div>
        <div class="w-1/3">
          <label for="password" class="sr-only">Password</label>
          <input
            id="password"
            v-model="form.password"
            name="password"
            type="password"
            autocomplete="current-password"
            required
            class="
              appearance-none
              rounded-none
              relative
              block
              w-full
              px-3
              py-2
              border border-gray-300
              placeholder-gray-500
              text-gray-900
              rounded-b-md
              focus:outline-none
              focus:ring-green-500
              focus:border-green-500
              focus:z-10
              sm:text-sm
            "
            placeholder="Password"
          />
        </div>
        <div class="text-sm">
          <a href="#" class="font-medium text-indigo-600 hover:text-indigo-500">
            Esqueceu sua senha?
          </a>
        </div>
        <div class="w-1/3">
          <button
            type="submit"
            class="
              group
              relative
              w-full
              flex
              justify-center
              py-2
              px-4
              border border-transparent
              text-sm
              font-medium
              rounded-md
              text-white
              bg-green-500
              hover:bg-green-700
              focus:outline-none
              focus:ring-2
              focus:ring-offset-2
              focus:ring-green-500
            "
            @click="login"
          >
            Entrar
          </button>
        </div>
      </div>
    </div>
  </div>
</template>

<script lang="ts">
import { defineComponent } from '@nuxtjs/composition-api'
export default defineComponent({
  name: 'Login',
  components: { },
  layout: 'blank',
  data: () => ({
    form: {
      email: '',
      password: '',
    },
  }),
  head: {
    title: 'Login - Caritas - Gestão de Projectos',
  },
  methods: {
    async login() {
      await (this as any).$auth
        .loginWith('local', { data: this.form })
        .then(() => {})
        .catch(() => {})
    },
  },
})
</script>
