// Step 1: Create a Vue instance
const Vue = require('vue')
const app = new Vue({
    template: `<div>Hello World</div>`
})

// Step 2: Create a renderer
const renderer = require('vue-server-renderer').createRenderer()

// Step 3: Render the Vue instance to HTML
renderer.renderToString(app, (err, html) => {
    if (err) {
        renderCallback(err)
    } else {
        renderCallback(html)
    }
})