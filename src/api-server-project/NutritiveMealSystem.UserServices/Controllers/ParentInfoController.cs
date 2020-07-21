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
    /// 对T_ParentInfo（家长表）的操作
    /// </summary>
    [Route("api/[controller]/[action]")]
    [ApiController]
    public class ParentInfoController : ControllerBase
    {
        /// <summary>
        /// 加载Log日志服务
        /// </summary>
        private readonly ILogger<ParentInfoController> _logger;
        /// <summary>
        /// 初始化Log日志对象
        /// </summary>
        /// <param name="logger"></param>
        public ParentInfoController(ILogger<ParentInfoController> logger)
        {
            _logger = logger;
        }

        /// <summary>
        /// 返回T_ParentInfo（家长表）的所有信息
        /// </summary>
        /// <returns></returns>
        [HttpGet]
        public Status GetAllParentInfo()
        {
            this._logger.LogWarning("The Server execute GetAllParentInfo Function  --" + DateTime.Now.ToString());
            using (UserContext dbcontext = new UserContext())
            {
                var result = dbcontext.TParentInfo.ToList();
                if (result.Count > 0)
                {
                    ParentInfoStatus parallelLoopState = new ParentInfoStatus
                    {
                        StatusCode = 200,
                        Message = "获取成功",
                        ReturnTime = DateTime.Now,
                        ParentInfo = result
                    };
                    return parallelLoopState;
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
        /// 添加家长用户
        /// </summary>
        /// <param name="parentname">家长姓名</param>
        /// <param name="username">用户名</param>
        /// <param name="password">密码</param>
        /// <param name="childrennum">学生学号</param>
        /// <param name="schoolname">学校名称</param>
        /// <returns></returns>
        [HttpPost]
        public Status AddParentInfo(string parentname, string username, string password, string childrennum,string schoolname)
        {
            this._logger.LogWarning("The server execute AddParentInfo Fuction  --" + DateTime.Now.ToString());
            using (UserContext dbcontext = new UserContext())
            {
                if (dbcontext.TParentInfo.Where(a => a.UserName == username).Count() < 1)
                {
                    if(dbcontext.TChildrenInfo.Where(a=>a.StuNo==childrennum && a.SchoolName==schoolname).Count()>0)
                    {
                        TParentInfo parentInfo = new TParentInfo()
                        {
                            ParentName = parentname,
                            UserName = username,
                            Password = password,
                            ChildrenNum = childrennum,
                            SchoolName = schoolname,
                        };
                        try
                        {
                            dbcontext.TParentInfo.Add(parentInfo);
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
                            this._logger.LogWarning("The server execute AddParentInfo Fuction  --" + ex.Message + DateTime.Now.ToString());
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
                        this._logger.LogWarning("The server execute AddParentInfo Fuction  --" + DateTime.Now.ToString());
                        Status status = new Status()
                        {
                            StatusCode = 0,
                            Message = "该学生不存在",
                            ReturnTime = DateTime.Now
                        };
                        return status;
                    }
                }
                else
                {
                    this._logger.LogWarning("The server execute AddParentInfo Fuction  --" + DateTime.Now.ToString());
                    Status status = new Status()
                    {
                        StatusCode = 0,
                        Message = "用户名重复",
                        ReturnTime = DateTime.Now
                    };
                    return status;
                }
            }
        }

        /// <summary>
        /// 根据用户名对T_ParentInfo（家长表）进行删除
        /// </summary>
        /// <param name="username">用户名</param>
        /// <returns></returns>
        [HttpPost]
        public Status DeleteParentInfo(string username)
        {
            this._logger.LogWarning("The server execute DeleteParentInfo Fuction  --" + DateTime.Now.ToString());
            using (UserContext dbcontext = new UserContext())
            {
                TParentInfo parentInfo = new TParentInfo()
                {
                    UserName = username
                };
                try
                {
                    var a = dbcontext.TParentInfo.Where(a => true).ToList().Find(a => a.UserName == username);
                    dbcontext.TParentInfo.Remove(a);
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
                    this._logger.LogWarning("The server execute DeleteParentInfo Fuction  --" + ex.Message + DateTime.Now.ToString());
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
        /// 通过用户名对T_ParentInfo（家长表）进行查询
        /// </summary>
        /// <param name="username">用户名</param>
        /// <returns></returns>
        [HttpGet]
        public Status GetConditionParentInfo(string username)
        {
            this._logger.LogWarning("The server execute GetConditionParentInfo Fuction  --" + DateTime.Now.ToString());
            using (UserContext dbcontext = new UserContext())
            {
                var result = dbcontext.TParentInfo.Where(a => a.UserName == username).ToList();
                if (result.Count > 0)
                {
                    ParentInfoStatus parentInfoStatus = new ParentInfoStatus
                    {
                        StatusCode = 200,
                        Message = "查询成功",
                        ReturnTime = DateTime.Now,
                        ParentInfo= result
                    };
                    return parentInfoStatus;
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
        /// 验证T_ParentInfo（家长表）用户名密码是否正确
        /// </summary>
        /// <param name="username">用户名</param>
        /// <param name="password">密码</param>
        /// <returns></returns>
        [HttpPost]
        public Status VerificationParentInfo(string username, string password)
        {
            this._logger.LogWarning("The server execute VerificationParentInfo Fuction  --" + DateTime.Now.ToString());
            using (UserContext dbcontext = new UserContext())
            {
                var result = dbcontext.TParentInfo.Where(a => a.UserName == username && a.Password == password).ToList();

                if (result.Count > 0)
                {
                    try
                    {
                        Status status = new Status()
                        {
                            StatusCode = 200,
                            Message = "登录成功",
                            ReturnTime = DateTime.Now
                        };
                        return status;
                    }
                    catch (Exception ex)
                    {
                        this._logger.LogWarning("The server execute VerificationParentInfo Fuction  --" + ex.Message + DateTime.Now.ToString());
                        Status status = new Status()
                        {
                            StatusCode = 0,
                            Message = "登录失败",
                            ReturnTime = DateTime.Now
                        };
                        return status;
                    }
                }
                else
                {
                    Status status = new Status()
                    {
                        StatusCode = 0,
                        Message = "登录失败",
                        ReturnTime = DateTime.Now
                    };
                    return status;
                }
            }
        }

        /// <summary>
        /// 根据用户名修改T_ParentInfo（家长表）信息
        /// </summary>
        /// <param name="conditionusername">用户名—条件</param>
        /// <param name="parentname">家长姓名</param>
        /// <param name="username">用户名</param>
        /// <param name="password">密码</param>
        /// <param name="childrennum">学生学号</param>
        /// <param name="schoolname">学校名称</param>
        /// <returns></returns>
        [HttpPost]
        public Status UpdateParentInfo(string conditionusername,string parentname, string username, string password, string childrennum, string schoolname)
        {
            this._logger.LogWarning("The server execute UpdateParentInfo Fuction  --" + DateTime.Now.ToString());
            using (UserContext dbcontext = new UserContext())
            {
                TParentInfo parentInfo = new TParentInfo()
                {
                    ParentName = parentname,
                    UserName = username,
                    Password = password,
                    ChildrenNum = childrennum,
                    SchoolName = schoolname
                };

                var ReadPeoples = dbcontext.TParentInfo.Where(a => true).ToList().Find(a => a.UserName == conditionusername);

                ReadPeoples.ParentName = parentInfo.ParentName;
                ReadPeoples.UserName = parentInfo.UserName;
                ReadPeoples.Password = parentInfo.Password;
                ReadPeoples.ChildrenNum = parentInfo.ChildrenNum;
                ReadPeoples.SchoolName = parentInfo.SchoolName;

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
                    this._logger.LogWarning("The server execute UpdateParentInfo Fuction  --" + ex.Message + DateTime.Now.ToString());
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
