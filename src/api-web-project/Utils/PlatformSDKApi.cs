using AdminManageSystem.Data;
using Consul;
using Microsoft.AspNetCore.Http;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace AdminManageSystem.Utils
{
    public class PlatformSDKApi
    {
        private string m_apihost = "http://123.56.152.95:8500/";
        private string m_currenthost;

        public PlatformSDKApi(string serverurl)
        {
            if (serverurl != "")
            {
                this.m_apihost = serverurl;
            }
        }
        public PlatformSDKApi(string serverurl, ServicesType type)
        {
            string resultx = string.Empty;
            if (serverurl != "")
            {
                this.m_apihost = serverurl;
            }
            using (var consultClient = new ConsulClient(c => c.Address = new Uri(m_apihost)))
            {
                var services = consultClient.Agent.Services().Result.Response.Values.Where(s => s.Service.Equals(type.ToString(), StringComparison.OrdinalIgnoreCase));
                if (!services.Any())
                {
                    Console.WriteLine("找不到服务的实例");
                }
                else
                {
                    //负载均衡代码实现
                    var service = services.ElementAt(Environment.TickCount % services.Count());
                    resultx = "http://" + $"{service.Address}:{service.Port}";
                }
            }
            m_currenthost = resultx;
        }
        #region ——CookBooks表的操作——

        /// <summary>
        /// 获取所有食谱表
        /// </summary>
        /// <returns></returns>
        public CookBooksDTO GetAllCookBooks()
        {
            string apipath = string.Format("{0}{1}", m_currenthost, FoodAnalysisApiUrl.getallcookbook);
            HttpRequestEntity httpRequestEntity = new HttpRequestEntity()
            {
                Method = HttpMethod.GET,
            };
            HttpResponseEntity responseEntity = HttpHelper.Get(apipath, httpRequestEntity);
            return JsonHelper.Deserialize<CookBooksDTO>(responseEntity.Bodys);
        }
        /// <summary>
        /// 获取所有食谱表  分页
        /// </summary>
        /// <returns></returns>
        public CookBooksPageDTO GetAllCookBooksPage(int pagesize,int pageindex)
        {
            string apipath = string.Format("{0}{1}?pagesize={2}&pageindex={3}", m_currenthost, FoodAnalysisApiUrl.cookbookpages,pagesize,pageindex);
            HttpRequestEntity httpRequestEntity = new HttpRequestEntity()
            {
                Method = HttpMethod.POST,
            };
            HttpResponseEntity responseEntity = HttpHelper.Post(apipath, httpRequestEntity);
            return JsonHelper.Deserialize<CookBooksPageDTO>(responseEntity.Bodys);
        }

        /// <summary>
        /// 用名称查询食谱信息
        /// </summary>
        /// <param name="NutritionName"></param>
        /// <returns></returns>
        public CookBooksDTO SearchCookBook(string cookbookname)
        {
            string apipath = string.Format("{0}{1}?cookbookname={2}", m_currenthost, FoodAnalysisApiUrl.searchcookbook, cookbookname);
            HttpRequestEntity httpRequestEntity = new HttpRequestEntity()
            {
                Method = HttpMethod.POST,
            };
            HttpResponseEntity responseEntity = HttpHelper.Post(apipath, httpRequestEntity);
            return JsonHelper.Deserialize<CookBooksDTO>(responseEntity.Bodys);
        }

        /// <summary>
        /// 用名称查询食谱信息 模糊查询
        /// </summary>
        /// <param name="NutritionName"></param>
        /// <returns></returns>
        public CookBooksPageDTO SearchCookBookPages(string cookbookname,int pagesize,int pageindex)
        {
            string apipath = string.Format("{0}{1}?pagesize={2}&pageindex={3}&likeword={4}", m_currenthost, FoodAnalysisApiUrl.cookbooklikesearchpages, pagesize, pageindex, cookbookname);
            HttpRequestEntity httpRequestEntity = new HttpRequestEntity()
            {
                Method = HttpMethod.POST,
            };
            HttpResponseEntity responseEntity = HttpHelper.Post(apipath, httpRequestEntity);
            return JsonHelper.Deserialize<CookBooksPageDTO>(responseEntity.Bodys);
        }
        /// <summary>
        /// 更新食谱条目信息
        /// </summary>
        /// <param name="info"></param>
        /// <returns></returns>
        public StatuDTO UpdateCookBooksInfo(CookBooks info)
        {
            string apipath = string.Format("{0}{1}", m_currenthost, FoodAnalysisApiUrl.updatecookbook);
            HttpRequestEntity httpRequestEntity = new HttpRequestEntity()
            {
                Method = HttpMethod.POST,
            };
            string jsoncontent = JsonHelper.Serialize<CookBooks>(info);
            HttpResponseEntity responseEntity = HttpHelper.Post(apipath, httpRequestEntity, jsoncontent);
            return JsonHelper.Deserialize<StatuDTO>(responseEntity.Bodys);
        }
        /// <summary>
        /// 添加
        /// </summary>
        /// <param name="info"></param>
        /// <returns></returns>
        public StatuDTO AddCookBook(CookBooks info,List<IFormFile> formFiles)
        {
            string apipath = string.Format("{0}{1}?cookBookname={2}&flavour={3}&material={4}&nutritionalingredient={5}", m_currenthost, FoodAnalysisApiUrl.addnutritioninfo,info.name,info.flavour,info.material,info.nutritionalIngredient);
            HttpRequestEntity httpRequestEntity = new HttpRequestEntity()
            {
                Method = HttpMethod.POST,
            };
            string jsoncontent = JsonHelper.Serialize<CookBooks>(info);
            HttpResponseEntity responseEntity = HttpHelper.Post(apipath, httpRequestEntity, jsoncontent);
            return JsonHelper.Deserialize<StatuDTO>(responseEntity.Bodys);
        }
        #endregion

        #region  ——营养素信息表操作——
        /// <summary>
        /// 查询所有营养素的信息
        /// </summary>
        /// <returns></returns>
        public NutrientInformationDTO GetAllNutrition()
        {
            string apipath = string.Format("{0}{1}", m_currenthost, FoodAnalysisApiUrl.getallnutritions);
            HttpRequestEntity httpRequestEntity = new HttpRequestEntity()
            {
                Method = HttpMethod.GET,
            };
            HttpResponseEntity responseEntity = HttpHelper.Get(apipath, httpRequestEntity);
            return JsonHelper.Deserialize<NutrientInformationDTO>(responseEntity.Bodys);
        }
        /// <summary>
        /// 营养素信息分页
        /// </summary>
        /// <param name="pagesize"></param>
        /// <param name="pageindex"></param>
        /// <returns></returns>
        public NutrientInfoPageDTO PageNutrition(int pagesize, int pageindex)
        {
            string apipath = string.Format("{0}{1}?pagesize={2}&pageindex={3}", m_currenthost, FoodAnalysisApiUrl.nutritionspage, pagesize, pageindex);
            HttpRequestEntity httpRequestEntity = new HttpRequestEntity()
            {
                Method = HttpMethod.POST
            };
            HttpResponseEntity responseEntity = HttpHelper.Post(apipath, httpRequestEntity);
            return JsonHelper.Deserialize<NutrientInfoPageDTO>(responseEntity.Bodys);
        }
        /// <summary>
        /// 用营养素名称或者别名查询营养素信息
        /// </summary>
        /// <param name="NutritionName"></param>
        /// <returns></returns>
        public NutrientInfoPageDTO SearchNutrition(string NutritionName, int pagesize, int pageindex)
        {
            string apipath = string.Format("{0}{1}?keyword={2}&pagesize={3}&pageindex={4}", m_currenthost, FoodAnalysisApiUrl.searchnutritioninfo,NutritionName,pagesize,pageindex);
            HttpRequestEntity httpRequestEntity = new HttpRequestEntity()
            {
                Method = HttpMethod.POST,
            };
            HttpResponseEntity responseEntity = HttpHelper.Post(apipath, httpRequestEntity);
            return JsonHelper.Deserialize<NutrientInfoPageDTO>(responseEntity.Bodys);
        }
        /// <summary>
        /// 用名称查询营养素信息
        /// </summary>
        /// <param name="NutritionName"></param>
        /// <returns></returns>
        public NutrientInformationDTO SearchNutritionInfo(string NutritionName)
        {
            string apipath = string.Format("{0}{1}?NutritionName={2}", m_currenthost, FoodAnalysisApiUrl.usenamesearchnutritioninfo, NutritionName);
            HttpRequestEntity httpRequestEntity = new HttpRequestEntity()
            {
                Method = HttpMethod.POST,
            };
            HttpResponseEntity responseEntity = HttpHelper.Post(apipath, httpRequestEntity);
            return JsonHelper.Deserialize<NutrientInformationDTO>(responseEntity.Bodys);
        }
        /// <summary>
        /// 更新条目信息
        /// </summary>
        /// <param name="info"></param>
        /// <returns></returns>
        public StatuDTO UpdateNutritionInfo(NutrientInformation info)
        {
            string apipath = string.Format("{0}{1}", m_currenthost, FoodAnalysisApiUrl.updatenutritioninfo);
            HttpRequestEntity httpRequestEntity = new HttpRequestEntity()
            {
                Method = HttpMethod.POST,
            };
            string jsoncontent = JsonHelper.Serialize<NutrientInformation>(info);
            HttpResponseEntity responseEntity = HttpHelper.Post(apipath, httpRequestEntity, jsoncontent);
            return JsonHelper.Deserialize<StatuDTO>(responseEntity.Bodys);
        }
        /// <summary>
        /// 删除
        /// </summary>
        /// <param name="info"></param>
        /// <returns></returns>
        public StatuDTO DeleteNutritionInfo(NutrientInformation info)
        {
            string apipath = string.Format("{0}{1}", m_currenthost, FoodAnalysisApiUrl.deletenutritioninfo);
            HttpRequestEntity httpRequestEntity = new HttpRequestEntity()
            {
                Method = HttpMethod.POST,
            };
            string jsoncontent = JsonHelper.Serialize<NutrientInformation>(info);
            HttpResponseEntity responseEntity = HttpHelper.Post(apipath, httpRequestEntity, jsoncontent);
            return JsonHelper.Deserialize<StatuDTO>(responseEntity.Bodys);
        }
        /// <summary>
        /// 添加
        /// </summary>
        /// <param name="info"></param>
        /// <returns></returns>
        public StatuDTO AddNutritionInfo(NutrientInformation info)
        {
            string apipath = string.Format("{0}{1}", m_currenthost, FoodAnalysisApiUrl.addnutritioninfo);
            HttpRequestEntity httpRequestEntity = new HttpRequestEntity()
            {
                Method = HttpMethod.POST,
            };
            string jsoncontent = JsonHelper.Serialize<NutrientInformation>(info);
            HttpResponseEntity responseEntity = HttpHelper.Post(apipath, httpRequestEntity, jsoncontent);
            return JsonHelper.Deserialize<StatuDTO>(responseEntity.Bodys);
        }
        #endregion

        #region——膳食数据库表的操作——
        /// <summary>
        /// 查询所有食物营养成分
        /// </summary>
        /// <param name="NutritionName"></param>
        /// <returns></returns>
        public FoodNutritionDTO GetAllFoodNutrion()
        {
            string apipath = string.Format("{0}{1}", m_currenthost, FoodAnalysisApiUrl.getallfoodnutrition);
            HttpRequestEntity httpRequestEntity = new HttpRequestEntity()
            {
                Method = HttpMethod.GET,
            };
            HttpResponseEntity responseEntity = HttpHelper.Get(apipath, httpRequestEntity);
            return JsonHelper.Deserialize<FoodNutritionDTO>(responseEntity.Bodys);
        }
        /// <summary>
        /// 查询所有食物营养成分
        /// </summary>
        /// <param name="pagesize"></param>
        /// <param name="pageindex"></param>
        /// <returns></returns>
        public FoodNutritionPageDTO GetAllFoodNutrionPages(int pagesize,int pageindex)
        {
            string apipath = string.Format("{0}{1}?pagesize={2}&pageindex={3}", m_currenthost, FoodAnalysisApiUrl.getallfoodnutritioninfopages,pagesize,pageindex);
            HttpRequestEntity httpRequestEntity = new HttpRequestEntity()
            {
                Method = HttpMethod.POST,
            };
            HttpResponseEntity responseEntity = HttpHelper.Post(apipath, httpRequestEntity);
            return JsonHelper.Deserialize<FoodNutritionPageDTO>(responseEntity.Bodys);
        }
        /// <summary>
        /// 查询单个食物营养成分
        /// </summary>
        /// <param name="searchword">食材名</param>
        /// <param name="pagesize"></param>
        /// <param name="pageindex"></param>
        /// <returns></returns>
        public FoodNutritionPageDTO GetAllFoodNutrionSearchPages(string searchword,int pagesize, int pageindex)
        {
            string apipath = string.Format("{0}{1}?keyword={2}&pagesize={3}&pageindex={4}", m_currenthost, FoodAnalysisApiUrl.searchfoodnutrtionpages, searchword, pagesize, pageindex);
            HttpRequestEntity httpRequestEntity = new HttpRequestEntity()
            {
                Method = HttpMethod.POST,
            };
            HttpResponseEntity responseEntity = HttpHelper.Post(apipath, httpRequestEntity);
            return JsonHelper.Deserialize<FoodNutritionPageDTO>(responseEntity.Bodys);
        }

        /// <summary>
        /// 更新食品营养信息
        /// </summary>
        /// <param name="info"></param>
        /// <returns></returns>
        public StatuDTO UpdateFoodNutrition(FoodNutritions info)
        {
            string apipath = string.Format("{0}{1}", m_currenthost, FoodAnalysisApiUrl.updatefoodnutrition);
            HttpRequestEntity httpRequestEntity = new HttpRequestEntity()
            {
                Method = HttpMethod.POST,
            };
            string jsoncontent = JsonHelper.Serialize<FoodNutritions>(info);
            HttpResponseEntity responseEntity = HttpHelper.Post(apipath, httpRequestEntity, jsoncontent);
            return JsonHelper.Deserialize<StatuDTO>(responseEntity.Bodys);
        }

        /// <summary>
        /// 用食材名查询食材信息
        /// </summary>
        /// <param name="foodname>食材名</param>
        /// <returns></returns>
        public FoodNutritionDTO UseFoodNameByNutritionInfo(string foodname)
        {
            string apipath = string.Format("{0}{1}?foodname={2}", m_currenthost, FoodAnalysisApiUrl.usefoodnamebysearchinfo, foodname);
            HttpRequestEntity httpRequestEntity = new HttpRequestEntity()
            {
                Method = HttpMethod.POST,
            };
            HttpResponseEntity responseEntity = HttpHelper.Post(apipath, httpRequestEntity);
            return JsonHelper.Deserialize<FoodNutritionDTO>(responseEntity.Bodys);
        }
        #endregion

        #region——食堂员工信息表的操作——
        /// <summary>
        /// 查询食堂所有员工信息  分页
        /// </summary>
        /// <param name="NutritionName"></param>
        /// <returns></returns>
        public StaffDTO GetCookHouseStaff()
        {
            string apipath = string.Format("{0}{1}", m_currenthost, SchoolCookHouseApiUrl.getallstaff);
            HttpRequestEntity httpRequestEntity = new HttpRequestEntity()
            {
                Method = HttpMethod.GET,
            };
            HttpResponseEntity responseEntity = HttpHelper.Get(apipath, httpRequestEntity);
            return JsonHelper.Deserialize<StaffDTO>(responseEntity.Bodys);
        }

        /// <summary>
        /// 查询食堂所有员工信息  分页
        /// </summary>
        /// <param name="NutritionName"></param>
        /// <returns></returns>
        public StaffPageDTO GetCookHouseStaffPage(int pagesize, int pageindex)
        {
            string apipath = string.Format("{0}{1}?pagesize={2}&pageindex={3}", m_currenthost, SchoolCookHouseApiUrl.staffpages, pagesize, pageindex);
            HttpRequestEntity httpRequestEntity = new HttpRequestEntity()
            {
                Method = HttpMethod.GET,
            };
            HttpResponseEntity responseEntity = HttpHelper.Get(apipath, httpRequestEntity);
            return JsonHelper.Deserialize<StaffPageDTO>(responseEntity.Bodys);
        }

        /// <summary>
        /// 查询食堂所有员工信息  分页
        /// </summary>
        /// <param name="NutritionName"></param>
        /// <returns></returns>
        public StaffPageDTO GetCookHouseStaffPageSearch(int pagesize, int pageindex,string staffname)
        {
            string apipath = string.Format("{0}{1}?pagesize={2}&pageindex={3}&staffname={4}", m_currenthost, SchoolCookHouseApiUrl.staffpagessearch, pagesize, pageindex,staffname);
            HttpRequestEntity httpRequestEntity = new HttpRequestEntity()
            {
                Method = HttpMethod.GET,
            };
            HttpResponseEntity responseEntity = HttpHelper.Get(apipath, httpRequestEntity);
            return JsonHelper.Deserialize<StaffPageDTO>(responseEntity.Bodys);
        }
        #endregion
    }
}
