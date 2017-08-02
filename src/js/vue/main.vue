<template>
    <div>
        <header-component></header-component>
        <h1>{{title}}</h1>
        <p>Welcome to the {{title}} demo. Click a link:</p>
        <input v-model="message" placeholder="edit me">
        <p>{{message}}</p>
        <button type="button" name="button" v-on:click="this.test">Test method</button>
    </div>
</template>

<script>
import headerComponent from '../src/js/vue/components/header.vue';

export default {
    data: function () {
        return {}
    },
    methods: {
        test: function () {
            console.error('test');
        }
    },
    components: ['headerComponent']
}
</script>

<style lang="css">

</style>