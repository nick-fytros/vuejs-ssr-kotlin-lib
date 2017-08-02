// Step 1: Create a Vue instance
const Vue = require('vue');
const ExpressVueRenderer = require('express-vue-renderer');
const path = require('path');
const uuidv4 = require('uuid/v4');

// options object
const options = {
    rootPath: path.join(__dirname),
    viewsPath: path.join(__dirname, 'vue'),
    componentsPath: 'vue/components',
    layout: {
        start: '<body><div id="app">',
        end: '</div></body>'
    },
    vue: {
        head: {
            meta: [{
                script: 'https://unpkg.com/vue@2.3.4/dist/vue.js'
            }]
        }
    },
    data: {
        thing: true
    }
};
// create the renderer with the options
const Renderer = new ExpressVueRenderer(options);
// data and options object to be passed from the backend
const data = {
    title: 'Express Vue',
    message: 'Hello world',
    uuid: uuidv4()
};
const vueOptions = {
    head: {
        title: 'Page Title',
    }
};

var HtmlChunks = '';
Renderer.renderToStream('main.vue', data, vueOptions)
    .then(stream => {
        stream.on('data', chunk => {
            HtmlChunks += chunk;
        });
        stream.on('end', () => {
            renderCallback(HtmlChunks);
        });
    }).catch(error => {
        console.error(error);
    });