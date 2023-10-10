const bcrypt = require("bcryptjs");
const jwt = require("jsonwebtoken"); // Добавили библиотеку для работы с JWT
const User = require("../models/User");
const keys = require("../config/keys");


module.exports.login = async function (req, res) {
    // Поиск пользователя по email
    const candidate = await User.findOne({ email: req.body.email });

    if (candidate) {
        // Проверка пароля
        const passwordResult = bcrypt.compareSync(req.body.password, candidate.password);

        if (passwordResult) {
            // Генерация JWT токена
            const token = jwt.sign({
                email: candidate.email,
                userId: candidate._id
            }, keys.jwt, { expiresIn: 60 * 60 })
            // Отправка токена в ответе
            res.status(200).json({
                token: `Bearer ${token}`, // Добавляем тип токена в ответе с помощью `Bearer `token 
            });

        } else {
            // Пароль неверный
            res.status(401).json({
                message: 'Password is incorrect',
            });
        }
    } else {
        // Пользователь не найден
        res.status(404).json({
            message: "User with this email not found",
        });
    }
}


module.exports.register = async function (req, res) {
    // Поиск пользователя по email
    const candidate = await User.findOne({ email: req.body.email });

    if (candidate) {
        // Пользователь уже существует
        res.status(409).json({
            message: "User with this email already exists",
        });
    } else {
        // Создание пользователя
        const salt = bcrypt.genSaltSync(10); // Генерация соли
        const password = req.body.password;
        const user = new User({
            email: req.body.email,
            password: bcrypt.hashSync(password, salt), // Хеширование пароля
        });

        // Сохранение пользователя в базе данных
        await user.save();

        res.status(201).json({
            message: "User has been created successfully",
        });
    }

};
