<template>
    <div>
        <h1>{{title}}</h1>
        <p>Welcome to the {{title}} demo. Click a link:</p>
        <input v-model="message" placeholder="edit me">
        <p>{{message}}</p>
        <uuid :uuid="uuid"></uuid>
        <button type="button" name="button" v-on:click="this.hello">Test mixin</button>
        <button type="button" name="button" v-on:click="this.test">Test method</button>
    </div>
</template>

<script>
import uuid from '../src/js/vue/components/uuid.vue';
import exampleMixin from '../src/js/vue/mixins/exampleMixin.js';
export default {
    data: function () {
        return {}
    },
    methods: {
        test: function () {
            console.error('test');
        }
    },
    mixins: [exampleMixin],
    components: {
        uuid: uuid
    }
}
</script>

<style lang="css">

</style>