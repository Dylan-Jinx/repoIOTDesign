package com.example.nutritional.util;

/**
 * @author 69182
 */
public class ConstantsUtils {

    /**
     * USER
     */

    public static String SERVER_URL_USER = "http://123.56.152.95:5729";

    /**
     * GET 通过学号学校名称查询学生
     */
    public static String Address_GetConditionChildrenInfo = "/api/ChildrenInfo/GetConditionChildrenInfo";

    /**
     * GET 通过学号学校名称查询学生
     */
    public static String Address_UseParentNameGetStudentinfo = "/api/ChildrenInfo/UseParentNameGetStudentinfo";

    /**
     * POST 添加家长用户
     */
    public static String Address_AddParentInfo = "/api/ParentInfo/AddParentInfo";

    /**
     * GET 返回T_ParentInfo（家长表）的所有信息
     */
    public static String Address_GetAllParentInfo = "/api/ParentInfo/GetAllParentInfo";

    /**
     * GET 通过用户名对T_ParentInfo（家长表）进行查询
     */
    public static String Address_GetConditionParentInfo = "/api/ParentInfo/GetConditionParentInfo";

    /**
     * POST 验证T_ParentInfo（家长表）用户名密码是否正确
     */
    public static String Address_VerificationParentInfo = "/api/ParentInfo/VerificationParentInfo";

    /**
     * GET 返回T_UserInfo（用户登录表）的所有信息
     */
    public static String Address_GetAllUserInfo = "/api/UserInfo/GetAllUserInfo";

    /**
     * POST 验证员工用户名密码是否正确
     */
    public static String Address_VerificationUserInfo = "/api/UserInfo/VerificationUserInfo";

    /**
     * SCHOOL
     */

    public static String SERVER_URL_SCHOOL = "http://123.56.152.95:5728";

    /**
     * GET 返回T_Bill（账单表）的所有信息
     */

    public static String Address_GetAllBill = "/api/Bill/GetAllBill";

    /**
     * GET 返回T_CookHouseInfo（厨房信息表）的所有信息
     */

    public static String Address_GetAllCookHouseInfo = "/api/CookHouseInfo/GetAllCookHouseInfo";

    /**
     * GET 通过厨房名称查询厨房信息
     */

    public static String Address_GetConditionCookHouseInfo = "/api/CookHouseInfo/GetConditionCookHouseInfo";

    /**
     * GET 返回T_Staff（员工表）的所有信息
     */

    public static String Address_GetAllStaff = "/api/Staff/GetAllStaff";

    /**
     * GET 返回T_Staff（员工表）的所有信息
     */

    public static String Address_GetConditionStaff = "/api/Staff/GetConditionStaff";

    /**
     * GET 返回T_Storage（产品信息表）的所有信息
     */

    public static String Address_GetAllStorage = "/api/Storage/GetAllStorage";

    /**
     * GET 通过产品信息进行查询
     */

    public static String Address_GetConditionStorage = "/api/Storage/GetConditionStorage";

    /**
     * POST 添加产品信息
     */

    public static String Address_AddStorage = "/api/Storage/AddStorage";

    /**
     * POST 修改产品信息表
     */

    public static String Address_UpdateStorage = "/api/Storage/UpdateStorage";

    /**
     * FOOD
     */

    public static String SERVER_URL_FOOD = "http://123.56.152.95:5727";

    /**
     * GET 返回营养素信息表中所有营养素的基本信息
     */

    public static String Address_GetAllNutritionInfo = "/api/NutrientInfo/GetAllNutritionInfo";

    /**
     * POST 用营养素的别名或者是名字查询营养素信息表中所有营养素的基本信息
     */

    public static String Address_UseNutritionNameBySearchInfo = "/api/NutrientInfo/UseNutritionNameBySearchInfo";

    /**
     * GET 获取所有食材的营养成分信息
     */

    public static String Address_GetAllFoodNutrition = "/api/FoodNutrition/GetAllFoodNutrition";

    /**
     * POST 根据食材名查询营养成分信息
     */

