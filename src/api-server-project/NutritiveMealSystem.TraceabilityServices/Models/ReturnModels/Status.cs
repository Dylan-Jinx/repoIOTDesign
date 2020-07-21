using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace NutritiveMealSystem.TraceabilityServices.Models.ReturnModels
{
    public class Status
    {
        public int StatusCode { get; set; }
        public string Message { get; set; }
        public DateTime CurrentTime { get; set; }
        public Status(bool state)
        {
            if (state)
            {
                StatusCode = 200;
                Message = "操作成功";
                CurrentTime = DateTime.Now;
            }
            else
            {
                StatusCode = 0;
                Message = "操作失败";
                CurrentTime = DateTime.Now;
            }
        }
    }
}
