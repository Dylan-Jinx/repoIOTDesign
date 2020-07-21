using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace AdminManageSystem.Utils
{
    public class FoodAnalysisApiUrl
    {
        #region ——食谱表的操作——
        /// <summary>
        /// 获取所有食材表
        /// </summary>
        public static string getallcookbook = "/api/CookBook/GetAllCookBook";
        /// <summary>
        /// 用食谱名称查询食谱信息(需要输入参数cookbookname)
        /// </summary>
        public static string searchcookbook = "/api/CookBook/UseCookBookNameBySearchInfo";
        /// <summary>
        /// 添加食谱，需要输入几个参数(cookBookname食谱名,flavour配料,material材料,nutritionalingredient营养成分)+还有图片上传 form-data形式
        /// </summary>
        public static string addcookbook = "/api/CookBook/AddCookBook";
        /// <summary>
        /// 修改食谱表的数据
        /// json格式发送数据，如下所示
        /// {
        ///  "id": 0,
        ///  "name": "string",
        ///  "material": "string",
        ///  "flavour": "string",
        ///  "image": "string",
        /// "nutritionalIngredient": "string"
        ///}
        /// </summary>
        public static string updatecookbook = "/api/CookBook/UpdateCookBook";
        /// <summary>
        /// 根据id删除食谱
        /// </summary>
        public static string useiddeletecookbook = "/api/CookBook/DeleteCookBook";
        /// <summary>
        /// 根据提交的表单删除对象  json格式提交 如下
        ///{
        ///  "id": 0,
        ///  "name": "string",
        ///  "material": "string",
        ///  "flavour": "string",
        ///  "image": "string",
        /// "nutritionalIngredient": "string"
        ///}
        /// </summary>
        public static string deletecookbook = "/api/CookBook/DeletexCookBook";
        /// <summary>
        /// 将获得的信息分页
        /// 有两个参数  pagesize pageindex
        /// </summary>
        public static string cookbookpages = "/api/CookBook/CookBookInfoPages";
        /// <summary>
        /// 传含菜谱名的几个关键字 分页大小  和页码  对应pagesize pageindex
        /// </summary>
        public static string cookbooklikesearchpages = "/api/CookBook/CookBookInfoLikePages";
        /// <summary>
        /// 精准查询并分页 分页大小 和页码 对应pagesize pageindex
        /// </summary>
        public static string cookbooksearchpages = "​/api​/CookBook​/CookBookInfoQueryPages";
        #endregion

        #region   ——营养素Url——
        /// <summary>
        /// /api/NutrientInfo/GetAllNutritionInfo 获取所有营养素表
        /// </summary>
        public static string getallnutritions = "/api/NutrientInfo/GetAllNutritionInfo";
        /// <summary>
        /// /api/NutrientInfo/NutritionInfoPages 营养素表分页
        /// </summary>
        public static string nutritionspage = "/api/NutrientInfo/NutritionInfoPages";
        /// <summary>
        /// /api/NutrientInfo/UpdateNutritionInfo 修改营养素信息
        /// </summary>
        public static string updatenutritioninfo = "/api/NutrientInfo/UpdateNutritionInfo";
        /// <summary>
        /// /api/NutrientInfo/NutritionInfoLikePages 用名称或别名查找营养素信息  分页
        /// </summary>
        public static string searchnutritioninfo = "/api/NutrientInfo/NutritionInfoLikePages";
        /// <summary>
        /// /api/NutrientInfo/UseNutritionNameBySearchInfo 更新营养素信息
        /// </summary>
        public static string usenamesearchnutritioninfo = "/api/NutrientInfo/UseNutritionNameBySearchInfo";
        /// <summary>
        /// /api/NutrientInfo/DeleteNutritionInfo 删除营养素信息
        /// </summary>
        public static string deletenutritioninfo = "/api/NutrientInfo/DeleteNutritionInfo";
        /// <summary>
        /// /api/NutrientInfo/AddNutritionInfo 添加营养素信息
        /// </summary>
        public static string addnutritioninfo = "/api/NutrientInfo/AddNutritionInfo";
        #endregion

        #region——膳食数据库表的操作——
        /// <summary>
        /// ​/api​/FoodNutrition​/GetAllFoodNutrition 获取所有食材的营养成分信息
        /// </summary>
        public static string getallfoodnutrition = "/api/FoodNutrition/GetAllFoodNutrition";
        /// <summary>
        /// /api/FoodNutrition/UseFoodNameBySearchInfo 用食物名称查询营养成分信息
        /// </summary>
        public static string usefoodnamebysearchinfo = "/api/FoodNutrition/UseFoodNameBySearchInfo";
        /// <summary>
        /// /api/FoodNutrition/UpdateFoodNutrionInfo 修改食材营养成分信息
        /// </summary>
        public static string updatefoodnutrition = "/api/FoodNutrition/UpdateFoodNutrionInfo";
        /// <summary>
        /// /api/FoodNutrition/FoodNutrionInfoPages 正常分页(属于网页功能)
        /// </summary>
        public static string getallfoodnutritioninfopages = "/api/FoodNutrition/FoodNutrionInfoPages";
        /// <summary>
        /// /api/FoodNutrition/FoodNutrionInfoLikePage 用食物名查询信息并分页
        /// </summary>
        public static string searchfoodnutrtionpages = "/api/FoodNutrition/FoodNutrionInfoLikePage";
        #endregion
    }
}
