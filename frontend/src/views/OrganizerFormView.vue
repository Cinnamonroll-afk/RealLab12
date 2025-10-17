<script setup lang="ts">
import type { Organizer } from '@/type'
import { ref } from 'vue'
import OrganizerService from '@/services/OrganizerService'
import { useRouter } from 'vue-router'
import { useMessageStore } from '@/stores/message'

const organizer = ref<Organizer>({
  id: null,
  organizationName: '',
  address: ''
})

const router = useRouter()
const store = useMessageStore()

function saveOrganizer() {
  OrganizerService.saveOrganizer(organizer.value)
    .then((response) => {
      console.log(response)
      
      router.push({ name: 'event-list' })

      
      store.updateMessage('Successfully added a new organizer: ' + response.data.organizationName)
      setTimeout(() => {
        store.resetMessage()
      }, 3000)
    })
    .catch(() => {
      router.push({ name: 'network-error' })
    })
}
</script>

<template>
  <div>
    <h1>Create an Organizer</h1>
    <form @submit.prevent="saveOrganizer">
      <label>Organization Name</label>
      <input v-model="organizer.organizationName" type="text" placeholder="Organization Name" class="field" />

      <label>Address</label>
      <input v-model="organizer.address" type="text" placeholder="Address" class="field" />

      <button class="button" type="submit">Submit</button>
    </form>
  </div>
</template>

<style >
b,
strong {
  font-weight: bolder;
}
small {
  font-size: 80%;
}
.eyebrow {
  font-size: 20px;
}
h1 {
  font-size: 52px;
  margin-bottom: 20px;
}
h3 {
  font-size: 28px;
  margin-bottom: 20px;
}
button,
label,
input,
optgroup,
select,
textarea {
  display: inline-flex;
  font-family: 'Open sans', sans-serif;
  font-size: 100%;
  line-height: 1.15;
  margin: 0;
}
button,
input {
  overflow: visible;
}
button,
select {
  text-transform: none;
}
label {
  color: rgba(0, 0, 0, 0.5);
  font-weight: 700;
}
input,
textarea {
  box-sizing: border-box;
  border: solid 1px rgba(0, 0, 0, 0.4);
}
input,
[type='text'],
[type='number'],
[type='search'],
[type='password'] {
  height: 52px;
  width: 100%;
  padding: 0 10px;
  font-size: 20px;
}
input:focus {
  border-color: #39b982;
}
.field {
  margin-bottom: 24px;
}
.button {
  display: inline-flex;
  align-items: center;
  justify-content: space-between;
  height: 52px;
  padding: 0 40px;
  background: #16c0b0;
  border: none;
  border-radius: 6px;
  text-align: center;
  font-weight: 600;
  color: white;
  white-space: nowrap;
  transition: all 0.2s linear;
}
.button:hover {
  transform: scale(1.02);
  box-shadow: 0 7px 17px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
}
</style>