    public static String Address_UseFoodNameBySearchInfo = "/api/FoodNutrition/UseFoodNameBySearchInfo";
    /**
     * GET 获取所有食材表
     */

    public static String Address_GetAllCookBook = "/api/CookBook/GetAllCookBook";

    /**
     * POST 根据食谱名查询相关食谱信息
     */

    public static String Address_UseCookBookNameBySearchInfo = "/api/CookBook/UseCookBookNameBySearchInfo";

    /**
     * POST 添加食谱表
     */

    public static String Address_AddCookBook = "/api/CookBook/AddCookBook";

    /**
     * SAFETY
     */

    public static String SERVER_URL_SAFETY = "http://123.56.152.95:5730";

    /**
     * GET 获得所有种植信息表
     */

    public static String Address_GetAllPlantInfo = "/api/PlantInfo/GetAllPlantInfo";

    /**
     * POST 按ID查询
     */

    public static String Address_UserIdByPlantSearch = "/api/PlantInfo/UserIdBySearch";

    /**
     * GET 获得所有商品基础信息表单
     */

    public static String Address_GetAllProductionBaseInfo = "/api/ProductionBaseInfo/GetAllProductionBaseInfo";

    /**
     * POST 按ID查询
     */

    public static String Address_UserIdByInfoSearch = "/api/ProductionBaseInfo/UserIdBySearch";

    /**
     * POST 添加商品基础信息表单
     */

    public static String Address_AddProductionBaseInfo = "/api/ProductionBaseInfo/AddProductionBaseInfo";

    /**
     * POST 修改商品基础信息
     */

    public static String Address_UpdateProuductionBaseInfo = "/api/ProductionBaseInfo/UpdateProuductionBaseInfo";

    /**
     * GET 获得所有员工信息
     */

    public static String Address_GetAllBaseStaff = "/api/ProductionBaseStaff/GetAllStaff";

    /**
     * POST 按ID查询
     */

    public static String Address_UserIdByStaffSearch = "/api/ProductionBaseStaff/UserIdBySearch";

    /**
     * GET 查询所有信息
     */

    public static String Address_GetAllProductInfo = "/api/ProductNumInfo/GetAllProductInfo";

    /**
     * POST 按ID查询
     */

    public static String Address_UserIdByNumSearch = "/api/ProductNumInfo/UserIdBySearch";

    /**
     * POST 添加商品信息
     */

    public static String Address_AddProduct = "/api/ProductNumInfo/AddProduct";

    /**
     * GET 查询所有信息
     */

    public static String Address_GetAllCompanyInfo = "/api/TransCompanyInfo/GetAllCompanyInfo";

    /**
     * POST 按ID查询
     */

    public static String Address_UserIdByCompanySearch = "/api/TransCompanyInfo/UserIdBySearch";

    /**
     * GET 查询所有信息
     */

    public static String Address_GetAllEnvironmentInfo = "/api/TransportationEnvironmentInfo/GetAllEnvironmentInfo";

    /**
     * POST 用产品批次编号查询运输信息
     */

    public static String Address_UseProductNumSearchInfo = "/api/TransportationEnvironmentInfo/UseProductNumSearchInfo";

    /**
     * GET 查询所有信息
     */

    public static String Address_GetAllStaffs = "/api/TransportCompanyStaff/GetAllStaffs";

    /**
     * POST 按ID查询
     */

    public static String Address_UserIdByStaffsSearch = "/api/TransportCompanyStaff/UserIdBySearch";

    /**
     * GET 查询所有信息
     */

    public static String Address_GetWareHouseInfo = "/api/WarehouseInfo/GetWareHouseInfo";

    /**
     * POST 按ID查询
     */

    public static String Address_UserIdByHouseSearch = "/api/WarehouseInfo/UserIdBySearch";

    /**
     * GET 查询所有信息
     */

    public static String Address_GetAllWaterQualityInfo = "/api/WaterQuality/GetAllWaterQualityInfo";

    /**
     * POST 添加水质监测信息
     */

    public static String Address_AddWaterQuality = "/api/WaterQuality/AddWaterQuality";

}
