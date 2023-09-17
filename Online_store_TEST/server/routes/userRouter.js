const Routers = require('express');
const router = new Routers();
const userRouter = require('../controllers/userController');

router.post('/registration', userController.registration);
router.post('/login', userController.login);
router.get('/auth',userController.check);




module.exports = router;
