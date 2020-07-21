using System;
using System.Collections.Generic;

namespace NutritiveMealSystem.SchoolCookHouseServices.Models
{
    public partial class TStorage
    {
        public int Id { get; set; }
        public string ProductInfo { get; set; }
        public double? Price { get; set; }
        public DateTime? StorageTime { get; set; }
        public string Remark { get; set; }
    }
}
