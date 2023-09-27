const uuid = require("uuid");
const path = require("path");
const ApiError = require("../error/ApiError");
const { Device, DeviceInfo } = require("../models/models");

class DeviceController {
  async create(req, res, next) {
    try {
      let { name, price, brandId, typeId, info } = req.body;
      const { img } = req.files;
      let fileName = uuid.v4() + ".jpg"; //uuid - уникальный идентификатор" + ".jpg" - расширение файла
      img.mv(path.resolve(__dirname, "..", "static", fileName));
      const device = await Device.create({
        name,
        price,
        brandId,
        typeId,
        img: fileName,
      });

      if (info) {
        info = JSON.parse(info);
        info.forEach((i) =>
          DeviceInfo.create({
            titel: i.titel,
            description: i.description,
            deviceId: device.id,
          })
        );
      }

      return res.json(device);
    } catch (e) {
      next(ApiError.badRequest(e.message));
    }
  }
  async getAll(req, res) {
    let { brandId, typeId, limit, page } = req.query; //получаем параметры из запроса
    page = page || 1; //если не передана страница, то по умолчанию 1
    limit = limit || 9; //если не передан лимит, то по умолчание 9
    let offset = page * limit - limit; //с какой записи начинать
    let devices;
    if (!brandId && !typeId) {
      devices = await Device.findAndCountAll({ limit, offset }); //передаем объект, где указываем, что искать
    }
    if (brandId && !typeId) {
      devices = await Device.findAndCountAll({
        where: { brandId },
        limit,
        offset,
      }); //передаем объект, где указываем, что искать
    }
    if (!brandId && typeId) {
      devices = await Device.findAndCountAll({
        where: { typeId },
        limit,
        offset,
      }); //передаем объект, где указываем, что искать
    }
    if (brandId && typeId) {
      devices = await Device.findAndCountAll({
        where: { brandId, typeId },
        limit,
        offset,
      }); //передаем объект, где указываем, что искать
    }
    return res.json(devices);
  }

  async getOne(req, res) {
    const { id } = req.params;
    const device = await Device.findOne(
      {
      where: { id },
      include: [{ model: DeviceInfo, as: "info" }],
    });
    return res.json(device);
  
  }
}

module.exports = new DeviceController();
