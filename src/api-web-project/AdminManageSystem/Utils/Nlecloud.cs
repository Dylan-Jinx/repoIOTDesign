using AdminManageSystem.Data;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Threading.Tasks;

namespace AdminManageSystem.Utils
{
    public class Nlecloud
    {
        public static string hostaddr = "http://api.nlecloud.com/";
        private static string currentaddr;
        public Nlecloud()
        {
        }

        public string UserLogin(AccountDTO obj)
        {
            currentaddr = string.Format("{0}{1}", hostaddr, "Users/Login");
            HttpRequestEntity httpRequestEntity = new HttpRequestEntity()
            {
                Method = HttpMethod.POST
            };
            string _jsonString = JsonHelper.Serialize<AccountDTO>(obj);
            HttpResponseEntity httpResponseEntity = HttpHelper.Post(currentaddr, httpRequestEntity,_jsonString);
            UserLoginDTO datas = JsonHelper.Deserialize<UserLoginDTO>(httpResponseEntity.Bodys);
            if (datas != null)
            {
                currentaddr = "";
                return datas.ResultObj.AccessToken;
            }
            else
            {
                return null;
            }
        }

        public CmdsDTO ControlDevices(string token,string deviceId,string apiTag,object cmds)
        {
            currentaddr = string.Format("{0}{1}?deviceId={2}&apiTag={3}", hostaddr, "Cmds",deviceId,apiTag);
            HttpRequestEntity httpRequestEntity = new HttpRequestEntity()
            {
                Method = HttpMethod.POST,
            };
            string _jsonString = JsonHelper.Serialize<object>(cmds);
            HttpResponseEntity httpResponseEntity = HttpHelper.Post(currentaddr, httpRequestEntity, _jsonString,token);
            CmdsDTO datas = JsonHelper.Deserialize<CmdsDTO>(httpResponseEntity.Bodys);
            if (datas != null)
            {
                currentaddr = "";
                return datas;
            }
            else
            {
                return null;
            }
        }

        class Cmd
        {
            public string name { get; set; }
            public int cmdx { get; set; }
        }
    }
}
