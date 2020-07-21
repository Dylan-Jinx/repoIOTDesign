using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using Microsoft.Extensions.Logging;
using NutritiveMealSystem.FoodAnalysisServices.Models;
using NutritiveMealSystem.FoodAnalysisServices.Models.ReturnModels;
using NutritiveMealSystem.TraceabilityServices.Models;

namespace NutritiveMealSystem.FoodAnalysisServices.Controllers
{
    /// <summary>
    /// 对食品营养成分的操作
    /// </summary>
    [Route("api/[controller]/[action]")]
    [ApiController]
    public class FoodNutritionController : ControllerBase
    {
        /// <summary>
        /// 加载Log日志服务
        /// </summary>
        private readonly ILogger<FoodNutritionController> _logger;
        /// <summary>
        /// 初始化Log日志对象
        /// </summary>
        /// <param name="logger"></param>
        public FoodNutritionController(ILogger<FoodNutritionController> logger)
        {
            _logger = logger;
        }
        /// <summary>
        /// 获取所有食材的营养成分信息
        /// </summary>
        /// <returns></returns>
        [HttpGet]
        public Status GetAllFoodNutrition()
        {
            this._logger.LogWarning("The server execute GetAllFoodNutrition Fuction  --" + DateTime.Now.ToString());
            using(DietaryNutritionContext dbcontext=new DietaryNutritionContext())
            {
                var result = dbcontext.TFoodNutrition.ToList();
                if (result.Count > 0)
                {
                    FoodNutritionStatus nutritionInfoStatus = new FoodNutritionStatus
                    {
                        StatusCode = 200,
                        Message = "获取成功",
                        ReturnTime = DateTime.Now,
                        FoodNutritions = result
                    };
                    return nutritionInfoStatus;
                }
                else
                {
                    Status status = new Status
                    {
                        StatusCode = 0,
                        Message = "获取失败",
                        ReturnTime = DateTime.Now,
                    };
                    return status;
                }
            }
        }
        /// <summary>
        /// 根据食材名查询营养成分信息
        /// </summary>
        /// <param name="foodname"></param>
        /// <returns></returns>
        [HttpPost]
        public Status UseFoodNameBySearchInfo(string foodname)
        {
            this._logger.LogWarning("The Server execute UseFoodNameBySearchInfo  --" + DateTime.Now.ToString());
            using (DietaryNutritionContext dbcontext = new DietaryNutritionContext())
            {
                var result = dbcontext.TFoodNutrition.Where(a => a.FoodName == foodname).ToList();
                if (result.Count > 0)
                {
                    FoodNutritionStatus nutritionInfoStatus = new FoodNutritionStatus
                    {
                        StatusCode = 200,
                        Message = "获取成功",
                        ReturnTime = DateTime.Now,
                        FoodNutritions = result
                    };
                    return nutritionInfoStatus;
                }
                else
                {
                    Status status = new Status
                    {
                        StatusCode = 0,
                        Message = "获取失败",
                        ReturnTime = DateTime.Now,
                    };
                    return status;
                }
            }
        }

        /// <summary>
        /// 添加食材营养成分信息
        /// </summary>
        /// <param name="datas">数据模型</param>
        /// <returns></returns>
        //[HttpPost]
        //public CookBookStatus AddFoodNutrionInfo(TFoodNutrition datas)
        //{
        //    this._logger.LogWarning("The server execute AddFoodNutrionInfo Fuction  --" + DateTime.Now.ToString());
        //    EFHelper<TFoodNutrition> eFHelper = new EFHelper<TFoodNutrition>();
        //    try
        //    {
        //        eFHelper.Add(datas);
        //        CookBookStatus status = new CookBookStatus()
        //        {
        //            StatusCode = 200,
        //            Message = "添加成功",
        //            ReturnTime = DateTime.Now
        //        };
        //        return status;
        //    }
        //    catch (Exception ex)
        //    {
        //        this._logger.LogWarning("The server execute AddFoodNutrionInfo Fuction  --" + ex.Message + DateTime.Now.ToString());
        //        CookBookStatus status = new CookBookStatus()
        //        {
        //            StatusCode = 0,
        //            Message = "添加失败",
        //            ReturnTime = DateTime.Now
        //        };
        //        return status;
        //    }
        //}

