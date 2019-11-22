module.exports = {
    devServer: {
        proxy: {
            '/dzy': {
                target: 'http://192.168.6.24:9090',
                changeOrigin: true,
                // pathRewrite: {
                //     '^/api': ""
                // }
            }
        }
    }
};