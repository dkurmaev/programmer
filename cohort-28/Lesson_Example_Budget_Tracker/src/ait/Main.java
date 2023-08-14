package ait;

import ait.service.InitService;
import ait.etity.EntityEnum;
import ait.etity.SubCategory;
import ait.repository.impl.SubCategoryRepository;
import ait.service.SubCategoryService;

import java.io.IOException;

public class Main {


    public static void main(String[] args) throws IOException {
        InitService initService = new InitService();
        initService.initDb();

        SubCategoryRepository subCategoryRepository = new SubCategoryRepository(EntityEnum.SUB_CATEGORY);
        SubCategoryService categoryService = new SubCategoryService(subCategoryRepository);

        for (int i = 0; i < 5; i++) {
            SubCategory subCategory = new SubCategory.Builder()
                    .id(subCategoryRepository.getNextId())
                    .name("Счет " + i)
                    .build();

            System.out.println(subCategory);
            SubCategory save = categoryService.save(subCategory);
            System.out.println(save);
        }
    }
}