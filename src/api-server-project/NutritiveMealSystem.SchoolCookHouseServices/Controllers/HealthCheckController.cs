using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Logging;

namespace NutritiveMealSystem.SchoolCookHouseServices.Controllers
{
    /// <summary>
    /// 实现健康、服务状态检查
    /// </summary>
    [Route("api/[controller]")]
    [ApiController]
    public class HealthCheckController : ControllerBase
    {
        /// <summary>
        /// 加载Log日志服务
        /// </summary>
        private readonly ILogger<HealthCheckController> _logger;
        /// <summary>
        /// 初始化Log日志对象
        /// </summary>
        /// <param name="logger"></param>
        public HealthCheckController(ILogger<HealthCheckController> logger)
        {
            _logger = logger;
        }
        /// <summary>
        /// 用于健康检查，心跳检测，检测服务是否出现异常或者是中断
        /// </summary>
        /// <returns></returns>
        [HttpGet]
        public IActionResult Get()
        {
            this._logger.LogWarning("The Server execute HealthCheck -" + DateTime.Now.ToString());
            return Ok();
        }
    }
}
