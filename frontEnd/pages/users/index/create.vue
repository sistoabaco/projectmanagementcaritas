<template>
  <div class="flex flex-wrap w-full">
    <Modal
      :title="'Adicionar novo funcionario'"
      size="xl"
      @close="$router.push({ name: 'users' })"
    >
      <div class="grid grid-cols-3 gap-4 space-y-px w-max">
        <TextInput
          v-model="user.username"
          label="Username"
          placeholder="Username"
          class="col-span-3"
          required
        />
        <TextInput label="Senha" placeholder="Senha" class="" required />
        <TextInput
          label="Repetir senha"
          placeholder="Repetir senha"
          class=""
          required
        />
        <p></p>
        <TextInput
          v-model="user.name"
          label="Nome"
          placeholder="Nome"
          class=""
          required
        />
        <TextInput
          v-model="user.email"
          label="Email"
          placeholder="Email"
          class=""
          required
        />
        <TextInput
          v-model="user.email"
          label="Telefone"
          placeholder="Email"
          class=""
          required
        />
        <TextInput
          v-model="user.email"
          label="Endereco"
          placeholder="Email"
          class=""
          required
        />
        <SelectInput
          v-model="user.role"
          label="Genero"
          placeholder=""
          :items="roleOptions"
          class=""
          required
        />
        <SelectInput
          v-model="user.role"
          label="Estado Civil"
          placeholder=""
          :items="roleOptions"
          class=""
          required
        />
        <SelectInput
          v-model="user.role"
          label="Categoria"
          placeholder=""
          :items="roleOptions"
          class=""
          required
        />
        <SelectInput
          v-model="user.department"
          label="Departamento"
          :items="departmentOptions"
          placeholder=""
          class=""
          required
        />
        <SelectInput
          v-model="user.department"
          label="Projecto"
          :items="departmentOptions"
          placeholder=""
          class=""
          required
        />

      </div>
      <template #actions>
        <div class="flex items-center space-x-4">
          <AppButton
            class="flex text-white w-full h-10"
            label="Salvar"
            variant="green"
            @click.native="handleSubmit"
          />
          <AppButton
            class="flex text-black"
            label="Cancelar"
            variant="white"
            size="large"
            @close="$router.push({ name: 'users' })"
          />
        </div>
      </template>
    </Modal>
  </div>
</template>

<script lang="ts">
import Modal from "~/components/common/misc/Modal.vue";
import AppButton from "~/components/common/misc/AppButton.vue";
import TextInput from "~/components/common/inputs/TextInput.vue";
import SelectInput from "~/components/common/inputs/SelectInput.vue";

export default {
  components: { Modal, AppButton, TextInput, SelectInput },

  data: () => ({
    user: {
      username: "",
      name: "",
      email: "",
      role: null,
      category : [],
    },
    roleOptions: [
      { value: "ADMIN", name: "Administrador" },
      { value: "MANAGER", name: "Gestor" },
      { value: "USER", name: "Utilizador" },
    ],
  }),


  methods: {

    handleSubmit() {
    },
  },
};
</script>
