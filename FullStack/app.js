const express = require('express');
const bodyParser = require('body-parser');
const mongoose = require('mongoose');
const passport = require('passport');
const authRoutes = require('./routes/auth'); // Импорт маршрутов для авторизации
const analyticsRoutes = require('./routes/analytics'); // Импорт маршрутов для аналитики
const categoryRoutes = require('./routes/category'); // Импорт маршрутов для категорий
const orderRoutes = require('./routes/order'); // Импорт маршрутов для заказов
const positionRoutes = require('./routes/position'); // Импорт маршрутов для позиций
const keys = require('./config/keys'); // Импорт конфигурационных ключей
const app = express();

// Подключение к MongoDB с использованием ключей из конфигурации
mongoose.connect(keys.mongoURI)
  .then(() => console.log('MongoDB connected')) // Вывод сообщения при успешном подключении
  .catch(err => console.log(err)); // Обработка ошибки при подключении

// Подключение Passport
app.use(passport.initialize());
require('./middleware/passport')(passport);

app.use(require('morgan')('dev')); // Использование логгера Morgan в режиме разработки
app.use(bodyParser.urlencoded({ extended: true })); // Парсинг URL-encoded данных
app.use(bodyParser.json()); // Парсинг JSON данных
app.use(require('cors')()); // Использование CORS middleware для разрешения кросс-доменных запросов

// Подключение маршрутов
app.use('/api/auth', authRoutes); // Маршруты для авторизации доступны по пути /api/auth
app.use('/api/analytics', analyticsRoutes); // Маршруты для аналитики доступны по пути /api/analytics
app.use('/api/category', categoryRoutes); // Маршруты для категорий доступны по пути /api/category
app.use('/api/order', orderRoutes); // Маршруты для заказов доступны по пути /api/order
app.use('/api/position', positionRoutes); // Маршруты для позиций доступны по пути /api/position

module.exports = app; // Экспорт объекта приложения для использования в других модулях
