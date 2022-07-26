<template>
  <div>
    <BlankTop/>
    <nuxt />
  </div>
</template>

<script lang="ts">
import { defineComponent } from '@nuxtjs/composition-api'
import BlankTop from '~/components/layout/BlankTop.vue'

export default defineComponent({
    name: 'Blank',
    components: { BlankTop }
})
</script>