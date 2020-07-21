using Consul;
using Microsoft.Extensions.Configuration;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace NutritiveMealSystem.UserServices.Utility
{
    /// <summary>
    /// Consul服务帮助类
    /// </summary>
    public static class ConsulHelper
    {
        /// <summary>
        /// 扩展，实现Consul的服务注册以及基础设置
        /// </summary>
        /// <param name="configuration"></param>
        public static void ConsulExtend(this IConfiguration configuration)
        {
            ConsulClient client = new ConsulClient(m =>
            {
                m.Address = new Uri(@"http://123.56.152.95:8500/");
                m.Datacenter = "dc1";
            });
            //启动的时候在consul中注册实例服务
            //在consul中注册的ip,port
            string ip = configuration["ip"];
            int port = int.Parse(configuration["port"]);
            int weight = string.IsNullOrWhiteSpace(configuration["weight"]) ? 1 : int.Parse(configuration["weight"]);
            client.Agent.ServiceRegister(new AgentServiceRegistration()
            {
                ID = "service" + Guid.NewGuid(),//唯一的
                Name = "UserServices",//组(服务)名称
                Address = ip,
                Port = port,//不同的端口=>不同的实例
                Tags = new string[] { weight.ToString() },//标签
                Check = new AgentServiceCheck()//服务健康检查
                {
                    Interval = TimeSpan.FromSeconds(12),//间隔12s一次 检查
                    HTTP = $"http://{ip}:{port}/api/HealthCheck",
                    Timeout = TimeSpan.FromSeconds(5),//检测等待时间
                    DeregisterCriticalServiceAfter = TimeSpan.FromSeconds(20)//失败后多久移除
                }
            });
        }
    }
}
