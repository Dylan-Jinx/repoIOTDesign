using System;
using System.Collections.Generic;

namespace NutritiveMealSystem.TraceabilityServices.Models
{
    public partial class TProductNumInfo
    {
        public int Id { get; set; }
        public string ProductNumber { get; set; }
        public string ProductInfo { get; set; }
        public string ProductionBase { get; set; }
        public string WareHouse { get; set; }
        public string Image { get; set; }
    }
}
