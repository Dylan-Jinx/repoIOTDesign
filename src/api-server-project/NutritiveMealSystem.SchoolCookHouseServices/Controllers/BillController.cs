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
    /// 对T_Bill（账单表）的操作
    /// </summary>
    [Route("api/[controller]/[action]")]
    [ApiController]
    public class BillController : ControllerBase
    {
        /// <summary>
        /// 加载Log日志服务
        /// </summary>
        private readonly ILogger<BillController> _logger;
        /// <summary>
        /// 初始化Log日志对象
        /// </summary>
        /// <param name="logger"></param>
        public BillController(ILogger<BillController> logger)
        {
            _logger = logger;
        }

        /// <summary>
        /// 返回T_Bill（账单表）的所有信息
        /// </summary>
        /// <returns></returns>
        [HttpGet]
        public Status GetAllBill()
        {
            this._logger.LogWarning("The Server execute GetAllBill Function  --" + DateTime.Now.ToString());
            using (SchoolCookHouseContext dbcontext = new SchoolCookHouseContext())
            {
                var result = dbcontext.TBill.ToList();
                if (result.Count > 0)
                {
                    BillStatus billStatus = new BillStatus
                    {
                        StatusCode = 200,
                        Message = "获取成功",
                        ReturnTime = DateTime.Now,
                        Bill = result
                    };
                    return billStatus;
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
        /// 添加账单
        /// </summary>
        /// <param name="price">价格</param>
        /// <param name="BillDatetime">记账日期</param>
        /// <param name="conductor">操作员</param>
        /// <param name="remark">备注</param>
        /// <returns></returns>
        [HttpPost]
        public Status AddBill(float price, DateTime BillDatetime,string conductor, string remark)
        {
            this._logger.LogWarning("The server execute AddBill Fuction  --" + DateTime.Now.ToString());
            using (SchoolCookHouseContext dbcontext = new SchoolCookHouseContext())
            {
                TBill bill = new TBill()
                {
                    Price= price,
                    BillDatetime=BillDatetime,
                    Conductor=conductor,
                    Remark = remark,
                };
                try
                {
                    dbcontext.Add(bill);
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
                    this._logger.LogWarning("The server execute AddBill Fuction  --" + ex.Message + DateTime.Now.ToString());
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
        /// 通过账单ID进行删除
        /// </summary>
        /// <param name="id">账单ID</param>
        /// <returns></returns>
        [HttpPost]
        public Status DeleteBill(int id)
        {
            this._logger.LogWarning("The server execute DeleteBill Fuction  --" + DateTime.Now.ToString());
            using (SchoolCookHouseContext dbcontext = new SchoolCookHouseContext())
            {
                TBill userInfo = new TBill()
                {
                    Id = id
                };
                try
                {
                    var a = dbcontext.TBill.Where(a => true).ToList().Find(a => a.Id == id);
                    dbcontext.TBill.Remove(a);
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
                    this._logger.LogWarning("The server execute DeleteBill Fuction  --" + ex.Message + DateTime.Now.ToString());
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
        /// 通过账单ID进行查询
        /// </summary>
        /// <param name="id">账单ID</param>
        /// <returns></returns>
        [HttpGet]
        public Status GetConditionBill(int id)
        {
            this._logger.LogWarning("The server execute GetConditionBill Fuction  --" + DateTime.Now.ToString());
            using (SchoolCookHouseContext dbcontext = new SchoolCookHouseContext())
            {
                var result = dbcontext.TBill.Where(a => a.Id == id).ToList();
                if (result.Count > 0)
                {
                    BillStatus userInfoStatus = new BillStatus
                    {
                        StatusCode = 200,
                        Message = "查询成功",
                        ReturnTime = DateTime.Now,
                        Bill = result
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
        /// 修改T_Bill（账单表）的数据
        /// </summary>
        /// <param name="id">账单ID</param>
        /// <param name="price">价格</param>
        /// <param name="BillDatetime">记账日期</param>
        /// <param name="conductor">操作员</param>
        /// <param name="remark">备注</param>
        /// <returns></returns>
        [HttpPost]
        public Status UpdateBill(int id,float price, DateTime BillDatetime, string conductor, string remark)
        {
            this._logger.LogWarning("The server execute UpdateBill Fuction  --" + DateTime.Now.ToString());
            using (SchoolCookHouseContext dbcontext = new SchoolCookHouseContext())
            {
                TBill bill = new TBill()
                {
                    Price = price,
                    BillDatetime = BillDatetime,
                    Conductor = conductor,
                    Remark = remark,
                };

                var ReadPeoples = dbcontext.TBill.Where(a => true).ToList().Find(a => a.Id == id);

                ReadPeoples.Price = bill.Price;
                ReadPeoples.BillDatetime = bill.BillDatetime;
                ReadPeoples.Conductor = bill.Conductor;
                ReadPeoples.Remark = bill.Remark;

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
                    this._logger.LogWarning("The server execute UpdateBill Fuction  --" + ex.Message + DateTime.Now.ToString());
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
        /// 查询账单信息  并分页
        /// </summary>
        /// <param name="pagesize"></param>
        /// <param name="pageindex"></param>
        /// <returns></returns>
        [HttpGet]
        public Status BillInfoPages(int pagesize, int pageindex)
        {
            this._logger.LogWarning("The server execute BillInfoPages Fuction  --");
            EFHelper<TBill> eFHelper = new EFHelper<TBill>();
            var result = eFHelper.getListByPage(a => true, a => a.Id, pagesize, pageindex);
            if (result != null)
            {
                PagesStatus<TBill> status = new PagesStatus<TBill>
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
        /// 根据日期查具体时间  并分页
        /// </summary>
        /// <param name="pagesize"></param>
        /// <param name="pageindex"></param>
        /// <param name="starttime">查询的账单开始日期</param>
        /// <param name="endtime">查询的账单结束日期</param>
        /// <returns></returns>
        [HttpGet]
        public Status BillInfoPagesSearch(int pagesize, int pageindex,DateTime starttime,DateTime endtime)
        {
            this._logger.LogWarning("The server execute BillInfoPages Fuction  --");
            EFHelper<TBill> eFHelper = new EFHelper<TBill>();
            var result = eFHelper.getListByPage(a => a.BillDatetime>=starttime&&a.BillDatetime<=endtime, a => a.BillDatetime, pagesize, pageindex);
            if (result != null)
            {
                PagesStatus<TBill> status = new PagesStatus<TBill>
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
