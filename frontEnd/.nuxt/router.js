import Vue from 'vue'
import Router from 'vue-router'
import { normalizeURL, decode } from 'ufo'
import { interopDefault } from './utils'
import scrollBehavior from './router.scrollBehavior.js'

<<<<<<< HEAD
const _8ba13664 = () => interopDefault(import('..\\pages\\login\\index.vue' /* webpackChunkName: "pages/login/index" */))
const _210a2552 = () => interopDefault(import('..\\pages\\partners\\index.vue' /* webpackChunkName: "pages/partners/index" */))
const _a1455844 = () => interopDefault(import('..\\pages\\project\\index.vue' /* webpackChunkName: "pages/project/index" */))
const _55d48662 = () => interopDefault(import('..\\pages\\users\\index.vue' /* webpackChunkName: "pages/users/index" */))
const _f6c7f76a = () => interopDefault(import('..\\pages\\users\\index\\create.vue' /* webpackChunkName: "pages/users/index/create" */))
const _8beaeb76 = () => interopDefault(import('..\\pages\\users\\index\\_id\\edit.vue' /* webpackChunkName: "pages/users/index/_id/edit" */))
const _03f3ca1d = () => interopDefault(import('..\\pages\\index.vue' /* webpackChunkName: "pages/index" */))
=======
const _32ce3264 = () => interopDefault(import('..\\pages\\partners\\index.vue' /* webpackChunkName: "pages/partners/index" */))
const _4d8b46e8 = () => interopDefault(import('..\\pages\\project\\index.vue' /* webpackChunkName: "pages/project/index" */))
const _1c379708 = () => interopDefault(import('..\\pages\\project\\index\\create.vue' /* webpackChunkName: "pages/project/index/create" */))
const _425918fd = () => interopDefault(import('..\\pages\\users\\index.vue' /* webpackChunkName: "pages/users/index" */))
const _3b0f5279 = () => interopDefault(import('..\\pages\\users\\index\\create.vue' /* webpackChunkName: "pages/users/index/create" */))
const _a37d3552 = () => interopDefault(import('..\\pages\\users\\index\\_id\\edit.vue' /* webpackChunkName: "pages/users/index/_id/edit" */))
const _ffc0b4a2 = () => interopDefault(import('..\\pages\\index.vue' /* webpackChunkName: "pages/index" */))
>>>>>>> 961ac01db9650739776c9558d93c0d6ea618e2d3

const emptyFn = () => {}

Vue.use(Router)

export const routerOptions = {
  mode: 'history',
  base: '/',
  linkActiveClass: 'nuxt-link-active',
  linkExactActiveClass: 'nuxt-link-exact-active',
  scrollBehavior,

  routes: [{
    path: "/login",
    component: _8ba13664,
    name: "login"
  }, {
    path: "/partners",
    component: _32ce3264,
    name: "partners"
  }, {
    path: "/project",
    component: _4d8b46e8,
    name: "project",
    children: [{
      path: "create",
      component: _1c379708,
      name: "project-index-create"
    }]
  }, {
    path: "/users",
    component: _425918fd,
    name: "users",
    children: [{
      path: "create",
      component: _3b0f5279,
      name: "users-index-create"
    }, {
      path: ":id?/edit",
      component: _a37d3552,
      name: "users-index-id-edit"
    }]
  }, {
    path: "/",
    component: _ffc0b4a2,
    name: "index"
  }],

  fallback: false
}

export function createRouter (ssrContext, config) {
  const base = (config._app && config._app.basePath) || routerOptions.base
  const router = new Router({ ...routerOptions, base  })

  // TODO: remove in Nuxt 3
  const originalPush = router.push
  router.push = function push (location, onComplete = emptyFn, onAbort) {
    return originalPush.call(this, location, onComplete, onAbort)
  }

  const resolve = router.resolve.bind(router)
  router.resolve = (to, current, append) => {
    if (typeof to === 'string') {
      to = normalizeURL(to)
    }
    return resolve(to, current, append)
  }

  return router
}
