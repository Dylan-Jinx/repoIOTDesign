using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using Microsoft.Extensions.Logging;
using NutritiveMealSystem.UserServices.Models;
using NutritiveMealSystem.UserServices.Models.ReturnModels;

namespace NutritiveMealSystem.UserServices.Controllers
{
    /// <summary>
    /// 对T_ChildrenInfo（学校学生信息表）的操作
    /// </summary>
    [Route("api/[controller]/[action]")]
    [ApiController]
    public class ChildrenInfoController : ControllerBase
    {
        /// <summary>
        /// 加载Log日志服务
        /// </summary>
        private readonly ILogger<ChildrenInfoController> _logger;
        /// <summary>
        /// 初始化Log日志对象
        /// </summary>
        /// <param name="logger"></param>
        public ChildrenInfoController(ILogger<ChildrenInfoController> logger)
        {
            _logger = logger;
        }

        /// <summary>
        /// 返回T_ChildrenInfo（学校学生信息表）的所有信息
        /// </summary>
        /// <returns></returns>
        [HttpGet]
        public Status GetAllChildrenInfo()
        {
            this._logger.LogWarning("The Server execute GetAllChildrenInfo Function  --" + DateTime.Now.ToString());
            using (UserContext dbcontext = new UserContext())
            {
                var result = dbcontext.TChildrenInfo.ToList();
                if (result.Count > 0)
                {
                    ChildrenInfoStatus childrenInfoStatus = new ChildrenInfoStatus
                    {
                        StatusCode = 200,
                        Message = "获取成功",
                        ReturnTime = DateTime.Now,
                        ChildrenInfo = result
                    };
                    return childrenInfoStatus;
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
        /// 添加学生信息
        /// </summary>
        /// <param name="name">姓名</param>
        /// <param name="stuno">学号</param>
        /// <param name="address">地址</param>
        /// <param name="parentname">家长姓名</param>
        /// <param name="schoolname">学校名称</param>
        /// <returns></returns>
        [HttpPost]
        public Status AddChildrenInfo(string name, string stuno, string address, string parentname,string schoolname)
        {
            this._logger.LogWarning("The server execute AddChildrenInfo Fuction  --" + DateTime.Now.ToString());
            using (UserContext dbcontext = new UserContext())
            {
                if (dbcontext.TChildrenInfo.Where(a => a.StuNo == stuno).Where(a=>a.SchoolName==schoolname).Count() < 1)
                {
                    TChildrenInfo childrenInfo = new TChildrenInfo()
                    {
                        Name = name,
                        StuNo=stuno,
                        Address=address,
                        ParentName=parentname,
                        SchoolName=schoolname,                      
                    };
                    try
                    {
                        dbcontext.Add(childrenInfo);
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
                        this._logger.LogWarning("The server execute AddChildrenInfo Fuction  --" + ex.Message + DateTime.Now.ToString());
                        Status status = new Status()
                        {
                            StatusCode = 0,
                            Message = "添加失败",
                            ReturnTime = DateTime.Now
                        };
                        return status;
                    }
                }
                else
                {
                    this._logger.LogWarning("The server execute AddChildrenInfo Fuction  --" + DateTime.Now.ToString());
                    Status status = new Status()
                    {
                        StatusCode = 0,
                        Message = "学号重复",
                        ReturnTime = DateTime.Now
                    };
                    return status;
                }
            }
        }

        /// <summary>
        /// 通过学号学校名称删除学生
        /// </summary>
        /// <param name="stuno">学号</param>
        /// <param name="schoolname">学生姓名</param>
        /// <returns></returns>
        [HttpPost]
        public Status DeleteChildrenInfo(string stuno,string schoolname)
        {
            this._logger.LogWarning("The server execute DeleteChildrenInfo Fuction  --" + DateTime.Now.ToString());
            using (UserContext dbcontext = new UserContext())
            {
                try
                {
                    var a = dbcontext.TChildrenInfo.Where(a => true).ToList().Find(a => a.StuNo == stuno && a.SchoolName==schoolname);
                    dbcontext.TChildrenInfo.Remove(a);
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
                    this._logger.LogWarning("The server execute DeleteChildrenInfo Fuction  --" + ex.Message + DateTime.Now.ToString());
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
        /// 通过学号学校名称查询学生
        /// </summary>
        /// <param name="stuno">学号</param>
        /// <param name="schoolname">学校名称</param>
        /// <returns></returns>
        [HttpGet]
        public Status GetConditionChildrenInfo(string stuno, string schoolname)
        {
            this._logger.LogWarning("The server execute GetConditionChildrenInfo Fuction  --" + DateTime.Now.ToString());
            using (UserContext dbcontext = new UserContext())
            {
                var result = dbcontext.TChildrenInfo.Where(a => a.StuNo == stuno && a.SchoolName==schoolname).ToList();
                if (result.Count > 0)
                {
                    ChildrenInfoStatus userInfoStatus = new ChildrenInfoStatus
                    {
                        StatusCode = 200,
                        Message = "查询成功",
                        ReturnTime = DateTime.Now,
                        ChildrenInfo = result
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
        /// 通过学生家长名字来查询
        /// </summary>
        /// <param name="parentname">家长名</param>
        /// <returns></returns>
        [HttpGet]
        public Status UseParentNameGetStudentinfo(string parentname)
        {
            this._logger.LogWarning("The server execute GetConditionChildrenInfo Fuction  --" + DateTime.Now.ToString());
            using (UserContext dbcontext = new UserContext())
            {
                var result = dbcontext.TChildrenInfo.Where(a => a.ParentName == parentname).ToList();
                if (result.Count > 0)
                {
                    ChildrenInfoStatus userInfoStatus = new ChildrenInfoStatus
                    {
                        StatusCode = 200,
                        Message = "查询成功",
                        ReturnTime = DateTime.Now,
                        ChildrenInfo = result
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
        /// 通过学号和学校名称修改学生信息
        /// </summary>
        /// <param name="conditionuserstuno">学号—条件</param>
        /// <param name="conditionuserschoolname">学校名称-条件</param>
        /// <param name="name">姓名</param>
        /// <param name="stuno">学号</param>
        /// <param name="address">地址</param>
        /// <param name="parentname">家长姓名</param>
        /// <param name="schoolname">学校名称</param>
        /// <returns></returns>
        [HttpPost]
        public Status UpdateChildrenInfo(string conditionuserstuno,string conditionuserschoolname, string name, string stuno, string address, string parentname, string schoolname)
        {
            this._logger.LogWarning("The server execute UpdateChildrenInfo Fuction  --" + DateTime.Now.ToString());
            using (UserContext dbcontext = new UserContext())
            {
                TChildrenInfo childrenInfo = new TChildrenInfo()
                {
                    Name = name,
                    StuNo = stuno,
                    Address = address,
                    ParentName = parentname,
                    SchoolName = schoolname,
                };
                var ReadPeoples = dbcontext.TChildrenInfo.Where(a => true).ToList().Find(a => a.StuNo == conditionuserstuno && a.SchoolName== conditionuserschoolname);

                ReadPeoples.Name = childrenInfo.Name;
                ReadPeoples.StuNo = childrenInfo.StuNo;
                ReadPeoples.Address = childrenInfo.Address;
                ReadPeoples.ParentName = childrenInfo.ParentName;
                ReadPeoples.SchoolName = childrenInfo.SchoolName;
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
                    this._logger.LogWarning("The server execute UpdateChildrenInfo Fuction  --" + ex.Message + DateTime.Now.ToString());
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
        }
}
