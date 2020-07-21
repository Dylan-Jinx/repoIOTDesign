using Microsoft.AspNetCore.Http;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Threading.Tasks;

namespace NutritiveMealSystem.TraceabilityServices.Utility
{
    public class UpLoadFile
    {
        /// <summary>
        /// 上传文件
        /// </summary>
        /// <param name="files">文件流</param>
        /// <param name="cookname">文件名</param>
        /// <param name="filename">输出存储的文件路径</param>
        /// <returns></returns>
        public static bool FileSave(List<IFormFile> files, string cookname, out List<string> filename)
        {
            filename = null;
            if (files.Count < 1)
            {
                //return Ok("空文件");
                return false;
            }
            //返回的文件地址
            List<string> filenames = new List<string>();
            DateTime now = DateTime.Now;
            //文件存储路径
            string filePath = string.Format("/Uploads/");
            //获取当前web目录
            var webRootPath = "File/"; ;
            if (!Directory.Exists(webRootPath + filePath))
            {
                Directory.CreateDirectory(webRootPath + filePath);
            }
            try
            {
                foreach (var item in files)
                {
                    if (item != null)
                    {
                        #region  图片文件的条件判断
                        //文件后缀
                        string fileExtension = Path.GetExtension(item.FileName);

                        //判断后缀是否是图片
                        const string fileFilt = ".gif|.jpg|.jpeg|.png";
                        if (fileExtension == null)
                        {
                            break;
                            //return Error("上传的文件没有后缀");
                        }
                        if (fileFilt.IndexOf(fileExtension.ToLower(), StringComparison.Ordinal) <= -1)
                        {
                            break;
                            //return Error("请上传jpg、png、gif格式的图片");
                        }

                        //判断文件大小
                        long length = item.Length;
                        if (length > 1024 * 1024 * 2) //2M
                        {
                            break;
                            //return Error("上传的文件不能大于2M");
                        }

                        #endregion

                        string strDateTime = DateTime.Now.ToString("yyMMddhhmmssfff"); //取得时间字符串
                        string strRan = Convert.ToString(new Random().Next(100, 999)); //生成三位随机数
                        string saveName = cookname + fileExtension;

                        //插入图片数据
                        using (FileStream fs = System.IO.File.Create(webRootPath + filePath + saveName))
                        {
                            item.CopyTo(fs);
                            fs.Flush();
                        }
                        filenames.Add("File" + filePath + saveName);
                    }
                }
                //return Ok(filenames);
                filename = filenames;
                return true;
            }
            catch (Exception)
            {
                //这边增加日志，记录错误的原因
                //ex.ToString();
                //this._logger.LogWarning("UpLoad File failed" + ex.Message + DateTime.Now.ToString());
                //return Ok("上传失败");
                return false;
            }
        }
    }
}
