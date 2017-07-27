// Step 1: Create a Vue instance
const Vue = require('vue')
// const ExpressVueRenderer = require('express-vue-renderer')
const path = require('path');
// test mixin functionality too
const exampleMixin = {
    methods: {
        hello: function () {
            console.log('Hello');
        }
    }
};
// options object
const options = {
    rootPath: path.join(__dirname),
    viewsPath: '',
    componentsPath: 'vueComponents',
    layout: {
        start: '<!DOCTYPE html><html lang="en"><head><meta charset="UTF-8"><meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">',
        middle: '<body><div id="app">',
        end: '</div></body></html>'
    },
    vue: {
        head: {
            meta: [{
                script: 'https://unpkg.com/vue@2.3.4/dist/vue.js'
            }]
        },
        mixins: [exampleMixin]
    },
    data: {
        thing: true
    }
};
// create the renderer with the options
// const Renderer = new ExpressVueRenderer(options);
// data and options object to be passed from the backend
const data = {
    title: 'Express Vue',
    message: 'Hello world'
};
const vueOptions = {
    components: ['header'],
    head: {
        title: 'Page Title',
    }
}

// Renderer.renderToStream('main.vue', data, vueOptions)
//     .then(stream => {
//         stream.on('data', chunk => res.write(chunk));
//         stream.on('end', () => res.end());
//     })
//     .catch(error => {
//         console.error(error);
//         res.send(error);
//     });

// Step 2: Create a renderer
const renderer = require('vue-server-renderer').createRenderer()
const app = {}
// Step 3: Render the Vue instance to HTML
renderer.renderToString(app, (err, html) => {
    if (err) {
        // console.log(err)
    } else {
        return renderCallback(html)
    }
})