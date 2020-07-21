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
    /// 对T_UserInfo（用户登录表）的操作
    /// </summary>
    [Route("api/[controller]/[action]")]
    [ApiController]
    public class UserInfoController : ControllerBase
    {
        /// <summary>
        /// 加载Log日志服务
        /// </summary>
        private readonly ILogger<UserInfoController> _logger;
        /// <summary>
        /// 初始化Log日志对象
        /// </summary>
        /// <param name="logger"></param>
        public UserInfoController(ILogger<UserInfoController> logger)
        {
            _logger = logger;
        }

        /// <summary>
        /// 返回T_UserInfo（用户登录表）的所有信息
        /// </summary>
        /// <returns></returns>
        [HttpGet]
        public Status GetAllUserInfo()
        {
            this._logger.LogWarning("The Server execute GetAllUserInfo Function  --" + DateTime.Now.ToString());
            using (UserContext dbcontext = new UserContext())
            {
                var result = dbcontext.TUserInfo.ToList();
                if (result.Count > 0)
                {
                    UserInfoStatus userInfoStatus = new UserInfoStatus
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
        /// 添加员工登录账户
        /// </summary>
        /// <param name="name">姓名</param>
        /// <param name="username">用户名</param>
        /// <param name="password">密码</param>
        /// <param name="usertype">职位</param>
        /// <returns></returns>
        [HttpPost]
        public Status AddUserInfo(string name, string username, string password, string usertype)
        {
            this._logger.LogWarning("The server execute AddUserInfo Fuction  --" + DateTime.Now.ToString());
            using (UserContext dbcontext = new UserContext())
            {
                if (dbcontext.TUserInfo.Where(a => a.UserName == username).Count() < 1)
                {
                    TUserInfo userInfo = new TUserInfo()
                    {
                        Name = name,
                        UserName = username,
                        Password = password,
                        UserType = usertype,
                    };
                    try
                    {
                        dbcontext.Add(userInfo);
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
                        this._logger.LogWarning("The server execute AddUserInfo Fuction  --" + ex.Message + DateTime.Now.ToString());
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
                    this._logger.LogWarning("The server execute AddUserInfo Fuction  --" + DateTime.Now.ToString());
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
        /// 通过用户名对员工进行删除
        /// </summary>
        /// <param name="username">用户名</param>
        /// <returns></returns>
        [HttpPost]
        public Status DeleteUserInfo(string username)
        {
            this._logger.LogWarning("The server execute DeleteUserInfo Fuction  --" + DateTime.Now.ToString());
            using (UserContext dbcontext = new UserContext())
            {
                TUserInfo userInfo = new TUserInfo()
                {
                    UserName = username
                };
                try
                {
                    var a=dbcontext.TUserInfo.Where(a => true).ToList().Find(a => a.UserName == username);
                    dbcontext.TUserInfo.Remove(a);
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
                    this._logger.LogWarning("The server execute DeleteUserInfo Fuction  --" + ex.Message + DateTime.Now.ToString());
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
        /// 通过用户名对员工进行查询
        /// </summary>
        /// <param name="username">用户名</param>
        /// <returns></returns>
        [HttpGet]
        public Status GetConditionUserInfo(string username)
        {
            this._logger.LogWarning("The server execute GetConditionUserInfo Fuction  --" + DateTime.Now.ToString());
            using (UserContext dbcontext = new UserContext())
            {
                var result = dbcontext.TUserInfo.Where(a=>a.UserName==username).ToList();
                if (result.Count > 0)
                {
                    UserInfoStatus userInfoStatus = new UserInfoStatus
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
        /// 验证用户名密码是否正确
        /// </summary>
        /// <param name="username">用户名</param>
        /// <param name="password">密码</param>
        /// <returns></returns>
        [HttpPost]
        public Status VerificationUserInfo(string username, string password)
        {
            this._logger.LogWarning("The server execute VerificationUserInfo Fuction  --" + DateTime.Now.ToString());
            using (UserContext dbcontext = new UserContext())
            {
                var result = dbcontext.TUserInfo.Where(a => a.UserName == username && a.Password == password).ToList();

                if(result.Count>0)
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
                        this._logger.LogWarning("The server execute VerificationUserInfo Fuction  --" + ex.Message + DateTime.Now.ToString());
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
        /// 根据用户名修改员工信息
        /// </summary>
        /// <param name="conditionusername">用户名—条件</param>
        /// <param name="name">姓名</param>
        /// <param name="username">用户名</param>
        /// <param name="password">密码</param>
        /// <param name="usertype">职位</param>
        /// <returns></returns>
        [HttpPost]
        public Status UpdateUserInfo(string conditionusername,string name, string username, string password, string usertype)
        {
            this._logger.LogWarning("The server execute UpdateUserInfo Fuction  --" + DateTime.Now.ToString());
            using (UserContext dbcontext = new UserContext())
            {
                TUserInfo userInfo = new TUserInfo()
                {
                    Name = name,
                    UserName = username,
                    Password = password,
                    UserType = usertype,
                };

                var ReadPeoples = dbcontext.TUserInfo.Where(a => true).ToList().Find(a => a.UserName ==conditionusername);

                ReadPeoples.Name = userInfo.Name;
                ReadPeoples.UserName = userInfo.UserName;
                ReadPeoples.Password = userInfo.Password;
                ReadPeoples.UserType = userInfo.UserType;

                try
                {
                    dbcontext.Entry(ReadPeoples).State=EntityState.Modified;
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
                    this._logger.LogWarning("The server execute UpdateUserInfo Fuction  --" + ex.Message + DateTime.Now.ToString());
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
