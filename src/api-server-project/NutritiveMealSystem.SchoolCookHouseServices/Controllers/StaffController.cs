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
    /// 对T_Staff（员工表）的操作
    /// </summary>
    [Route("api/[controller]/[action]")]
    [ApiController]
    public class StaffController : ControllerBase
    {
        /// <summary>
        /// 加载Log日志服务
        /// </summary>
        private readonly ILogger<StaffController> _logger;
        /// <summary>
        /// 初始化Log日志对象
        /// </summary>
        /// <param name="logger"></param>
        public StaffController(ILogger<StaffController> logger)
        {
            _logger = logger;
        }

        /// <summary>
        /// 返回T_Staff（员工表）的所有信息
        /// </summary>
        /// <returns></returns>
        [HttpGet]
        public Status GetAllStaff()
        {
            this._logger.LogWarning("The Server execute GetAllStaff Function  --" + DateTime.Now.ToString());
            using (SchoolCookHouseContext dbcontext = new SchoolCookHouseContext())
            {
                var result = dbcontext.TStaff.ToList();
                if (result.Count > 0)
                {
                    StaffStatus staffStatus = new StaffStatus
                    {
                        StatusCode = 200,
                        Message = "获取成功",
                        ReturnTime = DateTime.Now,
                        Staff = result
                    };
                    return staffStatus;
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
        /// 添加员工信息
        /// </summary>
        /// <param name="staffname">员工姓名</param>
        /// <param name="telephone">电话</param>
        /// <param name="position">职位</param>
        /// <returns></returns>
        [HttpPost]
        public Status AddStaff(string staffname, string telephone, string position,List<IFormFile> files)
        {
            List<string> filenames = new List<string>();
            string resultfilename = string.Empty;
            bool flag;
            this._logger.LogWarning("The server execute AddStaff Fuction  --" + DateTime.Now.ToString());
            using (SchoolCookHouseContext dbcontext = new SchoolCookHouseContext())
            {
                TStaff staff = new TStaff()
                {
                    StaffName = staffname,
                    Telephone = telephone,
                    Position = position,
                };
                if (staffname != "")
                {
                    flag = UpLoadFile.FileSave(files, staffname, out filenames);
                }
                else
                {
                    flag = UpLoadFile.FileSave(files, DateTime.Now.ToString("yyyy-MM-dd hh:mm:ss"), out filenames);
                }
                try
                {
                    if (flag)
                    {
                        filenames.Sort();
                        resultfilename = string.Join("", filenames.ToArray());
                        staff.Image = resultfilename;
                        dbcontext.Add(staff);
                        dbcontext.SaveChanges();
                        Status status = new Status()
                        {
                            StatusCode = 200,
                            Message = "添加成功",
                            ReturnTime = DateTime.Now
                        };
                        return status;
                    }
                    else
                    {
                        Status status = new Status()
                        {
                            StatusCode = 0,
                            Message = "添加失败",
                            ReturnTime = DateTime.Now
                        };
                        return status;
                    }
                }
                catch (Exception ex)
                {
                    this._logger.LogWarning("The server execute AddStaff Fuction  --" + ex.Message + DateTime.Now.ToString());
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
        /// 根据员工ID进行删除
        /// </summary>
        /// <param name="id">员工ID</param>
        /// <returns></returns>
        [HttpPost]
        public Status DeleteStaff(int id)
        {
            this._logger.LogWarning("The server execute DeleteStaff Fuction  --" + DateTime.Now.ToString());
            using (SchoolCookHouseContext dbcontext = new SchoolCookHouseContext())
            {
                try
                {
                    var a = dbcontext.TStaff.Where(a => true).ToList().Find(a => a.Id == id);
                    dbcontext.TStaff.Remove(a);
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
                    this._logger.LogWarning("The server execute DeleteStaff Fuction  --" + ex.Message + DateTime.Now.ToString());
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
        /// 根据员工ID进行查询
        /// </summary>
        /// <param name="id"></param>
        /// <returns></returns>
        [HttpGet]
        public Status GetConditionStaff(int id)
        {
            this._logger.LogWarning("The server execute GetConditionStaff Fuction  --" + DateTime.Now.ToString());
            using (SchoolCookHouseContext dbcontext = new SchoolCookHouseContext())
            {
                var result = dbcontext.TStaff.Where(a => a.Id == id).ToList();
                if (result.Count > 0)
                {
                    StaffStatus staffStatus = new StaffStatus
                    {
                        StatusCode = 200,
                        Message = "查询成功",
                        ReturnTime = DateTime.Now,
                        Staff = result
                    };
                    return staffStatus;
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
        /// 根据员工ID进行修改
        /// </summary>
        /// <param name="conditionuserid">员工ID-条件</param>
        /// <param name="staffname">员工姓名</param>
        /// <param name="telephone">电话</param>
        /// <param name="image">图片路径</param>
        /// <param name="position">职位</param>
        /// <returns></returns>
        [HttpPost]
        public Status UpdateStaff(int conditionuserid, string staffname, string telephone, string image, string position)
        {
            this._logger.LogWarning("The server execute UpdateStaff Fuction  --" + DateTime.Now.ToString());
            using (SchoolCookHouseContext dbcontext = new SchoolCookHouseContext())
            {
                TStaff staff = new TStaff()
                {
                    StaffName = staffname,
                    Telephone = telephone,
                    Image = image,
                    Position = position,
                };

                var ReadPeoples = dbcontext.TStaff.Where(a => true).ToList().Find(a => a.Id == conditionuserid);

                ReadPeoples.StaffName = staff.StaffName;
                ReadPeoples.Telephone = staff.Telephone;
                ReadPeoples.Image = staff.Image;
                ReadPeoples.Position = staff.Position;

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
                    this._logger.LogWarning("The server execute UpdateStaff Fuction  --" + ex.Message + DateTime.Now.ToString());
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
        /// 查询所有 分页
        /// </summary>
        /// <param name="pagesize"></param>
        /// <param name="pageindex"></param>
        /// <returns></returns>
        [HttpGet]
        public Status StaffPages(int pagesize,int pageindex)
        {
            this._logger.LogWarning("The server execute StaffPages Fuction  --");
            EFHelper<TStaff> eFHelper = new EFHelper<TStaff>();
            var result = eFHelper.getListByPage(a => true, a => a.Id, pagesize, pageindex);
            if (result != null)
            {
                PagesStatus<TStaff> status = new PagesStatus<TStaff>
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
        /// 查询所有 分页  精准查询
        /// </summary>
        /// <param name="pagesize"></param>
        /// <param name="pageindex"></param>
        /// <param name="staffname">查询的员工名</param>
        /// <returns></returns>
        [HttpGet]
        public Status StaffPagesSearch(int pagesize, int pageindex,string staffname)
        {
            this._logger.LogWarning("The server execute StaffPagesSearch Fuction  --");
            EFHelper<TStaff> eFHelper = new EFHelper<TStaff>();
            var result = eFHelper.getListByPage(a => a.StaffName==staffname, a => a.Id, pagesize, pageindex);
            if (result != null)
            {
                PagesStatus<TStaff> status = new PagesStatus<TStaff>
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
