const Order = require("../models/Order"); // Импорт модели заказов
const errorHandler = require("../utils/errorHandler"); // Импорт функции для обработки ошибок

// Контроллер для получения списка заказов, //(get) localhost:5000/api/order?offset=0&limit=10
module.exports.getAll = async function (req, res) {
  const query = {
    user: req.user.id, // Поиск заказов по идентификатору пользователя
  };
  if (req.query.start) {
    query.date = {
      // Ограничение даты начала заказа больше или равно
      $gte: req.query.start,
    };
  }

  if (req.query.end) {
    if (!query.date) {
      query.date = {};
    }
    query.date["$lte"] = req.query.end; // Ограничение даты конца заказа меньше или равно
  }

  if(req.query.order) {
    query.order = +req.query.order //
  }

  try {
    const orders = await Order.find(query) // Поиск заказов в базе данных
      .sort({ date: -1 }) // Сортировка по дате в убывающем порядке
      .skip(+req.query.offset) // Пропуск указанного количества заказов. Знак + перед строкой означает что выводится в числовом формате, а не в виде строки
      .limit(+req.query.limit); // Ограничение количества заказов

    res.status(200).json(orders); // Отправка списка заказов в формате JSON
  } catch (e) {
    errorHandler(res, e); // Обработка ошибки и отправка её клиенту
  }
};

// Контроллер для создания нового заказа
module.exports.create = async function (req, res) {
  try {
    const lastOrder = await Order.findOne({ user: req.user.id }) // Поиск последнего заказа пользователя
      .sort({ date: -1 }); // Сортировка по дате в убывающем порядке

    const maxOrder = lastOrder ? lastOrder.order : 0; // Получение номера последнего заказа

    const order = await new Order({
      list: req.body.list, // Список товаров в заказе
      user: req.user.id, // Идентификатор пользователя
      order: maxOrder + 1, // Новый номер заказа (максимальный + 1)
    }).save(); // Сохранение нового заказа в базе данных

    res.status(201).json(order); // Отправка информации о созданном заказе в формате JSON
  } catch (e) {
    errorHandler(res, e); // Обработка ошибки и отправка её клиенту
  }
};
