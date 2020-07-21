using System;
using System.Collections.Generic;

namespace NutritiveMealSystem.SchoolCookHouseServices.Models
{
    public partial class TCookHouseInfo
    {
        public int Id { get; set; }
        public string CookHouseName { get; set; }
        public double? Temperature { get; set; }
        public double? Humidity { get; set; }
        public string ReportTime { get; set; }
    }
}