        /// <summary>
        /// 添加食材营养成分信息
        /// </summary>
        /// <param name="foodname">食材名</param>
        /// <param name="nutritionalingredient">营养成分</param>
        /// <param name="introduce">食材介绍</param>
        /// <param name="files">食材图片</param>
        /// <returns></returns>
        [HttpPost]
        public Status AddFoodNutrionInfo(string foodname, string nutritionalingredient, string introduce, List<IFormFile> files)
        {

            TFoodNutrition foodNutrition = new TFoodNutrition()
            {
                FoodName = foodname,
                Introduce = introduce,
                NutritionalIngredient = nutritionalingredient
            };
            List<string> filenames = new List<string>();
            string resultfilename = string.Empty;
            bool flag = false;
            this._logger.LogWarning("The server execute AddFoodNutrionInfo Fuction  --" + DateTime.Now.ToString());
            using (DietaryNutritionContext dbcontext = new DietaryNutritionContext())
            {
                try
                {
                    if (foodNutrition.FoodName != "")
                    {
                        flag = FileSave(files, foodNutrition.FoodName, out filenames);
                    }
                    else
                    {
                        flag = FileSave(files, DateTime.Now.ToString(), out filenames);
                    }
                    if (!flag)
                    {
                        Status status = new Status
                        {
                            StatusCode = 0,
                            Message = "上传图片失败",
                            ReturnTime = DateTime.Now,
                        };
                        return status;
                    }
                    filenames.Sort();
                    resultfilename = string.Join("", filenames.ToArray());
                    foodNutrition.Images = resultfilename;
                    dbcontext.Add(foodNutrition);
                    int result = dbcontext.SaveChanges();
                    if (result > 0)
                    {
                        Status status = new Status
                        {
                            StatusCode = 200,
                            Message = "添加成功",
                            ReturnTime = DateTime.Now,
                        };
                        return status;
                    }
                    else
                    {
                        Status status = new Status
                        {
                            StatusCode = 0,
                            Message = "添加失败",
                            ReturnTime = DateTime.Now,
                        };
                        return status;
                    }
                }
                catch (Exception)
                {
                    Status status = new Status
                    {
                        StatusCode = 0,
                        Message = "添加失败",
                        ReturnTime = DateTime.Now,
                    };
                    return status;
                }
            }
        }

        /// <summary>
        /// 修改食材营养成分信息
        /// </summary>
        /// <param name="datas">数据模型</param>
        /// <returns></returns>
        [HttpPost]
        public Status UpdateFoodNutrionInfo(TFoodNutrition datas)
        {
            this._logger.LogWarning("The server execute UpdateFoodNutrionInfo Fuction  --" + DateTime.Now.ToString());
            EFHelper<TFoodNutrition> eFHelper = new EFHelper<TFoodNutrition>();
            try
            {
                eFHelper.Update(datas);
                Status status = new Status()
                {
                    StatusCode = 200,
                    Message = "修改成功",
                    ReturnTime = DateTime.Now
                };
                return status;
            }
            catch (Exception ex)
            {
                this._logger.LogWarning("The server execute AddNutrition Fuction  --" + ex.Message + DateTime.Now.ToString());
                Status status = new Status()
                {
                    StatusCode = 0,
                    Message = "修改失败",
                    ReturnTime = DateTime.Now
                };
                return status;
            }
        }
        /// <summary>
        /// 删除食材营养成分信息
        /// </summary>
        /// <param name="id">食材的id</param>
        /// <returns></returns>
        [HttpPost]
        public Status DeleteFoodNutrionInfo(int id)
        {
            this._logger.LogWarning("The server execute DeleteFoodNutrionInfo Fuction  --" + DateTime.Now.ToString());
            EFHelper<TFoodNutrition> eFHelper = new EFHelper<TFoodNutrition>();
            try
            {
                TFoodNutrition result = eFHelper.getList(a => a.Id == id).FirstOrDefault();
                if (result == null)
                {
                    this._logger.LogWarning("This object is null ");
                    throw new Exception();
                }
                else
                {
                    eFHelper.Delete(result);
                    Status status = new Status()
                    {
                        StatusCode = 200,
                        Message = "删除成功",
                        ReturnTime = DateTime.Now
                    };
                    return status;
                }
            }
            catch (Exception ex)
            {
                this._logger.LogWarning("The server execute DeleteNutritionInfo Fuction  --" + ex.Message + DateTime.Now.ToString());
                Status status = new Status()
                {
                    StatusCode = 0,
                    Message = "删除失败",
                    ReturnTime = DateTime.Now
                };
                return status;
            }
        }
        /// <summary>
        /// 正常分页(属于网页功能)
        /// </summary>
        /// <param name="pagesize"></param>
        /// <param name="pageindex"></param>
        /// <returns></returns>
        [HttpPost]
        public Status FoodNutrionInfoPages(int pagesize,int pageindex)
        {
            this._logger.LogWarning("The server execute FoodNutrionInfoPages Fuction  --" + DateTime.Now.ToString());
            EFHelper<TFoodNutrition> eFHelper = new EFHelper<TFoodNutrition>();
            var result = eFHelper.getListByPage(a => true, a => a.Id, pagesize, pageindex);
            if (result != null)
            {
                PagesStatus<TFoodNutrition> nutritionInfoStatus = new PagesStatus<TFoodNutrition>
                {
                    StatusCode = 200,
                    Message = "获取成功",
                    ReturnTime = DateTime.Now,
                    PageList = result
                };
                return nutritionInfoStatus;
            }
            else
            {
                Status status = new Status
                {
                    StatusCode = 0,
                    Message = "获取失败",
                    ReturnTime = DateTime.Now,
                };
                return status;
            }
        }
        /// <summary>
        /// 模糊分页（属于网页功能）
        /// </summary>
        /// <param name="keyword"></param>
        /// <param name="pagesize"></param>
        /// <param name="pageindex"></param>
        /// <returns></returns>
        [HttpPost]
        public Status FoodNutrionInfoLikePage(string keyword,int pagesize,int pageindex)
        {
            this._logger.LogWarning("The server execute FoodNutrionInfoLikePage Fuction  --" + DateTime.Now.ToString());
            EFHelper<TFoodNutrition> eFHelper = new EFHelper<TFoodNutrition>();
            var result = eFHelper.getListByPage(a => a.FoodName.Contains(keyword), a => a.Id, pagesize, pageindex);
            if (result != null)
            {
                PagesStatus<TFoodNutrition> nutritionInfoStatus = new PagesStatus<TFoodNutrition>
                {
                    StatusCode = 200,
                    Message = "获取成功",
                    ReturnTime = DateTime.Now,
                    PageList = result
                };
                return nutritionInfoStatus;
            }
            else
            {
                Status status = new Status
                {
                    StatusCode = 0,
                    Message = "获取失败",
                    ReturnTime = DateTime.Now,
                };
                return status;
            }
        }

