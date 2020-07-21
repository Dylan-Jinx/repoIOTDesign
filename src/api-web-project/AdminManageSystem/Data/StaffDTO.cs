using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace AdminManageSystem.Data
{
    public class StaffDTO
    {
        /// <summary>
        /// 
        /// </summary>
        public List<Staff> staff { get; set; }
        /// <summary>
        /// 
        /// </summary>
        public int statusCode { get; set; }
        /// <summary>
        /// 获取成功
        /// </summary>
        public string message { get; set; }
        /// <summary>
        /// 
        /// </summary>
        public string returnTime { get; set; }
    }
    public class Staff
    {
        [DisplayName("id")]
        /// <summary>
        /// 
        /// </summary>
        public int id { get; set; }
        [DisplayName("员工姓名")]
        /// <summary>
        /// 李四
        /// </summary>
        public string staffName { get; set; }
        [DisplayName("电话号码")]
        /// <summary>
        /// 
        /// </summary>
        public string telephone { get; set; }
        [DisplayName("照片")]
        /// <summary>
        /// File/Uploads/李四.jpg
        /// </summary>
        public string image { get; set; }
        [DisplayName("职位")]
        /// <summary>
        /// 漳州职业技术学院-第一食堂-负责人
        /// </summary>
        public string position { get; set; }
    }


}
