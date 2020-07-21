using System;
using System.Collections.Generic;

namespace NutritiveMealSystem.TraceabilityServices.Models
{
    public partial class TWarehouseInfo
    {
        public int Id { get; set; }
        public string Name { get; set; }
        public string Location { get; set; }
        public string ResponsiblePerson { get; set; }
        public string Telephone { get; set; }
        public double? Temperature { get; set; }
        public double? Humidity { get; set; }
        public string Remark { get; set; }
    }
}
