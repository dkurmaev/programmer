class UserController {
  async registration(req, res) {
    const users = await User.findAll();
    return res.json(users);
  }
  async login(req, res) {
    const users = await User.findAll();
    return res.json(users);
  }
    async check(req, res) {
        const users = await User.findAll();
        return res.json(users);
    }
}

module.exports = new UserController();
