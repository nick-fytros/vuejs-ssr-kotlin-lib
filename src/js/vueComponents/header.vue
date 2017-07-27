<template>
    <div class="test-component">
        <h1>{{title}}</h1>
        <p>Test this component</p>
    </div>
</template>

<script>
export default {
    data: function() {
        return {
            title: 'Test vue data'
        }
    }
}
</script>

<style>
    .test-component p{
        color: red;
    }
</style>

