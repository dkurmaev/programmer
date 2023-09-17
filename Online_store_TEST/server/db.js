const {Sequelize} = require('sequelize');

module.exports = new Sequelize(
    process.env.DB_NAME, // Name of the database
    process.env.DB_USER, // User of the database
    process.env.DB_PASSWORD, // Password of the database
    {
        dialect: 'postgres', // Type of the database
        host: process.env.DB_HOST, // Host of the database
        port: process.env.DB_PORT, // Port of the database
    }
)
