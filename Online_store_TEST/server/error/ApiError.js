/**Класс  ApiError  является расширением класса  Error  и представляет собой кастомное исключение для обработки ошибок в API. 
Конструктор класса принимает два параметра:  message  (сообщение об ошибке) и  statusCode  (код состояния HTTP). 
Он вызывает конструктор родительского класса  Error  и устанавливает значения свойств  statusCode  и  message .
Класс также содержит несколько статических методов для генерации экземпляров  ApiError  с предопределенными значениями  statusCode :  */

class ApiError extends Error {
  constructor(message, statusCode) {
    super();
    this.statusCode = statusCode;
    this.message = message;
  }

  static badRequest(message) {
    return new ApiError(404, message); // badRequest  - генерирует объект  ApiError  с кодом состояния 404 (Not Found).
  }

  static internal(message) {
    return new ApiError(500, message); // internal  - генерирует объект  ApiError  с кодом состояния 500 (Internal Server Error).
  }

  static forbidden(message) {
    return new ApiError(403, message); // forbidden  - генерирует объект  ApiError  с кодом состояния 403 (Forbidden).
  }
}

module.exports = ApiError;
