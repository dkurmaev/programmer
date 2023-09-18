const ApiError = require('../error/ApiError');

class UserController {
  async registration(req, res) {
    const users = await User.findAll();
    return res.json(users);
  }
  async login(req, res) {
    const users = await User.findAll();
    return res.json(users);
  }
  
    async check(req, res, next) {        
        const {id} = req.query;
        if (!id) {
          return next(ApiError.badRequest('ID не указан'));            
        }
        res.json(id);
    }
}

module.exports = new UserController();