        /// <summary>
        /// 上传文件
        /// </summary>
        /// <param name="files">文件流</param>
        /// <param name="cookname">文件名</param>
        /// <param name="filename">输出存储的文件路径</param>
        /// <returns></returns>
        [HttpPost]
        public static bool FileSave(List<IFormFile> files, string cookname, out List<string> filename)
        {
            filename = null;
            if (files.Count < 1)
            {
                //return Ok("空文件");
                return false;
            }
            //返回的文件地址
            List<string> filenames = new List<string>();
            DateTime now = DateTime.Now;
            //文件存储路径
            string filePath = string.Format("/Uploads/");
            //获取当前web目录
            var webRootPath = "File/"; ;
            if (!Directory.Exists(webRootPath + filePath))
            {
                Directory.CreateDirectory(webRootPath + filePath);
            }
            try
            {
                foreach (var item in files)
                {
                    if (item != null)
                    {
                        #region  图片文件的条件判断
                        //文件后缀
                        string fileExtension = Path.GetExtension(item.FileName);

                        //判断后缀是否是图片
                        const string fileFilt = ".gif|.jpg|.jpeg|.png";
                        if (fileExtension == null)
                        {
                            break;
                            //return Error("上传的文件没有后缀");
                        }
                        if (fileFilt.IndexOf(fileExtension.ToLower(), StringComparison.Ordinal) <= -1)
                        {
                            break;
                            //return Error("请上传jpg、png、gif格式的图片");
                        }

                        //判断文件大小
                        long length = item.Length;
                        if (length > 1024 * 1024 * 2) //2M
                        {
                            break;
                            //return Error("上传的文件不能大于2M");
                        }

                        #endregion

                        string strDateTime = DateTime.Now.ToString("yyMMddhhmmssfff"); //取得时间字符串
                        string strRan = Convert.ToString(new Random().Next(100, 999)); //生成三位随机数
                        string saveName = cookname + fileExtension;

                        //插入图片数据
                        using (FileStream fs = System.IO.File.Create(webRootPath + filePath + saveName))
                        {
                            item.CopyTo(fs);
                            fs.Flush();
                        }
                        filenames.Add("File" + filePath + saveName);
                    }
                }
                //return Ok(filenames);
                filename = filenames;
                return true;
            }
            catch (Exception)
            {
                //这边增加日志，记录错误的原因
                //ex.ToString();
                //this._logger.LogWarning("UpLoad File failed" + ex.Message + DateTime.Now.ToString());
                //return Ok("上传失败");
                return false;
            }
        }
    }
}
