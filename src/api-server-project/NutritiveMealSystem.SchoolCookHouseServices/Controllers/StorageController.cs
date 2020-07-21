using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using Microsoft.Extensions.Logging;
using NutritiveMealSystem.SchoolCookHouseServices.Models;
using NutritiveMealSystem.SchoolCookHouseServices.Models.ReturnModels;
using NutritiveMealSystem.SchoolCookHouseServices.Utility;

namespace NutritiveMealSystem.SchoolCookHouseServices.Controllers
{
    /// <summary>
    /// 对T_Storage（产品信息表）的操作
    /// </summary>
    [Route("api/[controller]/[action]")]
    [ApiController]
    public class StorageController : ControllerBase
    {
        /// <summary>
        /// 加载Log日志服务
        /// </summary>
        private readonly ILogger<StorageController> _logger;
        /// <summary>
        /// 初始化Log日志对象
        /// </summary>
        /// <param name="logger"></param>
        public StorageController(ILogger<StorageController> logger)
        {
            _logger = logger;
        }

        /// <summary>
        /// 返回T_Storage（产品信息表）的所有信息
        /// </summary>
        /// <returns></returns>
        [HttpGet]
        public Status GetAllStorage()
        {
            this._logger.LogWarning("The Server execute GetAllStorage Function  --" + DateTime.Now.ToString());
            using (SchoolCookHouseContext dbcontext = new SchoolCookHouseContext())
            {
                var result = dbcontext.TStorage.ToList();
                if (result.Count > 0)
                {
                    StorageStatus userInfoStatus = new StorageStatus
                    {
                        StatusCode = 200,
                        Message = "获取成功",
                        ReturnTime = DateTime.Now,
                        UserInfo = result
                    };
                    return userInfoStatus;
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
        /// 添加产品信息
        /// </summary>
        /// <param name="productinfo">产品信息</param>
        /// <param name="price">价格</param>
        /// <param name="storagetime">入库日期</param>
        /// <param name="remark">备注</param>
        /// <returns></returns>
        [HttpPost]
        public Status AddStorage(string productinfo, float price, DateTime storagetime, string remark)
        {
            this._logger.LogWarning("The server execute AddStorage Fuction  --" + DateTime.Now.ToString());
            using (SchoolCookHouseContext dbcontext = new SchoolCookHouseContext())
            {
                    TStorage storage = new TStorage()
                    {
                        ProductInfo = productinfo,
                        Price = price,
                        StorageTime = storagetime,
                        Remark = remark,
                    };
                    try
                    {
                        dbcontext.Add(storage);
                        dbcontext.SaveChanges();
                        Status status = new Status()
                        {
                            StatusCode = 200,
                            Message = "添加成功",
                            ReturnTime = DateTime.Now
                        };
                        return status;
                    }
                    catch (Exception ex)
                    {
                        this._logger.LogWarning("The server execute AddStorage Fuction  --" + ex.Message + DateTime.Now.ToString());
                        Status status = new Status()
                        {
                            StatusCode = 0,
                            Message = "添加失败",
                            ReturnTime = DateTime.Now
                        };
                        return status;
                    }
            }
        }

        /// <summary>
        /// 根据产品信息进行删除
        /// </summary>
        /// <param name="productinfo">产品信息</param>
        /// <returns></returns>
        [HttpPost]
        public Status DeleteStorage(string productinfo)
        {
            this._logger.LogWarning("The server execute DeleteStorage Fuction  --" + DateTime.Now.ToString());
            using (SchoolCookHouseContext dbcontext = new SchoolCookHouseContext())
            {
                TStorage userInfo = new TStorage()
                {
                    ProductInfo = productinfo
                };
                try
                {
                    var a = dbcontext.TStorage.Where(a => true).ToList().Find(a => a.ProductInfo == productinfo);
                    dbcontext.TStorage.Remove(a);
                    dbcontext.SaveChanges();
                    Status status = new Status()
                    {
                        StatusCode = 200,
                        Message = "删除成功",
                        ReturnTime = DateTime.Now
                    };
                    return status;
                }
                catch (Exception ex)
                {
                    this._logger.LogWarning("The server execute DeleteStorage Fuction  --" + ex.Message + DateTime.Now.ToString());
                    Status status = new Status()
                    {
                        StatusCode = 0,
                        Message = "删除失败",
                        ReturnTime = DateTime.Now
                    };
                    return status;
                }
            }
        }

        /// <summary>
        /// 通过产品信息进行查询
        /// </summary>
        /// <param name="productinfo">产品信息</param>
        /// <returns></returns>
        [HttpGet]
        public Status GetConditionStorage(string productinfo)
        {
            this._logger.LogWarning("The server execute GetConditionStorage Fuction  --" + DateTime.Now.ToString());
            using (SchoolCookHouseContext dbcontext = new SchoolCookHouseContext())
            {
                var result = dbcontext.TStorage.Where(a => a.ProductInfo == productinfo).ToList();
                if (result.Count > 0)
                {
                    StorageStatus userInfoStatus = new StorageStatus
                    {
                        StatusCode = 200,
                        Message = "查询成功",
                        ReturnTime = DateTime.Now,
                        UserInfo = result
                    };
                    return userInfoStatus;
                }
                else
                {
                    Status status = new Status
                    {
                        StatusCode = 0,
                        Message = "查询失败",
                        ReturnTime = DateTime.Now,
                    };
                    return status;
                }
            }
        }

        /// <summary>
        /// 修改产品信息表
        /// </summary>
        /// <param name="conditionuserproductinfo">产品信息-条件</param>
        /// <param name="productinfo">产品信息</param>
        /// <param name="price">价格</param>
        /// <param name="storagetime">入库日期</param>
        /// <param name="remark">备注</param>
        /// <returns></returns>
        [HttpPost]
        public Status UpdateStorage(string conditionuserproductinfo, string productinfo, float price, DateTime storagetime, string remark)
        {
            this._logger.LogWarning("The server execute UpdateStorage Fuction  --" + DateTime.Now.ToString());
            using (SchoolCookHouseContext dbcontext = new SchoolCookHouseContext())
            {
                TStorage storage = new TStorage()
                {
                    ProductInfo = productinfo,
                    Price = price,
                    StorageTime = storagetime,
                    Remark = remark,
                };

                var ReadPeoples = dbcontext.TStorage.Where(a => true).ToList().Find(a => a.ProductInfo == conditionuserproductinfo);

                ReadPeoples.ProductInfo = storage.ProductInfo;
                ReadPeoples.Price = storage.Price;
                ReadPeoples.StorageTime = storage.StorageTime;
                ReadPeoples.Remark = storage.Remark;

                try
                {
                    dbcontext.Entry(ReadPeoples).State = EntityState.Modified;
                    dbcontext.SaveChanges();
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
                    this._logger.LogWarning("The server execute UpdateStorage Fuction  --" + ex.Message + DateTime.Now.ToString());
                    Status status = new Status()
                    {
                        StatusCode = 0,
                        Message = "修改失败",
                        ReturnTime = DateTime.Now
                    };
                    return status;
                }
            }
        }

        /// <summary>
        /// 查询所有入库信息 并分页
        /// </summary>
        /// <param name="pagesize"></param>
        /// <param name="pageindex"></param>
        /// <returns></returns>
        [HttpGet]
        public Status StoragePages(int pagesize, int pageindex)
        {
            this._logger.LogWarning("The server execute StoragePages Fuction  --");
            EFHelper<TStorage> eFHelper = new EFHelper<TStorage>();
            var result = eFHelper.getListByPage(a =>true, a => a.Id, pagesize, pageindex);
            if (result != null)
            {
                PagesStatus<TStorage> status = new PagesStatus<TStorage>
                {
                    StatusCode = 200,
                    Message = "获取成功",
                    ReturnTime = DateTime.Now,
                    PageList = result
                };
                return status;
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
        /// 根据日期查入库信息  并分页
        /// </summary>
        /// <param name="pagesize"></param>
        /// <param name="pageindex"></param>
        /// <param name="starttime">查询的账单开始日期</param>
        /// <param name="endtime">查询的账单结束3日期</param>
        /// <returns></returns>
        [HttpGet]
        public Status StoragePagesSearch(int pagesize, int pageindex, DateTime starttime, DateTime endtime)
        {
            this._logger.LogWarning("The server execute StoragePages Fuction  --");
            EFHelper<TStorage> eFHelper = new EFHelper<TStorage>();
            var result = eFHelper.getListByPage(a => a.StorageTime >= starttime && a.StorageTime <= endtime, a => a.StorageTime, pagesize, pageindex);
            if (result != null)
            {
                PagesStatus<TStorage> status = new PagesStatus<TStorage>
                {
                    StatusCode = 200,
                    Message = "获取成功",
                    ReturnTime = DateTime.Now,
                    PageList = result
                };
                return status;
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
}
