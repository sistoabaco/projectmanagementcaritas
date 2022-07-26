export default {
  // Disable server-side rendering: https://go.nuxtjs.dev/ssr-mode
  ssr: false,

  // Global page headers: https://go.nuxtjs.dev/config-head
  head: {
    title: 'Caritas - Gestão de Projectos',
    htmlAttrs: {
      lang: 'en'
    },
    meta: [
      { charset: 'utf-8' },
      { name: 'viewport', content: 'width=device-width, initial-scale=1' },
      { hid: 'description', name: 'description', content: 'Caritas - Gestão de Projectos' },
      { name: 'format-detection', content: 'telephone=no' }
    ],
    link: [
      { rel: 'icon', type: 'image/x-icon', href: '/favicon.ico' }
    ]
  },

  // Global CSS: https://go.nuxtjs.dev/config-css
  css: [
  ],

  // Plugins to run before rendering page: https://go.nuxtjs.dev/config-plugins
  plugins: [
  ],

  // Auto import components: https://go.nuxtjs.dev/config-components
  components: true,

  // Modules for dev and build (recommended): https://go.nuxtjs.dev/config-modules
  buildModules: [
    // https://go.nuxtjs.dev/typescript
    '@nuxt/typescript-build',
    // https://go.nuxtjs.dev/tailwindcss
    '@nuxtjs/tailwindcss',
    '@nuxtjs/composition-api/module',
  ],

  // Modules: https://go.nuxtjs.dev/config-modules
  modules: [
    // https://go.nuxtjs.dev/axios
    '@nuxtjs/axios',
    '@nuxtjs/auth-next',
    '@nuxtjs/pwa',
  ],

  auth: {
    strategies: {
      local: {
        token: {
          property: 'token',
          global: true,
        },
        user: {
          property: 'data',
        },
        endpoints: {
          login: {
            url: '/auth/jwt',
            method: 'post',
            headers: {
              'Content-Type': 'application/json',
              Accept: 'application/json',
            },
          },
          logout: { url: '/auth/jwt/logout', method: 'post' },
          user: { url: '/user/info', method: 'get' },
        },
      },
    },
    redirect: {
      login: '/auth/login',
      logout: '/auth/login',
      home: '/',
    },
  },

  // Axios module configuration: https://go.nuxtjs.dev/config-axios
  axios: {
    // Workaround to avoid enforcing hard-coded localhost:3000: https://github.com/nuxt-community/axios-module/issues/308
    baseURL: 'http://localhost:8080/',
  },

  router: {
    middleware: ['auth'],
  },

  pwa: {
    manifest: {
      lang: 'en',
    },
    icon: {
      fileName: 'icon.png',
    },
  },

  // Build Configuration: https://go.nuxtjs.dev/config-build
  build: {
  }
}
