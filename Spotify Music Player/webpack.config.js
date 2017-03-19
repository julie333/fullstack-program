module.exports = {
    entry: __dirname + '/src/app.js',
    output: {
        path: __dirname + '/build/',
        publicPath: '/build/', // for webpack-dev-server
        filename: 'app.bundle.js'
    },
    module: {
        loaders: [{
            test: /\.css$/,
            exclude: /(node_modules)/,
            loaders: ['style-loader', 'css-loader']
        }, {
            test: /\.js$/,
            exclude: /(node_modules)/,
            loader: 'babel-loader',
            query: {
                presets: ['es2015']
            }
        }, {
            test: /\.jpg/,
            exclude: /(node_modules)/,
            loader: 'url-loader'
        }]
    }
};
