using System;
using System.Collections;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Metadata.Internal;
using Microsoft.Extensions.Logging;
using NutritiveMealSystem.FoodAnalysisServices.Models.FileModels;
using NutritiveMealSystem.FoodAnalysisServices.Models.ReturnModels;
using NutritiveMealSystem.TraceabilityServices.Models;

namespace NutritiveMealSystem.FoodAnalysisServices.Controllers
{
    /// <summary>
    /// 对食谱表的操作
    /// </summary>
    [Route("api/[controller]/[action]")]
    [ApiController]
    public class CookBookController : ControllerBase
    {
        /// <summary>
        /// 加载Log日志服务
        /// </summary>
        private readonly ILogger<CookBookController> _logger;
        /// <summary>
        /// 初始化Log日志对象
        /// </summary>
        /// <param name="logger"></param>
        public CookBookController(ILogger<CookBookController> logger)
        {
            _logger = logger;
        }
        /// <summary>
        /// 获取所有食材表
        /// </summary>
        /// <returns></returns>
        [HttpGet]
        public CookBookStatus GetAllCookBook()
        {
            this._logger.LogWarning("The server execute GetAllCookBook Function  --" + DateTime.Now.ToString());
            using (DietaryNutritionContext dbcontext = new DietaryNutritionContext())
            {
                var result = dbcontext.TCookBook.ToList();
                if (result.Count > 0)
                {
                    CookBookStatus cookBookStatus = new CookBookStatus()
                    {
                        StatusCode = 200,
                        Message = "获取成功",
                        ReturnTime = DateTime.Now,
                        CookBooks = result
                    };
                    return cookBookStatus;
                }
                else
                {
                    CookBookStatus status = new CookBookStatus
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
        /// 根据食谱名查询相关食谱信息
        /// </summary>
        /// <returns></returns>
        [HttpPost]
        public CookBookStatus UseCookBookNameBySearchInfo(string cookbookname)
        {
            this._logger.LogWarning("The server execute UseCookBookNameBySearchInfo Fuction  --" + DateTime.Now.ToString());
            using (DietaryNutritionContext dbcontext = new DietaryNutritionContext())
            {
                var result = dbcontext.TCookBook.Where(a => a.Name == cookbookname).ToList();
                if (result.Count > 0)
                {
                    CookBookStatus nutritionInfoStatus = new CookBookStatus
                    {
                        StatusCode = 200,
                        Message = "获取成功",
                        ReturnTime = DateTime.Now,
                        CookBooks = result
                    };
                    return nutritionInfoStatus;
                }
                else
                {
                    CookBookStatus status = new CookBookStatus
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
        /// 添加食谱表
        /// </summary>
        /// <param name="cookBookname">食谱名</param>
        /// <param name="flavour">配料</param>
        /// <param name="material">材料</param>
        /// <param name="nutritionalingredient">营养成分</param>
        /// <param name="files">食谱图片</param>
        /// <returns></returns>
        [HttpPost]
        public Status AddCookBook(string cookBookname,string flavour,string material,string nutritionalingredient, List<IFormFile> files)
        {
            TCookBook cookBook = new TCookBook()
            {
                Name=cookBookname,
                Flavour= flavour,
                Material= material,
                NutritionalIngredient=nutritionalingredient
            };
            List<string> filenames = new List<string>();
            string resultfilename = string.Empty;
            bool flag = false;
            this._logger.LogWarning("The server execute AddCookBook Fuction  --" + DateTime.Now.ToString());
            using (DietaryNutritionContext dbcontext = new DietaryNutritionContext())
            {
                try
                {
                    if (cookBook.Name != "")
                    {
                       flag = FileSave(files, cookBook.Name, out filenames);
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
                    cookBook.Image = resultfilename;
                    dbcontext.Add(cookBook);
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
                catch(Exception)
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
        /// 修改食谱表内容
        /// </summary>
        /// <param name="cookBook"></param>
        /// <returns></returns>
        [HttpPost]
        public Status UpdateCookBook(TCookBook cookBook)
        {
            EFHelper<TCookBook> eFHelper = new EFHelper<TCookBook>();
            int result = eFHelper.Update(cookBook);
            if (result > 0)
            {
                Status nutritionInfoStatus = new Status
                {
                    StatusCode = 200,
                    Message = "修改成功",
                    ReturnTime = DateTime.Now
                };
                return nutritionInfoStatus;
            }
            else
            {
                CookBookStatus status = new CookBookStatus
                {
                    StatusCode = 0,
                    Message = "修改失败",
                    ReturnTime = DateTime.Now,
                };
                return status;
            }
        }
        /// <summary>
        /// 根据id删除食谱
        /// </summary>
        /// <param name="id"></param>
        /// <returns></returns>
        [HttpPost]
        public Status DeleteCookBook(int id)
        {
            this._logger.LogWarning("The server execute DeleteCookBook Fuction  --" + DateTime.Now.ToString());
            using (DietaryNutritionContext dbcontext = new DietaryNutritionContext())
            {

                var query = dbcontext.TCookBook.Where(a => a.Id == id).FirstOrDefault();
                if (query != null)
                {
                    dbcontext.TCookBook.Remove(query);
                    int result = dbcontext.SaveChanges();
                    if (result > 0)
                    {
                        Status status = new Status
                        {
                            StatusCode = 200,
                            Message = "删除成功",
                            ReturnTime = DateTime.Now,
                        };
                        return status;
                    }
                    else
                    {
                        Status status = new Status
                        {
                            StatusCode = 0,
                            Message = "删除失败",
                            ReturnTime = DateTime.Now,
                        };
                        return status;
                    }
                }
                else
                {
                    Status status = new Status
                    {
                        StatusCode = 0,
                        Message = "没有查询到该食谱",
                        ReturnTime = DateTime.Now,
                    };
                    return status;
                }
            }
        }
        /// <summary>
        /// 根据提交的表单删除对象
        /// </summary>
        /// <param name="cookBook"></param>
        /// <returns></returns>
        [HttpPost]
        public Status DeletexCookBook(TCookBook cookBook)
        {
            this._logger.LogWarning("The server execute DeleteCookBook Fuction  --" + DateTime.Now.ToString());
            try
            {
                EFHelper<TCookBook> eFHelper = new EFHelper<TCookBook>();
                int result = eFHelper.Delete(cookBook);
                if (result > 0)
                {
                    Status status = new Status
                    {
                        StatusCode = 200,
                        Message = "删除成功",
                        ReturnTime = DateTime.Now,
                    };
                    return status;
                }
                else
                {
                    Status status = new Status
                    {
                        StatusCode = 0,
                        Message = "删除失败",
                        ReturnTime = DateTime.Now,
                    };
                    return status;
                }
            }
            catch (Exception ex)
            {
                this._logger.LogWarning("the DeleteCookBook Function Exception message:" + ex.Message);
                Status status = new Status
                {
                    StatusCode = 0,
                    Message = "删除失败",
                    ReturnTime = DateTime.Now,
                };
                return status;
            }
        }
        /// <summary>
        /// 分页  网页功能
        /// </summary>
        /// <param name="pagesize">分页大小</param>
        /// <param name="pageindex">当前页码</param>
        /// <returns></returns>
        [HttpPost]
        public Status CookBookInfoPages(int pagesize,int pageindex)
        {
            this._logger.LogWarning("The server execute CookBookInfoPages function  --" + DateTime.Now.ToString());
            EFHelper<TCookBook> eFHelper = new EFHelper<TCookBook>();
            var result = eFHelper.getListByPage(a => true, a => a.Id, pagesize, pageindex);
            if (result != null)
            {
                PagesStatus<TCookBook> pagesStatus = new PagesStatus<TCookBook>()
                {
                    StatusCode = 200,
                    Message = "获取成功",
                    ReturnTime = DateTime.Now,
                    PageList = result
                };
                return pagesStatus;
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
        /// 模糊查询分页
        /// </summary>
        /// <param name="pagesize">分页大小</param>
        /// <param name="pageindex">当前页码</param>
        /// <param name="likeword">查询词</param>
        /// <returns></returns>
        [HttpPost]
        public Status CookBookInfoLikePages(int pagesize,int pageindex,string likeword)
        {
            this._logger.LogWarning("The server execute CookBookInfoLikePages function  --" + DateTime.Now.ToString());
            EFHelper<TCookBook> eFHelper = new EFHelper<TCookBook>();
            var result = eFHelper.getListByPage(a => a.Name.Contains(likeword), a => a.Id, pagesize, pageindex);
            if (result != null)
            {
                PagesStatus<TCookBook> pagesStatus = new PagesStatus<TCookBook>()
                {
                    StatusCode = 200,
                    Message = "获取成功",
                    ReturnTime = DateTime.Now,
                    PageList = result
                };
                return pagesStatus;
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
        /// 精准查询并分页
        /// </summary>
        /// <param name="pagesize">分页大小</param>
        /// <param name="pageindex">当前页码</param>
        /// <param name="keyword">查询词</param>
        /// <returns></returns>
        [HttpPost]
        public Status CookBookInfoQueryPages(int pagesize,int pageindex,string keyword)
        {
            EFHelper<TCookBook> eFHelper = new EFHelper<TCookBook>();
            var result = eFHelper.getListByPage(a => a.Name == keyword, a => a.Id, pagesize, pageindex);
            if (result != null)
            {
                PagesStatus<TCookBook> pagesStatus = new PagesStatus<TCookBook>()
                {
                    StatusCode = 200,
                    Message = "获取成功",
                    ReturnTime = DateTime.Now,
                    PageList = result
                };
                return pagesStatus;
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
        public static bool FileSave(List<IFormFile> files,string cookname,out List<string> filename)
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
                        string saveName = cookname+fileExtension;

                        //插入图片数据
                        using (FileStream fs = System.IO.File.Create(webRootPath + filePath + saveName))
                        {
                            item.CopyTo(fs);
                            fs.Flush();
                        }
                        filenames.Add("File"+filePath + saveName);
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
