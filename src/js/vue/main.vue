<template>
    <div>
        <header></header>
        <h1>{{title}}</h1>
        <p>Welcome to the {{title}} demo. Click a link:</p>
        <input v-model="message" placeholder="edit me">
        <p>{{message}}</p>
        <button type="button" name="button" v-on:click="this.hello">Test mixin</button>
        <button type="button" name="button" v-on:click="this.test">Test method</button>
    </div>
</template>

<script>
export default {
    data: function () {
        return {
        }
    },
    methods: {
        test: function () {
            console.error('test');
        }
    }
}
</script>

<style lang="css">

</style>