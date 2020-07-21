using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Text;
using System.Threading.Tasks;

namespace AdminManageSystem.Utils
{
    public static class HttpHelper
    {
        public static HttpResponseEntity Get(string url, HttpRequestEntity entity)
        {
            HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
            //设置请求基本参数
            var httpWebRequest = (HttpWebRequest)WebRequest.Create(url); httpWebRequest.ContentType = string.IsNullOrEmpty(entity.ContentType) ? "application/json" : entity.ContentType;
            httpWebRequest.Method = entity.Method.ToString();

            //接收返回的数据
            var httpResponse = (HttpWebResponse)httpWebRequest.GetResponse();
            using (var streamReader = new StreamReader(httpResponse.GetResponseStream()))
            {
                httpResponseEntity.Bodys = streamReader.ReadToEnd().ToString();
                return httpResponseEntity;
            }
        }

        public static HttpResponseEntity Post(string url, HttpRequestEntity entity, string content = null,string token=null)
        {
            HttpResponseEntity responseEntity = new HttpResponseEntity();
            //设置请求基本参数
            var httpWebRequest = (HttpWebRequest)WebRequest.Create(url);
            httpWebRequest.ContentType = string.IsNullOrEmpty(entity.ContentType) ? "application/json" : entity.ContentType;
            httpWebRequest.Method = entity.Method.ToString();
            if (token != null)
            {
                httpWebRequest.Headers.Add("AccessToken", token);
            }
            //请求体发送json格式字符  这里不需要但是也无法去除  就创建置空就可以
            using (var streamWriter = new StreamWriter(httpWebRequest.GetRequestStream()))
            {
                if (content != null)
                {
                    streamWriter.Write(content);
                    streamWriter.Flush();
                    streamWriter.Close();
                }
            }

            //接收数据
            var httpresponse = (HttpWebResponse)httpWebRequest.GetResponse();
            using (var streamReader = new StreamReader(httpresponse.GetResponseStream()))
            {
                responseEntity.Bodys = streamReader.ReadToEnd().ToString();
                return responseEntity;
            }
        }

        public static HttpResponseMessage PostFile(string url, HttpRequestEntity entity, byte[] filestream = null)
        {
            HttpClient httpClient = new HttpClient();
            MultipartFormDataContent content = new MultipartFormDataContent();
            content.Add(new ByteArrayContent(filestream, 0, filestream.Length),"files");

            HttpResponseEntity responseEntity = new HttpResponseEntity();
            HttpResponseMessage responseMessage = httpClient.PostAsync(url, content).Result;
            return responseMessage;
        }
    }
}
